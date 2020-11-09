package br.com.fastpizza.service;

import br.com.fastpizza.entity.Categoria;
import org.springframework.http.ResponseEntity;

public interface CategoriaService {

    ResponseEntity<?> cadastrar(Categoria categoria);
    ResponseEntity<?> listar(Integer id);

}
