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
 * A Entry.
 */
@Entity
@Table(name = "entry")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Entry extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "jhi_type")
    private String type;

    @Column(name = "version")
    private Integer version;

    @OneToMany(mappedBy = "entry")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<EntryProperty> entryProperties = new HashSet<>();

    @ManyToMany(mappedBy = "entries")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Chrono> chronos = new HashSet<>();

    @ManyToMany(mappedBy = "entries")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Sample> samples = new HashSet<>();

    @ManyToMany(mappedBy = "entries")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<ThermalHistory> thermalHistories = new HashSet<>();

    @ManyToMany(mappedBy = "entries")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Vitrinite> vitrinites = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Entry type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public Entry version(Integer version) {
        this.version = version;
        return this;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Set<EntryProperty> getEntryProperties() {
        return entryProperties;
    }

    public Entry entryProperties(Set<EntryProperty> entryProperties) {
        this.entryProperties = entryProperties;
        return this;
    }

    public Entry addEntryProperty(EntryProperty entryProperty) {
        this.entryProperties.add(entryProperty);
        entryProperty.setEntry(this);
        return this;
    }

    public Entry removeEntryProperty(EntryProperty entryProperty) {
        this.entryProperties.remove(entryProperty);
        entryProperty.setEntry(null);
        return this;
    }

    public void setEntryProperties(Set<EntryProperty> entryProperties) {
        this.entryProperties = entryProperties;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public Entry chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public Entry addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.getEntries().add(this);
        return this;
    }

    public Entry removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.getEntries().remove(this);
        return this;
    }

    public void setChronos(Set<Chrono> chronos) {
        this.chronos = chronos;
    }

    public Set<Sample> getSamples() {
        return samples;
    }

    public Entry samples(Set<Sample> samples) {
        this.samples = samples;
        return this;
    }

    public Entry addSample(Sample sample) {
        this.samples.add(sample);
        sample.getEntries().add(this);
        return this;
    }

    public Entry removeSample(Sample sample) {
        this.samples.remove(sample);
        sample.getEntries().remove(this);
        return this;
    }

    public void setSamples(Set<Sample> samples) {
        this.samples = samples;
    }

    public Set<ThermalHistory> getThermalHistories() {
        return thermalHistories;
    }

    public Entry thermalHistories(Set<ThermalHistory> thermalHistories) {
        this.thermalHistories = thermalHistories;
        return this;
    }

    public Entry addThermalHistory(ThermalHistory thermalHistory) {
        this.thermalHistories.add(thermalHistory);
        thermalHistory.getEntries().add(this);
        return this;
    }

    public Entry removeThermalHistory(ThermalHistory thermalHistory) {
        this.thermalHistories.remove(thermalHistory);
        thermalHistory.getEntries().remove(this);
        return this;
    }

    public void setThermalHistories(Set<ThermalHistory> thermalHistories) {
        this.thermalHistories = thermalHistories;
    }

    public Set<Vitrinite> getVitrinites() {
        return vitrinites;
    }

    public Entry vitrinites(Set<Vitrinite> vitrinites) {
        this.vitrinites = vitrinites;
        return this;
    }

    public Entry addVitrinite(Vitrinite vitrinite) {
        this.vitrinites.add(vitrinite);
        vitrinite.getEntries().add(this);
        return this;
    }

    public Entry removeVitrinite(Vitrinite vitrinite) {
        this.vitrinites.remove(vitrinite);
        vitrinite.getEntries().remove(this);
        return this;
    }

    public void setVitrinites(Set<Vitrinite> vitrinites) {
        this.vitrinites = vitrinites;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entry)) {
            return false;
        }
        return id != null && id.equals(((Entry) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Entry{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", version=" + getVersion() +
            "}";
    }
}
