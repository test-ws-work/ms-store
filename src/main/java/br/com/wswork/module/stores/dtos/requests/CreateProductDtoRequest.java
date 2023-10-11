package br.com.wswork.module.stores.dtos.requests;

import br.com.wswork.module.stores.entities.Store;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class CreateProductDtoRequest {

    @JsonProperty
    private String name;

    @JsonProperty
    private String brand;

    @JsonProperty
    private BigDecimal price;

    @JsonProperty
    private String description;

    @JsonProperty
    private String category;

    @JsonProperty
    private Integer stock;

    @JsonProperty
    private Long storeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
