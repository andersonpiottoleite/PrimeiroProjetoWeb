package br.com.sinquia.primeiroprojetoweb.injecao.email;

import br.com.sinquia.primeiroprojetoweb.model.Cliente;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

//@Alternative
@Named("servicoHotmail")
//@ServicoHotmailQualifier
public class HotmailService  implements EmailService {
    public void enviaEmailBoasVindas(Cliente cliente){
        System.out.println("HOTMAIL SERVICE: Enviando Email de boas vindas para :".concat(cliente.getEmail()));
    }
}
