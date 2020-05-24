package br.com.fastpizza.controller;

import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fastpizza/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Cliente cliente = clienteService.buscar(id);
        return ResponseEntity.ok(cliente);
    }

}
