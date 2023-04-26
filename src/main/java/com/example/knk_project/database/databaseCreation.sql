-- drop database grading;

create database grading;

use grading;

create table if not exists nxenesit(
	id integer not null auto_increment primary key,
    emri varchar(50),
    mbiemri varchar(50),
    date_lindja date,
    vend_lindja varchar(50),
    komuna varchar(50),
    shteti varchar(50)
)