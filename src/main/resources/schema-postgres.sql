drop table if exists products cascade;
drop table if exists orders cascade;
drop table if exists order_items;
drop table if exists cart_items;
drop table if exists shopping_carts;
drop table if exists customers;

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

create table if not exists customers (
  customer_id int generated always as identity primary key,
  first_name varchar(255),
  last_name varchar(255),
  address varchar(255),
  email varchar(255),
  user_name varchar(255),
  password varchar(255)
);

create table if not exists shopping_carts (
    cart_id int generated always as identity primary key,
    customer_id int,
    constraint fk_user foreign key(customer_id) references customers(customer_id)
);

create table if not exists cart_items (
    cart_item_id int generated always as identity primary key,
    quantity int,
    cart_id int,
    product_id int,
    constraint fk_cart foreign key(cart_id) references shopping_carts(cart_id),
    constraint fk_product foreign key(product_id) references products(product_id)
);



