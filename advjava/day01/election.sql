create table users (id int primary key auto_increment, first_name varchar(20),last_name varchar(20), email varchar(80) unique, password varchar(20), dob date, status boolean,role varchar(20));

insert into users values(default,'Rama','Kher','rama@gmail.com','ram#123','1999-1-1',0,'admin');
insert into users values(default,'Shekhar','Patil','shekhar@gmail.com','shk#123','1992-10-20',0,'voter');
insert into users values(default,'Medha', 'Khole','medha@gmail.com','mad#123','1990-11-21',0,'voter');
insert into users values(default,'Nilesh', 'Ghule','nilesh@gmail.com','nilesh','1983-09-28',0,'voter');

select * from users;

create table candidates(id int primary key auto_increment, name varchar(20) unique,party varchar(20), votes int);

insert into candidates values(default,'Ravi','BJP',10);
insert into candidates values(default,'Asha','NCP',20);
insert into candidates values(default,'Kiran','Congress',15);
insert into candidates values(default,'Riya','SP',25);
insert into candidates values(default,'Subhash','AAP',37);
insert into candidates values(default,'Ganesh','BJP',40);
insert into candidates values(default,'Vidya','NCP',32);
insert into candidates values(default,'Meeta','Congress',23);
insert into candidates values(default,'Geeta','AAP',30);

select * from candidates;
