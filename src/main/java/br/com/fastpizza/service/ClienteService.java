package br.com.fastpizza.service;

import org.springframework.http.ResponseEntity;

public interface ClienteService {

    ResponseEntity<?> buscar(Integer id);

}
