package br.com.fastpizza.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;

@JsonSerialize
public class ClienteVO {

    public String nome;
    public ArrayList<String> telefones;
    public String email;
    public String senha;
    public String rua;
    public Integer numero;
    public String bairro;
    public String pontoReferencia;
    public String complemento;

}
