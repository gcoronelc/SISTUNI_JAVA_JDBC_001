CREAR SCOTT
======================

1.- Copiar el archivo scott.sql
    a la raíz de la unidad E:

2.- Ejecutar el archivo scott.sql 
    con el usuario SYSTEM.

SQL> connect system/oracle

SQL> @E:\scott.sql

SQL> show user
Usuario: SCOTT

La contraseña de scott es tiger.

SQL> connect scott/tiger


HABILITAR HR
===============================

SQL> altr user hr
     account unlock
	 identified by hr;

SQL> connect hr/hr

SQL> select * from cat;


CREAR EL ESQUEMA UNI
==================================

connect system/oracle;

create user uni
identified by uni;

grant connect, resource
to uni;

connect uni/uni;


create table mensaje(
  id number(5) primary key,
  de varchar2(20),
  para varchar2(20),
  texto varchar2(200)
);


create sequence sq_mensaje;

insert into mensaje
values(sq_mensaje.nextval,'Gustavo','Todos',
'Que les parece el curso?');


column texto format a50
select * from mensaje;


commit;



AVERIGUAR PARAMETROS DE LA BASE DE DATOS
=============================================

connect system/oracle

show parameter name

NAME                                 TYPE        VALUE
------------------------------------ ----------- --------------
db_file_name_convert                 string
db_name                              string      XE
db_unique_name                       string      XE
global_names                         boolean     FALSE
instance_name                        string      xe
lock_name_space                      string
log_file_name_convert                string
service_names                        string      XE

CONEXION REMOTA
===============================

SINTAXIS
--------

connect usuario/clave@ip:1521/sid


EJEMPLO
-------

connect uni/uni@172.17.3.126:1521/XE


insert into mensaje
values(sq_mensaje.nextval,'Gustavo','Todos',
'Me llamo Gustavo, y tú?');

insert into mensaje
values(sq_mensaje.nextval,'Gustavo','Todos',
'mi face es gcronelc.');








	 


	
	
	
	
	
	