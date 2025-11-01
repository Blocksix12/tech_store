package com.teamforone.tech_store.controller.admin.crud;

import com.teamforone.tech_store.dto.request.ProductRequest;
import com.teamforone.tech_store.dto.response.Response;
import com.teamforone.tech_store.model.Product;
import com.teamforone.tech_store.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products/add")
    public ResponseEntity<Response> addProduct(@RequestBody ProductRequest productRequest) {
        Response response = productService.addProduct(productRequest);
        // Implementation for adding a product would go here
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/products/update/{id}")
    public ResponseEntity<Response> updateProduct(@PathVariable String id , @RequestBody ProductRequest productRequest) {
        Response response = productService.updateProduct(id, productRequest);
        // Implementation for adding a product would go here
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable String id) {
        Response response = productService.deleteProduct(id);
        // Implementation for deleting a product would go here
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable String id){
        return productService.findProductById(id);
    }

}
