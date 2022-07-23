package br.com.sinquia.primeiroprojetoweb.bo;

import br.com.sinquia.primeiroprojetoweb.dao.ClienteDAO;
import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import java.io.DataInput;
import java.util.List;
import java.util.Objects;

public class ClienteBusinessObject {

    private ClienteDAO clienteDAO;

    public ClienteBusinessObject(){
        clienteDAO = new ClienteDAO(); // TODO rever isso, não é bacana
    }

    public Cliente save(Cliente cliente){
        valida(cliente);
        return clienteDAO.save(cliente);
    }

    private void valida(Cliente cliente) {
        if(Objects.isNull(cliente.getNome())){
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    public List<Cliente> findAll(){
        return clienteDAO.findAll();
    }
}
