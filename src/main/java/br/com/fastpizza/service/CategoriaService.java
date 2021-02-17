package br.com.fastpizza.service;

import br.com.fastpizza.entity.Categoria;
import br.com.fastpizza.vo.CategoriaUpdateVO;
import org.springframework.http.ResponseEntity;

public interface CategoriaService {

    ResponseEntity<?> cadastrar(Categoria categoria);
    ResponseEntity<?> buscar(Integer id);
    ResponseEntity<?> update(Integer id, CategoriaUpdateVO categoriaUpdateVO);
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<?> listar();

}
