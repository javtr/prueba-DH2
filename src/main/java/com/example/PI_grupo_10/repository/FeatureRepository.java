package com.example.PI_grupo_10.repository;

import com.example.PI_grupo_10.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeatureRepository extends JpaRepository <Feature, Integer> {
    List<Feature> findFeaturesByProductsId(Integer productId);
}

