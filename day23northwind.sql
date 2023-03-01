use northwind;

SELECT Orders.id, Customers.first_name
FROM Orders
INNER JOIN Customers ON Orders.customer_id = Customers.id;

SELECT Customers.first_name, Orders.id
FROM Customers
LEFT JOIN Orders
ON customers.id = Orders.customer_id
ORDER BY Customers.first_name;

SELECT Orders.id, Employees.last_name, Employees.first_name
FROM Orders
RIGHT JOIN Employees 
ON Orders.employee_id = Employees.id
ORDER BY Orders.id;

select * from customers;

CREATE VIEW Boston_Customers AS
SELECT first_name, last_name, job_title
FROM Customers
WHERE city = 'Boston';

select * from boston_customers;

CREATE VIEW cust_order_count AS
SELECT customer_id, count(customer_id) cnt
FROM orders
GROUP BY customer_id;

select * from cust_order_count;

SELECT ship_city, count(ship_city) FROM 
(SELECT Orders.*, Customers.first_name
FROM Orders
INNER JOIN Customers ON Orders.customer_id = Customers.id
WHERE employee_id in (9)
AND shipped_date between '2006-01-01' and '2006-03-31') Customer_Order
GROUP BY ship_city;

SELECT employee_id, ship_city, count(*) FROM 
(SELECT Orders.*, Customers.first_name
FROM Orders
INNER JOIN Customers ON Orders.customer_id = Customers.id
WHERE employee_id in (9)
AND shipped_date between '2006-01-01' and '2006-03-31') Customer_Order
GROUP BY employee_id,ship_city;

#SUBQUERY
#Step 1
SELECT Orders.*, Customers.first_name
FROM Orders
INNER JOIN Customers ON Orders.customer_id = Customers.id
WHERE employee_id in (9)
AND shipped_date between '2006-01-01' and '2006-03-31';

#Step 2
SELECT employee_id, ship_city, count(*) cnt FROM 
(SELECT Orders.*, Customers.first_name
FROM Orders
INNER JOIN Customers ON Orders.customer_id = Customers.id
WHERE employee_id in (9)
AND shipped_date between '2006-01-01' and '2006-03-31') Customer_Order
GROUP BY employee_id,ship_city;

#Step 3
SELECT employee_id, sum(cnt) FROM
(SELECT employee_id, ship_city, count(*) cnt FROM 
(SELECT Orders.*, Customers.first_name
FROM Orders
INNER JOIN Customers ON Orders.customer_id = Customers.id
WHERE employee_id in (9)
AND shipped_date between '2006-01-01' and '2006-03-31') Customer_Order
GROUP BY employee_id,ship_city) Overview
GROUP BY employee_id;
