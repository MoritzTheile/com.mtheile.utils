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
 * A SingleGrain.
 */
@Entity
@Table(name = "single_grain")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SingleGrain extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "sing_grain_age")
    private Float singGrainAge;

    @Column(name = "sing_grain_age_err")
    private Float singGrainAgeErr;

    @Column(name = "rho_d")
    private Float rhoD;

    @Column(name = "rho_i")
    private Float rhoI;

    @Column(name = "dpar")
    private Float dpar;

    @Column(name = "cl_cont")
    private Float clCont;

    @Column(name = "rho_s")
    private Float rhoS;

    @Column(name = "sing_grain_name")
    private String singGrainName;

    @Column(name = "l_a_pit_area")
    private Float lAPitArea;

    @Column(name = "ni")
    private Integer ni;

    @Column(name = "ns")
    private Integer ns;

    @Column(name = "u_ca_ratio")
    private Float uCaRatio;

    @Column(name = "u_si_ratio")
    private Float uSiRatio;

    @Column(name = "dper")
    private Float dper;

    @Column(name = "u_ppm")
    private Float uPpm;

    @Column(name = "l_a_pit_depth")
    private Float lAPitDepth;

    @Column(name = "l_a_pit_diameter")
    private Float lAPitDiameter;

    @Column(name = "l_a_pit_shape")
    private String lAPitShape;

    @Column(name = "l_a_pit_volume")
    private Float lAPitVolume;

    @Column(name = "uppm_error")
    private Float uppmError;

    @ManyToOne
    @JsonIgnoreProperties("singleGrains")
    private Chrono chrono;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getSingGrainAge() {
        return singGrainAge;
    }

    public SingleGrain singGrainAge(Float singGrainAge) {
        this.singGrainAge = singGrainAge;
        return this;
    }

    public void setSingGrainAge(Float singGrainAge) {
        this.singGrainAge = singGrainAge;
    }

    public Float getSingGrainAgeErr() {
        return singGrainAgeErr;
    }

    public SingleGrain singGrainAgeErr(Float singGrainAgeErr) {
        this.singGrainAgeErr = singGrainAgeErr;
        return this;
    }

    public void setSingGrainAgeErr(Float singGrainAgeErr) {
        this.singGrainAgeErr = singGrainAgeErr;
    }

    public Float getRhoD() {
        return rhoD;
    }

    public SingleGrain rhoD(Float rhoD) {
        this.rhoD = rhoD;
        return this;
    }

    public void setRhoD(Float rhoD) {
        this.rhoD = rhoD;
    }

    public Float getRhoI() {
        return rhoI;
    }

    public SingleGrain rhoI(Float rhoI) {
        this.rhoI = rhoI;
        return this;
    }

    public void setRhoI(Float rhoI) {
        this.rhoI = rhoI;
    }

    public Float getDpar() {
        return dpar;
    }

    public SingleGrain dpar(Float dpar) {
        this.dpar = dpar;
        return this;
    }

    public void setDpar(Float dpar) {
        this.dpar = dpar;
    }

    public Float getClCont() {
        return clCont;
    }

    public SingleGrain clCont(Float clCont) {
        this.clCont = clCont;
        return this;
    }

    public void setClCont(Float clCont) {
        this.clCont = clCont;
    }

    public Float getRhoS() {
        return rhoS;
    }

    public SingleGrain rhoS(Float rhoS) {
        this.rhoS = rhoS;
        return this;
    }

    public void setRhoS(Float rhoS) {
        this.rhoS = rhoS;
    }

    public String getSingGrainName() {
        return singGrainName;
    }

    public SingleGrain singGrainName(String singGrainName) {
        this.singGrainName = singGrainName;
        return this;
    }

    public void setSingGrainName(String singGrainName) {
        this.singGrainName = singGrainName;
    }

    public Float getlAPitArea() {
        return lAPitArea;
    }

    public SingleGrain lAPitArea(Float lAPitArea) {
        this.lAPitArea = lAPitArea;
        return this;
    }

    public void setlAPitArea(Float lAPitArea) {
        this.lAPitArea = lAPitArea;
    }

    public Integer getNi() {
        return ni;
    }

    public SingleGrain ni(Integer ni) {
        this.ni = ni;
        return this;
    }

    public void setNi(Integer ni) {
        this.ni = ni;
    }

    public Integer getNs() {
        return ns;
    }

    public SingleGrain ns(Integer ns) {
        this.ns = ns;
        return this;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public Float getuCaRatio() {
        return uCaRatio;
    }

    public SingleGrain uCaRatio(Float uCaRatio) {
        this.uCaRatio = uCaRatio;
        return this;
    }

    public void setuCaRatio(Float uCaRatio) {
        this.uCaRatio = uCaRatio;
    }

    public Float getuSiRatio() {
        return uSiRatio;
    }

    public SingleGrain uSiRatio(Float uSiRatio) {
        this.uSiRatio = uSiRatio;
        return this;
    }

    public void setuSiRatio(Float uSiRatio) {
        this.uSiRatio = uSiRatio;
    }

    public Float getDper() {
        return dper;
    }

    public SingleGrain dper(Float dper) {
        this.dper = dper;
        return this;
    }

    public void setDper(Float dper) {
        this.dper = dper;
    }

    public Float getuPpm() {
        return uPpm;
    }

    public SingleGrain uPpm(Float uPpm) {
        this.uPpm = uPpm;
        return this;
    }

    public void setuPpm(Float uPpm) {
        this.uPpm = uPpm;
    }

    public Float getlAPitDepth() {
        return lAPitDepth;
    }

    public SingleGrain lAPitDepth(Float lAPitDepth) {
        this.lAPitDepth = lAPitDepth;
        return this;
    }

    public void setlAPitDepth(Float lAPitDepth) {
        this.lAPitDepth = lAPitDepth;
    }

    public Float getlAPitDiameter() {
        return lAPitDiameter;
    }

    public SingleGrain lAPitDiameter(Float lAPitDiameter) {
        this.lAPitDiameter = lAPitDiameter;
        return this;
    }

    public void setlAPitDiameter(Float lAPitDiameter) {
        this.lAPitDiameter = lAPitDiameter;
    }

    public String getlAPitShape() {
        return lAPitShape;
    }

    public SingleGrain lAPitShape(String lAPitShape) {
        this.lAPitShape = lAPitShape;
        return this;
    }

    public void setlAPitShape(String lAPitShape) {
        this.lAPitShape = lAPitShape;
    }

    public Float getlAPitVolume() {
        return lAPitVolume;
    }

    public SingleGrain lAPitVolume(Float lAPitVolume) {
        this.lAPitVolume = lAPitVolume;
        return this;
    }

    public void setlAPitVolume(Float lAPitVolume) {
        this.lAPitVolume = lAPitVolume;
    }

    public Float getUppmError() {
        return uppmError;
    }

    public SingleGrain uppmError(Float uppmError) {
        this.uppmError = uppmError;
        return this;
    }

    public void setUppmError(Float uppmError) {
        this.uppmError = uppmError;
    }

    public Chrono getChrono() {
        return chrono;
    }

    public SingleGrain chrono(Chrono chrono) {
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
        if (!(o instanceof SingleGrain)) {
            return false;
        }
        return id != null && id.equals(((SingleGrain) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "SingleGrain{" +
            "id=" + getId() +
            ", singGrainAge=" + getSingGrainAge() +
            ", singGrainAgeErr=" + getSingGrainAgeErr() +
            ", rhoD=" + getRhoD() +
            ", rhoI=" + getRhoI() +
            ", dpar=" + getDpar() +
            ", clCont=" + getClCont() +
            ", rhoS=" + getRhoS() +
            ", singGrainName='" + getSingGrainName() + "'" +
            ", lAPitArea=" + getlAPitArea() +
            ", ni=" + getNi() +
            ", ns=" + getNs() +
            ", uCaRatio=" + getuCaRatio() +
            ", uSiRatio=" + getuSiRatio() +
            ", dper=" + getDper() +
            ", uPpm=" + getuPpm() +
            ", lAPitDepth=" + getlAPitDepth() +
            ", lAPitDiameter=" + getlAPitDiameter() +
            ", lAPitShape='" + getlAPitShape() + "'" +
            ", lAPitVolume=" + getlAPitVolume() +
            ", uppmError=" + getUppmError() +
            "}";
    }
}
