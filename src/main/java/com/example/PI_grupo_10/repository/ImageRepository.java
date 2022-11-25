package com.example.PI_grupo_10.repository;

import com.example.PI_grupo_10.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository <Image, Integer> {
    List<Image> findByProductId (int productId);
}
