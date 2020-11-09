package br.com.fastpizza.repository;

import br.com.fastpizza.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findById(Integer id);
    Optional<Categoria> findByNome(String nome);
    boolean existsById(Integer id);
    boolean existsByNome(String nome);

}
