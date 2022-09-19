# Lab 2
## Task
- Write SQL queries for sampling the necessary data and statistical information from the databases specified in the application
### Variant 75
- Database "Comp. firm". Display PC models with processor speeds ranging from 500 to 750 MHz. Display: model, speed, price. Sort the output in descending order by the hd column.
- DB "Airport". Display passenger surnames (the second word in the name column) starting with the letter 'C'.
- Database "Ships". For ships that survived the battles, display the names and dates of the battles in which they participated.
- Database "Comp. firm". Find manufacturers that produce PCs and laptops at the same time (use keyword ALL). Display maker.
- Database "Comp. firm". Find printer manufacturers that produce PCs with the highest processor speeds. Output: maker.
- Database "Ships". From the Battles table, output the dates in the following format: day.month_year.for example, 12.06.2001 (without time format).
- Database "Comp. firm". Find the average PC hard disk size (one value for all) of those manufacturers that also produce printers. Output: average hard disk size.
- Database "Comp. firm". For each PC speed value greater than 600 MHz, determine the average price of a PC with the same speed. Output: speed, average price. (Hint: use subqueries as calculated columns)
- DB "Ships". Determine the names of all ships from the Ships table that satisfy, in the extreme case, a combination of any four criteria from the following list: numGuns=8, bore=15, displacement=32000, type='bb', country='USA', launched=1915, class='Congo'. Output: name, numGuns, bore, displacement, type, country, launched, class. (Hint: use the CASE operator to check conditions)
- Database "Comp. firm". For each product model from the entire database, display its average price. Output: type, model, average price. (Hint: use the UNION operator)
