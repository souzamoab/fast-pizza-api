package br.com.fastpizza.api;

import br.com.fastpizza.entity.Categoria;
import br.com.fastpizza.service.CategoriaService;
import br.com.fastpizza.vo.CategoriaUpdateVO;
import br.com.fastpizza.vo.CategoriaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        return categoriaService.buscar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CategoriaUpdateVO categoriaUpdateVO) {
        return categoriaService.update(id, categoriaUpdateVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return categoriaService.delete(id);
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return categoriaService.listar();
    }

    @GetMapping("/page")
    public ResponseEntity<?> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        return categoriaService.findPage(page, linesPerPage, orderBy, direction);
    }

}
