package com.example.PI_grupo_10.service;

import com.example.PI_grupo_10.exceptions.ResourceNotFoundException;
import com.example.PI_grupo_10.model.Image;
import com.example.PI_grupo_10.repository.ImageRepository;
import com.example.PI_grupo_10.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ImageService {

    private ProductRepository productRepository;
    private ImageRepository imageRepository;

    private static final Logger logger = Logger.getLogger(ProductService.class);

    public List<Image> buscarPorProductId(Integer productId) throws ResourceNotFoundException {
        if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Not found product with id = " + productId);
        } else {
            logger.info("Se buscan todas las imágenes con el productId: " + productId);
            return imageRepository.findByProductId(productId);
        }
    }

}
