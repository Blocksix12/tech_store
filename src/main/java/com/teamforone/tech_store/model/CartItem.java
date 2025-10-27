package com.teamforone.tech_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "item_id", columnDefinition = "CHAR(36)")
    private UUID cartItemID;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "colorID", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "sizeID", nullable = false)
    private DisplaySize displaySize;

    @ManyToOne
    @JoinColumn(name = "storageID", nullable = false)
    private Storage storage;

    @Column(name = "quantity", nullable = false, columnDefinition = "INT DEFAULT 1")
    private int quantity;

    @CreationTimestamp
    @Column(name = "added_at", nullable = false)
    private Date addedAt;
}
