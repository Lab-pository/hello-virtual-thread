DROP TABLE if EXISTS PRODUCT cascade;
DROP TABLE if EXISTS PRODUCT_CREATE_EVENT cascade;

CREATE TABLE PRODUCT
(
    id       bigint generated by default as identity,
    price    integer not null,
    quantity bigint  not null,
    name     varchar(255),
    primary key (id)
);

CREATE TABLE PRODUCT_CREATE_EVENT
(
    id         bigint generated by default as identity,
    product_id bigint not null,
    primary key (id)
);
