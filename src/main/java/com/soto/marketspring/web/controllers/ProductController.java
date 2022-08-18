package com.soto.marketspring.web.controllers;

import com.soto.marketspring.domain.Product;
import com.soto.marketspring.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 400,message = "NOT_FOUND")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of product",required = true,example = "5")
                                                  @PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(prods->new ResponseEntity<>(prods,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    @ApiOperation("Search a product with an Category Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 400,message = "NOT_FOUND")
    })
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return  productService.getByCategory(categoryId)
                .map(prods->new ResponseEntity<>(prods,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/save")
    @ApiOperation("Save a product")
    public ResponseEntity<Product> save(@RequestBody Product product){
               return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete a Product")
    public ResponseEntity delete(@PathVariable("id")int productId){
         productService.delete(productId);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
