package br.com.fastpizza.api;

import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fastpizza/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Cliente cliente) {
        return clienteService.inserir(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        return clienteService.buscar(id);
    }

}
