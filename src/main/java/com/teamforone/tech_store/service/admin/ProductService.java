package com.teamforone.tech_store.service.admin;

import com.teamforone.tech_store.dto.request.ProductRequest;
import com.teamforone.tech_store.dto.response.ProductResponse;
import com.teamforone.tech_store.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    ProductResponse addProduct(ProductRequest product);
    ProductResponse updateProduct(String id, ProductRequest product);
}
