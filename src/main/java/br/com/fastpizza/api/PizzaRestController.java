package br.com.fastpizza.api;

import br.com.fastpizza.entity.Pizza;
import br.com.fastpizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fastpizza/pizzas")
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Pizza pizza) {
        return pizzaService.cadastrar(pizza);
    }

}
