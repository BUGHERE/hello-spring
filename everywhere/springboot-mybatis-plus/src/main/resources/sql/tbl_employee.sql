-- init
CREATE DATABASE `mybatisplus`;

USE `mybatisplus`;

DROP TABLE IF EXISTS `tbl_employee`;

CREATE TABLE `tbl_employee` (
  `id` bigint(20) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

insert  into `tbl_employee`(`id`,`last_name`,`email`,`gender`,`age`) values (1,'jack','jack@qq.com','1',35),(2,'tom','tom@qq.com','1',30),(3,'jerry','jerry@qq.com','1',40);

-- add time property
alter table tbl_employee add column gmt_create datetime not null;
alter table tbl_employee add column gmt_modified datetime not null;

-- add is_deleted property
alter table tbl_employee add column is_deleted tinyint not null;