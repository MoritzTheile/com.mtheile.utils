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
 * A SingleGrainHe.
 */
@Entity
@Table(name = "single_grain_he")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SingleGrainHe extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "u_ppm")
    private Float uPpm;

    @Column(name = "th_ppm")
    private Float thPpm;

    @Column(name = "sm_ppm")
    private Float smPpm;

    @Column(name = "he_4_nmol")
    private Float he4Nmol;

    @Column(name = "grain_age")
    private Float grainAge;

    @Column(name = "grain_age_err")
    private Float grainAgeErr;

    @Column(name = "grain_name")
    private String grainName;

    @Column(name = "grain_len")
    private Float grainLen;

    @Column(name = "grain_wid")
    private Float grainWid;

    @Column(name = "grain_thick")
    private Float grainThick;

    @Column(name = "grain_eradius")
    private Float grainEradius;

    @Column(name = "ft")
    private Float ft;

    @Column(name = "raw_age")
    private Float rawAge;

    @Column(name = "raw_age_err")
    private Float rawAgeErr;

    @Column(name = "eu_ppm")
    private Float euPpm;

    @Column(name = "mass_ug")
    private Float massUg;

    @Column(name = "eu_ng")
    private Float euNg;

    @Column(name = "he_4_ncc")
    private Float he4Ncc;

    @Column(name = "sm_ng")
    private Float smNg;

    @Column(name = "th_ng")
    private Float thNg;

    @Column(name = "th_u_ratio")
    private Float thURatio;

    @Column(name = "u_ng")
    private Float uNg;

    @Column(name = "n_t")
    private Integer nT;

    @Column(name = "he_4_nmol_per_gram")
    private Float he4NmolPerGram;

    @Lob
    @Column(name = "jhi_comment")
    private String comment;

    @ManyToOne
    @JsonIgnoreProperties("singleGrainHes")
    private LThermDiffusion diffusionMod;

    @ManyToOne
    @JsonIgnoreProperties("singleGrainHes")
    private LErrorType errorType;

    @ManyToOne
    @JsonIgnoreProperties("singleGrainHes")
    private LLab lab;

    @ManyToOne
    @JsonIgnoreProperties("singleGrainHes")
    private LChrMineral mineral;

    @ManyToOne
    @JsonIgnoreProperties("singleGrainHes")
    private Helium helium;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getuPpm() {
        return uPpm;
    }

    public SingleGrainHe uPpm(Float uPpm) {
        this.uPpm = uPpm;
        return this;
    }

    public void setuPpm(Float uPpm) {
        this.uPpm = uPpm;
    }

    public Float getThPpm() {
        return thPpm;
    }

    public SingleGrainHe thPpm(Float thPpm) {
        this.thPpm = thPpm;
        return this;
    }

    public void setThPpm(Float thPpm) {
        this.thPpm = thPpm;
    }

    public Float getSmPpm() {
        return smPpm;
    }

    public SingleGrainHe smPpm(Float smPpm) {
        this.smPpm = smPpm;
        return this;
    }

    public void setSmPpm(Float smPpm) {
        this.smPpm = smPpm;
    }

    public Float getHe4Nmol() {
        return he4Nmol;
    }

    public SingleGrainHe he4Nmol(Float he4Nmol) {
        this.he4Nmol = he4Nmol;
        return this;
    }

    public void setHe4Nmol(Float he4Nmol) {
        this.he4Nmol = he4Nmol;
    }

    public Float getGrainAge() {
        return grainAge;
    }

    public SingleGrainHe grainAge(Float grainAge) {
        this.grainAge = grainAge;
        return this;
    }

    public void setGrainAge(Float grainAge) {
        this.grainAge = grainAge;
    }

    public Float getGrainAgeErr() {
        return grainAgeErr;
    }

    public SingleGrainHe grainAgeErr(Float grainAgeErr) {
        this.grainAgeErr = grainAgeErr;
        return this;
    }

    public void setGrainAgeErr(Float grainAgeErr) {
        this.grainAgeErr = grainAgeErr;
    }

    public String getGrainName() {
        return grainName;
    }

    public SingleGrainHe grainName(String grainName) {
        this.grainName = grainName;
        return this;
    }

    public void setGrainName(String grainName) {
        this.grainName = grainName;
    }

    public Float getGrainLen() {
        return grainLen;
    }

    public SingleGrainHe grainLen(Float grainLen) {
        this.grainLen = grainLen;
        return this;
    }

    public void setGrainLen(Float grainLen) {
        this.grainLen = grainLen;
    }

    public Float getGrainWid() {
        return grainWid;
    }

    public SingleGrainHe grainWid(Float grainWid) {
        this.grainWid = grainWid;
        return this;
    }

    public void setGrainWid(Float grainWid) {
        this.grainWid = grainWid;
    }

    public Float getGrainThick() {
        return grainThick;
    }

    public SingleGrainHe grainThick(Float grainThick) {
        this.grainThick = grainThick;
        return this;
    }

    public void setGrainThick(Float grainThick) {
        this.grainThick = grainThick;
    }

    public Float getGrainEradius() {
        return grainEradius;
    }

    public SingleGrainHe grainEradius(Float grainEradius) {
        this.grainEradius = grainEradius;
        return this;
    }

    public void setGrainEradius(Float grainEradius) {
        this.grainEradius = grainEradius;
    }

    public Float getFt() {
        return ft;
    }

    public SingleGrainHe ft(Float ft) {
        this.ft = ft;
        return this;
    }

    public void setFt(Float ft) {
        this.ft = ft;
    }

    public Float getRawAge() {
        return rawAge;
    }

    public SingleGrainHe rawAge(Float rawAge) {
        this.rawAge = rawAge;
        return this;
    }

    public void setRawAge(Float rawAge) {
        this.rawAge = rawAge;
    }

    public Float getRawAgeErr() {
        return rawAgeErr;
    }

    public SingleGrainHe rawAgeErr(Float rawAgeErr) {
        this.rawAgeErr = rawAgeErr;
        return this;
    }

    public void setRawAgeErr(Float rawAgeErr) {
        this.rawAgeErr = rawAgeErr;
    }

    public Float getEuPpm() {
        return euPpm;
    }

    public SingleGrainHe euPpm(Float euPpm) {
        this.euPpm = euPpm;
        return this;
    }

    public void setEuPpm(Float euPpm) {
        this.euPpm = euPpm;
    }

    public Float getMassUg() {
        return massUg;
    }

    public SingleGrainHe massUg(Float massUg) {
        this.massUg = massUg;
        return this;
    }

    public void setMassUg(Float massUg) {
        this.massUg = massUg;
    }

    public Float getEuNg() {
        return euNg;
    }

    public SingleGrainHe euNg(Float euNg) {
        this.euNg = euNg;
        return this;
    }

    public void setEuNg(Float euNg) {
        this.euNg = euNg;
    }

    public Float getHe4Ncc() {
        return he4Ncc;
    }

    public SingleGrainHe he4Ncc(Float he4Ncc) {
        this.he4Ncc = he4Ncc;
        return this;
    }

    public void setHe4Ncc(Float he4Ncc) {
        this.he4Ncc = he4Ncc;
    }

    public Float getSmNg() {
        return smNg;
    }

    public SingleGrainHe smNg(Float smNg) {
        this.smNg = smNg;
        return this;
    }

    public void setSmNg(Float smNg) {
        this.smNg = smNg;
    }

    public Float getThNg() {
        return thNg;
    }

    public SingleGrainHe thNg(Float thNg) {
        this.thNg = thNg;
        return this;
    }

    public void setThNg(Float thNg) {
        this.thNg = thNg;
    }

    public Float getThURatio() {
        return thURatio;
    }

    public SingleGrainHe thURatio(Float thURatio) {
        this.thURatio = thURatio;
        return this;
    }

    public void setThURatio(Float thURatio) {
        this.thURatio = thURatio;
    }

    public Float getuNg() {
        return uNg;
    }

    public SingleGrainHe uNg(Float uNg) {
        this.uNg = uNg;
        return this;
    }

    public void setuNg(Float uNg) {
        this.uNg = uNg;
    }

    public Integer getnT() {
        return nT;
    }

    public SingleGrainHe nT(Integer nT) {
        this.nT = nT;
        return this;
    }

    public void setnT(Integer nT) {
        this.nT = nT;
    }

    public Float getHe4NmolPerGram() {
        return he4NmolPerGram;
    }

    public SingleGrainHe he4NmolPerGram(Float he4NmolPerGram) {
        this.he4NmolPerGram = he4NmolPerGram;
        return this;
    }

    public void setHe4NmolPerGram(Float he4NmolPerGram) {
        this.he4NmolPerGram = he4NmolPerGram;
    }

    public String getComment() {
        return comment;
    }

    public SingleGrainHe comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LThermDiffusion getDiffusionMod() {
        return diffusionMod;
    }

    public SingleGrainHe diffusionMod(LThermDiffusion lThermDiffusion) {
        this.diffusionMod = lThermDiffusion;
        return this;
    }

    public void setDiffusionMod(LThermDiffusion lThermDiffusion) {
        this.diffusionMod = lThermDiffusion;
    }

    public LErrorType getErrorType() {
        return errorType;
    }

    public SingleGrainHe errorType(LErrorType lErrorType) {
        this.errorType = lErrorType;
        return this;
    }

    public void setErrorType(LErrorType lErrorType) {
        this.errorType = lErrorType;
    }

    public LLab getLab() {
        return lab;
    }

    public SingleGrainHe lab(LLab lLab) {
        this.lab = lLab;
        return this;
    }

    public void setLab(LLab lLab) {
        this.lab = lLab;
    }

    public LChrMineral getMineral() {
        return mineral;
    }

    public SingleGrainHe mineral(LChrMineral lChrMineral) {
        this.mineral = lChrMineral;
        return this;
    }

    public void setMineral(LChrMineral lChrMineral) {
        this.mineral = lChrMineral;
    }

    public Helium getHelium() {
        return helium;
    }

    public SingleGrainHe helium(Helium helium) {
        this.helium = helium;
        return this;
    }

    public void setHelium(Helium helium) {
        this.helium = helium;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SingleGrainHe)) {
            return false;
        }
        return id != null && id.equals(((SingleGrainHe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "SingleGrainHe{" +
            "id=" + getId() +
            ", uPpm=" + getuPpm() +
            ", thPpm=" + getThPpm() +
            ", smPpm=" + getSmPpm() +
            ", he4Nmol=" + getHe4Nmol() +
            ", grainAge=" + getGrainAge() +
            ", grainAgeErr=" + getGrainAgeErr() +
            ", grainName='" + getGrainName() + "'" +
            ", grainLen=" + getGrainLen() +
            ", grainWid=" + getGrainWid() +
            ", grainThick=" + getGrainThick() +
            ", grainEradius=" + getGrainEradius() +
            ", ft=" + getFt() +
            ", rawAge=" + getRawAge() +
            ", rawAgeErr=" + getRawAgeErr() +
            ", euPpm=" + getEuPpm() +
            ", massUg=" + getMassUg() +
            ", euNg=" + getEuNg() +
            ", he4Ncc=" + getHe4Ncc() +
            ", smNg=" + getSmNg() +
            ", thNg=" + getThNg() +
            ", thURatio=" + getThURatio() +
            ", uNg=" + getuNg() +
            ", nT=" + getnT() +
            ", he4NmolPerGram=" + getHe4NmolPerGram() +
            ", comment='" + getComment() + "'" +
            "}";
    }
}
