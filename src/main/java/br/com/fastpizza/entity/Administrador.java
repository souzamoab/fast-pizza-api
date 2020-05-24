package br.com.fastpizza.entity;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Administrador extends Usuario {

    public Administrador() {

    }

    public Administrador(Integer id, String nome, String cpf, ArrayList<String> telefones, String email, String senha) {
        super(id, nome, cpf, telefones, email, senha);
    }

}
