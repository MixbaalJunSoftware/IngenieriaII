-- Posibles Tablas
CREATE TABLE Cliente(
  idCliente integer,
  nombre         varchar(30),
  appCliente	           varchar(30),
  apmCliente                varchar(30),
  correoCliente           varchar(50),
  telefonoCliente        integer,
  celularClinete            integer,
  empresaCliente  varchar(50),
  areaCliente varchar(50),
  puestoCliente varchar(50),
  usuariorIdusuario  integer
  );

  CREATE TABLE Usuario(
  idUsuario integer,
  usuario varchar(30),
  contrasenia varchar(30)
  );
  
CREATE TABLE Empleado(
  idEmpleado   integer,
  fechaContrato date,
  puestoCandidato varchar (30)
  candidatoIdCandidato integer,
  proyectoIdProyecto integer
  );
  
  CREATE TABLE Candidato(
  idCandidato integer,
  nombreCandidato varchar(30),
  appCandidato varchar(30),
  apmCandidato varchar(30),
  fechaNacimientoC date,
  rfcCandidato varchar(50),
  generoCandidato varchar(20),
  direccion     varchar(30)
  );
  
  CREATE TABLE Proyecto(
  idProyecto integer,
  clienteIdCliente integer,
  Area varchar (30),
  codigo varchar(30)
  );
  
CREATE TABLE PruebaCliente(
    idPruebaCliente integer,
    proyectoIdProyecto integer,
    adaptabilidadLIdAdaptabilidadL integer
);

CREATE TABLE AdaptabilidadL(
    idadaptabilidadL integer;
    respuesta1 integer,
    respuesta2 integer,
    respuesta3 integer,
    respuesta4 integer,
    respuesta5 integer,
    respuesta6 integer,
    respuesta7 integer,
    respuesta8 integer,
    respuesta9 integer,
    respuesta10 integer,
    respuesta11 integer,
    respuesta12 integer,
    respuesta13 integer,
    respuesta14 integer,
    respuesta15 integer
    respuesta16 integer,
    respuesta17 integer,
    respuesta18 integer,
    respuesta19 integer,
    respuesta20 integer,
    respuesta21 integer,
    respuesta22 integer,
    respuesta23 integer,
    respuesta24 integer,
    respuesta25 integer,
    respuesta26 integer,
    respuesta27 integer,
    respuesta28 integer,
    respuesta29 integer,
    respuesta30 integer
);
 
