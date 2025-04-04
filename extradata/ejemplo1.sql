create database if not exists ejemplo1DB;
use ejemplo1DB;

create table if not exists Clientes(
    idCliente varchar(10) unique primary key,
    nombre varchar(50) not null
) engine=innoDB;

create table if not exists Productos(
    idProducto varchar(10) unique primary key,
    tipo varchar(15),
    descripcion varchar(100)
) engine=innoDB;

create table if not exists ProdAlimenticios(
    idProductoAlimenticio varchar(10) unique primary key,
    foreign key (idProductoAlimenticio) references Productos(idProducto) on delete cascade,
    aporteCalorico varchar(10) not null
) engine=innoDB;

create table if not exists ProdElectricos(
    idProductoElectrico varchar(10) unique primary key,
    foreign key (idProductoElectrico) references Productos(idProducto) on delete cascade,
    voltajeEntrada varchar(10) not null
) engine=innoDB;
