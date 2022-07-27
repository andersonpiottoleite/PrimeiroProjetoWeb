package br.com.sinquia.primeiroprojetoweb;

import br.com.sinquia.primeiroprojetoweb.bo.ClienteBusinessObjectI;
import br.com.sinquia.primeiroprojetoweb.bo.ClienteBusinessObjectImpl;
import br.com.sinquia.primeiroprojetoweb.injecao.email.EmailService;
import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(value = "/cliente-servlet/*") /*    esse    /*   diz que qualquer requisição que venha com
                                                cliente-servlet/qualquer-coisa vai cair ai nessa servlet.
                                                exemplo
                                           */
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
        System.out.println("Iniciando Servlet");
    }

    /** Metodo service, que realiza a distribuição para, POST, PUT, DELETE, ETC.
     * Uma espécie de controlador que age de acordo com o comando (cadastrar, editar, etc) que vem do request
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String caminho = request.getPathInfo();

        switch (caminho) {
            case "/cadastrar-cliente":
                doPost(request, response);
                break;
            case "/carregar-para-edicao":
                carregarParaEdicao(request, response);
                break;
            case "/editar-cliente":
                doPut(request, response);
                break;
            case "/deletar":
                doDelete(request, response);
                break;
            default:
                super.service(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = clienteBusinessObjectI.findAll();

        request.setAttribute("clientes", clientes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-clientes.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cliente cliente = criaCliente(request);

        Cliente clienteSalvo = clienteBusinessObjectI.save(cliente);

        emailService.enviaEmailBoasVindas(cliente);

        request.setAttribute("idClienteSalvo", clienteSalvo.getId());

        List<Cliente> clientes = clienteBusinessObjectI.findAll();

        request.setAttribute("clientes", clientes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-clientes.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCliente = request.getParameter("id");
        clienteBusinessObjectI.delete(idCliente);

        List<Cliente> clientes = clienteBusinessObjectI.findAll();
        request.setAttribute("clientes", clientes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-clientes.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Cliente cliente = criaCliente(request);

        cliente.setId(Long.parseLong(id));

        Cliente clienteAlterado = clienteBusinessObjectI.update(cliente);

        request.setAttribute("idClienteAlterado", clienteAlterado.getId());

        List<Cliente> clientes = clienteBusinessObjectI.findAll();

        request.setAttribute("clientes", clientes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-clientes.jsp");
        dispatcher.forward(request,response);
    }


    private void carregarParaEdicao(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String idCliente = request.getParameter("id");

        Cliente cliente = clienteBusinessObjectI.getById(idCliente);

        request.setAttribute("cliente", cliente);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/edicao-cliente.jsp");
        dispatcher.forward(request,response);
    }
    private Cliente criaCliente(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String idade = request.getParameter("idade");

        Integer idadeCliente = null;
        if(!idade.isEmpty()){
            idadeCliente = Integer.parseInt(idade);
        }
        Cliente cliente = new Cliente(nome, cpf, email, idadeCliente);
        return cliente;
    }

    @Override
    public void destroy() {
        System.out.println("Destruindo Servlet");
    }
}
