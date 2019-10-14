create table customer(
          id int  not null auto_increment primary key ,
          name varchar(10) not null,
          email varchar (100) not null,
          phone_number varchar (10) not null,
          foreign key (phone_number) references product(id)
);
create table product(
        id int not null auto_increment primary key,
        name_product varchar (100) not null,
        total_price double (10) not null,

          foreign key (name) references customer(id)




);

create table checklist(
        id int  not null auto_increment primary key,
        address_customer varchar (1000) not null ,
        manager varchar (1000) not null,
         foreign key (name) references customer(id)


);
create table dogs_goods(
        id int  not null auto_increment primary key,
        name_product varchar(1000) not null,
        quality varchar(100) not null,
           foreign key (name_product,quality) references product(id)

           );


