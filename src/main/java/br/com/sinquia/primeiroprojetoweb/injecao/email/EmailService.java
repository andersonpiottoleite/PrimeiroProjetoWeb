package br.com.sinquia.primeiroprojetoweb.injecao.email;

import br.com.sinquia.primeiroprojetoweb.model.Cliente;

public interface EmailService {

    void enviaEmailBoasVindas(Cliente cliente);
}
