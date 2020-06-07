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
 * A LLocCapture.
 */
@Entity
@Table(name = "l_loc_capture")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LLocCapture extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "method")
    private String method;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "locCapture")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Location> locations = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public LLocCapture method(String method) {
        this.method = method;
        return this;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public LLocCapture description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public LLocCapture locations(Set<Location> locations) {
        this.locations = locations;
        return this;
    }

    public LLocCapture addLocation(Location location) {
        this.locations.add(location);
        location.setLocCapture(this);
        return this;
    }

    public LLocCapture removeLocation(Location location) {
        this.locations.remove(location);
        location.setLocCapture(null);
        return this;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LLocCapture)) {
            return false;
        }
        return id != null && id.equals(((LLocCapture) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LLocCapture{" +
            "id=" + getId() +
            ", method='" + getMethod() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
