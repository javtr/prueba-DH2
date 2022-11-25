package com.example.PI_grupo_10.controller;

import com.example.PI_grupo_10.exceptions.ResourceNotFoundException;
import com.example.PI_grupo_10.model.Category;
import com.example.PI_grupo_10.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PutMapping
    public ResponseEntity<Category> editar(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.editar(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> listarTodas(){
        return ResponseEntity.ok(categoryService.listarTodas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        categoryService.eliminar(id);
        return ResponseEntity.ok().body("Category eliminada");
    }

    @PostMapping
    public ResponseEntity<Category> agregar(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.agregar(category));
    }
}
