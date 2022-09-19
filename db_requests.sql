use labor_sql;

-------- 1 --------
select model, speed, price from pc
where pc.speed between 500 and 750
order by pc.hd desc;

-------- 2 --------
select substring_index(name, ' ', -1) as surname from passenger
where name rlike '[[:space:]]C[[:alpha:]]*$';

-------- 3 --------
select ouc.ship, ouc.battle, btt.date from outcomes ouc
join battles btt on ouc.battle = btt.name
where ouc.result = 'OK';

-------- 4 --------
select distinct maker from product
where type = 'PC' 
and not maker <> all(select maker from product where type = 'Laptop');

-------- 5 --------
select maker from product p join pc on p.model = pc.model
where p.maker in(select maker from product where type = 'Printer')
and pc.speed = (select max(speed) from pc);

-------- 6 --------
-- select substring_index(date, ' ', 1) date from battles;
select substring_index(date, ' ', 1) date, replace(substring_index(date, ' ', 1), '-', '.') 'dot date' from battles;

-------- 7 --------
select avg(pc.hd) from pc
join product p on p.model = pc.model
where p.maker
in(select maker from product where type = 'Printer');

-------- 8 --------
select speed, avg(price) 'same-speed pc avg price' from pc
where speed > 600
group by speed
order by speed;

-------- 9 --------
select s.name, c.numGuns, c.bore, c.displacement, c.type, c.country, s.launched, s.class 
from ships s join classes c on s.class = c.class
where 
	case when numGuns = 8 then 1 else 0 end +
	case when bore = 15 then 1 else 0 end +
	case when displacement = 32000 then 1 else 0 end +
	case when type = 'bb' then 1 else 0 end +
	case when country = 'USA' then 1 else 0 end +
	case when s.launched = 1915 then 1 else 0 end +
	case when c.class = 'Kon' then 1 else 0 end >= 4;
    
-------- 10 --------
select p.type, laptop.model, avg(price) 'avg price' from laptop join product p on p.model = laptop.model
group by model
union
select p.type, pc.model, avg(price) from pc join product p on p.model = pc.model
group by model
union
select p.type, printer.model, avg(price) from printer join product p on p.model = printer.model
group by model
order by 1,2;
