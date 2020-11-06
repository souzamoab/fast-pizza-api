package br.com.fastpizza.service;

import br.com.fastpizza.entity.Categoria;
import br.com.fastpizza.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Value("${categoria.ja.cadastrada}")
    private String categoriaJaCadastrada;

    @Value("${categoria.nao.encontrada}")
    private String categoriaNaoEncontrada;

    @Override
    public ResponseEntity<?> cadastrar(Categoria categoria) {
        try {
            if(!categoriaRepository.existsByNome(categoria.getNome())) {
                categoriaRepository.save(categoria);
                return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoriaJaCadastrada);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> listar(Integer id) {
        try {
            if(categoriaRepository.existsById(id)) {
                Optional<Categoria> categoria = categoriaRepository.findById(id);
                return ResponseEntity.status(HttpStatus.OK).body(categoria);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoriaNaoEncontrada);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
