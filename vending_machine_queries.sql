use vending_machine;


-------- #1 get the closest vending machine --------
set @latitude = 10.82;
set @longitude = 22.02;
select machine_model_name, contact_number, 
	if(is_out_of_order, 'yes', 'no') as 'is out-of-order?', 
	if(is_empty, 'yes', 'no') as 'empty?', gps, 
	concat(street, '. ', house_number, ',  ', city.name, ',  ', region.name) as address
from vending_machine
	join address on address_id = address.id
	join city on city_id = city.id
	join region on region_id = region.id
where (sqrt(pow(@latitude - cast(substring_index(gps, ' ', 1) as decimal(5,2)), 2) + pow(@longitude - cast(substring_index(gps, ' ', -1) as decimal(5,2)), 2))) =
(select min(sqrt(pow(@latitude - cast(substring_index(gps, ' ', 1) as decimal(5,2)), 2) + pow(@longitude - cast(substring_index(gps, ' ', -1) as decimal(5,2)), 2))) 
 	from vending_machine);


-------- #2 get menu of a vending machine --------
select slot_number as slot, 
if(menu.quantity > 0, concat(snack.name, '  ', net_weight, ' g  ', '© ', trademark_name), '--------') as snack, 
if(menu.quantity > 0, cast(price_per_unit as decimal(10,1)), '----') as price 
from menu join snack on snack_id = snack.id
where vending_machine_id = 4;


-------- #3 get machines that soon need to be restocked --------
select vm.id, avg(menu.quantity) 'avg amount of snacks' from vending_machine vm
join menu on vm.id = menu.vending_machine_id
group by vm.id
having avg(menu.quantity) between 0 and 1;


-------- #4 get amount of slot rows and snack name they need to be restocked with --------
select concat(snack.name, '  ', net_weight, 'g  ', '© ', trademark_name) as snack, count(*) 'slots to restock' from menu
join snack on snack_id = snack.id
where menu.quantity = 0
group by snack_id;


-------- #5 get amount of sold snacks in one day --------
set @date = '2022-09-20';
select city.name city, menu_vending_machine_id as 'vm id', 
	concat(snack.name, '  ', net_weight, 'g  ', '© ', trademark_name) as snack, count(*) as sold 
from sold
	join menu on menu_vending_machine_id = menu.vending_machine_id and menu_slot_number = menu.slot_number
	join snack on snack_id = snack.id
	join vending_machine on vending_machine_id = vending_machine.id
	join address on address_id = address.id
	join city on city_id = city.id
where date(time) = @date
group by city.name, snack
order by city, sold desc;


-------- #6 get date and all details of the latest restock for each vemding machine --------
select r.menu_vending_machine_id as 'vending machine id', r.menu_slot_number as slot, 
	concat(snack.name, '  ', net_weight, 'g  ', '© ', trademark_name) as snack, 
	r.quantity, r.date, s.name, s.last_name, s.id 
from restock as r
join service_staff as s on service_staff_id = s.id
join menu on menu_slot_number = menu.slot_number and menu_vending_machine_id = menu.vending_machine_id
join snack on snack_id = snack.id 
where r.date in(select max(date) from restock group by menu_vending_machine_id)
order by 1,2;


-------- #7 get a total income of each vending machine for the current month --------
select vending_machine_id as 'machine id', sum(amount) as 'total for 2022.09' from cash_withdrawal
where year(date) = 2022 and month(date) = 9
group by vending_machine_id
order by vending_machine_id;


-------- #8 get amount of one-day earned money for each machine --------
select vending_machine.id, sum(menu.price_per_unit) as earned, date(time) as date from vending_machine
join menu on menu.vending_machine_id = vending_machine.id
join sold on menu_vending_machine_id = menu.vending_machine_id and menu_slot_number = menu.slot_number
group by vending_machine.id, date(time)
order by vending_machine.id, date(time) desc;


-------- #9 get top 3 most popular snack trademarks --------
select ROW_NUMBER() OVER (ORDER BY count(*) desc) AS top, trademark_name from menu
join snack on snack_id = snack.id
group by trademark_name
limit 3;


-------- #10 get list of all service staff that have ever serviced vending machine # --------
set @machine_id = 1;
select concat(name, ' ', last_name) as name from service_staff
join cash_withdrawal on service_staff_id = service_staff.id
where vending_machine_id = @machine_id
union
select concat(name, ' ', last_name) from service_staff
join cash_load on service_staff_id = service_staff.id
where vending_machine_id = @machine_id
union
select concat(name, ' ', last_name) from service_staff
join restock on service_staff_id = service_staff.id
where menu_vending_machine_id = @machine_id;
