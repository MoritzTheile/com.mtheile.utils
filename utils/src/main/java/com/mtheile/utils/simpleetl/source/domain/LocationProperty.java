package com.mtheile.utils.simpleetl.source.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import com.mtheile.utils.simpleetl.util.WithCustomId;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A LocationProperty.
 */
@Entity
@Table(name = "location_property")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LocationProperty extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "prop_name")
    private String propName;

    @Column(name = "prop_value")
    private String propValue;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonIgnoreProperties("locationProperties")
    private Location location;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropName() {
        return propName;
    }

    public LocationProperty propName(String propName) {
        this.propName = propName;
        return this;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropValue() {
        return propValue;
    }

    public LocationProperty propValue(String propValue) {
        this.propValue = propValue;
        return this;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    public String getDescription() {
        return description;
    }

    public LocationProperty description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public LocationProperty location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LocationProperty)) {
            return false;
        }
        return id != null && id.equals(((LocationProperty) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LocationProperty{" +
            "id=" + getId() +
            ", propName='" + getPropName() + "'" +
            ", propValue='" + getPropValue() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
