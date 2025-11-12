package com.teamforone.tech_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {
    @Id
    @UuidGenerator
    @Column(name = "order_item_id", columnDefinition = "CHAR(36)")
    private String orderItemID;

    @Column(name = "order_id", nullable = false, columnDefinition = "CHAR(36)")
    private String order;

    @Column(name = "color_id", nullable = false, columnDefinition = "CHAR(36)")
    private String color;

    @Column(name = "size_id", nullable = false, columnDefinition = "CHAR(36)")
    private String displaySize;

    @Column(name = "storage_id", nullable = false, columnDefinition = "CHAR(36)")
    private String storage;

    @Column(name = "quantity", columnDefinition = "INT DEFAULT 1 CHECK (quantity > 0)")
    private Integer quantity;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderItemStatus status = OrderItemStatus.PENDING;

    public enum OrderItemStatus {
        PENDING,
        SHIPPED,
        DELIVERED,
        RETURNED,
        PAID,
        PROCESSING,
        CANCELLED;

        private static OrderItemStatus toEnum(String status) {
            for (OrderItemStatus item : values()) {
                if (item.toString().equalsIgnoreCase(status)) return item;
            }
            return null;
        }
    }
}
