use vending_machine;

delimiter //
drop function if exists get_avg_cash_withdrawal_amount_f//
create function get_avg_cash_withdrawal_amount_f()
returns int
deterministic
begin
	return (select avg(amount) from cash_withdrawal);
end //
delimiter ;