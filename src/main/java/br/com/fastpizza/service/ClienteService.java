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
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Value("${cliente.nao.encontrado}")
    private String clienteNaoEncontrado;

    public ResponseEntity<?> buscar(String cpf) {
        try {
            Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
            if(!Objects.isNull(cliente)) {
                return ResponseEntity.status(HttpStatus.OK).body(cliente);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> inserir(Cliente cli) {
        clienteRepository.save(cli);
        return ResponseEntity.status(HttpStatus.CREATED).body(cli);
    }

    public ResponseEntity<?> deletar(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(Objects.isNull(cliente)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteNaoEncontrado);
        }else {
            clienteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }
    }
}
