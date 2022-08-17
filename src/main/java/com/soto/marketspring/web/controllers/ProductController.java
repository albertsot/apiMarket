package com.soto.marketspring.web.controllers;

import com.soto.marketspring.domain.Product;
import com.soto.marketspring.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    Optional<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        return productService.getByCategory(categoryId);
    }
    @GetMapping("/category/{categoryId}")
    public Optional<Product> getProduct(@PathVariable("categoryId") int productId){
        return productService.getProduct(productId);
    }
    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id")int productId){
        return productService.delete(productId);

    }
}
