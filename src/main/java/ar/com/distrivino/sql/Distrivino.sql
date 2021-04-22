create database DistriVino;
use Distrivino;

create table vinos(
codigo int auto_increment primary key,
bodega varchar(30) not null,
nombre varchar(30) not null,
descripcion varchar(30) not null,
añoElab int not null
);

alter table venta add column total double not null;


alter table venta add constraint FK_vi FOREIGN KEY (vinoCodigo) references vinos(codigo);

create table compra(
proveedorId int not null,
vinoCodigo int not null,
cantidad int not null,
precioUnit double not null,
factura int auto_increment primary key,
fecha varchar(30) not null
);

create table venta(
clienteId int not null,
vinoCodigo int not null,
cantidad int not null,
precioUnit double not null,
factura int auto_increment primary key,
fecha varchar(30) not null
);
 

create table cliente(
id int auto_increment primary key,
nombre varchar(30) not null,
telefono varchar(30) not null,
email varchar(30) not null,
formaPago varchar(30) not null
);

create table proveedor(
id int auto_increment primary key,
razonSocial varchar(30)not null,
email varchar(30)not null
);
alter table stock 
drop constraint FK_st_ven;

create table totalesVenta(
ingresosVenta double not null,
cantidad int not null,
factura int not null primary key,
fecha varchar(10) not null
);

drop table totalesVenta; 
add column cantidad int not null;

alter table totalesVenta
drop column fecha;

