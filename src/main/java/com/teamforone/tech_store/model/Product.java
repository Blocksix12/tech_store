package com.teamforone.tech_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id", columnDefinition = "CHAR(36)")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "brand_id", columnDefinition = "CHAR(36)")
    private String brandId;

    @Column(name = "category_id", columnDefinition = "CHAR(36)")
    private String categoryId;

    @Column(name = "default_image", nullable = false)
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "ENUM('draft','published','archived') DEFAULT 'published'")
    private Status productStatus = Status.PUBLISHED;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    public enum Status {
        DRAFT,
        PUBLISHED,
        ARCHIVED;

        public static Status toEnum(String type) {
            for (Status item : values()) {
                if (item.toString().equalsIgnoreCase(type)) return item;
            }
            return null;
        }
    }
}
