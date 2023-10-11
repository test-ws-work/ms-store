package br.com.wswork.module.stores.dtos.responses;

import br.com.wswork.module.stores.entities.Store;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProductDtoResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private BigDecimal price;

    @JsonProperty
    private String description;

    @JsonProperty
    private String category;

    @JsonProperty
    private Integer stock;

    @JsonProperty
    private Store store;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
