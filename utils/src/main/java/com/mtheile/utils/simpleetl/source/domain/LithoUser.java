package com.mtheile.utils.simpleetl.source.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

/**
 * A LithoUser.
 */
@Entity
@Table(name = "litho_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LithoUser extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    @OneToMany(mappedBy = "creator")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Basket> baskets = new HashSet<>();

    @OneToMany(mappedBy = "lithoUser")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<LithoRequest> lithoRequests = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("lithoUsers")
    private Institution institution;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public LithoUser user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Basket> getBaskets() {
        return baskets;
    }

    public LithoUser baskets(Set<Basket> baskets) {
        this.baskets = baskets;
        return this;
    }

    public LithoUser addBasket(Basket basket) {
        this.baskets.add(basket);
        basket.setCreator(this);
        return this;
    }

    public LithoUser removeBasket(Basket basket) {
        this.baskets.remove(basket);
        basket.setCreator(null);
        return this;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }

    public Set<LithoRequest> getLithoRequests() {
        return lithoRequests;
    }

    public LithoUser lithoRequests(Set<LithoRequest> lithoRequests) {
        this.lithoRequests = lithoRequests;
        return this;
    }

    public LithoUser addLithoRequest(LithoRequest lithoRequest) {
        this.lithoRequests.add(lithoRequest);
        lithoRequest.setLithoUser(this);
        return this;
    }

    public LithoUser removeLithoRequest(LithoRequest lithoRequest) {
        this.lithoRequests.remove(lithoRequest);
        lithoRequest.setLithoUser(null);
        return this;
    }

    public void setLithoRequests(Set<LithoRequest> lithoRequests) {
        this.lithoRequests = lithoRequests;
    }

    public Institution getInstitution() {
        return institution;
    }

    public LithoUser institution(Institution institution) {
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
        if (!(o instanceof LithoUser)) {
            return false;
        }
        return id != null && id.equals(((LithoUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LithoUser{" +
            "id=" + getId() +
            "}";
    }
}
