package br.com.wswork.module.stores.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sales_products")
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal productPrice;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public SaleProduct() { }

    public SaleProduct(Sale sale, Product product, Integer quantity, BigDecimal productPrice) {
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    public Long getId() {
        return id;
    }

    public Sale getSale() {
        return sale;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

