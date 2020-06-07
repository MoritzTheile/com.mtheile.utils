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
 * A SmNd.
 */
@Entity
@Table(name = "sm_nd")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SmNd extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "smppm")
    private Float smppm;

    @Column(name = "ndppm")
    private Float ndppm;

    @Column(name = "sm_147_nd_144")
    private Float sm147Nd144;

    @Column(name = "nd_143_nd_144")
    private Float nd143Nd144;

    @Column(name = "error_20")
    private Float error20;

    @Column(name = "epsilon_ndt")
    private Float epsilonNdt;

    @Column(name = "d_mage")
    private Float dMage;

    @ManyToOne
    @JsonIgnoreProperties("smNds")
    private Chrono chrono;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSmppm() {
        return smppm;
    }

    public SmNd smppm(Float smppm) {
        this.smppm = smppm;
        return this;
    }

    public void setSmppm(Float smppm) {
        this.smppm = smppm;
    }

    public Float getNdppm() {
        return ndppm;
    }

    public SmNd ndppm(Float ndppm) {
        this.ndppm = ndppm;
        return this;
    }

    public void setNdppm(Float ndppm) {
        this.ndppm = ndppm;
    }

    public Float getSm147Nd144() {
        return sm147Nd144;
    }

    public SmNd sm147Nd144(Float sm147Nd144) {
        this.sm147Nd144 = sm147Nd144;
        return this;
    }

    public void setSm147Nd144(Float sm147Nd144) {
        this.sm147Nd144 = sm147Nd144;
    }

    public Float getNd143Nd144() {
        return nd143Nd144;
    }

    public SmNd nd143Nd144(Float nd143Nd144) {
        this.nd143Nd144 = nd143Nd144;
        return this;
    }

    public void setNd143Nd144(Float nd143Nd144) {
        this.nd143Nd144 = nd143Nd144;
    }

    public Float getError20() {
        return error20;
    }

    public SmNd error20(Float error20) {
        this.error20 = error20;
        return this;
    }

    public void setError20(Float error20) {
        this.error20 = error20;
    }

    public Float getEpsilonNdt() {
        return epsilonNdt;
    }

    public SmNd epsilonNdt(Float epsilonNdt) {
        this.epsilonNdt = epsilonNdt;
        return this;
    }

    public void setEpsilonNdt(Float epsilonNdt) {
        this.epsilonNdt = epsilonNdt;
    }

    public Float getdMage() {
        return dMage;
    }

    public SmNd dMage(Float dMage) {
        this.dMage = dMage;
        return this;
    }

    public void setdMage(Float dMage) {
        this.dMage = dMage;
    }

    public Chrono getChrono() {
        return chrono;
    }

    public SmNd chrono(Chrono chrono) {
        this.chrono = chrono;
        return this;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SmNd)) {
            return false;
        }
        return id != null && id.equals(((SmNd) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "SmNd{" +
            "id=" + getId() +
            ", smppm=" + getSmppm() +
            ", ndppm=" + getNdppm() +
            ", sm147Nd144=" + getSm147Nd144() +
            ", nd143Nd144=" + getNd143Nd144() +
            ", error20=" + getError20() +
            ", epsilonNdt=" + getEpsilonNdt() +
            ", dMage=" + getdMage() +
            "}";
    }
}
