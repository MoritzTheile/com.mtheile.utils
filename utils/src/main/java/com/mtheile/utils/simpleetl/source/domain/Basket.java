package com.mtheile.utils.simpleetl.source.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import com.mtheile.utils.simpleetl.util.WithCustomId;


import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.mtheile.utils.simpleetl.source.domain.enumeration.BasketState;

/**
 * A Basket.
 */
@Entity
@Table(name = "basket")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Basket extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "basket_state")
    private BasketState basketState;

    @Column(name = "price")
    private Integer price;

    @Lob
    @Column(name = "purchase_protocol")
    private String purchaseProtocol;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "basket_data_package",
               joinColumns = @JoinColumn(name = "basket_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "data_package_id", referencedColumnName = "id"))
    private Set<DataPackage> dataPackages = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("baskets")
    private LithoUser creator;

    @ManyToOne
    @JsonIgnoreProperties("baskets")
    private Institution institution;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Basket name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasketState getBasketState() {
        return basketState;
    }

    public Basket basketState(BasketState basketState) {
        this.basketState = basketState;
        return this;
    }

    public void setBasketState(BasketState basketState) {
        this.basketState = basketState;
    }

    public Integer getPrice() {
        return price;
    }

    public Basket price(Integer price) {
        this.price = price;
        return this;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPurchaseProtocol() {
        return purchaseProtocol;
    }

    public Basket purchaseProtocol(String purchaseProtocol) {
        this.purchaseProtocol = purchaseProtocol;
        return this;
    }

    public void setPurchaseProtocol(String purchaseProtocol) {
        this.purchaseProtocol = purchaseProtocol;
    }

    public Set<DataPackage> getDataPackages() {
        return dataPackages;
    }

    public Basket dataPackages(Set<DataPackage> dataPackages) {
        this.dataPackages = dataPackages;
        return this;
    }

    public Basket addDataPackage(DataPackage dataPackage) {
        this.dataPackages.add(dataPackage);
        dataPackage.getBaskets().add(this);
        return this;
    }

    public Basket removeDataPackage(DataPackage dataPackage) {
        this.dataPackages.remove(dataPackage);
        dataPackage.getBaskets().remove(this);
        return this;
    }

    public void setDataPackages(Set<DataPackage> dataPackages) {
        this.dataPackages = dataPackages;
    }

    public LithoUser getCreator() {
        return creator;
    }

    public Basket creator(LithoUser lithoUser) {
        this.creator = lithoUser;
        return this;
    }

    public void setCreator(LithoUser lithoUser) {
        this.creator = lithoUser;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Basket institution(Institution institution) {
        this.institution = institution;
        return this;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Basket)) {
            return false;
        }
        return id != null && id.equals(((Basket) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Basket{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", basketState='" + getBasketState() + "'" +
            ", price=" + getPrice() +
            ", purchaseProtocol='" + getPurchaseProtocol() + "'" +
            "}";
    }
}
