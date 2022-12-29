package com.mycompany.web.servlets;
import java.io.IOException;
import com.mycompany.web.models.AccionesPaciente;
import com.mycompany.web.models.Paciente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verpaciente")
public class VerServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String d = req.getParameter("dni");
        Paciente registro = AccionesPaciente.verPaciente(d);

        req.setAttribute("p", registro);

        RequestDispatcher respuesta = req.getRequestDispatcher("/infopaciente.jsp");
        respuesta.forward(req,resp);
    }
}
