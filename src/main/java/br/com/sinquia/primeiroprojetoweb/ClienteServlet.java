package br.com.sinquia.primeiroprojetoweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/cliente-servlet")
public class ClienteServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Inciando Servlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Chamando Metodo");
        response.setContentType("text/html");

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p>Nome Cliente: "+nome+"</p>");
        writer.println("<p>CPF Cliente: "+cpf+"</p>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Chamando Metodo");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<p>POST</p>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    public void destroy() {
        System.out.println("Destruindo Servlet");
    }
}
