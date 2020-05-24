package br.com.fastpizza.service;

import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@Service
@CrossOrigin
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Integer id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.orElse(null);

    }

}
