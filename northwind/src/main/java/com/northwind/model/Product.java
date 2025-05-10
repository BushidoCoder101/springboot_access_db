package com.northwind.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCTS")  // Use uppercase to match what UCanAccess returns
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "PRODUCTID")
    private Integer id;

    @Column(name = "PRODUCTNAME")
    private String name;

    @Column(name = "QUANTITYPERUNIT")
    private String quantityPerUnit;

    @Column(name = "UNITPRICE")
    private Double unitPrice;
}
