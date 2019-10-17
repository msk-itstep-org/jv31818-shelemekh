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
        address_customer varchar (1000) not null ,
        manager varchar (1000) not null



);

create table dogs_goods (
        id int  unsigned  not null auto_increment primary key
        references product(id),
        name_product varchar(1000) not null,
        quality varchar(100) not null

  );
