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
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "colorID", columnDefinition = "CHAR(36)")
    private UUID colorID;

    @Column(name = "colorname", nullable = false)
    private String colorName;
}
