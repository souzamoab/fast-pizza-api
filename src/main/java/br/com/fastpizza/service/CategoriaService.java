package br.com.fastpizza.service;

import br.com.fastpizza.entity.Categoria;
import br.com.fastpizza.vo.CategoriaDTO;
import org.springframework.http.ResponseEntity;

public interface CategoriaService {

    ResponseEntity<?> cadastrar(CategoriaDTO categoriaDTO);
    ResponseEntity<?> buscar(Integer id);
    ResponseEntity<?> update(Integer id, CategoriaDTO categoriaDTO);
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<?> listar();
    ResponseEntity<?> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);
    Categoria fromDTO(CategoriaDTO categoriaDTO);

}
