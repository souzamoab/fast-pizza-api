package br.com.fastpizza.service;

import br.com.fastpizza.entity.Pizza;
import br.com.fastpizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

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

}
