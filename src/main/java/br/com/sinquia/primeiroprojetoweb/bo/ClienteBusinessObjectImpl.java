package br.com.sinquia.primeiroprojetoweb.bo;

import br.com.sinquia.primeiroprojetoweb.dao.ClienteDAOI;
import br.com.sinquia.primeiroprojetoweb.dao.ClienteDAOImpl;
import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteBusinessObjectImpl implements ClienteBusinessObjectI{

    private ClienteDAOI clienteDAO;

    @Inject
    public ClienteBusinessObjectImpl(ClienteDAOI clienteDAOI){
        this.clienteDAO = clienteDAOI;
    }

    @Override
    public Cliente save(Cliente cliente){
        valida(cliente);
        return clienteDAO.save(cliente);
    }

    private void valida(Cliente cliente) {
        if(Objects.isNull(cliente.getNome())){
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    @Override
    public List<Cliente> findAll(){
        return clienteDAO.findAll();
    }

    @Override
    public void delete(String idCliente) {
        clienteDAO.delete(idCliente);
    }

    @Override
    public Cliente getById(String idCliente) {
        Optional<Cliente> optionalCliente = clienteDAO.getById(idCliente);
        if (optionalCliente.isPresent()){
            return optionalCliente.get();
        } else {
            throw new IllegalArgumentException("Cliente não encontrado para o id: ".concat(idCliente));
        }
    }

    @Override
    public Cliente update(Cliente cliente) {
        Optional<Cliente> optionalCliente = clienteDAO.update(cliente);
        return optionalCliente.get();
    }
}
