
-- Tabla: Moneda

insert into moneda values ( '01', 'Soles' );
insert into moneda values ( '02', 'Dolares' );


-- Tabla: CargoMantenimiento

insert into cargomantenimiento values ( '01', 3500.00, 8.00 );
insert into cargomantenimiento values ( '02', 1200.00, 3.50 );

-- Tabla: CargoMovimiento

insert into CostoMovimiento values ( '01', 1.80 );
insert into CostoMovimiento values ( '02', 0.50 );

-- Tabla: InteresMensual

insert into InteresMensual values ( '01', 0.80 );
insert into InteresMensual values ( '02', 0.40 );

-- Tabla: TipoMovimiento

insert into TipoMovimiento values( '001', 'Apertura de Cuenta', 'INGRESO', 'ACTIVO' );
insert into TipoMovimiento values( '002', 'Cancelar Cuenta', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento values( '003', 'Deposito', 'INGRESO', 'ACTIVO' );
insert into TipoMovimiento values( '004', 'Retiro', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento values( '005', 'Interes', 'INGRESO', 'ACTIVO' );
insert into TipoMovimiento values( '006', 'Mantenimiento', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento values( '007', 'ITF', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento values( '008', 'Transferencia', 'INGRESO', 'ACTIVO' );
insert into TipoMovimiento values( '009', 'Transferencia', 'SALIDA', 'ACTIVO' );
insert into TipoMovimiento values( '010', 'Cargo por Movimiento', 'SALIDA', 'ACTIVO' );

-- Tabla: Sucursal

insert into sucursal values( '001', 'Miraflores', 'Lima', 'Av. Arequipa 4409', 1 );
insert into sucursal values( '002', 'Mancora', 'Piura', 'Av.Piura  2105', 1 );
insert into sucursal values( '003', 'Los Olivos', 'Lima', 'Av. Central 1234', 1 );
insert into sucursal values( '004', 'San Juan de Lurigancho', 'Lima', 'Av.Las Flores 1567', 1 );
insert into sucursal values( '005', 'Chancay', 'Lima', 'Av.1 de mayo', 1 );
insert into sucursal values( '006', 'Machupicchu', 'Cusco', 'Calle El Sol 534', 1 );


-- Tabla: Empleado

INSERT INTO empleado VALUES( '9999', 'Internet', 'Internet', 'internet', 'Internet', 'internet', 'internet', 'internet' );
INSERT INTO empleado VALUES( '0001', 'Pacheco', 'Rojas', 'Gianella Estefaniaz', 'Lima', 'Call1 1 Nro. 456', 'rpachecho', 'tom' );
INSERT INTO empleado VALUES( '0002', 'Velasco', 'Carhuamaca', 'Carla Maribel', 'Lima', 'Av.Universitaria 4322', 'cvelasco', 'gringasha' );
INSERT INTO empleado VALUES( '0003', 'Delgado', 'Alejos', 'Fiorella', 'Lima', 'Av. Aviación 3456 - San Borja', 'adelgado', 'linda' );
INSERT INTO empleado VALUES( '0004', 'Rosales', 'Olivas', 'Adriana Nicole', 'Chiclayo', 'Calle Barcelona 345', 'orosales', 'blanca' );
INSERT INTO empleado VALUES( '0005', 'Espinoza', 'Guevara', 'Diana Carolina', 'Lima', 'Av.Wiesse 1543', 'gespinoza', 'cachetes' );
INSERT INTO empleado VALUES( '0006', 'Medina', 'Villanueva', 'Brenda Estefani', 'Lima', 'Av.Mariscal Caceres 898', 'vmedina', 'kauzha' );
INSERT INTO empleado VALUES( '0007', 'Trujillo', 'Paredes', 'Paul Trujillo', 'Lima', 'Av. Perú 2312', 'ptrujillo', 'cabeza' );

-- Asignado

insert into Asignado values( '000001', '001', '0001', to_date('20070101','YYYYMMDD'), to_date('20071231','YYYYMMDD') );
insert into Asignado values( '000002', '002', '0005', to_date('20070101','YYYYMMDD'), to_date('20071231','YYYYMMDD') );
insert into Asignado values( '000003', '001', '0004', to_date('20080101','YYYYMMDD'), null );
insert into Asignado values( '000004', '002', '0001', to_date('20080101','YYYYMMDD'), null );
insert into Asignado values( '000005', '003', '0002', to_date('20080101','YYYYMMDD'), null );
insert into Asignado values( '000006', '004', '0003', to_date('20070101','YYYYMMDD'), to_date('20071231','YYYYMMDD') );
insert into Asignado values( '000007', '005', '0006', to_date('20080101','YYYYMMDD'), null );
insert into Asignado values( '000008', '006', '0005', to_date('20080101','YYYYMMDD'), null );
insert into Asignado values( '000009', '004', '0007', to_date('20080101','YYYYMMDD'), null );

-- Tabla: Parametro

insert into Parametro values( '001', 'ITF - Impuesto a la Transacciones Financieras', '0.08', 'ACTIVO' );
insert into Parametro values( '002', 'Número de Operaciones Sin Costo', '15', 'ACTIVO' );

-- Tabla: Cliente

insert into cliente values( '00001', 'LAFAIX', 'RIVERA', 'ANTHUANET', '71619273', 'LIMA', 'SAN JUAN DE LURIGANCHO', '971358007', 'anthuanet.lafaix@gmail.com' );
insert into cliente values( '00002', 'DIAZ', 'ROMERO', 'PAMELA', '72394874', 'LIMA', 'SAN JUAN DE LURIGANCHO', '924-7834', 'pmela.diaza@hotmail.com' );
insert into cliente values( '00003', 'BERMUDEZ', 'GUITERREZ', 'ALEXIS', '72638983', 'LIMA', 'LINCE', '993-62966', 'bermudez123@hotmail.com' );
insert into cliente values( '00004', 'LAGUNA', 'GARCIA', 'STEVEN', '06531983', 'LIMA', 'LOS OLIVOS', '865-84762', 'steven_12@hotmail.com' );
insert into cliente values( '00005', 'LOPEZ', 'GUITERREZ', 'NATALIA', '34554442', 'LIMA', 'SAN ISIDRO', '834-67125', 'a.natalia@hotmail.com' );
insert into cliente values( '00006', 'RIVERA', 'SALVADOR', 'MARITZA', '06285992', 'LIMA', 'CALLAO', '963-34769', 'r.feliz@gmail.com' );
insert into cliente values( '00007', 'CHAVEZ', 'CANALES', 'EDGAR RAFAEL', '10145693', 'LIMA', 'MIRAFLORES', '999-96673', 'e.chavez@gmail.com' );
insert into cliente values( '00008', 'LOARTE', 'LOARTE', 'ANLI MAITE', '72353790', 'LIMA', 'SAN ISIDRO', '966-87567', 'anli.1997@hotmail.com' );
insert into cliente values( '00009', 'EVANGELISTA', 'PIRCA', 'PEDRO', '45367273', 'LIMA', 'JESUS MARIA', '978-43768', 'force-epdro@hotmail.com' );
insert into cliente values( '00010', 'ALFARO', 'GARCIA', 'ALEJANDRO', '72627087', 'LIMA', 'SAN MIGUEL', '945-56782', 'alejandro-223@gmail.com' );
insert into cliente values( '00011', 'LAY', 'TUPAC', 'FEDERICO', '10942287', 'LIMA', 'LINCE', '956-12657', 'j.lay@peru.com' );
insert into cliente values( '00012', 'ATENCIO', 'SOTO', 'VALERIA ', '10612376', 'LIMA', 'SURCO', '965-67235', 'vo-soto@hotmail.com' );
insert into cliente values( '00013', 'CAMPOS', 'RAMIREZ', 'NELSON ODILON', '45682245', 'LIMA', 'SAN MIGUEL', '991-23546', 'campos-2010@gmail.com' );
insert into cliente values( '00014', 'IGLESIAS', 'RAMOS', 'ENRIQUE', '72639398', 'LIMA', 'LA MOLINA', '976-82838', 'enrique.302@gmail.com' );
insert into cliente values( '00015', 'LOVATO', 'OSCANOA', 'DEMETRIA', '34555651', 'LIMA', 'ATE', '962-32158', 'd-lovato@gmail.com' );
insert into cliente values( '00016', 'TEJADA', 'DEL AGUILA', 'TANIA LORENA', '10446791', 'LIMA', 'PUEBLO LIBRE', '966-23854', 't.tejada@hotmail.com' );
insert into cliente values( '00017', 'AZELEA', 'LEYVA', 'IGGY', '10452682', 'LIMA', 'SURCO', '956-78951', 'iggy-344@terra.com.pe' );
insert into cliente values( '00018', 'VALENTIN', 'ACOSTA', 'JUAN DIEGO', '10398247', 'LIMA', 'SAN BORJA', '921-12456', 'j.valentin@terra.com.pe' );
insert into cliente values( '00019', 'YAURICASA', 'BAUTISTA', 'YAREMIS', '74455592', 'LIMA', 'COMAS', '977-75777', 'y.yaremis@hotmail.com' );
insert into cliente values( '00020', 'ZEGARRA', 'GARCIA', 'JEREMY', '75639447', 'LIMA', 'SRIMAC', '936-45876', 'j.zegarra@hotmail.com' );

-- Tabla: Cuenta

insert into cuenta values('00100001','01','001','0004','00005',6900,to_date('20080106 16:27:48','YYYYMMDD HH24:MI:SS'),'ACTIVO',8,'123456');
insert into cuenta values('00100002','02','001','0004','00005',4500,to_date('20080108 14:21:12','YYYYMMDD HH24:MI:SS'),'ACTIVO',5,'123456');
insert into cuenta values('00200001','01','002','0001','00008',7000,to_date('20080105 13:15:30','YYYYMMDD HH24:MI:SS'),'ACTIVO',16,'123456');
insert into cuenta values('00200002','01','002','0001','00001',6800,to_date('20080109 10:30:25','YYYYMMDD HH24:MI:SS'),'ACTIVO',4,'123456');
insert into cuenta values('00200003','02','002','0001','00007',6000,to_date('20080111 15:45:12','YYYYMMDD HH24:MI:SS'),'ACTIVO',7,'123456');


-- Tabla: Movimiento

insert into movimiento values('00100001',01,to_date('20080106 16:27:48','YYYYMMDD HH24:MI:SS'),'0004','001',2800,null);
insert into movimiento values('00100001',02,to_date('20080115 13:47:31','YYYYMMDD HH24:MI:SS'),'0004','003',3200,null);
insert into movimiento values('00100001',03,to_date('20080120 17:11:15','YYYYMMDD HH24:MI:SS'),'0004','004',0800,null);
insert into movimiento values('00100001',04,to_date('20080214 12:12:12','YYYYMMDD HH24:MI:SS'),'0004','003',2000,null);
insert into movimiento values('00100001',05,to_date('20080225 15:45:23','YYYYMMDD HH24:MI:SS'),'0004','004',0500,null);
insert into movimiento values('00100001',06,to_date('20080303 11:17:19','YYYYMMDD HH24:MI:SS'),'0004','004',0800,null);
insert into movimiento values('00100001',07,to_date('20080315 13:26:39','YYYYMMDD HH24:MI:SS'),'0004','003',1000,null);

insert into movimiento values('00100002',01,to_date('20080108 14:21:12','YYYYMMDD HH24:MI:SS'),'0004','001',1800,null);
insert into movimiento values('00100002',02,to_date('20080125 15:15:15','YYYYMMDD HH24:MI:SS'),'0004','004',1000,null);
insert into movimiento values('00100002',03,to_date('20080213 11:12:56','YYYYMMDD HH24:MI:SS'),'0004','003',2200,null);
insert into movimiento values('00100002',04,to_date('20080308 10:21:12','YYYYMMDD HH24:MI:SS'),'0004','003',1500,null);

insert into movimiento values('00200001',01,to_date('20080105 13:15:30','YYYYMMDD HH24:MI:SS'),'0001','001',5000,null);
insert into movimiento values('00200001',02,to_date('20080107 12:14:18','YYYYMMDD HH24:MI:SS'),'0001','003',4000,null);
insert into movimiento values('00200001',03,to_date('20080109 09:34:12','YYYYMMDD HH24:MI:SS'),'0001','004',2000,null);
insert into movimiento values('00200001',04,to_date('20080111 11:11:11','YYYYMMDD HH24:MI:SS'),'0001','003',1000,null);
insert into movimiento values('00200001',05,to_date('20080113 16:16:16','YYYYMMDD HH24:MI:SS'),'0001','003',2000,null);
insert into movimiento values('00200001',06,to_date('20080115 14:15:16','YYYYMMDD HH24:MI:SS'),'0001','004',4000,null);
insert into movimiento values('00200001',07,to_date('20080119 18:34:12','YYYYMMDD HH24:MI:SS'),'0001','003',2000,null);
insert into movimiento values('00200001',08,to_date('20080121 16:34:18','YYYYMMDD HH24:MI:SS'),'0001','004',3000,null);
insert into movimiento values('00200001',09,to_date('20080123 10:23:56','YYYYMMDD HH24:MI:SS'),'0001','003',7000,null);
insert into movimiento values('00200001',10,to_date('20080127 09:12:56','YYYYMMDD HH24:MI:SS'),'0001','004',1000,null);
insert into movimiento values('00200001',11,to_date('20080130 16:34:50','YYYYMMDD HH24:MI:SS'),'0001','004',3000,null);
insert into movimiento values('00200001',12,to_date('20080204 16:12:21','YYYYMMDD HH24:MI:SS'),'0001','003',2000,null);
insert into movimiento values('00200001',13,to_date('20080208 17:21:23','YYYYMMDD HH24:MI:SS'),'0001','004',4000,null);
insert into movimiento values('00200001',14,to_date('20080213 14:17:45','YYYYMMDD HH24:MI:SS'),'0001','003',2000,null);
insert into movimiento values('00200001',15,to_date('20080219 17:32:23','YYYYMMDD HH24:MI:SS'),'0001','004',1000,null);

insert into movimiento values('00200002',01,to_date('20080109 10:30:25','YYYYMMDD HH24:MI:SS'),'0001','001',3800,null);
insert into movimiento values('00200002',02,to_date('20080120 14:56:23','YYYYMMDD HH24:MI:SS'),'0001','003',4200,null);
insert into movimiento values('00200002',03,to_date('20080306 13:58:58','YYYYMMDD HH24:MI:SS'),'0001','004',1200,null);

insert into movimiento values('00200003',01,to_date('20080111 15:45:12','YYYYMMDD HH24:MI:SS'),'0001','001',2500,null);
insert into movimiento values('00200003',02,to_date('20080117 14:17:12','YYYYMMDD HH24:MI:SS'),'0001','003',1500,null);
insert into movimiento values('00200003',03,to_date('20080120 14:12:12','YYYYMMDD HH24:MI:SS'),'0001','004',0500,null);
insert into movimiento values('00200003',04,to_date('20080209 15:45:34','YYYYMMDD HH24:MI:SS'),'0001','004',0500,null);
insert into movimiento values('00200003',05,to_date('20080225 11:18:20','YYYYMMDD HH24:MI:SS'),'0001','003',3500,null);
insert into movimiento values('00200003',06,to_date('20080311 10:56:23','YYYYMMDD HH24:MI:SS'),'0001','004',0500,null);

--  Tabla: Contador

insert into Contador Values( 'Moneda', 2, 2 );
insert into Contador Values( 'TipoMovimiento', 10, 3 );
insert into Contador Values( 'Sucursal', 6, 3 );
insert into Contador Values( 'Empleado', 6, 4 );
insert into Contador Values( 'Asignado', 6, 6 );
insert into Contador Values( 'Parametro', 2, 3 );
insert into Contador Values( 'Cliente', 21, 5 );

-- Actualizar Contadores

update cuenta
set int_cuencontmov = (select max(int_movinumero) from movimiento
    where movimiento.chr_cuencodigo = cuenta.chr_cuencodigo);
    
update contador
set int_contitem = (select count(*) from cliente)
where vch_conttabla = 'Cliente';

update contador
set int_contitem = (select count(*) from empleado)
where vch_conttabla = 'Empleado';

update contador
set int_contitem = (select count(*) from sucursal)
where vch_conttabla = 'Sucursal';

update contador
set int_contitem = (select count(*) from TipoMovimiento)
where vch_conttabla = 'TipoMovimiento';

update contador
set int_contitem = (select count(*) from Moneda)
where vch_conttabla = 'Moneda';

update contador
set int_contitem = (select count(*) from Asignado)
where vch_conttabla = 'Asignado';

update contador
set int_contitem = (select count(*) from Parametro)
where vch_conttabla = 'Parametro';

commit;
