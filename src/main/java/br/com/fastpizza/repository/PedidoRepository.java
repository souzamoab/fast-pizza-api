package br.com.fastpizza.repository;

import br.com.fastpizza.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    Optional<Pedido> findById(Integer id);
    boolean existsById(Integer id);

}
