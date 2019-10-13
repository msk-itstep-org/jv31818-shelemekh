create table customer(
          id long unsigneg not null auto_increment primary key ,
          name varchar(10) not null,
          email varchar (100) not null,
          phone_number varchar (10) not null
          foreign key (product_id) references product(id)
);
create table product(
        id long unsigneg not null auto_increment primary key,
        name_product varchar (100) not null, unique true ,
        total_price double (10) not null
          foreign key (customer_id) references customer(id)




);

create table checklist(
        id long unsigneg not null auto_increment primary key
        address_customer varchar (1000) not null ,
        manager varchar (1000) not null,
        foreign key (customer_id) references customer(id)


);
create table dogs_goods(
        id long unsigneg not null auto_increment primary key,
        name_product varchar(1000) not null,
        quality varchar(100) not null, unique true,
          foreign key (product_id) references product(id)


);


