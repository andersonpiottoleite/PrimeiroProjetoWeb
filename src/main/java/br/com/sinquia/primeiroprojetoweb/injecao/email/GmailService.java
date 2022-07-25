package br.com.sinquia.primeiroprojetoweb.injecao.email;

import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import javax.enterprise.inject.Default;
import javax.inject.Named;

@Named("servicoGmail")
//@ServicoGmailQualifier
public class GmailService implements EmailService{

    public void enviaEmailBoasVindas(Cliente cliente){
        System.out.println("GMAIL SERVICE: Enviando Email de boas vindas para :".concat(cliente.getEmail()));
    }
}
