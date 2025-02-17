create database if not exists ejemplo1BD;
use ejemplo1BD;

create table if not exists Clientes(
ID integer unique primary key,
nombre varchar(25) not null
)engine=innoDB;
insert into Clientes values
(1076736852,'Juan David Gómez Cárdenas'),	
(1278432116,'Carlos Manuel Rodríguez Garnica'),
(1875432460,'María','Lucia','Torres','Pedraza');
select * from Cliente;
/*
create table if not exists Empresa(
CodSede integer unique primary key,
NomEmpresa varchar(40) not null,
Establecimiento varchar(30),
Calle varchar(30) not null,
Numeral int not null,
TelEmpresa int not null
)engine=innoDB;
insert into Empresa values
(32,'Coca-Cola',null,'37A',4,8525595),
(5,'Yamaha',null,'65C',4,3123016),
(73,'Elektra','250 Segundo piso sector 5','7B',9,8670983);
select * from Empresa;

create table if not exists Producto(
CodProducto integer unique primary key,
NomProducto varchar(255) not null,
PrecioUnitario decimal(8,2) not null,
Categoria varchar(50) not null
)engine=innoDB;
insert into Producto values
(235875,'iPhone 11 ProMax',98999.00, 'Celular'),
(654234,'Quatro 1.5L',5600.00, 'Bebida'),
(123453,'Nevera Apponte',675000.00, 'Electrodoméstico');
select * from Producto;

create table if not exists Factura(
NoFactura integer unique primary key,
NICliente integer not null,
constraint FK_NICliente foreign key(NICliente) references Cliente(NICliente),
Impuesto decimal(5,2) not null,
Descuento decimal(5,2),
FormaPago varchar(35) not null
)engine=innoDB;
insert into Factura values
(10001,1076736852,0.19,0.00,'Efectivo'),
(10002,1278432116,0.19,0.00,'Efectivo'),
(10003,1875432460,0.19,0.00,'Tarjeta Débito');
select * from Factura;

create table if not exists DetFactura(
CodDetFactura integer unique primary key,
NoFactura integer not null,
constraint FK_NoFactura foreign key(NoFactura) references Factura(NoFactura),
CodProducto integer not null,
constraint FK_CodProducto foreign key(CodProducto) references Producto(CodProducto),
Cantidad integer not null,
PrecioTotal decimal(8,2)
)engine=innoDB;
insert into DetFactura values
(10001,10001,235875,1,98999.00),
(10002,10002,654234,1,5600.00),
(10003,10003,123453,1,675000.00);
select * from DetFactura;

create table if not exists OrdenCompra(
CodVinculacion integer unique primary key,
CodSede integer not null,
constraint FK_CodSede foreign key(CodSede) references Empresa(CodSede),
CodProducto integer not null,
constraint FK_CodProducto2 foreign key(CodProducto) references Producto(CodProducto),
CantPedido integer not null,
FechaPedido varchar(10) not null
)engine=innoDB;
insert into OrdenCompra values
(312,32,235875,90,'25-11-2023'),
(532,5,654234,90,'25-11-2023'),
(102,73,123453,90,'25-11-2023');
select * from OrdenCompra;
*/
