create database spring_tx;
use spring_tx;
create table account(
	id int auto_increment ,
    name varchar(5) not null,
    money double ,
    primary key(id)
);

insert into account(name,money) value("amber", 10000);
insert into account(name,money) value("jack", 10000);