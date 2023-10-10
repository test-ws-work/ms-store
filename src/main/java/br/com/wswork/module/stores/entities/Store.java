package br.com.wswork.module.stores.entities;

import javax.persistence.*;

@Entity
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private final String name;

    @Column
    private final String address;

    @Column
    private final Long number;

    @Column
    private final String complement;

    @Column
    private final String neighbor;

    @Column
    private final String state;

    @Column
    private final String city;

    @Column
    private final String country;

    @Column
    private final Long userId;

    public Store(final String name,
                 final String address,
                 final Long number,
                 final String complement,
                 final String neighbor,
                 final String state,
                 final String city,
                 final String country,
                 final Long userId) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.neighbor = neighbor;
        this.state = state;
        this.city = city;
        this.country = country;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Long getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighbor() {
        return neighbor;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Long getUserId() {
        return userId;
    }
}
