package com.teamforone.tech_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shipping_id", columnDefinition = "CHAR(36)")
    private UUID shippingID;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "distance_km", nullable = false, precision = 10, scale = 2)
    private BigDecimal distance;

    @Column(name = "price_per_km", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerKm;

    @Column(name = "total_price", insertable = false, updatable = false, columnDefinition = "DECIMAL(10,2)")
    private Double totalPrice;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
}
