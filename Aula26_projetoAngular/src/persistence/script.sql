drop database if exists bdtel;
create database bdtel;
use bdtel;

create table produto(
idProduto int primary key auto_increment,
nomeProduto varchar (50),
preco double);

 insert into produto values  (null,'hellow kitts',200);
 insert into produto values  (null,'hiphone pera',350);
 insert into produto values  (null,'hitable orange',200);
 insert into produto values  (null,'xanxung',350);
 insert into produto values  (null,'rasus',200);
 insert into produto values  (null,'celular Roni',300);
 
 select * from produto;
 