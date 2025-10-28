package com.teamforone.tech_store.service.admin.impl;

import com.teamforone.tech_store.model.Product;
import com.teamforone.tech_store.repository.admin.ProductRepository;
import com.teamforone.tech_store.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
