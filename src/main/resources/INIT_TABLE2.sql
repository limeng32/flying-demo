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
values ('2', '1', '2017-09-10 18:39:00');

create table COMMODITY
(
   ID         			varchar(40) not null ,
   NAME                 varchar(64) ,
   PRICE            	integer ,
   primary key (ID)
);

create table CART_COMMODITY
(
   ID         			varchar(40) not null ,
   CART_ID              varchar(40) ,
   COMM_ID				varchar(40) ,
   AMOUNT            	integer ,
   primary key (ID)
);