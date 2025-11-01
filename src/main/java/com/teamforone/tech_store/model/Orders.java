package com.teamforone.tech_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    @UuidGenerator
    @Column(name = "order_id", columnDefinition = "CHAR(36)")
    private String orderID;

    @Column(name = "order_no", unique = true, length = 20)
    private String orderNo;

    // === Quan hệ với User ===
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_order_user"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private User user;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    // === Quan hệ với Shipping ===
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_id", foreignKey = @ForeignKey(name = "fk_order_shipping"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Shipping shipping;

    @Column(name = "payment_method", columnDefinition = "ENUM('cod','vnpay','momo','stripe')")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    // === Quan hệ với NhanVien ===
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhanvienID", foreignKey = @ForeignKey(name = "fk_order_nhanvien"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private NhanVien nhanvien;

    public enum PaymentMethod {
        MOMO,
        VNPAY,
        STRIPE,
        COD;

        private static PaymentMethod toEnum(String value) {
            for(PaymentMethod method : PaymentMethod.values()){
                if (method.toString().equalsIgnoreCase(value)) return method;
            }
            return null;
        }
    }
}
