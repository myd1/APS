create tablespace animal datafile 'C:/Users/admin/Desktop/xiaodongwu/animal.dbf'size 10m 
alter user system default tablespace animal
--------------------------------------------------------------------------------------------
/*
����Ʒ��(animal_variety)��
  Ʒ�ֱ��(varietyId)
  Ʒ����((varietyName)
*/
create sequence animal_variety_seq start with 1 increment by 1;
create table animal_variety
(
       varietyId int,
       varietyName varchar2(20),
       constraint pk_animal_variety primary key(varietyId)
)
/*
������Ϣ(animal)��
  ���(animalId)
  ������name��
  �������typeName��
  Ʒ�ֱ��(varietyId)
  �Ա�(sex)
  ���䣨age��
  ����ʱ��(adopt_time)
  ������ܣ�introduction��
  �Ƿ�����(flag)��0������ 1δ������
  ����ͼƬ��picture��
*/
create sequence animal_seq start with 1 increment by 1;
create table animal
(
       animalId int,
       name varchar2(20),
       typeName varchar2(20),
       varietyId int,
       sex varchar2(20),
       age int,
       adopt_time date,
       introduction clob,
       flag int,
       picture varchar2(20),
       constraint pk_animal primary key(animalId)
)
drop table animal
/*
���������apply��
  ������(applyId)
  ����������(applyName)
  ���붯����(animalId)
  �����˼�ͥ��ַ��address��
  �����˵绰��applyPhone��
  �������ɣ�applyReason��
  ����״̬��applyFlag��:0���ڴ��� 1ͨ�� 2��ͨ�� 
*/
create sequence applyl_seq start with 1 increment by 1;
create table apply
(
       applyId int,
       applyName varchar2(20),
       animalId int,
       address varchar2(20),
       applyPhone varchar2(20),
       applyReason clob,
       applyFlag int,
       constraint pk_apply primary key(applyId),
       constraint fk_apply foreign key(animalId) references animal(animalId)
)
drop table apply
/*
־Ը�߱�volunteer��
  ־Ը�߱��(volunteerId)  
  ������volunteerName��
  ��ַ��address��
  �ֻ���phone��
  ���䣨email��
  �Ա�sex��
  ���գ�birthday��
  ѧ����education��
  ϣ�����¹�����exceptWork��
  ���״̬��flag����0���ڴ��� 1ͨ�� 2��ͨ�� 
*/
create sequence volunteer_seq start with 1 increment by 1;
create table volunteer
(
       volunteerId int,
       volunteerName varchar2(20),
       address varchar2(20),
       phone varchar2(20),
       email varchar2(20),
       sex varchar2(20),
       birthday date,
       education varchar2(20),
       exceptWork clob,
       flag int,
       constraint pk_volunteer primary key(volunteerId)
)
alter table volunteer modify address varchar2(200)
/*
���ű�(news)
  ���ű�ţ�newsId��
  ���ű��⣨newsTitle��
  ����ʱ�䣨newsTime��
  ���ݣ�content�� 
*/
create sequence news_seq start with 1 increment by 1;
create table news
(
       newsId int,
       newsTitle varchar2(20),
       newsTime date,
       content clob,
       constraint pk_news primary key(newsId)
       
)
drop table news
/*
Э�ᶯ̬��(association)
  Э�ᶯ̬��ţ�a_Id��
  Э�ᶯ̬���⣨a_Title��
  ����ʱ�䣨a_Time��
  �ͼƬ��a_Image��
  ���ݣ�a_content��
*/
create sequence association_seq start with 1 increment by 1;
create table association
(
     a_Id int,
     a_Title varchar2(20),
     a_Time date,
     a_Image varchar2(20),
     a_content clob,
     constraint pk_association primary key(a_Id)

)
/*
������donate��
  ������ţ�donateId��
  ������donatemoney��
  ����(donatename)
  ͷ��donateImage��
  ���䣨email��
  �ֻ���phone��
  ���ԣ�message��   
  ����ʱ�䣨donateDate��
*/
create sequence donate_seq start with 1 increment by 1;
create table donate
(
     donateId int,
     donatemoney float,
     donatename varchar2(20),
     donateImage varchar2(20),
     email varchar2(20),
     phone varchar2(20),
     message clob,
     donateDate date,
     constraint pk_donate primary key(donateId)
)
/*
�����̱�partner��
  �����̱�ţ�p_Id��
  ������ͼƬ��p_logo��
  ���������ƣ�p_Name��
*/
create sequence partner_seq start with 1 increment by 1;
create table partner
(
     p_Id int,
     p_logo varchar2(20),
     p_Name varchar2(20),
     constraint pk_partner primary key(p_Id)
)

/*
־Ը�߻��activity��
  ���ţ�activityId��
  �����activityName��
  �ʱ�䣨activityTime��
  ����ݣ�content��
*/
create sequence activity_seq start with 1 increment by 1;
create table activity
(
     activityId int,
     activityName varchar2(20),
     activityTime date,
     content varchar2(20),
     constraint pk_activity primary key(activityId)
)
drop table activity
/*
�û���(user)��
  �û����(userId)
  �û���(userName)
  ����(pwd)
  ��ַ��address��
  ��ʵ������realname��
  �ֻ���phone��
  ���գ�birthday��
  ���䣨email��
  �Ƿ�ΪԱ����flag��
*/
create sequence user_seq start with 1 increment by 1;
create table user_
(
     userId int,
     userName varchar2(20),
     pwd varchar2(20),
     address varchar2(20),
     realname varchar2(20),
     phone varchar2(20),
     birthday date,
     email varchar2(20),
     flag int,
     constraint pk_user primary key(userId)
)
/*Ա����(emp)��
  Ա����ţ�empId��
  Ա��������empName��
  �Ա�sex��
  ��ְʱ�䣨hireTime��
*/
create sequence emp_seq start with 1 increment by 1;
create table emp
(
     empId int,
     empName varchar2(20),
     sex varchar2(20),
     pwd varchar2(20),
     hireTime date,
     constraint pk_emp primary key(empId)
)

create sequence message_seq start with 1 increment by 1;
create table message
(
       messageId int,
       name varchar2(20),
       phone varchar2(20),
       content clob,
       messageTime date,
       flag int,
       constraint pk_message primary key( messageId)
)
delete from message+
drop table message
----------------------------------------------------------------------------------------------
select * from animal_variety;
select * from animal;
select * from apply;
select * from volunteer;
select * from news;
select * from association;
select * from donate;         
select * from partner;
select * from activity;
select * from user_;
select * from emp;
commit 
delete from volunteer where volunteerid=44
delete from animal where animalid=101
delete from activity where activityid=21
update volunteer set flag=2 where volunteerid=3
select count(*) from activity where activitytime <= sysdate

create sequence unhappen_seq start with 1 increment by 1;
create table unhappen
(
       unhappenId int,
       title varchar2(100),
       happentime date,
       content clob,
       constraint pk_unhappen primary key(unhappenId)
)
create sequence attendactivity_seq start with 1 increment by 1;
create table attendactivity
(
       attendactivityId int,
       name varchar2(20),
       phone varchar2(20),
       unhappenId int,
       constraint pk_attendactivity primary key(attendactivityId),
       constraint fk_attendactivity foreign key(unhappenId) references unhappen(unhappenId)
)
drop table attendactivity

insert into unhappen values(unhappen_seq.nextval,'־Ը�����˻��101�ڣ�',to_date('2017-11-15','yyyy-mm-dd'),'�������������������');

insert into unhappen values(unhappen_seq.nextval,'־Ը�����˻��102�ڣ�',to_date('2017-12-15','yyyy-mm-dd'),'�������������������');

insert into unhappen values(unhappen_seq.nextval,'��������',to_date('2018-01-01','yyyy-mm-dd'),'���زιۣ�־Ը��֮���໥����');
select * from attendactivity
select * from unhappen
delete from attendactivity
delete from news where newsid=22

delete from 


select count(*) from animal
select count(*) from animal where flag=0

select * from(
select * from association order by a_time desc)where rownum=1

select * from(
select * from news order by newstime desc)where rownum between 1 and 6

select varietyname from animal_variety where varietyid=1

insert into apply(applyid,applyname,animalid,address,applyphone,applyreason,applyflag) 
values(applyl_seq.nextval,'����','3','������','17706248839','�Ұ��Ҽ�',0)

delete from apply where applyid=41

select count(*) from donate
select sum(donatemoney) from donate

delete from association where a_id>10
insert into donate values(donate_seq.nextval,5000,'lili','4.gif','418825364@qq.com','17706248839','dsfdsvxczvxcvcxs',sysdate)
delete from donate where donateid=11
commit




