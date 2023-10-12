package br.com.wswork.module.stores.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SaleItemDtoRequest {
    @JsonProperty
    private Long productId;

    @JsonProperty
    private Integer quantity;

    @JsonProperty
    private BigDecimal productPrice;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
