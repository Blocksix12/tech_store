package com.teamforone.tech_store.service.admin.impl;

import com.teamforone.tech_store.dto.request.ProductRequest;
import com.teamforone.tech_store.dto.response.Response;
import com.teamforone.tech_store.model.Product;
import com.teamforone.tech_store.repository.admin.crud.ProductRepository;
import com.teamforone.tech_store.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Response addProduct(ProductRequest product) {
        String name = product.getName();
        String slug = product.getSlug();
        String description = product.getDescription();
        String brand = product.getBrandId();
        String category = product.getCategoryId();
        String imageUrl = product.getImageUrl();
        String status = product.getStatus();

        Product newProduct = Product.builder()
                .name(name)
                .slug(slug)
                .description(description)
                .brandId(brand)
                .categoryId(category)
                .imageUrl(imageUrl)
                .productStatus(Product.Status.toEnum(status))
                .build();

        productRepository.save(newProduct);

        return Response.builder()
                .status(HttpStatus.OK.value())
                .message("Product added successfully")
                .build();

    }

    @Override
    public Response updateProduct(String id, ProductRequest product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return Response.builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message("Product not found")
                    .build();
        }
        existingProduct.setName(product.getName());
        existingProduct.setSlug(product.getSlug());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setBrandId(product.getBrandId());
        existingProduct.setCategoryId(product.getCategoryId());
        existingProduct.setImageUrl(product.getImageUrl());
        existingProduct.setProductStatus(Product.Status.toEnum(product.getStatus()));

        productRepository.save(existingProduct);
        // Implementation for updating a product would go here
        return Response.builder()
                .status(HttpStatus.OK.value())
                .message("Product updated successfully")
                .build();
    }

    @Override
    public Response deleteProduct(String id) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return Response.builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message("Product not found")
                    .build();
        }

        productRepository.delete(existingProduct);

        return Response.builder()
                .status(HttpStatus.OK.value())
                .message("Product deleted successfully")
                .build();
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }


}
