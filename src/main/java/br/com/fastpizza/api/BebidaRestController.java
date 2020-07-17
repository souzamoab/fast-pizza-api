package br.com.fastpizza.api;

import br.com.fastpizza.entity.Bebida;
import br.com.fastpizza.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fastpizza/bebidas")
public class BebidaRestController {

    @Autowired
    private BebidaService bebidaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Bebida bebida) {
        return bebidaService.cadastrar(bebida);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscar(@PathVariable Integer codigo) {
        return bebidaService.buscar(codigo);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> buscar(@RequestParam String categoria, @RequestParam String nome) {
        return bebidaService.buscar(categoria, nome);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> remover(@PathVariable Integer codigo) {
        return bebidaService.remover(codigo);
    }

}
