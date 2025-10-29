package com.teamforone.tech_store.controller.admin;

import com.teamforone.tech_store.dto.request.ProductRequest;
import com.teamforone.tech_store.dto.response.ProductResponse;
import com.teamforone.tech_store.model.Product;
import com.teamforone.tech_store.service.admin.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse response = productService.addProduct(productRequest);
        // Implementation for adding a product would go here
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/products/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable String id , @RequestBody ProductRequest productRequest) {
        ProductResponse response = productService.updateProduct(id, productRequest);
        // Implementation for adding a product would go here
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
