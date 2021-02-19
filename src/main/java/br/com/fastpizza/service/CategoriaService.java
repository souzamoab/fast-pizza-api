package br.com.fastpizza.service;

import br.com.fastpizza.entity.Categoria;
import br.com.fastpizza.vo.CategoriaUpdateDTO;
import br.com.fastpizza.vo.CategoriaInputDTO;
import org.springframework.http.ResponseEntity;

public interface CategoriaService {

    ResponseEntity<?> cadastrar(CategoriaInputDTO categoriaInputDTO);
    ResponseEntity<?> buscar(Integer id);
    ResponseEntity<?> update(Integer id, CategoriaUpdateDTO categoriaUpdateDTO);
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<?> listar();
    ResponseEntity<?> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);
    Categoria fromDTO(CategoriaInputDTO categoriaInputDTO);

}
