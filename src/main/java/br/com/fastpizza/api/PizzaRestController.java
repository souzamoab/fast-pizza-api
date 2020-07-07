package br.com.fastpizza.api;

import br.com.fastpizza.entity.Pizza;
import br.com.fastpizza.service.PizzaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Pizzas")
@RequestMapping("/fastpizza/pizzas")
public class PizzaRestController {

    @Autowired
    private PizzaService pizzaService;

    @ApiOperation(value = "Método para cadastrar uma pizza")
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Pizza pizza) {
        return pizzaService.cadastrar(pizza);
    }

    @ApiOperation(value = "Método para buscar pizza pelo código")
    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscar(@PathVariable Integer codigo) {
        return pizzaService.buscar(codigo);
    }

    @ApiOperation(value = "Método para filtrar pizzas pela categoria e sabor")
    @GetMapping("/filter")
    public ResponseEntity<?> buscar(@RequestParam String categoria, @RequestParam String sabor) {
        return pizzaService.buscar(categoria, sabor);
    }

    @ApiOperation(value = "Método para listar todas as pizzas cadastradas")
    @GetMapping
    public ResponseEntity<?> listar() {
        return pizzaService.listar();
    }

    @ApiOperation(value = "Método para remover pizza pelo código")
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> remover(@PathVariable Integer codigo) {
        return pizzaService.remover(codigo);
    }

}
