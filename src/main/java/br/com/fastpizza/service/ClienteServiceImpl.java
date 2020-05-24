package br.com.fastpizza.service;

import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ResponseEntity<?> buscar(Integer id) {

        try {
            Optional<Cliente> cliente = clienteRepository.findById(id);

            if(Objects.isNull(cliente)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado");
            }else {
                return ResponseEntity.status(HttpStatus.OK).body(cliente.get().getNome());
            }

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }
}
