-----------------------------Activity 6----------------------------------------------------------------------------

Select Distinct salesman_id from orders;

Select order_no,order_date from orders order by order_date;

Select order_no, purchase_amount from orders order by purchase_amount desc;

Select * from orders where purchase_amount < 500;

Select * from orders where purchase_Amount between 1000 and 2000;

-----------------------------Activity 7----------------------------------------------------------------------------

Select sum(purchase_amount) from orders;

Select avg(purchase_amount) from orders;

Select max(purchase_amount) from orders;

Select min(purchase_amount) from orders;

Select count(distinct salesman_id) from orders;


-----------------------------Activity 8----------------------------------------------------------------------------

Select customer_id, max(purchase_amount) As "Max Amount" from orders group by customer_id;

Select salesman_id, max(purchase_amount) As "Max Amount" from orders where order_date=TO_DATE('2012/08/17','YYYY/MM/DD') group by salesman_id;

Select customer_id, order_date, max(purchase_amount) As "Max Amount" from orders group by customer_id,order_date having max(purchase_amount) in (2030,3450,5760,6000);



