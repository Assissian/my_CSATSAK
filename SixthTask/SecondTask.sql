create table Students
(
    SNO varchar(20),
    Name varchar(10),
    Age Integer,
    College varchar(30)
);

insert Students
values
    ('s001', '老大', 20, '计算机学院'),
    ('s002', '老二', 19, '计算机学院'),
    ('s003', '老三', 18, '计算机学院'),
    ('s004', '老四', 17, '计算机学院');

select * from Students;

delete from Students
where SNO = 's004';

select * from Students where SNO = 's003';

update Students
set College = '通信学院'
where SNO = 's001';