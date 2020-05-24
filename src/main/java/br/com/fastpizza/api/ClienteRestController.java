package br.com.fastpizza.api;

import br.com.fastpizza.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fastpizza/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<String> buscar(@PathVariable Integer id) {
        return (ResponseEntity<String>) clienteService.buscar(id);
    }

}
