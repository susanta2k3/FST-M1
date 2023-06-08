-----------------------------Activity 1----------------------------------------------------------------------------

Create table salesman(
salesman_id int,
salesman_name varchar2(20),
salesman_city varchar2(20),
commission int);

Describe salesman;


-----------------------------Activity 2----------------------------------------------------------------------------


INSERT ALL
INTO salesman VALUES(5001,'James Hoog', 'New York',15)
INTO salesman VALUES(5002,'Nail Knite', 'Paris',13)
INTO salesman VALUES(5005,'Pit Alex', 'London',11)
INTO salesman VALUES(5006,'McLyon', 'Paris',14)
INTO salesman VALUES(5007,'Paul Adam', 'Rome',13)
INTO salesman VALUES(5003,'Lauson Hen', 'San Jose',12)
Select 1 from DUAL;


Select * from salesman;


-----------------------------Activity 3----------------------------------------------------------------------------

Select salesman_id,salesman_city from salesman;

Select * from salesman where salesman_city='Paris';

Select salesman_id, commission from salesman where salesman_name='Paul Adam';



-----------------------------Activity 4----------------------------------------------------------------------------

Alter table salesman ADD grade int;

Update salesman set grade=100;

Select * from salesman;


-----------------------------Activity 5----------------------------------------------------------------------------

Update salesman set grade =200 where salesman_city='Rome';

Update salesman set grade = 300 where salesman_name ='James Hoog';

Update salesman set salesman_name='Pierre' where salesman_name ='McLyon';

Select * from salesman;