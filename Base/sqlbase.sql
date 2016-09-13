-- Posibles Tablas
CREATE TABLE Cliente(
  idCliente integer,
  nombre         varchar(30),
  appCliente	           varchar(30),
  apmCliente                varchar(30),
  correoCliente           varchar(50),
  puestoCliente            varchar(50),
  telefonoCliente        varchar(15),
  celularCliente           varchar(50),
  empresaCliente           varchar(50),
  areaCliente           varchar(50),
  usuariorIdusuario  integer
  );

  CREATE TABLE Usuario(
  idUsuario integer,
  usuario varchar(30),
  contrasenia varchar(30)
  );
  
CREATE TABLE Empleado(
  idEmpleado   integer,
  nombreEmpleado        varchar(50),
  appEmpleado	           varchar(30),
  apmEmpleado                varchar(30),
  direccion     varchar(30),
  rfc       varchar(50),
  fechaNacimiento date,
  genero varchar(50),
  antiguedad      integer,
  nivelPuesto      varchar(50),
  puestoEmpleado varchar(30),
  proyectoIdProyecto integer
  );
  
  CREATE TABLE Proyecto(
  idProyecto integer,
  clienteIdCliente integer,
  codigo varchar(30)
  );
  
CREATE TABLE PruebaCliente(
    idPruebaCliente integer,
    proyectoIdProyecto integer,
    pruebaIdprueba integer
);

CREATE TABLE Prueba(
    idPrueba integer;
    
);
 
