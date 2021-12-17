package com.redis.repository;

import com.redis.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    void deleteProductById(Integer id);

    Optional<Product> findProductById(Integer id);
}
