package br.com.fastpizza.repository;

import br.com.fastpizza.entity.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Integer> {

    Boolean existsByCodigo(Integer codigo);
    Boolean existsByCategoriaAndNome(String categoria, String nome);

}
