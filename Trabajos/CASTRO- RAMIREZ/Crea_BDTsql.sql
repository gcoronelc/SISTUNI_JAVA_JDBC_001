

DECLARE
	N INT;
	COMMAND VARCHAR2(200);
BEGIN
	COMMAND := 'DROP USER SOL CASCADE';
	SELECT COUNT(*) INTO N
	FROM DBA_USERS
	WHERE USERNAME = 'SOL';
	IF ( N = 1 ) THEN
		EXECUTE IMMEDIATE COMMAND;
	END IF;
END;
/

-- Valido para la versión 12
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

CREATE USER sol IDENTIFIED BY admin;

GRANT CONNECT, RESOURCE TO sol;

ALTER USER SOL
QUOTA UNLIMITED ON USERS;


-- =============================================
-- CONECTARSE A LA APLICACIÓN
-- =============================================

CONNECT sol/admin


-- =============================================
-- CREACIÓN DE LOS OBJETOS DE LA BASE DE DATOS
-- =============================================

CREATE TABLE Empleado (
       chr_emplcodigo       CHAR(6) NOT NULL,
       vch_emplpaterno      VARCHAR(25) NOT NULL,
       vch_emplmaterno      VARCHAR(25) NOT NULL,
       vch_emplnombre       VARCHAR(30) NOT NULL,
       vch_emplciudad       VARCHAR(30) NOT NULL,
       vch_empldireccion    VARCHAR(50) NOT NULL,
       vch_emplusuario      VARCHAR(15) NOT NULL,
       vch_emplclave        VARCHAR(15) NOT NULL,
       CONSTRAINT XPKEmpleado 
              PRIMARY KEY (chr_emplcodigo)
);

CREATE TABLE Libros (
        chr_libbcodigo       CHAR(6) NOT NULL,
       vch_libbapellidos      VARCHAR(25) NOT NULL,
       vch_libbnombre      VARCHAR(25) NOT NULL,
       vch_libbciudad     VARCHAR(30) NOT NULL,
       vch_libbobra    VARCHAR(50) NOT NULL,
       vch_libbisbn       VARCHAR(15) NOT NULL,
       CONSTRAINT XPKLibros
              PRIMARY KEY (chr_libbcodigo)
);

CREATE TABLE Pedido (
        chr_cuencodigo       CHAR(8) NOT NULL,
	   chr_cuennombre		VARCHAR(20) NOT NULL,
       dtt_cuenfecha        DATE NOT NULL,     
       CONSTRAINT XPKPedido 
              PRIMARY KEY (chr_cuencodigo)
);

			  

CREATE TABLE Contador (
       vch_conttabla        VARCHAR(30) NOT NULL,
       int_contitem         NUMBER(6,0) NOT NULL,
       int_contlongitud     NUMBER(3,0) NOT NULL,
       CONSTRAINT XPKContador 
              PRIMARY KEY (vch_conttabla)
);