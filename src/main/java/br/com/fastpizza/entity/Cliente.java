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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}