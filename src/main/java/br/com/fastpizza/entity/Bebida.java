package br.com.fastpizza.entity;

import javax.persistence.Entity;

@Entity
public class Bebida extends Produto {

    private String nome;
    private String quantidade;

    public Bebida() {

    }

    public Bebida(Integer codigo, String categoria, String descricao, double preco, String nome, String quantidade) {
        super(codigo, categoria, descricao, preco);
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

}
