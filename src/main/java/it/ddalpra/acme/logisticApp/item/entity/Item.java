package it.ddalpra.acme.logisticApp.item.entity;

import java.math.BigDecimal;

import it.ddalpra.acme.logisticApp.common.entity.BaseEntity;
import it.ddalpra.acme.logisticApp.item.model.UnitOfMeasure;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Item extends BaseEntity {

    @Column(name = "code_item", unique = true, nullable = false)
    private String codeItem;

    @Column(name = "description")
    private String description;

    @Column(name = "code_family")
    private String codeFamily;

    @Column(name = "barcode", unique = true)
    private String barcode;

    @Column(name = "weight", precision = 10, scale = 3)
    private BigDecimal weight;

    @Column(name = "volume", precision = 10, scale = 3)
    private BigDecimal volume;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_of_measure")
    private UnitOfMeasure unitOfMeasure;
}
