//address
CREATE TABLE Address(
id int Identity,
place varchar(50),
zip_code int,
city varchar(20),
native_place varchar(30),
state varchar(30),
road varchar(50),
constraint pk_Address_id primary key(id),
constraint fk_Address_user_id foreign key(user_id) REFERENCES User(id)

);           
//cart
CREATE TABLE Cart (
	id IDENTITY,
	user_id int,
	grand_total double,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES User (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);
//user


create table User(
id int IDENTITY,
first_name varchar(30),
last_name varchar(30),
role varchar(10),
enabled boolean,
password varchar(30),
email varchar(30),
contact_number bigint,
CONSTRAINT pk_user_id PRIMARY KEY(id)
);