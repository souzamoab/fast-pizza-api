package br.com.fastpizza.repository;

import br.com.fastpizza.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer> {

    Boolean existsByCodigo(Integer codigo);
    Boolean existsByCategoriaAndNome(String categoria, String nome);
    Optional<Bebida> findByCodigo(Integer codigo);
    Optional<Bebida> findByCategoriaAndNome(String categoria, String nome);
    void deleteByCodigo(Integer codigo);

}
