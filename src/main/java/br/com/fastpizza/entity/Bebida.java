package br.com.fastpizza.entity;

import javax.persistence.Entity;

@Entity
public class Bebida extends Produto {

    private String sabor;
    private String marca;
    private String quantidade;

    public Bebida() {

    }

    public Bebida(Integer codigo, String nome, String descricao, double preco, String sabor, String marca, String quantidade) {
        super(codigo, nome, descricao, preco);
        this.sabor = sabor;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

}
