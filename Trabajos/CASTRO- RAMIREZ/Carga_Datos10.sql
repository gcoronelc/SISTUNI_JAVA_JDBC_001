

INSERT INTO libros VALUES( '0011', 'Becquer', 'Adolfo', 'España', 'Rimas y poesias', '352455');
INSERT INTO libros VALUES( '0012', 'Hugo', 'Victor', 'Francia', 'Los Miserables', '824774' );
INSERT INTO libros VALUES( '00013', 'Shakespare', 'William', 'Inglaterra', 'Hamblet', '345453' );

-- Tabla: Empleado

INSERT INTO empleado VALUES( '9999', 'Internet', 'Internet', 'internet', 'Internet', 'internet', 'internet', 'internet' );
INSERT INTO empleado VALUES( '0001', 'Romero', 'Castillo', 'Carlos Alberto', 'Trujillo', 'Call1 1 Nro. 456', 'cromero', 'chicho' );
INSERT INTO empleado VALUES( '0002', 'Castro', 'Vargas', 'Lidia', 'Lima', 'Federico Villarreal 456 - SMP', 'lcastro', 'suerte' );
INSERT INTO empleado VALUES( '0003', 'Reyes', 'Ortiz', 'Claudia', 'Lima', 'Av. Aviación 3456 - San Borja', 'creyes', 'linda' );
INSERT INTO empleado VALUES( '0004', 'Ramos', 'Garibay', 'Angelica', 'Chiclayo', 'Calle Barcelona 345', 'aramos', 'china' );
INSERT INTO empleado VALUES( '0005', 'Ruiz', 'Zabaleta', 'Claudia', 'Cusco', 'Calle Cruz Verde 364', 'cvalencia', 'angel' );
INSERT INTO empleado VALUES( '0006', 'Cruz', 'Tarazona', 'Ricardo', 'Areguipa', 'Calle La Gruta 304', 'rcruz', 'cerebro' );
INSERT INTO empleado VALUES( '0007', 'Torres', 'Diaz', 'Guino', 'Lima', 'Av. Salaverry 1416', 'gtorres', 'talento' );

insert into pedido values('00100001','JUAN RAMIRES',to_date('20080106 16:27:48','YYYYMMDD HH24:MI:SS'));
insert into pedido values('00100002','EDGAR FLORES',to_date('20080108 14:21:12','YYYYMMDD HH24:MI:SS'));
insert into pedido values('00200001','MIGUEL SOLER',to_date('20080105 13:15:30','YYYYMMDD HH24:MI:SS'));

insert into Contador Values( 'libros', 10, 2 );
insert into Contador Values( 'empleado', 10, 3 );
insert into Contador Values( 'cuenta', 10, 3 );


update contador
set int_contitem = (select count(*) from empleado)
where vch_conttabla = 'empleado';

update contador
set int_contitem = (select count(*) from libros)
where vch_conttabla = 'libros';
update contador
set int_contitem = (select count(*) from pedido)
where vch_conttabla = 'pedido';

commit;
