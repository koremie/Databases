use vending_machine;

delimiter //

# Task 2.a
# Забезпечити параметризовану вставку нових значень у довільну таблицю
drop procedure if exists insert_into_trademark //
create procedure insert_into_trademark(
	in name_in varchar (50),
	out name_out varchar (50)
)
begin    
	insert into country(name) values (name_in);
    select last_insert_id() into name_out;
end //

# Task 2.b
# Забезпечити реалізацію зв’язку М:М між 2ма таблицями, 
# тобто вставити в стикувальну таблицю відповідну стрічку за реально-існуючими значеннями 
# (напр. surname, name) в цих основних таблицях
drop procedure if exists insert_into_cash_withdrawal //
create procedure insert_into_cash_withdrawal(
	in service_member_name varchar (50),
    in service_member_last_name varchar (50),
    in vending_machine_model_name varchar (50),
    in amount int,
	out cash_withdrawal_id int
)
begin
	declare vending_machine_id, service_staff_id int;
	set vending_machine_id = (select id from vending_machine 
								where vending_machine.machine_model_name = vending_machine_model_name 
                                limit 1);
    set service_staff_id = (select id from service_staff 
								where service_staff.name = service_member_name 
								and service_staff.last_name = service_member_last_name 
								limit 1);
	if (vending_machine_id is null) then
        signal sqlstate '45000' 
        set message_text = 'No vending machines with such model name found';
    end if;
	if (service_staff_id is null) then
        signal sqlstate '45000' 
        set message_text = 'No service staff member with such name found';
    end if;
    insert into cash_withdrawal (vending_machine_id, service_staff_id, amount, date) 
		values (vending_machine_id, service_staff_id, amount, date(now()));
    select last_insert_id() into cash_withdrawal_id;
end //

# Task 2.c
# Створити пакет, який вставляє 10 стрічок у довільну таблицю БД у форматі <Noname+№>
# наприклад: Noname5, Noname6, Noname7 і т.д.
drop procedure if exists insert_nonames_into_country //
create procedure insert_nonames_into_country()
begin
    declare n int;
    set n = 1;
    label1: while n < 11 do
        insert into country values (CONCAT('Noname_', n));
        set n = n + 1;
    end while label1;
end //

# Task 2.d
# Написати користувацьку функцію, яка буде шукати Max, Min, Sum чи Avg для стовпця довільної таблиці у БД
# Написати процедуру, яка буде у SELECT викликати цю функцію
drop procedure if exists get_avg_cash_withdrawal_amount //
create procedure get_avg_cash_withdrawal_amount(
	out average double)
begin
    set average = get_avg_cash_withdrawal_amount_f();
end // 


# Task 2.e
# Використовуючи курсор, забезпечити динамічне створення таблиць з назвами+штамп часу, взятими зі стовпця з довільної таблиці БД,
# з випадковою кількістю стовпців (від 1 до 9). Імена та тип стовпців довільні
drop procedure if exists create_tables_by_country_names //
create procedure create_tables_by_country_names()
begin
	declare done bool default false;
	declare country_name varchar(50); 
    declare table_name_with_time varchar(50);
    
    declare counter, random_num int;

	declare country_cursor cursor
	for select name from country;

	declare continue handler
	for not found set done = true;
	
	open country_cursor;   
    	
	country_names_loop: loop

		fetch country_cursor into country_name;
        set table_name_with_time = concat(country_name, '_', replace(time(now()), ':', '_'));
        
		if done then leave country_names_loop;
		end if;
        
		set @drop_table_query = concat('drop table if exists ', table_name_with_time, ';');
		set @create_table_query = concat('create table ', table_name_with_time, ' (id int NOT NULL AUTO_INCREMENT, CONSTRAINT ', table_name_with_time, '_pk PRIMARY KEY (id));');
        
		set counter = 1;
        set random_num = (select floor(rand()*10)+1);
            
        prepare drop_table_query_ from @drop_table_query;
		execute drop_table_query_;
		deallocate prepare drop_table_query_;
	
		prepare create_table_query_ from @create_table_query;
		execute create_table_query_;
		deallocate prepare create_table_query_;
        
        columns_loop: loop

			set @add_column_query = concat('alter table ', table_name_with_time, ' add column column_', counter, ' varchar(50);');

			prepare add_column_query_ from @add_column_query;
			execute add_column_query_;
			deallocate prepare add_column_query_;

			if counter = random_num then leave columns_loop;
			end if;

			set counter = counter + 1;
		end loop;
        
	end loop;
    
	close country_cursor;
end //

delimiter ;