package com.redis.service;

import com.redis.entity.Product;
import com.redis.entity.ProductTRec;
import com.redis.exception.UserNotFoundException;
import com.redis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
//        ProductTRec productTRec = fromProductToProductTRec(product);
        return productRepository.save(product);
    }

    private ProductTRec fromProductToProductTRec(Product product){
        return new ProductTRec(
                product.getId(),product.getName(),product.getQty(),product.getPrice()
        );
    }


    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product updateEmployee(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(Integer id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteProduct(Integer id){
        productRepository.deleteProductById(id);
    }
}
