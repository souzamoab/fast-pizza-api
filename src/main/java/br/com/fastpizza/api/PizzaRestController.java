package br.com.fastpizza.api;

import br.com.fastpizza.entity.Pizza;
import br.com.fastpizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fastpizza/pizzas")
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Pizza pizza) {
        return pizzaService.cadastrar(pizza);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscar(@PathVariable Integer codigo) {
        return pizzaService.buscar(codigo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> remover(@PathVariable Integer codigo) {
        return pizzaService.remover(codigo);
    }

}
