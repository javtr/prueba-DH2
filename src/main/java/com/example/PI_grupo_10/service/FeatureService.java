package com.example.PI_grupo_10.service;

import com.example.PI_grupo_10.exceptions.ResourceNotFoundException;
import com.example.PI_grupo_10.model.Feature;
import com.example.PI_grupo_10.repository.FeatureRepository;
import com.example.PI_grupo_10.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FeatureService {
    private FeatureRepository featureRepository;
    private ProductRepository productRepository;

    public List<Feature> findFeaturesByProductsId(Integer productId) throws ResourceNotFoundException {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Not found Product with id = " + productId);
        }
        List<Feature> features = featureRepository.findFeaturesByProductsId(productId);
        return featureRepository.findFeaturesByProductsId(productId);
    }
}
