package com.mycompany.web.servlets;
import com.mycompany.web.models.Paciente;
import java.io.IOException;
import com.mycompany.web.models.AccionesPaciente ;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nuevopaciente")
public class InsertarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String d, n , a, e, c;

        d = req.getParameter("dni");

        n = req.getParameter("nombre");

        a = req.getParameter("apellido");

        e = req.getParameter("edad");

        c = req.getParameter("contacto");

        Paciente nuevoPaciente = new Paciente();

        nuevoPaciente.setDni(d);
        nuevoPaciente.setNombre(n);
        nuevoPaciente.setApellido(a);
        nuevoPaciente.setEdad(e);
        nuevoPaciente.setContacto(c);

        int estado = AccionesPaciente.registrarPaciente(nuevoPaciente);

        if (estado == 1){
            resp.sendRedirect("exito.jsp");
            System.out.println("todo ok");
        } else {
            System.out.println("Error");
            resp.sendRedirect("error.jsp");
        }



    }
}
