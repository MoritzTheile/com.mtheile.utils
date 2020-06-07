package com.mtheile.utils.simpleetl.target.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import com.mtheile.utils.simpleetl.util.WithCustomId;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A EntryProperty.
 */
@Entity
@Table(name = "entry_property")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EntryProperty extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "prop_name")
    private String propName;

    @Lob
    @Column(name = "prop_value")
    private String propValue;

    @ManyToOne
    @JsonIgnoreProperties("entryProperties")
    private Entry entry;

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

    public EntryProperty propName(String propName) {
        this.propName = propName;
        return this;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropValue() {
        return propValue;
    }

    public EntryProperty propValue(String propValue) {
        this.propValue = propValue;
        return this;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    public Entry getEntry() {
        return entry;
    }

    public EntryProperty entry(Entry entry) {
        this.entry = entry;
        return this;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntryProperty)) {
            return false;
        }
        return id != null && id.equals(((EntryProperty) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "EntryProperty{" +
            "id=" + getId() +
            ", propName='" + getPropName() + "'" +
            ", propValue='" + getPropValue() + "'" +
            "}";
    }
}
