package br.com.fastpizza.service;

import br.com.fastpizza.entity.Pizza;
import br.com.fastpizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Value("${pizza.nao.cadastrada}")
    private String pizzaNaoCadastrada;

    public ResponseEntity<?> cadastrar(Pizza pizza) {
        try {
            if (!Objects.isNull(pizza)){
                pizzaRepository.save(pizza);
                return ResponseEntity.status(HttpStatus.OK).body(pizza);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
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
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pizzaNaoCadastrada);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
