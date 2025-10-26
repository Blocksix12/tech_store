package com.teamforone.tech_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ctproducts")
public class CTProducts {
    @Id
    @Column(name = "product_id", columnDefinition = "CHAR(36)")
    private UUID productId;

    @Id
    @Column(name = "colorID", columnDefinition = "CHAR(36)")
    private UUID colorId;

    @Id
    @Column(name = "storageID", columnDefinition = "CHAR(36)")
    private UUID storageId;

    @Id
    @Column(name = "sizeID", columnDefinition = "CHAR(36)")
    private UUID sizeId;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // ----- Relationships -----
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colorID", insertable = false, updatable = false)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storageID", insertable = false, updatable = false)
    private Storage storage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sizeID", insertable = false, updatable = false)
    private DisplaySize size;
}
