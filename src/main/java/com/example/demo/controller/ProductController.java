package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.utils.InventoryOuter.Inventory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    private final ProductService productService;

    public ProductController( ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        for(Product product: productService.findAllProducts()) {
            products.add(product);
        }
        return products;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> find(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @PostMapping("/products/")
    public Product save(@RequestBody Product product) {
        return this.productService.saveProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable int id) {
        this.productService.deleteProduct(id);
    }

    @GetMapping("/products/inventory")
    public Inventory getInventory() {
        return this.productService.getProductsData();
    }
}
