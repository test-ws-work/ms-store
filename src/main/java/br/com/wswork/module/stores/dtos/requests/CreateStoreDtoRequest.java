package br.com.wswork.module.stores.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateStoreDtoRequest {
    @JsonProperty
    @NotBlank
    @NotNull
    private String name;

    @JsonProperty
    @NotBlank
    @NotNull
    private String address;

    @JsonProperty
    @Min(1)
    @NotNull
    private Long number;

    @JsonProperty
    private String complement;

    @JsonProperty
    @NotBlank
    @NotNull
    private String neighbor;

    @JsonProperty
    @NotBlank
    @NotNull
    private String state;

    @JsonProperty
    @NotBlank
    @NotNull
    private String city;

    @JsonProperty
    @NotBlank
    @NotNull
    private String country;

    @JsonProperty
    @NotNull
    private Long personId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(String neighbor) {
        this.neighbor = neighbor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
