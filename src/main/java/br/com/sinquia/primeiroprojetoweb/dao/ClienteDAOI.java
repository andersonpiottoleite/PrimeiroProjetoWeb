package br.com.sinquia.primeiroprojetoweb.dao;

import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteDAOI {

    Cliente save(Cliente cliente);

    List<Cliente> findAll();

    void delete(String idCliente);

    Optional<Cliente> getById(String idCliente);

    Optional<Cliente> update(Cliente cliente);
}
