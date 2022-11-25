package com.example.PI_grupo_10.controller;

import com.example.PI_grupo_10.exceptions.ResourceNotFoundException;
import com.example.PI_grupo_10.model.Booking;
import com.example.PI_grupo_10.model.Feature;
import com.example.PI_grupo_10.model.Image;
import com.example.PI_grupo_10.model.Product;
import com.example.PI_grupo_10.service.FeatureService;
import com.example.PI_grupo_10.service.ImageService;
import com.example.PI_grupo_10.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private FeatureService featureService;

    @GetMapping("/{productId}/images")
    public ResponseEntity<List<Image>> buscarPorProductId(@PathVariable Integer productId) throws ResourceNotFoundException {
        return ResponseEntity.ok(imageService.buscarPorProductId(productId));
    }

    @GetMapping("/{productId}/features")
    public ResponseEntity<List<Feature>> getAllFeaturesByProductId(@PathVariable(value = "productId") Integer productId) throws ResourceNotFoundException {
        return ResponseEntity.ok(featureService.findFeaturesByProductsId(productId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> listarTodos(){
        return ResponseEntity.ok(productService.listarTodos());
    }

    @GetMapping
    public ResponseEntity<List<Product>> listarOchoProductos(){
        return ResponseEntity.ok(productService.listarOchoProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> buscar(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.buscar(id));
    }

    @PostMapping
    public ResponseEntity<Product> agregar(@RequestBody Product product){
        return ResponseEntity.ok(productService.agregar(product));
    }

    @GetMapping("/cities/{cityId}")
    public ResponseEntity<List<Product>> buscarPorCityId(@PathVariable Integer cityId) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.buscarPorCityId(cityId));
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<Product>> buscarPorCategoryId(@PathVariable Integer categoryId) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.buscarPorCategoryId(categoryId));
    }

    @GetMapping("/dates")
    public List<Product> obtenerProductosPorFechasDisponibles(@RequestParam String initialDate, @RequestParam String endDate) throws ParseException {
        log.info("Se reciben los datos:" + initialDate +" "+endDate);
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date iDate = simpleDateFormat.parse(initialDate);
        Date eDate = simpleDateFormat.parse(endDate);
        log.info("Se convierten los datos:" + iDate +" "+eDate);
        return productService.obtenerProductosPorFechasDisponibles(iDate, eDate);
    }

}
