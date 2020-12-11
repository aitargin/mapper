create database mapper;
use mapper;

create table student
(
    id int primary key auto_increment,
    name varchar(100),
    sex varchar(100) default '男',
    age int,
    tid int
);

create table s_teacher
(
    t_id int primary key auto_increment,
    t_name varchar(100)
);

insert into student values
(1,'张三','男',18,1),
(2,'李四','男',22,2),
(3,'王五','女',19,1),
(4,'赵六','女',22,2),
(5,'朱七','女',18,1),
(6,'王八','男',21,2),
(7,'张三','男',23,2);

insert into s_teacher values
(1,'郭月龙'),
(2,'车杰');
