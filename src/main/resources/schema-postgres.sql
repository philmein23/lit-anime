drop table if exists products cascade;
drop table if exists orders cascade;


create table if not exists products (
    product_id serial primary key,
    product_name varchar(255),
    price float,
    product_type varchar(255),
    description varchar(255)
);

create table if not exists orders (
    order_id serial primary key,
    order_status varchar(255),
    order_date timestamp,
    product_id int,
    constraint fk_product foreign key(product_id) references products(product_id)
);

