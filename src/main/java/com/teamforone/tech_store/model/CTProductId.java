package com.teamforone.tech_store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
public class CTProductId implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID productId;
    private UUID colorId;
    private UUID storageId;
    private UUID sizeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CTProductId that = (CTProductId) o;

        return productId == that.productId &&
                colorId == that.colorId &&
                storageId == that.storageId &&
                sizeId == that.sizeId;
    }

    @Override
    public int hashCode(){
        return Objects.hash(productId, colorId, storageId, sizeId);
    }
}
