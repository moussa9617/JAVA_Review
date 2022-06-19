package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.utils.InventoryOuter.Inventory;

public interface ProductService {

   Inventory getProductsData();

   Iterable<Product> findAllProducts();

   Product saveProduct(Product product);

   void deleteProduct(Integer id);

   Product findProductById(Integer id) throws Exception;



}
