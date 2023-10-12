package br.com.wswork.module.stores.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

public class SaleDtoResponse {

    @JsonProperty
    private Long custumerId;

    @JsonProperty
    private Integer quantity;

    @JsonProperty
    private BigDecimal totalPrice;

    @JsonProperty
    private Integer tax;

    @JsonProperty
    private LocalDateTime saleDate;

    @JsonProperty
    private Collection<String> products;

    @JsonProperty
    private String store;

    public Long getCustumerId() {
        return custumerId;
    }

    public void setCustumerId(Long custumerId) {
        this.custumerId = custumerId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public Collection<String> getProducts() {
        return products;
    }

    public void setProducts(Collection<String> products) {
        this.products = products;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
