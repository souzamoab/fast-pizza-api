package br.com.fastpizza.service;

import br.com.fastpizza.entity.Cliente;
import org.springframework.http.ResponseEntity;

public interface ClienteService {

    ResponseEntity<?> buscar(Integer id);

}
