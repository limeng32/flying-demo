drop table if exists CART;

drop table if exists Commodity;

drop table if exists CART_COMMODITY;

create table CART
(
   ID         			varchar(40) not null ,
   DEAL                 tinyint ,
   DEAL_TIME            datetime ,
   primary key (ID)
);

insert into CART
values ('1', '0', null);

insert into CART
values ('2', '0', null);

create table COMMODITY
(
   ID         			varchar(40) not null ,
   NAME                 varchar(64) ,
   PRICE            	integer ,
   primary key (ID)
);

insert into COMMODITY
values ('1', '牙刷A', '1200');

insert into COMMODITY
values ('2', '牙刷B', '1850');

insert into COMMODITY
values ('3', '牙刷C', '2100');

insert into COMMODITY
values ('4', '佳洁士牙膏', '1499');

insert into COMMODITY
values ('5', '六必治牙膏', '1999');

insert into COMMODITY
values ('6', '云南白药牙膏', '2499');

insert into COMMODITY
values ('7', '潘婷洗发露', '3500');

insert into COMMODITY
values ('8', '多芬洗发露', '3900');

insert into COMMODITY
values ('9', '海飞丝洗发露', '5100');

insert into COMMODITY
values ('10', '浴液-1500ML', '2800');

insert into COMMODITY
values ('11', '浴液-2000ML', '3200');

insert into COMMODITY
values ('12', '浴液-4000ML', '4900');

create table CART_COMMODITY
(
   ID         			varchar(40) not null ,
   CART_ID              varchar(40) ,
   COMM_ID				varchar(40) ,
   AMOUNT            	integer ,
   primary key (ID)
);

insert into CART_COMMODITY
values ('1', '1', '1', '3');

insert into CART_COMMODITY
values ('2', '1', '5', '4');

insert into CART_COMMODITY
values ('3', '1', '8', '1');

insert into CART_COMMODITY
values ('4', '1', '12', '1');

insert into CART_COMMODITY
values ('5', '2', '2', '2');

insert into CART_COMMODITY
values ('6', '2', '4', '1');

insert into CART_COMMODITY
values ('7', '2', '9', '2');

insert into CART_COMMODITY
values ('8', '2', '11', '1');