create table customer (
          id  int  unsigned not null auto_increment primary key
          references  product(id),
          name varchar(100) not null,
          email varchar (100) not null,
          phone_number varchar (10) not null

);

create table product (
        id int  unsigned not null auto_increment primary key
        references customer(id),
        name_product varchar (100) not null,
        total_price double (10,0) not null





);

create table checklist (
        id int  unsigned not null auto_increment primary key
        references customer(id),
        address_customer varchar (1000) not null,
        manager varchar (1000) not null




);

create table dogs_goods (
        id int  unsigned  not null auto_increment primary key
        references product(id),
        name_product varchar(1000) not null,
        quality varchar(100) not null

  );

create table category_product(
dogs_good_id integer not null,
product_id integer not null,

foreign key (dogs_good_id) references dogs_goods(id),
foreign key (product_id) references product(id),

unique (dogs_good_id,product_id)

);

create table roles (
id integer not null auto_increment primary key,
name varchar (100) not null


);

create table custom_roles(
customer_id integer not null,
roles_id integer  not null,

foreign key (customer_id) references customer(id),
foreign key (roles_id) references roles(id),

unique (customer_id,roles_id)
);



