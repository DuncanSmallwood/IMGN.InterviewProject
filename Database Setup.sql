use IMGN
drop table employee
drop table company
drop sequence company_id_generator
drop sequence employee_id_generator

create sequence company_id_generator
	start with 100
	increment by 1;

create table company(
	id bigint primary key,
	name varchar(MAX) not null,
	telephone_number varchar(15),
	street_address varchar(MAX)
)

create sequence employee_id_generator
	start with 100
	increment by 1;

create table employee(
	id bigint primary key,
	company_id bigint,
	name varchar(MAX),
	mobile_number varchar(15),
	email varchar(MAX),
	profile_picture_blob image,
	foreign key (company_id) references company(id)
)