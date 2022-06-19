package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.model.InventoryOuter.InventoryItem;
import com.example.demo.model.InventoryOuter.Inventory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpli implements ProductService {

    private ProductRepository productRepository ;

    public ProductServiceImpli(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Inventory getProductsData() {
        Inventory inventory = new Inventory();
        for(Product p: productRepository.findAll()) {
            if (inventory.containsKey(p.getName())) {
                InventoryItem productItem = inventory.get(p.getName());

                if (!p.getState().equals("broken")) {
                    productItem.setQty(productItem.getQty() + 1);
                    productItem.setTotalPrice(productItem.getTotalPrice() + p.getPrice());
                    productItem.setProductBarcodes(productItem.getProductBarcodes() + "," + p.getBarcode());
                }
            }
            else {
                inventory.put(p.getName(), new InventoryItem(p.getName().toLowerCase(), p.getPrice(), 1));
            }
        }
        return inventory;
    }

    @Override
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
          try {
               productRepository.deleteById(id);
          }catch (Exception e){
              e.printStackTrace();
          }
    }
    @Override
    public Product findProductById(Integer id) throws Exception {
        return productRepository.findById(id).orElseThrow(() -> new Exception("product Not found"));
    }


}
