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
	cartline_id int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES User (id),
	CONSTRAINT fk_cart_cartline_id FOREIGN KEY (cartline_id) REFERENCES CartLine (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);
//user


create table User(
id int IDENTITY,
first_name varchar(30),
last_name varchar(30),
role varchar(10),
enabled boolean,
password varchar(60),
email varchar(30),
contact_number bigint,
CONSTRAINT pk_user_id PRIMARY KEY(id)
);



//inserting into the table 



insert into user(first_name,last_name,role,enabled,password,email,cantact_number)
values
('vishal','pathak','USER',true,'$2a$06$WOGE17NzRMaOA1QCxANKIe.Ehr8LDifF33yg8GUQ9MV1lDysYHnCG','vishal@gmail.com',9987544694),
('ankush','pathak','ADMIN',true,'$2a$06$O5LpNm54bysLfy2UIK47oeQYEAPtpVnUimBj5dk793WiW1SPoIzx6','Ankush@gmail.com',9987544694);




//cart line

create table CartLine (id int IDENTITY,
product_id int,
product_count int,
cart_id int,
price double,
total double,
available boolean,
CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES Product (id),
CONSTRAINT fk_cartline_cart_id FOREIGN KEY (cart_id) REFERENCES Cart (id),
CONSTRAINT pk_cartline_id PRIMARY KEY(id)
);