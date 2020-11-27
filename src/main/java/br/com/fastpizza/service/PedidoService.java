package br.com.fastpizza.service;

import br.com.fastpizza.entity.Cliente;
import br.com.fastpizza.entity.Pedido;
import br.com.fastpizza.repository.ClienteRepository;
import br.com.fastpizza.repository.PedidoRepository;
import br.com.fastpizza.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Value("${cliente.nao.encontrado}")
    private String clienteNaoEncontrado;

    public ResponseEntity<?> buscar(Integer id) {
        try {
            if(pedidoRepository.existsById(id)) {
                Optional<Pedido> pedido = pedidoRepository.findById(id);
                return ResponseEntity.status(HttpStatus.OK).body(pedido);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(clienteNaoEncontrado);
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
