SET FOREIGN_KEY_CHECKS=0;
drop table product;
SET FOREIGN_KEY_CHECKS=1;
SET FOREIGN_KEY_CHECKS=0;
drop table category;
SET FOREIGN_KEY_CHECKS=1;
create table product
(
    id  integer unsigned not null auto_increment primary key,
    name_product varchar(100) not null,
    final_price  double (10, 0) not null

    );
create table category
(
    id            integer      not null auto_increment primary key,
    category_name varchar(100) not null,
    image         varchar(20)
);
