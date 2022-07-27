package br.com.sinquia.primeiroprojetoweb.bo;

import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import java.util.List;
import java.util.Objects;

public interface ClienteBusinessObjectI {

    Cliente save(Cliente cliente);

    List<Cliente> findAll();

    void delete(String idCliente);

    Cliente getById(String idCliente);

    Cliente update(Cliente cliente);
}
