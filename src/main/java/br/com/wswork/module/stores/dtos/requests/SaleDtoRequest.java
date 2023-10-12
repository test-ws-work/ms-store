package br.com.wswork.module.stores.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class SaleDtoRequest {

    @JsonProperty
    private Long costumerId;

    @JsonProperty
    private Integer tax;

    @JsonProperty
    private Long storeId;

    @JsonProperty
    private List<SaleItemDtoRequest> items;

    public Long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Long costumerId) {
        this.costumerId = costumerId;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<SaleItemDtoRequest> getItems() {
        return items;
    }

    public void setItems(List<SaleItemDtoRequest> items) {
        this.items = items;
    }
}
