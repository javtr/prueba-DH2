package com.example.PI_grupo_10.service;

import com.example.PI_grupo_10.exceptions.ResourceNotFoundException;
import com.example.PI_grupo_10.model.Product;
import com.example.PI_grupo_10.repository.CategoryRepository;
import com.example.PI_grupo_10.repository.CityRepository;
import com.example.PI_grupo_10.repository.FeatureRepository;
import com.example.PI_grupo_10.repository.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CityRepository cityRepository;
    private CategoryRepository categoryRepository;
    private FeatureRepository featureRepository;
    private static final Logger logger = Logger.getLogger(ProductService.class);

    //Inyectar la dependencia
    public ProductService(ProductRepository productRepository, CityRepository cityRepository, CategoryRepository categoryRepository, FeatureRepository featureRepository) {
        this.productRepository = productRepository;
        this.cityRepository = cityRepository;
        this.categoryRepository = categoryRepository;
        this.featureRepository = featureRepository;
    }

    public Product buscar(Integer id) {
        Product product = null;
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
            logger.info("Se encontró el producto con el id: " + id);
        }
        return product;
    }

    public List<Product> listarTodos() {
        logger.info("Se buscan todos los productos");
        return productRepository.findAll();
    }

    public List<Product> listarOchoProductos() {
        logger.info("Se buscan 8 productos random");
        return productRepository.findTop8();
    }

    public Product agregar(Product p) {
        logger.info("Se crea el producto: " + p);
        return productRepository.save(p);
    }

    public List<Product> buscarPorCityId(Integer cityId) throws ResourceNotFoundException {
        if (!cityRepository.existsById(cityId)) {
            throw new ResourceNotFoundException("Not found City with id = " + cityId);
        } else {
            logger.info("Se buscan todos los productos con el cityId: " + cityId);
            return productRepository.findByCityId(cityId);
        }
    }

    public List<Product> buscarPorCategoryId(Integer categoryId) throws ResourceNotFoundException {
        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException("Not found Category with id = " + categoryId);
        } else {
            logger.info("Se buscan todos los productos con el categoryId: " + categoryId);
            return productRepository.findByCategoryId(categoryId);
        }
    }

    public List<Product> obtenerProductosPorFechasDisponibles(Date iDate, Date eDate){
        return productRepository.findByAvailableDate(iDate,eDate);
    }
}


