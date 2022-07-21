package br.com.sinquia.primeiroprojetoweb;

import javax.servlet.RequestDispatcher;
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Chamando Metodo");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String idade = request.getParameter("idade");

        System.out.println("cadastro cliente...");

        request.setAttribute("meuNome",nome);

        RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso-cadastro-cliente.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("Destruindo Servlet");
    }
}
