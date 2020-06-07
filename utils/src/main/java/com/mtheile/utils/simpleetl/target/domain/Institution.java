package com.mtheile.utils.simpleetl.target.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * A Institution.
 */
@Entity
@Table(name = "institution")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Institution extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "logo_content_type")
    private String logoContentType;

    @OneToMany(mappedBy = "institution")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<DataPackage> dataPackages = new HashSet<>();

    @OneToMany(mappedBy = "institution")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Basket> baskets = new HashSet<>();

    @OneToMany(mappedBy = "institution")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<LithoUser> lithoUsers = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "institution_community",
               joinColumns = @JoinColumn(name = "institution_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "community_id", referencedColumnName = "id"))
    private Set<Community> communities = new HashSet<>();

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

    public Institution name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Institution description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getLogo() {
        return logo;
    }

    public Institution logo(byte[] logo) {
        this.logo = logo;
        return this;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public Institution logoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
        return this;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public Set<DataPackage> getDataPackages() {
        return dataPackages;
    }

    public Institution dataPackages(Set<DataPackage> dataPackages) {
        this.dataPackages = dataPackages;
        return this;
    }

    public Institution addDataPackage(DataPackage dataPackage) {
        this.dataPackages.add(dataPackage);
        dataPackage.setInstitution(this);
        return this;
    }

    public Institution removeDataPackage(DataPackage dataPackage) {
        this.dataPackages.remove(dataPackage);
        dataPackage.setInstitution(null);
        return this;
    }

    public void setDataPackages(Set<DataPackage> dataPackages) {
        this.dataPackages = dataPackages;
    }

    public Set<Basket> getBaskets() {
        return baskets;
    }

    public Institution baskets(Set<Basket> baskets) {
        this.baskets = baskets;
        return this;
    }

    public Institution addBasket(Basket basket) {
        this.baskets.add(basket);
        basket.setInstitution(this);
        return this;
    }

    public Institution removeBasket(Basket basket) {
        this.baskets.remove(basket);
        basket.setInstitution(null);
        return this;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }

    public Set<LithoUser> getLithoUsers() {
        return lithoUsers;
    }

    public Institution lithoUsers(Set<LithoUser> lithoUsers) {
        this.lithoUsers = lithoUsers;
        return this;
    }

    public Institution addLithoUser(LithoUser lithoUser) {
        this.lithoUsers.add(lithoUser);
        lithoUser.setInstitution(this);
        return this;
    }

    public Institution removeLithoUser(LithoUser lithoUser) {
        this.lithoUsers.remove(lithoUser);
        lithoUser.setInstitution(null);
        return this;
    }

    public void setLithoUsers(Set<LithoUser> lithoUsers) {
        this.lithoUsers = lithoUsers;
    }

    public Set<Community> getCommunities() {
        return communities;
    }

    public Institution communities(Set<Community> communities) {
        this.communities = communities;
        return this;
    }

    public Institution addCommunity(Community community) {
        this.communities.add(community);
        community.getInstitutions().add(this);
        return this;
    }

    public Institution removeCommunity(Community community) {
        this.communities.remove(community);
        community.getInstitutions().remove(this);
        return this;
    }

    public void setCommunities(Set<Community> communities) {
        this.communities = communities;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Institution)) {
            return false;
        }
        return id != null && id.equals(((Institution) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Institution{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", logo='" + getLogo() + "'" +
            ", logoContentType='" + getLogoContentType() + "'" +
            "}";
    }
}
