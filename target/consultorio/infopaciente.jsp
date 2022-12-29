<%@ page contentType="text/html" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Informacion Registro</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <section>
    <h2>Informacion del Paciente</h2>
    <p>ID: ${p.getId()}</p>
    <p>DNI: ${p.getDni()}</p>
    <p>Nombre: ${p.getNombre()}</p>
    <p>Apellido: ${p.getApellido()}</p>
    <p>Edad: ${p.getEdad()}</p>
    <p>Contacto: ${p.getContacto()}</p>
    </section>
    <a href="index.html">Volver</a>
</body>
</html>