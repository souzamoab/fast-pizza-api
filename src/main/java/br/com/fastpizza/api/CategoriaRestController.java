package br.com.fastpizza.api;

import br.com.fastpizza.entity.Categoria;
import br.com.fastpizza.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fastpizza/categorias")
public class CategoriaRestController {

    @Autowired
    public CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Categoria categoria) {
        return categoriaService.cadastrar(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listar(@PathVariable Integer id) {
        return categoriaService.listar(id);
    }

}
