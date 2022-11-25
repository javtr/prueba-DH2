package com.example.PI_grupo_10.service;

import com.example.PI_grupo_10.exceptions.ResourceNotFoundException;
import com.example.PI_grupo_10.model.Category;
import com.example.PI_grupo_10.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    private static final Logger logger = Logger.getLogger(CategoryService.class);

    public Category editar(Category c) {
        logger.info("Se actualiza la categoría con el id: " + c.getId());
        return categoryRepository.save(c);
    }

    public Category buscar(Integer id){
        Category category = null;
        Optional<Category> optionalCategoria= categoryRepository.findById(id);
        if (optionalCategoria.isPresent()){
            category = optionalCategoria.get();
            logger.info("Se encontró la category con el id: " + id);
        }
        return category;
    }

    public List<Category> listarTodas(){
        logger.info("Se buscan todas las categorias");
        return categoryRepository.findAll();
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {
        if (this.buscar(id)==null){
            logger.error("Se quiere eliminar una categoria con un id inexistente en la base de datos.");
            throw new ResourceNotFoundException("No existe una categoria con el ID: " + id);
        } else{
            categoryRepository.deleteById(id);
            logger.info("Se elimino la categoria con el id: " + id);
        }
    }

    public Category agregar(Category c){
        logger.info("Se crea la categoria: " + c);
        return categoryRepository.save(c);
    }
}
