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
 * A LSampleType.
 */
@Entity
@Table(name = "l_sample_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LSampleType extends WithCustomId implements Serializable {

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

    @OneToMany(mappedBy = "sampleType")
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

    public LSampleType name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public LSampleType description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Sample> getSamples() {
        return samples;
    }

    public LSampleType samples(Set<Sample> samples) {
        this.samples = samples;
        return this;
    }

    public LSampleType addSample(Sample sample) {
        this.samples.add(sample);
        sample.setSampleType(this);
        return this;
    }

    public LSampleType removeSample(Sample sample) {
        this.samples.remove(sample);
        sample.setSampleType(null);
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
        if (!(o instanceof LSampleType)) {
            return false;
        }
        return id != null && id.equals(((LSampleType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LSampleType{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
