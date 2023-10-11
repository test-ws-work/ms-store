package br.com.wswork.module.stores.entities;

import br.com.wswork.module.stores.constants.StoreStatusEnum;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "stores")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Long number;

    @Column
    private String complement;

    @Column
    private String neighbor;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private String country;

    @Column()
    @Enumerated(EnumType.STRING)
    private StoreStatusEnum status = StoreStatusEnum.ACTIVE;

    @Column
    private Long userId;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Collection<Product> product;

    public Store() {
    }

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

    public StoreStatusEnum getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setStatus(StoreStatusEnum status) {
        this.status = status;
    }
}
