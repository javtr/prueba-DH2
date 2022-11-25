package com.example.PI_grupo_10.repository;

import com.example.PI_grupo_10.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Integer> {
    List<Product> findByCityId (int cityId);
    List<Product> findByCategoryId (int categoryId);

    @Query(value="SELECT * FROM products ORDER BY rand() LIMIT 8", nativeQuery=true)
    List<Product> findTop8();

    @Query(
            value = "select p.* from products p " +
                    "where p.id not in( "+
                    "select distinct b.product_id "+
                    "from bookings b "+
                    "where ((b.initial_date <= ?1 AND ?1 <= b.end_date)"+
                    "OR (b.initial_date <= ?2 AND ?2 <= b.end_date)"+
                    "OR (?1 <= b.initial_date AND b.end_date <= ?2))"+
                    "); ", nativeQuery = true)
    List<Product> findByAvailableDate(Date iDate, Date eDate);
}
