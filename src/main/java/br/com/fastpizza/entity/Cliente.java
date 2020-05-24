package br.com.fastpizza.entity;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Cliente extends Usuario {

    private String rua;
    private Integer numero;
    private String bairro;
    private String pontoReferencia;
    private String complemento;

    public Cliente(Integer id, String nome, String cpf, ArrayList<String> telefones, String email, String senha, String rua, Integer numero, String bairro, String pontoReferencia, String complemento) {
        super(id, nome, cpf, telefones, email, senha);
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.complemento = complemento;
    }

}