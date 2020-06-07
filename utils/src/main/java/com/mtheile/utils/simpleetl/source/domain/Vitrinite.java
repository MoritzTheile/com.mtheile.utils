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
 * A Vitrinite.
 */
@Entity
@Table(name = "vitrinite")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Vitrinite extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "no_meas")
    private Integer noMeas;

    @Column(name = "om_pct")
    private Float omPct;

    @Column(name = "ro_max")
    private Float roMax;

    @Column(name = "ro_min")
    private Float roMin;

    @Column(name = "ro_pct")
    private Float roPct;

    @Column(name = "ro_sd")
    private Float roSd;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "vitrinite_entry",
               joinColumns = @JoinColumn(name = "vitrinite_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "entry_id", referencedColumnName = "id"))
    private Set<Entry> entries = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("vitrinites")
    private Sample sample;

    @ManyToOne
    @JsonIgnoreProperties("vitrinites")
    private LLab lab;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNoMeas() {
        return noMeas;
    }

    public Vitrinite noMeas(Integer noMeas) {
        this.noMeas = noMeas;
        return this;
    }

    public void setNoMeas(Integer noMeas) {
        this.noMeas = noMeas;
    }

    public Float getOmPct() {
        return omPct;
    }

    public Vitrinite omPct(Float omPct) {
        this.omPct = omPct;
        return this;
    }

    public void setOmPct(Float omPct) {
        this.omPct = omPct;
    }

    public Float getRoMax() {
        return roMax;
    }

    public Vitrinite roMax(Float roMax) {
        this.roMax = roMax;
        return this;
    }

    public void setRoMax(Float roMax) {
        this.roMax = roMax;
    }

    public Float getRoMin() {
        return roMin;
    }

    public Vitrinite roMin(Float roMin) {
        this.roMin = roMin;
        return this;
    }

    public void setRoMin(Float roMin) {
        this.roMin = roMin;
    }

    public Float getRoPct() {
        return roPct;
    }

    public Vitrinite roPct(Float roPct) {
        this.roPct = roPct;
        return this;
    }

    public void setRoPct(Float roPct) {
        this.roPct = roPct;
    }

    public Float getRoSd() {
        return roSd;
    }

    public Vitrinite roSd(Float roSd) {
        this.roSd = roSd;
        return this;
    }

    public void setRoSd(Float roSd) {
        this.roSd = roSd;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public Vitrinite entries(Set<Entry> entries) {
        this.entries = entries;
        return this;
    }

    public Vitrinite addEntry(Entry entry) {
        this.entries.add(entry);
        entry.getVitrinites().add(this);
        return this;
    }

    public Vitrinite removeEntry(Entry entry) {
        this.entries.remove(entry);
        entry.getVitrinites().remove(this);
        return this;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }

    public Sample getSample() {
        return sample;
    }

    public Vitrinite sample(Sample sample) {
        this.sample = sample;
        return this;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public LLab getLab() {
        return lab;
    }

    public Vitrinite lab(LLab lLab) {
        this.lab = lLab;
        return this;
    }

    public void setLab(LLab lLab) {
        this.lab = lLab;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vitrinite)) {
            return false;
        }
        return id != null && id.equals(((Vitrinite) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Vitrinite{" +
            "id=" + getId() +
            ", noMeas=" + getNoMeas() +
            ", omPct=" + getOmPct() +
            ", roMax=" + getRoMax() +
            ", roMin=" + getRoMin() +
            ", roPct=" + getRoPct() +
            ", roSd=" + getRoSd() +
            "}";
    }
}
