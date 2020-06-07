package com.mtheile.utils.simpleetl.source.domain;


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
 * A LLithologyType.
 */
@Entity
@Table(name = "l_lithology_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LLithologyType extends WithCustomId implements Serializable {

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

    @OneToMany(mappedBy = "lithologyType")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Sample> samples = new HashSet<>();

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

    public LLithologyType name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public LLithologyType description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Sample> getSamples() {
        return samples;
    }

    public LLithologyType samples(Set<Sample> samples) {
        this.samples = samples;
        return this;
    }

    public LLithologyType addSample(Sample sample) {
        this.samples.add(sample);
        sample.setLithologyType(this);
        return this;
    }

    public LLithologyType removeSample(Sample sample) {
        this.samples.remove(sample);
        sample.setLithologyType(null);
        return this;
    }

    public void setSamples(Set<Sample> samples) {
        this.samples = samples;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LLithologyType)) {
            return false;
        }
        return id != null && id.equals(((LLithologyType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LLithologyType{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
