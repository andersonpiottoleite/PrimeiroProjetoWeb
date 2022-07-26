package br.com.sinquia.primeiroprojetoweb.dao;

import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import java.util.List;

public interface ClienteDAOI {

    Cliente save(Cliente cliente);

    List<Cliente> findAll();
}
