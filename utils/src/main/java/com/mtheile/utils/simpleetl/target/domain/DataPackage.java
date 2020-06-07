package com.mtheile.utils.simpleetl.target.domain;


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

import com.mtheile.utils.simpleetl.target.domain.enumeration.Distribution;

import com.mtheile.utils.simpleetl.target.domain.enumeration.WorkflowState;

/**
 * A DataPackage.
 */
@Entity
@Table(name = "data_package")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DataPackage extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "distribution")
    private Distribution distribution;

    @Enumerated(EnumType.STRING)
    @Column(name = "workflow_state")
    private WorkflowState workflowState;

    @Lob
    @Column(name = "describtion")
    private String describtion;

    @Lob
    @Column(name = "license_text")
    private String licenseText;

    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "dataPackage")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<DataPoint> dataPoints = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("dataPackages")
    private Institution institution;

    @ManyToMany(mappedBy = "dataPackages")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Basket> baskets = new HashSet<>();

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

    public DataPackage name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public DataPackage distribution(Distribution distribution) {
        this.distribution = distribution;
        return this;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public WorkflowState getWorkflowState() {
        return workflowState;
    }

    public DataPackage workflowState(WorkflowState workflowState) {
        this.workflowState = workflowState;
        return this;
    }

    public void setWorkflowState(WorkflowState workflowState) {
        this.workflowState = workflowState;
    }

    public String getDescribtion() {
        return describtion;
    }

    public DataPackage describtion(String describtion) {
        this.describtion = describtion;
        return this;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getLicenseText() {
        return licenseText;
    }

    public DataPackage licenseText(String licenseText) {
        this.licenseText = licenseText;
        return this;
    }

    public void setLicenseText(String licenseText) {
        this.licenseText = licenseText;
    }

    public Integer getPrice() {
        return price;
    }

    public DataPackage price(Integer price) {
        this.price = price;
        return this;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<DataPoint> getDataPoints() {
        return dataPoints;
    }

    public DataPackage dataPoints(Set<DataPoint> dataPoints) {
        this.dataPoints = dataPoints;
        return this;
    }

    public DataPackage addDataPoint(DataPoint dataPoint) {
        this.dataPoints.add(dataPoint);
        dataPoint.setDataPackage(this);
        return this;
    }

    public DataPackage removeDataPoint(DataPoint dataPoint) {
        this.dataPoints.remove(dataPoint);
        dataPoint.setDataPackage(null);
        return this;
    }

    public void setDataPoints(Set<DataPoint> dataPoints) {
        this.dataPoints = dataPoints;
    }

    public Institution getInstitution() {
        return institution;
    }

    public DataPackage institution(Institution institution) {
        this.institution = institution;
        return this;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Set<Basket> getBaskets() {
        return baskets;
    }

    public DataPackage baskets(Set<Basket> baskets) {
        this.baskets = baskets;
        return this;
    }

    public DataPackage addBasket(Basket basket) {
        this.baskets.add(basket);
        basket.getDataPackages().add(this);
        return this;
    }

    public DataPackage removeBasket(Basket basket) {
        this.baskets.remove(basket);
        basket.getDataPackages().remove(this);
        return this;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DataPackage)) {
            return false;
        }
        return id != null && id.equals(((DataPackage) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DataPackage{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", distribution='" + getDistribution() + "'" +
            ", workflowState='" + getWorkflowState() + "'" +
            ", describtion='" + getDescribtion() + "'" +
            ", licenseText='" + getLicenseText() + "'" +
            ", price=" + getPrice() +
            "}";
    }
}
