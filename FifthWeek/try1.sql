-- 1
create table cqupt_student
(
	studentid varchar(10),
    name varchar(20),
    sex varchar(2),
    age Integer,
    Fee DECIMAL,
    address varchar(50),
    memo varchar(300)
);

-- 2
create table CourseAa
(
	Aa1 varchar(20),
    Aa2 Integer,
    Aa3 DECIMAL(10)
);

-- 3
create table CourseBb
(
	Bb1 varchar(30),
    Bb2 Integer,
    Bb3 DECIMAL(6)
);

-- 4
alter table CourseBb add column Bb4 varchar(20) not null 
default '系统测试值';

-- 5 
alter table CourseBb add column Bb5 varchar(10) primary key;

-- 6
create view 
	View_CourseBb (View_bb1, View_bb2, View_bb3)
as select
	Bb1, Bb4, Bb5 from CourseBb;
select * from
	View_CourseBb;

-- 7
drop view View_CourseBb;

-- 8
create index Index_bb2 on CourseBb (Bb2);
create index Index_bb4 on CourseBb (Bb4 desc);

-- 9
drop index Index_bb2 on CourseBb;

-- 10
create table test
(
	Name varchar(20),
	Age Integer,
    Score Numeric(10, 2),
    Address varchar(60)
);

-- 11
insert into 
	test (Name, Age, Score, Address)
values
	('赵一', 20, 580.00, '重邮宿舍12-3-5'),
    ('赵二', 19, 540.00, '南福苑5-2-9'),
    ('孙三', 21, 555.50, '学生新区21-5-15'),
    ('李四', 22, 505.00, '重邮宿舍8-6-22'),
    ('周五', 20, 495.50, '学生新区23-4-8'),
    ('吴六', 19, 435.00, '南福苑2-5-12');
    
-- 12
create table test_temp
(
	Name varchar(20),
    Age Integer,
    Score Numeric,
    Address varchar(60)
);

-- 13
insert into 
	test_temp (Name, Age, Score, Address)
values
	('郑七', 21, 490.50, '重邮宿舍11-2-1'),
    ('张八', 20, 560.00, '南福苑3-3-3'),
    ('王九', 10, 515.00, '学生新区19-7-1');
    
-- 14
insert into test select * from test_temp;
select * from test;

-- 15 **weizhixing
update test
set Age = Age + 5
where Age < 20;

-- 16
update test
set Age = Age - 1;

-- 17
delete from test
where Age >= 21 and score >= 500;

-- 18
delete from test
where 
	Score < 550 and Address like '重邮宿舍%';
    
-- 19
create table Student
(
	SNO varchar(20),
    Name varchar(10),
    Age Integer,
    College varchar(30)
);

-- 20
create table Course
(
	CourseID varchar(15),
    CourseName varchar(30),
    CourseBeforeID varchar(15)
);

-- 21
create table Choose
(
	SNO varchar(20),
    CourseID varchar(30),
    Score DECIMAL(5, 2)
);

-- 22
insert into 
	Student (SNO, Name, Age, College)
values
	('S00001', '张三', 20, '计算机学院'),
    ('S00002', '李四', 19, '通信学院'),
    ('S00003', '王五', 21, '计算机学院');
    
-- 23
insert into 
	Course
values
	('C1', '计算机引论', null),
    ('C2', 'C语言', 'C1'),
    ('C3', '数据结构', 'C2');
    
-- 24
insert into 
	Choose
values
	('S00001', 'C1', 95),
    ('S00001', 'C2', 80),
    ('S00001', 'C3', 84),
    ('S00002', 'C1', 80),
    ('S00002', 'C2', 85),
    ('S00003', 'C1', 78),
    ('S00003', 'C3', 70);
    
-- 25
select
	SNO, Name
from 
	Student
where 
	College = '计算机学院';
    
-- 26
select
	*
from 
	Student
where
	Age between 20 and 23;
    
-- 27
select count(*) from Student;

-- 28
select max(Score) from Choose;
select min(Score) from Choose;
select sum(Score) from Choose;
select avg(Score) from Choose;

-- 29
select CourseID, CourseName from Course
where CourseBeforeID is null;

-- 30
select
	Student.SNO, Student.Name, Choose.CourseID, Choose.Score
from 
	Student
right join
	Choose
on 
	Student.SNO = Choose.SNO;
    
-- 31
select
	*
from 
	Student
where
	EXISTS(select Name from Student where College = '计算机学院' and Name <> '张三');

-- 32
select
		Student.SNO, Student.Name
from 
	Student
right join
	Choose
on 
	Choose.CourseID = 'C1' and Choose.Score < (select Score from Choose where Choose.SNO = 'S00001')
;

-- 33
select SNO from Student
union
select SNO from Choose where CourseID = 'C1' or CourseID = 'C3';

-- 34
select distinct SNO from  Student
union
select distinct SNO from Choose where CourseID = 'C1' or CourseID = 'C3';

	




