package com.redis.contoller;

import com.redis.entity.Product;
import com.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//untuk coba2 aja bisa apa nggak (dan ternyata bisa)

@RestController
@RequestMapping("/redis/raka")
@EnableCaching
public class RAPController {
    public static final String HASH_KEY = "Product";

    @Autowired
    private ProductDao dao;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return dao.save(product);
    }

    @GetMapping
    @Cacheable(value = HASH_KEY)
    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = HASH_KEY)
    public Product findProduct(@PathVariable int id) {
        return dao.findProductById(id);
    }
    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = HASH_KEY)
    public String remove(@PathVariable int id)   {
        return dao.deleteProduct(id);
    }
}
