-----------------------------Activity 9----------------------------------------------------------------------------

Select a.customer_name As "Customer Name", a.city, b.salesman_name As "Salesman", b.commission from customers a inner join salesman b on a.salesman_id=b.salesman_id ;

SELECT a.customer_name, a.city, a.grade, b.salesman_name AS "Salesman", b.salesman_city from customers a 
LEFT OUTER JOIN salesman b on a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;

SELECT a.customer_name As "Customer Name", a.city, b.name As "Salesman", b.commission from customers a 
INNER JOIN salesman b on a.salesman_id=b.salesman_id WHERE b.commission>12;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name As "Customer Name", b.grade, c.name As "Salesman", c.commission from orders a INNER JOIN customers b on a.customer_id=b.customer_id 
INNER JOIN salesman c on a.salesman_id=c.salesman_id;

-----------------------------Activity 10---------------------------------------------------------------------------

Select * from orders
WHERE salesman_id=(Select DISTINCT salesman_id from orders WHERE customer_id=3007);

Select * from orders
WHERE salesman_id IN (Select salesman_id from salesman WHERE city='New York');

Select grade, COUNT(*) from customers
GROUP BY grade HAVING grade>(Select AVG(grade) from customers WHERE city='New York');

Select order_no, purchase_amount, order_date, salesman_id from orders
WHERE salesman_id IN( Select salesman_id from salesman
WHERE commission=( Select MAX(commission) from salesman));

-----------------------------Activity 11---------------------------------------------------------------------------

Select customer_id, customer_name from customers a
WHERE 1<(Select COUNT(*) from orders b WHERE a.customer_id = b.customer_id)
UNION Select salesman_id, name from salesman a
WHERE 1<(Select COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY customer_name;

Select a.salesman_id, name, order_no, 'highest on', order_date from salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(Select MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date)
UNION
Select a.salesman_id, name, order_no, 'lowest on', order_date from salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(Select MIN(purchase_amount) from orders c WHERE c.order_date = b.order_date);

