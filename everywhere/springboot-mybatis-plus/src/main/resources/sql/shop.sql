-- init
create table shop(
	id bigint(20) not null auto_increment,
  name varchar(30) not null,
  price int(11) default 0,
  version int(11) default 1,
  primary key(id)
);

insert into shop(id,name,price) values(1,'笔记本电脑',8000);