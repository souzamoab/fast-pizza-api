package br.com.fastpizza.service;

import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.repository.ClienteRepository;
import br.com.fastpizza.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Value("${cliente.nao.encontrado}")
    private String clienteNaoEncontrado;

    @Value("${cliente.ja.cadastrado}")
    private String clienteCadastrado;

    public ResponseEntity<?> buscar(String cpf) {
        try {
            if(clienteRepository.existsByCpf(cpf)) {
                Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
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

    @Transactional
    public ResponseEntity<?> remover(String cpf) {
        try {
            if(clienteRepository.existsByCpf(cpf)) {
                Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
                clienteRepository.deleteByCpf(cpf);
                return ResponseEntity.status(HttpStatus.OK).body(cliente);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteNaoEncontrado);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> atualizar(String cpf, ClienteVO clienteVO) {
        try {
            if(clienteRepository.existsByCpf(cpf)) {
                Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);

                cliente.get().setNome(clienteVO.nome);
                cliente.get().setEmail(clienteVO.email);

                clienteRepository.save(cliente.get());

                return ResponseEntity.status(HttpStatus.OK).body(cliente.get());

            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteNaoEncontrado);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
