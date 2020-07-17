package br.com.fastpizza.service;

import br.com.fastpizza.entity.Bebida;
import br.com.fastpizza.entity.Pizza;
import br.com.fastpizza.repository.BebidaRepository;
import br.com.fastpizza.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Value("${bebida.categoria}")
    private String bebidaCategoria;

    @Value("${bebida.nao.encontrada}")
    private String bebidaNaoEncontrada;

    @Value("${bebida.ja.cadastrada}")
    private String bebidaJaCadastrada;

    @Value("${categoria.nao.encontrada}")
    private String categoriaNaoEncontrada;

    @Value("${nenhuma.bebida.cadastrada}")
    private String emptyBebidas;

    public ResponseEntity<?> cadastrar(Bebida bebida) {
        try {
            if (!bebidaRepository.existsByCategoriaAndNome(bebida.getCategoria(), bebida.getNome()) && categoriaRepository.existsByNome(bebida.getCategoria())
                    && bebida.getCategoria().equals(bebidaCategoria)) {
                bebidaRepository.save(bebida);
                return ResponseEntity.status(HttpStatus.CREATED).body(bebida);
            } else if (!bebidaRepository.existsByCategoriaAndNome(bebida.getCategoria(), bebida.getNome()) && !categoriaRepository.existsByNome(bebida.getCategoria())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoriaNaoEncontrada);
            } else  {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bebidaJaCadastrada);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> buscar(Integer codigo) {
        try {
            if (bebidaRepository.existsByCodigo(codigo)) {
                Optional<Bebida> bebida = bebidaRepository.findByCodigo(codigo);
                return ResponseEntity.status(HttpStatus.OK).body(bebida);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bebidaNaoEncontrada);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> buscar(String categoria, String nome) {
        try {
            if (bebidaRepository.existsByCategoriaAndNome(categoria, nome)) {
                Optional<Bebida> bebida = bebidaRepository.findByCategoriaAndNome(categoria, nome);
                return ResponseEntity.status(HttpStatus.OK).body(bebida);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bebidaNaoEncontrada);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity<?> remover(Integer codigo) {
        try {
            if (bebidaRepository.existsByCodigo(codigo)) {
                Optional<Bebida> bebida = bebidaRepository.findByCodigo(codigo);
                bebidaRepository.deleteByCodigo(codigo);
                return ResponseEntity.status(HttpStatus.OK).body(bebida);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bebidaNaoEncontrada);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> listar() {
        try {
            if (!bebidaRepository.findAll().isEmpty()) {
                List<Bebida> bebidas = bebidaRepository.findAll();
                return ResponseEntity.status(HttpStatus.OK).body(bebidas);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(emptyBebidas);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
