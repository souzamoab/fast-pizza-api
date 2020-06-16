package br.com.fastpizza.api;

import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fastpizza/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
        return clienteService.cadastrar(cliente);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> buscar(@PathVariable String cpf) {
        return clienteService.buscar(cpf);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> remover(@PathVariable String cpf) {
        return clienteService.remover(cpf);
    }

}
