package br.com.sinquia.primeiroprojetoweb;

import br.com.sinquia.primeiroprojetoweb.bo.ClienteBusinessObjectI;
import br.com.sinquia.primeiroprojetoweb.bo.ClienteBusinessObjectImpl;
import br.com.sinquia.primeiroprojetoweb.injecao.email.EmailService;
import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/cliente-servlet")
public class ClienteServlet extends HttpServlet {

    @Inject
    @Named("servicoGmail")
    //@ServicoGmailQualifier
    private EmailService emailService;

    private ClienteBusinessObjectI clienteBusinessObjectI;

    @Inject
    public ClienteServlet(ClienteBusinessObjectI clienteBusinessObjectI){
        this.clienteBusinessObjectI = clienteBusinessObjectI;
    }

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

        Integer idadeCliente = null;
        if(!idade.isEmpty()){
            idadeCliente = Integer.parseInt(idade);
        }
        Cliente cliente = new Cliente(nome, cpf, email, idadeCliente);
        Cliente clienteSalvo = clienteBusinessObjectI.save(cliente);

        emailService.enviaEmailBoasVindas(cliente);

        request.setAttribute("idClienteSalvo", clienteSalvo.getId());

        List<Cliente> clientes = clienteBusinessObjectI.findAll();

        request.setAttribute("clientes", clientes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("lista-clientes.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("Destruindo Servlet");
    }
}
