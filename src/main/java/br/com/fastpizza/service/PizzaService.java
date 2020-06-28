package br.com.fastpizza.service;

import br.com.fastpizza.entity.Pizza;
import br.com.fastpizza.repository.CategoriaRepository;
import br.com.fastpizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;

@Service
public class PizzaService {

    //TODO: Implementar envio de imagem no cadastro de Pizza

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Value("${pizza.categoria}")
    private String pizzaCategoria;

    @Value("${pizza.nao.encontrada}")
    private String pizzaNaoEncontrada;

    @Value("${pizza.ja.cadastrada}")
    private String pizzaJaCadastrada;

    @Value("${categoria.nao.encontrada}")
    private String categoriaNaoEncontrada;

    public ResponseEntity<?> cadastrar(Pizza pizza) {
        try {
            if (!pizzaRepository.existsByCategoriaAndSabor(pizza.getCategoria(), pizza.getSabor()) && categoriaRepository.existsByNome(pizza.getCategoria())
                    && pizza.getCategoria().equals(pizzaCategoria)){
                pizzaRepository.save(pizza);
                return ResponseEntity.status(HttpStatus.CREATED).body(pizza);
            } else if (!pizzaRepository.existsByCategoriaAndSabor(pizza.getCategoria(), pizza.getSabor())
                    && !categoriaRepository.existsByNome(pizza.getCategoria())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(categoriaNaoEncontrada);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pizzaJaCadastrada);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> buscar(Integer codigo) {
        try {
            if (pizzaRepository.existsByCodigo(codigo)) {
                Optional<Pizza> pizza = pizzaRepository.findByCodigo(codigo);
                return ResponseEntity.status(HttpStatus.OK).body(pizza);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pizzaNaoEncontrada);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity<?> remover(Integer codigo) {
        try {
            if (pizzaRepository.existsByCodigo(codigo)) {
                Optional<Pizza> pizza = pizzaRepository.findByCodigo(codigo);
                pizzaRepository.deleteByCodigo(codigo);
                return ResponseEntity.status(HttpStatus.OK).body(pizza);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pizzaNaoEncontrada);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
