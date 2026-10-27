#drop database college_db;
-- create database college_db;
-- use college_db;

-- create table students (
--     student_id int primary key,
--     student_name varchar(100) not null,
--     age int,
--     department varchar(100),
--     email varchar(100) not null
-- );

create table employees (
    employee_id int primary key,
    employee_name varchar(100),
    salary decimal(10,2),
    joining_date date,
    email varchar(100) UNIQUE
);

-- show tables;
-- describe students;
-- describe employees;

-- alter table students add phone_number varchar(15);
-- describe students;
-- alter table students add date_of_birth date;
-- describe students;
-- alter table students modify student_name varchar(150) not null;
-- alter table students rename column department to course;
-- alter table students drop column phone_number;



-- insert into students (student_id, student_name, department, age, marks) values (1, 'Karthi', 'Java', 21, 78);
-- insert into students (student_id, student_name, department, age, marks) values (2, 'sharan', 'Cpp', 20, 88);
-- insert into students (student_id, student_name, department, age, marks) values (3, 'Ravi', 'Java', 40, 30);
-- insert into students (student_id, student_name, department, age, marks) values (4, 'durai', 'python', 20, 78);
-- select * from students where marks > 80;
-- update students set marks = 96 where student_name = 'sharan';
-- update students set department = 'Python' where student_name = 'Ravi';
-- delete from students where student_id = 3;
-- update students set marks = marks + 10 where department = 'Java';
-- select * from students;



#create database practise;

use college_db;

-- create table employee(
-- 	id int primary key auto_increment,
--     name varchar(20) not null,
--     email varchar(100) unique,
--     age int check(age > 18),
--     college varchar(100) default "CHennai Institute of Technology"
-- );

-- create table department(
-- 	dept_id int primary key auto_increment,
--     dept_name varchar(100)
--     );
    
show tables;
#alter table employee add constraint dept_id  foreign key (dept_id) references department(dept_id);
#alter table employee add column dept_id int;
#insert into employee (name,email) values("Sharan","sharanprashanth24@gmail.com");


-- describe employee;
-- select * from employee limit 0;
-- #insert into department(dept_id,dept_name) values(101,"CSE");
-- select * from department;
-- select * from employee where name in ("Sharan", "kishore");


-- delimiter $$

-- create procedure func5(out named varchar(2000))
-- begin
--     select * into named
--     from employee
--     where id = 1;
-- end $$

-- delimiter ;

-- call func5(@variable);

-- select @variable;
--  
-- delimiter //
-- call world("email")//

-- update employee set age = 15 where name = "Sharan";
-- select * from employee where salary > (select avg(age) from employee);
-- select * from employee where dept_id = (select dept_id from department where dept_name  = "CSE");

-- Joins 
-- select * from employee e inner join department d on e.id = d.dept_id;
-- select * from employee e left join department d on e.id = d.dept_id;
-- select * from eployee e right join department d on e.id = d.dept_id;
-- select * from employee e cross join department d on e.id = d.dept_id;

-- select * from employee e left join department d on e.id = d.dept_id
-- union 
-- select * from eployee e right join department d on e.id = d.dept_id;

-- Views 
-- create view name_view as select * from employee where name = "Sharan";
-- select * from name_view;

select * from employees;
-- create table backup_student(
-- student_id int primary key,
--     student_name varchar(100) not null,
--     age int,
--     department varchar(100),
--     email varchar(100) not null
--  );
--  


 delimiter //
 create trigger trigger_name after delete on student for each row 
 begin 
insert into backup values (old.student_id,old.age,old.department,old.email);
 end //
 