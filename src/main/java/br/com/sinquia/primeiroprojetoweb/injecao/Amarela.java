package br.com.sinquia.primeiroprojetoweb.injecao;

import javax.inject.Named;

//@Named("amarela")
@AmareloQualifier
public class Amarela implements Cor{
    @Override
    public String definirCor(){
            return "Amarela";
    }
}
