package com.teamforone.tech_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Roles {
    @Id
    @UuidGenerator
    @Column(name = "role_id", columnDefinition = "CHAR(36)")
    private String roleID;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, columnDefinition = "ENUM('ADMIN','MANAGER','STAFF')")
    private RoleName roleName;

    @ManyToOne
    @JoinColumn(name = "nhanvienID", nullable = false)
    private NhanVien nhanVien;

    public enum RoleName {
        ADMIN,
        STAFF,
        MANAGER;

        private static RoleName toEnum(String value) {
            for (RoleName item : values()) {
                if (item.toString().equalsIgnoreCase(value)) return item;
            }
            return null;
        }
    }
}
