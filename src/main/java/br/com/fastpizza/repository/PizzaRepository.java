package br.com.fastpizza.repository;

import br.com.fastpizza.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

    boolean existsByCodigo(Integer codigo);
    boolean existsByCategoriaAndSabor(String categoria, String sabor);
    Optional<Pizza> findByCodigo(Integer codigo);
    void deleteByCodigo(Integer codigo);

}
