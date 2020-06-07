package com.mtheile.utils.simpleetl.source.domain;


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
 * A ThermalHistory.
 */
@Entity
@Table(name = "thermal_history")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ThermalHistory extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "t_min")
    private Float tMin;

    @Column(name = "t_max")
    private Float tMax;

    @Column(name = "t_best")
    private Float tBest;

    @Column(name = "t_avg")
    private Float tAvg;

    @Column(name = "age_ma")
    private Float ageMa;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "thermal_history_entry",
               joinColumns = @JoinColumn(name = "thermal_history_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "entry_id", referencedColumnName = "id"))
    private Set<Entry> entries = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("thermalHistories")
    private Sample sample;

    @ManyToOne
    @JsonIgnoreProperties("thermalHistories")
    private Location location;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float gettMin() {
        return tMin;
    }

    public ThermalHistory tMin(Float tMin) {
        this.tMin = tMin;
        return this;
    }

    public void settMin(Float tMin) {
        this.tMin = tMin;
    }

    public Float gettMax() {
        return tMax;
    }

    public ThermalHistory tMax(Float tMax) {
        this.tMax = tMax;
        return this;
    }

    public void settMax(Float tMax) {
        this.tMax = tMax;
    }

    public Float gettBest() {
        return tBest;
    }

    public ThermalHistory tBest(Float tBest) {
        this.tBest = tBest;
        return this;
    }

    public void settBest(Float tBest) {
        this.tBest = tBest;
    }

    public Float gettAvg() {
        return tAvg;
    }

    public ThermalHistory tAvg(Float tAvg) {
        this.tAvg = tAvg;
        return this;
    }

    public void settAvg(Float tAvg) {
        this.tAvg = tAvg;
    }

    public Float getAgeMa() {
        return ageMa;
    }

    public ThermalHistory ageMa(Float ageMa) {
        this.ageMa = ageMa;
        return this;
    }

    public void setAgeMa(Float ageMa) {
        this.ageMa = ageMa;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public ThermalHistory entries(Set<Entry> entries) {
        this.entries = entries;
        return this;
    }

    public ThermalHistory addEntry(Entry entry) {
        this.entries.add(entry);
        entry.getThermalHistories().add(this);
        return this;
    }

    public ThermalHistory removeEntry(Entry entry) {
        this.entries.remove(entry);
        entry.getThermalHistories().remove(this);
        return this;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }

    public Sample getSample() {
        return sample;
    }

    public ThermalHistory sample(Sample sample) {
        this.sample = sample;
        return this;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public Location getLocation() {
        return location;
    }

    public ThermalHistory location(Location location) {
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
        if (!(o instanceof ThermalHistory)) {
            return false;
        }
        return id != null && id.equals(((ThermalHistory) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ThermalHistory{" +
            "id=" + getId() +
            ", tMin=" + gettMin() +
            ", tMax=" + gettMax() +
            ", tBest=" + gettBest() +
            ", tAvg=" + gettAvg() +
            ", ageMa=" + getAgeMa() +
            "}";
    }
}
