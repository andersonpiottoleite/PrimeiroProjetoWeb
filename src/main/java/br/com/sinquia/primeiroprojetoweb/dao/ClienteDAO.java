package br.com.sinquia.primeiroprojetoweb.dao;

import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/** Classe que representa o acesso a base de dados
 * @author anderson piotto
 * @since 22/07/2022
 * @version 1.0.0
 * isso deve ser subsitituido pela nomenclatura repository
 */

public class ClienteDAO {

    private static List<Cliente> bancoClientes = new ArrayList<>();
    private static long countCliente;

    public Cliente save(Cliente cliente){
        countCliente++;
        cliente.setId(countCliente);
        bancoClientes.add(cliente);
        return cliente;
    }

    public List<Cliente> findAll(){
        return bancoClientes;
    }

}
