package br.com.fastpizza.service;

import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.repository.ClienteRepository;
import br.com.fastpizza.services.exception.DataIntegrityException;
import br.com.fastpizza.vo.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Value("${cliente.nao.encontrado}")
    private String clienteNaoEncontrado;

    @Value("${cliente.ja.cadastrado}")
    private String clienteCadastrado;

    public ResponseEntity<?> buscar(Integer id) {
        try {
            if(clienteRepository.existsById(id)) {
                Optional<Cliente> cliente = clienteRepository.findById(id);
                return ResponseEntity.status(HttpStatus.OK).body(cliente);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteNaoEncontrado);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> cadastrar(Cliente cli) {
        try {
            if (clienteRepository.existsByCpf(cli.getCpf())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteCadastrado);
            }else {
                clienteRepository.save(cli);
                return ResponseEntity.status(HttpStatus.CREATED).body(cli);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> delete(Integer id) {
        try {
            if(clienteRepository.existsById(id)) {
                clienteRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteNaoEncontrado);
            }
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas.");
        }
    }

    public ResponseEntity<?> update(Integer id, ClienteDTO clienteDTO) {
        try {
            if(clienteRepository.existsById(id)) {
                Optional<Cliente> cliente = clienteRepository.findById(id);

                cliente.get().setNome(clienteDTO.getNome());
                cliente.get().setEmail(clienteDTO.getEmail());

                clienteRepository.save(cliente.get());

                return ResponseEntity.status(HttpStatus.OK).body(cliente.get());

            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteNaoEncontrado);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> listar() {
        try {
            List<Cliente> clientes = clienteRepository.findAll();
            List<ClienteDTO> clientesDTO = clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(clientesDTO);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<Cliente> clientes = clienteRepository.findAll(pageRequest);
        Page<ClienteDTO> clientesDTO =  clientes.map(ClienteDTO::new);
        return ResponseEntity.status(HttpStatus.OK).body(clientesDTO);
    }

    public Cliente fromDTO(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
    }

}
