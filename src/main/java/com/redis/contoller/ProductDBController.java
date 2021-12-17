package com.redis.contoller;

import com.redis.entity.Product;
import com.redis.entity.ProductTRec;
import com.redis.repository.ProductDao;
import com.redis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/product")
@EnableCaching
public class ProductDBController {

    public static final String HASH_KEY = "Product";

//    @Autowired
//    private ProductDao dao;

    private final ProductService productService;

    public ProductDBController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @Cacheable(value = HASH_KEY)
    public ResponseEntity<List<Product>> getAllProducts () {
        List<Product> employees = productService.findAllProduct();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
//    @Cacheable(key = "#id", value = HASH_KEY)
    public ResponseEntity<Product> getProductById (@PathVariable("id") Integer id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @PostMapping
//    @Cacheable(key = "#id", value = HASH_KEY)
    public ResponseEntity<Product> addEmployee(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
//        dao.save(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = HASH_KEY)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
