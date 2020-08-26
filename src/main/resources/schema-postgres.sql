drop table if exists products cascade;
drop table if exists orders cascade;
drop table if exists order_items;

create table if not exists orders (
    order_id int generated always as identity primary key,
    order_status varchar(255),
    order_date timestamp
);

create table if not exists products (
    product_id int generated always as identity primary key,
    product_name varchar(255),
    price float,
    product_type varchar(255),
    description varchar(255)
);

create table if not exists order_items (
    order_item_id int generated always as identity primary key,
    quantity int,
    order_id int,
    product_id int,
    constraint fk_order foreign key(order_id) references orders(order_id),
    constraint fk_product foreign key(product_id) references products(product_id)
);

