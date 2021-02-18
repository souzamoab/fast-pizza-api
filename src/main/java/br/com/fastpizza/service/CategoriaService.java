package br.com.fastpizza.service;

import br.com.fastpizza.entity.Categoria;
import br.com.fastpizza.vo.CategoriaUpdateVO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface CategoriaService {

    ResponseEntity<?> cadastrar(Categoria categoria);
    ResponseEntity<?> buscar(Integer id);
    ResponseEntity<?> update(Integer id, CategoriaUpdateVO categoriaUpdateVO);
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<?> listar();
    ResponseEntity<?> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

}
