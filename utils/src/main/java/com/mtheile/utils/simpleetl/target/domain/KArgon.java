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
 * A KArgon.
 */
@Entity
@Table(name = "k_argon")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class KArgon extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "lambda")
    private Float lambda;

    @Column(name = "kperc")
    private Float kperc;

    @Column(name = "rad_40_k")
    private Float rad40k;

    @Column(name = "ar_40_ar_40")
    private Float ar40Ar40;

    @Column(name = "atom_ar")
    private Float atomAr;

    @Column(name = "s_tp_mole_gar")
    private Float sTPMoleGAR;

    @ManyToOne
    @JsonIgnoreProperties("kArgons")
    private Chrono chrono;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLambda() {
        return lambda;
    }

    public KArgon lambda(Float lambda) {
        this.lambda = lambda;
        return this;
    }

    public void setLambda(Float lambda) {
        this.lambda = lambda;
    }

    public Float getKperc() {
        return kperc;
    }

    public KArgon kperc(Float kperc) {
        this.kperc = kperc;
        return this;
    }

    public void setKperc(Float kperc) {
        this.kperc = kperc;
    }

    public Float getRad40k() {
        return rad40k;
    }

    public KArgon rad40k(Float rad40k) {
        this.rad40k = rad40k;
        return this;
    }

    public void setRad40k(Float rad40k) {
        this.rad40k = rad40k;
    }

    public Float getAr40Ar40() {
        return ar40Ar40;
    }

    public KArgon ar40Ar40(Float ar40Ar40) {
        this.ar40Ar40 = ar40Ar40;
        return this;
    }

    public void setAr40Ar40(Float ar40Ar40) {
        this.ar40Ar40 = ar40Ar40;
    }

    public Float getAtomAr() {
        return atomAr;
    }

    public KArgon atomAr(Float atomAr) {
        this.atomAr = atomAr;
        return this;
    }

    public void setAtomAr(Float atomAr) {
        this.atomAr = atomAr;
    }

    public Float getsTPMoleGAR() {
        return sTPMoleGAR;
    }

    public KArgon sTPMoleGAR(Float sTPMoleGAR) {
        this.sTPMoleGAR = sTPMoleGAR;
        return this;
    }

    public void setsTPMoleGAR(Float sTPMoleGAR) {
        this.sTPMoleGAR = sTPMoleGAR;
    }

    public Chrono getChrono() {
        return chrono;
    }

    public KArgon chrono(Chrono chrono) {
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
        if (!(o instanceof KArgon)) {
            return false;
        }
        return id != null && id.equals(((KArgon) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "KArgon{" +
            "id=" + getId() +
            ", lambda=" + getLambda() +
            ", kperc=" + getKperc() +
            ", rad40k=" + getRad40k() +
            ", ar40Ar40=" + getAr40Ar40() +
            ", atomAr=" + getAtomAr() +
            ", sTPMoleGAR=" + getsTPMoleGAR() +
            "}";
    }
}
