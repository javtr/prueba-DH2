package com.example.PI_grupo_10.repository;

import com.example.PI_grupo_10.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository <Country, Integer> {
}
