package com.mycompany.web.models;
import com.mycompany.web.models.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class AccionesPaciente {
//insertar registro
public static int registrarPaciente(Paciente p){
    int estado = 0;

    try {
        Class.forName("com.mysql.jdbc.Driver"); 
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/consultorio","root","Agus");

        String query = "INSERT INTO pacientes(dni,nombre,apellido,edad,contacto) VALUES (?,?,?,?,?)";

        String dni = p.getDni();
        String nombre = p.getNombre();
        String apellido = p.getApellido();
        String edad = p.getEdad();
        String contacto = p.getContacto();

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, dni);
        pst.setString(2, nombre);
        pst.setString(3, apellido);
        pst.setString(4, edad);
        pst.setString(5, contacto);

        estado = pst.executeUpdate();

        conexion.close();


    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return estado;
}

public static int actualizarPaciente(Paciente p){
    int estado = 0;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/consultorio","root","Agus");

        String query = "UPDATE pacientes SET nombres=?,apellidos=?,edad=?,contacto=? WHERE id_paciente=?";

        String dni = p.getDni();
        String nombre = p.getNombre();
        String apellido = p.getApellido();
        String edad = p.getEdad();
        String contacto = p.getContacto();

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, dni);
        pst.setString(2, nombre);
        pst.setString(3, apellido);
        pst.setString(4, contacto);
        pst.setString(5, edad);

        estado = pst.executeUpdate();

        conexion.close();


    } catch (Exception e){
        System.out.println("uppsss algo salio mal");
    }

    return estado;
}


/** public static Paciente verPaciente(int idAConsultar){
    Paciente pacienteADevolver = new Paciente();

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/consultorio","root","Agus");

        String query = "SELECT * FROM pacientes WHERE id=?";

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setInt(1, idAConsultar);

        ResultSet consultaPaciente = pst.executeQuery();

        if (consultaPaciente.next()){
            pacienteADevolver.setDni( consultaPaciente.getString(1));
            pacienteADevolver.setNombre( consultaPaciente.getString(2));
            pacienteADevolver.setApellido( consultaPaciente.getString(3));
            pacienteADevolver.setEdad( consultaPaciente.getString(4));
            pacienteADevolver.setContacto( consultaPaciente.getString(5));
            conexion.close();
        }
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return pacienteADevolver;
}  **/
public static Paciente verPaciente(String dniAConsultar){
    Paciente pacienteADevolver = new Paciente();

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/consultorio","root","Agus");

        String query = "SELECT * FROM pacientes WHERE DNI=?";

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, dniAConsultar);

        ResultSet consultaPaciente = pst.executeQuery();

        if (consultaPaciente.next()){
            pacienteADevolver.setId( consultaPaciente.getInt(1));
            pacienteADevolver.setDni( consultaPaciente.getString(2));
            pacienteADevolver.setNombre( consultaPaciente.getString(3));
            pacienteADevolver.setApellido( consultaPaciente.getString(4));
            pacienteADevolver.setEdad( consultaPaciente.getString(5));
            pacienteADevolver.setContacto( consultaPaciente.getString(6));
            conexion.close();
        }
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return pacienteADevolver;
}

public static List<Paciente> verTodosPacientes(){
    List<Paciente> listaPacientesADevolver = new ArrayList<Paciente>();
    

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/consultorio","root","Agus");

        String query = "SELECT * FROM pacientes";

        PreparedStatement pst = conexion.prepareStatement(query);

        ResultSet consultaPaciente = pst.executeQuery();

        while (consultaPaciente.next()){
            Paciente pacienteADevolver = new Paciente(); //EN CADA VUELTA NECESITAREMOS INSTANCIAR UN NUEVO OBJETO
            pacienteADevolver.setId( consultaPaciente.getInt(1));
            pacienteADevolver.setDni( consultaPaciente.getString(2));
            pacienteADevolver.setNombre( consultaPaciente.getString(3));
            pacienteADevolver.setApellido( consultaPaciente.getString(4));
            pacienteADevolver.setEdad( consultaPaciente.getString(5));
            pacienteADevolver.setContacto( consultaPaciente.getString(6));
            listaPacientesADevolver.add(pacienteADevolver);
        }
        conexion.close();
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return listaPacientesADevolver;
} 
    
}
