REM   Script: Activity 2
REM   Insert into table

CREATE TABLE salesman (     salesman_id int,     salesman_name varchar2(32),     salesman_city varchar2(32),     commission int );

desc salesman


CREATE TABLE salesman (     salesman_id int not null primary key,     salesman_name varchar2(32),     salesman_city varchar2(32),     commission int );

drop table salesman;

CREATE TABLE salesman (     salesman_id int not null primary key,     salesman_name varchar2(32),     salesman_city varchar2(32),     commission int );

INSERT INTO salesman 
VALUES (5001,'James Hoog','New York',15);

INSERT INTO salesman 
VALUES (5002,'Nail Knite','Paris',13);

INSERT INTO salesman 
VALUES (5005,'Pit Alex','London',11);

INSERT INTO salesman 
VALUES (5006,'McLyon','Paris',14);

INSERT ALL salesman 
values(5007,'Paul Adam','Rome',13) 
values(5003,'Lauson Hen','San Jose',12);

INSERT ALL into salesman 
values(5007,'Paul Adam','Rome',13) 
values(5003,'Lauson Hen','San Jose',12);

INSERT ALL into salesman 
values(5007,'Paul Adam','Rome',13) 
values(5003,'Lauson Hen','San Jose',12) 
select 1 from Dual;

INSERT ALL into salesman 
values(5007,'Paul Adam','Rome',13) 
values(5003,'Lauson Hen','San Jose',12) 
select 1 from Dual;

INSERT ALL into salesman 
values(5007,'Paul Adam','Rome',13) 
values(5003,'Lauson Hen','San Jose',12) 
select 1 from Dual;

INSERT ALL into salesman 
values(5007,'Paul Adam','Rome',13) 
;

INSERT into salesman 
values(5007,'Paul Adam','Rome',13);

INSERT into salesman 
values(5003,'Lauson Hen','San Jose',12);

select * from salesman;

