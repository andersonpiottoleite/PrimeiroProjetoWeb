package br.com.sinquia.primeiroprojetoweb.injecao;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

//@Alternative
//@Named("vermelha")
@VermelhoQualifier
public class Vermelha implements Cor{
    @Override
    public String definirCor(){
        return "Vermelha";
    }
}
