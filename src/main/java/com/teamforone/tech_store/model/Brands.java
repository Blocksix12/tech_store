package com.teamforone.tech_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "brand_id", columnDefinition = "CHAR(36)")
    private String brandID;

    @Column(name = "brand_name", nullable = false)
    private String brandName;
}
