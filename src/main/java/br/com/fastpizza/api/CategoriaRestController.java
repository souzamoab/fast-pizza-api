package br.com.fastpizza.api;

import br.com.fastpizza.entity.Categoria;
import br.com.fastpizza.service.CategoriaService;
import br.com.fastpizza.vo.CategoriaUpdateVO;
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

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CategoriaUpdateVO categoriaUpdateVO) {
        return categoriaService.update(id, categoriaUpdateVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return categoriaService.delete(id);
    }

}
