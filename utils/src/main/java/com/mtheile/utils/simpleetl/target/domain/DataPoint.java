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

import com.mtheile.utils.simpleetl.target.domain.enumeration.DataStructure;

/**
 * A DataPoint.
 */
@Entity
@Table(name = "data_point")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DataPoint extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "data_structure")
    private DataStructure dataStructure;

    @Column(name = "data_entity_id")
    private Long dataEntityId;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "elevation")
    private Float elevation;

    @OneToMany(mappedBy = "datapoint")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<DatapointProperty> datapointProperties = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("dataPoints")
    private DataPackage dataPackage;

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

    public DataPoint name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataStructure getDataStructure() {
        return dataStructure;
    }

    public DataPoint dataStructure(DataStructure dataStructure) {
        this.dataStructure = dataStructure;
        return this;
    }

    public void setDataStructure(DataStructure dataStructure) {
        this.dataStructure = dataStructure;
    }

    public Long getDataEntityId() {
        return dataEntityId;
    }

    public DataPoint dataEntityId(Long dataEntityId) {
        this.dataEntityId = dataEntityId;
        return this;
    }

    public void setDataEntityId(Long dataEntityId) {
        this.dataEntityId = dataEntityId;
    }

    public Float getLatitude() {
        return latitude;
    }

    public DataPoint latitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public DataPoint longitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getElevation() {
        return elevation;
    }

    public DataPoint elevation(Float elevation) {
        this.elevation = elevation;
        return this;
    }

    public void setElevation(Float elevation) {
        this.elevation = elevation;
    }

    public Set<DatapointProperty> getDatapointProperties() {
        return datapointProperties;
    }

    public DataPoint datapointProperties(Set<DatapointProperty> datapointProperties) {
        this.datapointProperties = datapointProperties;
        return this;
    }

    public DataPoint addDatapointProperty(DatapointProperty datapointProperty) {
        this.datapointProperties.add(datapointProperty);
        datapointProperty.setDatapoint(this);
        return this;
    }

    public DataPoint removeDatapointProperty(DatapointProperty datapointProperty) {
        this.datapointProperties.remove(datapointProperty);
        datapointProperty.setDatapoint(null);
        return this;
    }

    public void setDatapointProperties(Set<DatapointProperty> datapointProperties) {
        this.datapointProperties = datapointProperties;
    }

    public DataPackage getDataPackage() {
        return dataPackage;
    }

    public DataPoint dataPackage(DataPackage dataPackage) {
        this.dataPackage = dataPackage;
        return this;
    }

    public void setDataPackage(DataPackage dataPackage) {
        this.dataPackage = dataPackage;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DataPoint)) {
            return false;
        }
        return id != null && id.equals(((DataPoint) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DataPoint{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", dataStructure='" + getDataStructure() + "'" +
            ", dataEntityId=" + getDataEntityId() +
            ", latitude=" + getLatitude() +
            ", longitude=" + getLongitude() +
            ", elevation=" + getElevation() +
            "}";
    }
}
