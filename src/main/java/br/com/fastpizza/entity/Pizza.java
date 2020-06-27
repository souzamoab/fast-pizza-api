package br.com.fastpizza.entity;

import javax.persistence.Entity;

@Entity
public class Pizza extends Produto {

    private String sabor;
    private String tamanho;

    public Pizza() {

    }

    public Pizza(Integer codigo, String categoria, String descricao, double preco, String sabor, String tamanho) {
        super(codigo, categoria, descricao, preco);
        this.sabor = sabor;
        this.tamanho = tamanho;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
