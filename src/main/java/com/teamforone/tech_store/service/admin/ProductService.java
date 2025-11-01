package com.teamforone.tech_store.service.admin;

import com.teamforone.tech_store.dto.request.ProductRequest;
import com.teamforone.tech_store.dto.response.Response;
import com.teamforone.tech_store.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Response addProduct(ProductRequest product);
    Response updateProduct(String id, ProductRequest product);
    Response deleteProduct(String id);
    Product findProductById(String id);

}
