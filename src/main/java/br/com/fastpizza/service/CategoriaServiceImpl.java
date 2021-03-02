package br.com.fastpizza.service;

import br.com.fastpizza.entity.Categoria;
import br.com.fastpizza.repository.CategoriaRepository;
import br.com.fastpizza.services.exception.DataIntegrityException;
import br.com.fastpizza.vo.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Value("${categoria.ja.cadastrada}")
    private String categoriaJaCadastrada;

    @Value("${categoria.nao.encontrada}")
    private String categoriaNaoEncontrada;

    @Override
    public ResponseEntity<?> cadastrar(CategoriaDTO categoriaDTO) {
        try {
            Categoria categoria = fromDTO(categoriaDTO);
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
    public ResponseEntity<?> buscar(Integer id) {
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

    @Override
    public ResponseEntity<?> update(Integer id, CategoriaDTO categoriaDTO) {
        try {
            if(categoriaRepository.existsById(id)) {
                Optional<Categoria> categoria = categoriaRepository.findById(id);

                categoria.get().setNome(categoriaDTO.getNome());

                categoriaRepository.save(categoria.get());

                return ResponseEntity.status(HttpStatus.OK).body(categoria.get());
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoriaNaoEncontrada);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        try {
            if(categoriaRepository.existsById(id)) {
                categoriaRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoriaNaoEncontrada);
            }
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
        }
    }

    @Override
    public ResponseEntity<?> listar() {
        try {
            List<Categoria> categorias = categoriaRepository.findAll();
            List<CategoriaDTO> categoriasVO = categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(categoriasVO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<Categoria> categorias = categoriaRepository.findAll(pageRequest);
        Page<CategoriaDTO> categoriasVO =  categorias.map(CategoriaDTO::new);
        return ResponseEntity.status(HttpStatus.OK).body(categoriasVO);
    }

    @Override
    public Categoria fromDTO(CategoriaDTO categoriaDTO) {
        return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
    }

}
