use vending_machine;

delimiter //

# Task 1
# Додати до БД 1 додаткову довільну таблицю і зв’язати з іншою існуючою таблицею зв’язком  1:M
# Однак для забезпечення цілісності значень використати тригери замість фізичного зовнішнього ключа
drop trigger if exists before_insert_region //
create trigger before_insert_region
before insert
on region
for each row
begin
    if (new.country_id not in (select id from country)) then
        signal sqlstate '45000' 
        set message_text = 'Region\'s refering to non-existent country';
    end if;
end//

drop trigger if exists before_update_region //
create trigger before_update_region
before update
on region
for each row
begin
    if (new.country_id not in (select id from country)) then
        signal sqlstate '45000' set message_text = 'Region\'s refering to non-existent country';
    end if;
end//

drop trigger if exists before_update_country //
create trigger before_update_country
before update
on country
for each row
begin
    if (old.id in (select country_id from region)) then
        signal sqlstate '45000' set message_text = 'There are regions refering to the country';
    end if;
end//

drop trigger if exists before_delete_country //
create trigger before_delete_country
before delete
on country
for each row
begin
    if (old.id in (select country_id from region)) then
        signal sqlstate '45000' set message_text = 'There are regions refering to the country';
    end if;
end //


# Task 3.a
# Значення певного стовпця не може закінчувати двома нулями
drop trigger if exists no_contacts_ending_with_00_before_insert //
create trigger no_contacts_ending_with_00_before_insert
before insert
on vending_machine
for each row
begin
    if (new.contact_number like "%00") then
        signal sqlstate '45000' set message_text = 'Contact number cannot end with \'00\'';
    end if;
end //

drop trigger if exists no_contacts_ending_with_00_before_update //
create trigger no_contacts_ending_with_00_before_update
before update
on vending_machine
for each row
begin
    if (new.contact_number like "%00") then
        signal sqlstate '45000' set message_text = 'Contact number cannot end with \'00\'';
    end if;
end //


# Task 3.d
# Забезпечити мінімальну кардинальність 6 стрічок для певної  таблиці БД
drop trigger if exists city_minimal_cardinality_trigger //
create trigger city_minimal_cardinality_trigger
after delete
on city
for each row
begin
    if ((select count(*) from city) < 6) then
        signal sqlstate '45000' set message_text = 'Minimal cardinality condition is not met';
    end if;
end //

# Task 3.b
# Заборонити будь-яку модифікацію даних в таблиці
drop trigger if exists forbid_country_data_update //
create trigger forbid_country_data_update
before update
on country
for each row
begin
	signal sqlstate '45000' set message_text = 'Data modification is forbidden';
end //
delimiter ;