package br.com.fastpizza.service;

import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Value("${cliente.nao.encontrado}")
    private String clienteNaoEncontrado;

    @Override
    public ResponseEntity<?> buscar(Integer id) {
        try {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            if(Objects.isNull(cliente)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteNaoEncontrado);
            }else {
                return ResponseEntity.status(HttpStatus.OK).body(cliente);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> inserir(Cliente cli) {
        clienteRepository.save(cli);
        return ResponseEntity.status(HttpStatus.CREATED).body(cli);
    }
}
