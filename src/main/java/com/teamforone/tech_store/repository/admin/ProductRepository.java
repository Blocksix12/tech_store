package com.teamforone.tech_store.repository.admin;

import com.teamforone.tech_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
