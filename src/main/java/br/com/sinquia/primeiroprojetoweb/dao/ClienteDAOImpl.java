package br.com.sinquia.primeiroprojetoweb.dao;

import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Classe que representa o acesso a base de dados
 * @author anderson piotto
 * @since 22/07/2022
 * @version 1.0.0
 * isso deve ser subsitituido pela nomenclatura repository
 */

public class ClienteDAOImpl implements ClienteDAOI{

    private static List<Cliente> bancoClientes = new ArrayList<>();
    private static long countCliente;


    @Override
    public Cliente save(Cliente cliente){
        countCliente++;
        cliente.setId(countCliente);
        bancoClientes.add(cliente);
        return cliente;
    }

    @Override
    public List<Cliente> findAll(){
        return bancoClientes;
    }

    @Override
    public void delete(String idCliente) {
        for (Cliente cliente: bancoClientes) {
            if (cliente.getId().equals(Long.valueOf(idCliente))){
                bancoClientes.remove(cliente);
                break;
            }
        }
    }

    @Override
    public Optional<Cliente> getById(String idCliente) {
        for (Cliente cliente: bancoClientes) {
            if (cliente.getId().equals(Long.valueOf(idCliente))){
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Cliente> update(Cliente clienteComDadosNovos) {
        for (Cliente clienteParaAlterar: bancoClientes) {
            if (clienteParaAlterar.getId().equals(clienteComDadosNovos.getId())){
                alteraCliente(clienteParaAlterar, clienteComDadosNovos);
               return Optional.of(clienteParaAlterar);
            }
        }
        return Optional.empty();
    }

    private void alteraCliente(Cliente clienteParaAlterar, Cliente clienteComDadosNovos) {
        clienteParaAlterar.setId(clienteComDadosNovos.getId());
        clienteParaAlterar.setNome(clienteComDadosNovos.getNome());
        clienteParaAlterar.setCpf(clienteComDadosNovos.getCpf());
        clienteParaAlterar.setIdade(clienteComDadosNovos.getIdade());
        clienteParaAlterar.setEmail(clienteComDadosNovos.getEmail());
    }

}
