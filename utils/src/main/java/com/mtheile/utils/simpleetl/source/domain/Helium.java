package com.mtheile.utils.simpleetl.source.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * A Helium.
 */
@Entity
@Table(name = "helium")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Helium extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "grain_name")
    private String grainName;

    @Column(name = "ngrains")
    private Integer ngrains;

    @Column(name = "avg_grain_length_um")
    private Float avgGrainLengthUm;

    @Column(name = "avg_grain_width_um")
    private Float avgGrainWidthUm;

    @Column(name = "avg_grain_thick_um")
    private Float avgGrainThickUm;

    @Column(name = "grain_eradius_um")
    private Float grainEradiusUm;

    @Column(name = "mass_ug")
    private Float massUg;

    @Column(name = "total_u_ppm")
    private Float totalUPpm;

    @Column(name = "total_th_ppm")
    private Float totalThPpm;

    @Column(name = "total_sm_ppm")
    private Float totalSmPpm;

    @Column(name = "total_eu_ppm")
    private Float totalEUPpm;

    @Column(name = "total_u_ng")
    private Float totalUNg;

    @Column(name = "total_th_ng")
    private Float totalThNg;

    @Column(name = "total_sm_ng")
    private Float totalSmNg;

    @Column(name = "total_eu_ng")
    private Float totalEuNg;

    @Column(name = "total_he_nmol")
    private Float totalHeNmol;

    @Column(name = "total_he_4_ncc")
    private Float totalHe4Ncc;

    @Column(name = "th_u_ratio")
    private Float thURatio;

    @Column(name = "n_t")
    private Integer nT;

    @Column(name = "ft")
    private Float ft;

    @Column(name = "raw_age")
    private Float rawAge;

    @Column(name = "raw_age_err")
    private Float rawAgeErr;

    @Column(name = "grain_age")
    private Float grainAge;

    @Column(name = "grain_age_err")
    private Float grainAgeErr;

    @Column(name = "total_he_4_nmol_per_gram")
    private Float totalHe4NmolPerGram;

    @Lob
    @Column(name = "jhi_comment")
    private String comment;

    @OneToMany(mappedBy = "helium")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SingleGrainHe> singleGrainHes = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("heliums")
    private Chrono chrono;

    @ManyToOne
    @JsonIgnoreProperties("heliums")
    private LChrAnalyticalMethod analyticalMethod;

    @ManyToOne
    @JsonIgnoreProperties("heliums")
    private LChrAvgKind averageKind;

    @ManyToOne
    @JsonIgnoreProperties("heliums")
    private LThermDiffusion diffusionMod;

    @ManyToOne
    @JsonIgnoreProperties("heliums")
    private LErrorType errorType;

    @ManyToOne
    @JsonIgnoreProperties("heliums")
    private LLab lab;

    @ManyToOne
    @JsonIgnoreProperties("heliums")
    private LChrMineral mineral;

    @ManyToOne
    @JsonIgnoreProperties("heliums")
    private LChrAnalyticalKind analyticalKind;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrainName() {
        return grainName;
    }

    public Helium grainName(String grainName) {
        this.grainName = grainName;
        return this;
    }

    public void setGrainName(String grainName) {
        this.grainName = grainName;
    }

    public Integer getNgrains() {
        return ngrains;
    }

    public Helium ngrains(Integer ngrains) {
        this.ngrains = ngrains;
        return this;
    }

    public void setNgrains(Integer ngrains) {
        this.ngrains = ngrains;
    }

    public Float getAvgGrainLengthUm() {
        return avgGrainLengthUm;
    }

    public Helium avgGrainLengthUm(Float avgGrainLengthUm) {
        this.avgGrainLengthUm = avgGrainLengthUm;
        return this;
    }

    public void setAvgGrainLengthUm(Float avgGrainLengthUm) {
        this.avgGrainLengthUm = avgGrainLengthUm;
    }

    public Float getAvgGrainWidthUm() {
        return avgGrainWidthUm;
    }

    public Helium avgGrainWidthUm(Float avgGrainWidthUm) {
        this.avgGrainWidthUm = avgGrainWidthUm;
        return this;
    }

    public void setAvgGrainWidthUm(Float avgGrainWidthUm) {
        this.avgGrainWidthUm = avgGrainWidthUm;
    }

    public Float getAvgGrainThickUm() {
        return avgGrainThickUm;
    }

    public Helium avgGrainThickUm(Float avgGrainThickUm) {
        this.avgGrainThickUm = avgGrainThickUm;
        return this;
    }

    public void setAvgGrainThickUm(Float avgGrainThickUm) {
        this.avgGrainThickUm = avgGrainThickUm;
    }

    public Float getGrainEradiusUm() {
        return grainEradiusUm;
    }

    public Helium grainEradiusUm(Float grainEradiusUm) {
        this.grainEradiusUm = grainEradiusUm;
        return this;
    }

    public void setGrainEradiusUm(Float grainEradiusUm) {
        this.grainEradiusUm = grainEradiusUm;
    }

    public Float getMassUg() {
        return massUg;
    }

    public Helium massUg(Float massUg) {
        this.massUg = massUg;
        return this;
    }

    public void setMassUg(Float massUg) {
        this.massUg = massUg;
    }

    public Float getTotalUPpm() {
        return totalUPpm;
    }

    public Helium totalUPpm(Float totalUPpm) {
        this.totalUPpm = totalUPpm;
        return this;
    }

    public void setTotalUPpm(Float totalUPpm) {
        this.totalUPpm = totalUPpm;
    }

    public Float getTotalThPpm() {
        return totalThPpm;
    }

    public Helium totalThPpm(Float totalThPpm) {
        this.totalThPpm = totalThPpm;
        return this;
    }

    public void setTotalThPpm(Float totalThPpm) {
        this.totalThPpm = totalThPpm;
    }

    public Float getTotalSmPpm() {
        return totalSmPpm;
    }

    public Helium totalSmPpm(Float totalSmPpm) {
        this.totalSmPpm = totalSmPpm;
        return this;
    }

    public void setTotalSmPpm(Float totalSmPpm) {
        this.totalSmPpm = totalSmPpm;
    }

    public Float getTotalEUPpm() {
        return totalEUPpm;
    }

    public Helium totalEUPpm(Float totalEUPpm) {
        this.totalEUPpm = totalEUPpm;
        return this;
    }

    public void setTotalEUPpm(Float totalEUPpm) {
        this.totalEUPpm = totalEUPpm;
    }

    public Float getTotalUNg() {
        return totalUNg;
    }

    public Helium totalUNg(Float totalUNg) {
        this.totalUNg = totalUNg;
        return this;
    }

    public void setTotalUNg(Float totalUNg) {
        this.totalUNg = totalUNg;
    }

    public Float getTotalThNg() {
        return totalThNg;
    }

    public Helium totalThNg(Float totalThNg) {
        this.totalThNg = totalThNg;
        return this;
    }

    public void setTotalThNg(Float totalThNg) {
        this.totalThNg = totalThNg;
    }

    public Float getTotalSmNg() {
        return totalSmNg;
    }

    public Helium totalSmNg(Float totalSmNg) {
        this.totalSmNg = totalSmNg;
        return this;
    }

    public void setTotalSmNg(Float totalSmNg) {
        this.totalSmNg = totalSmNg;
    }

    public Float getTotalEuNg() {
        return totalEuNg;
    }

    public Helium totalEuNg(Float totalEuNg) {
        this.totalEuNg = totalEuNg;
        return this;
    }

    public void setTotalEuNg(Float totalEuNg) {
        this.totalEuNg = totalEuNg;
    }

    public Float getTotalHeNmol() {
        return totalHeNmol;
    }

    public Helium totalHeNmol(Float totalHeNmol) {
        this.totalHeNmol = totalHeNmol;
        return this;
    }

    public void setTotalHeNmol(Float totalHeNmol) {
        this.totalHeNmol = totalHeNmol;
    }

    public Float getTotalHe4Ncc() {
        return totalHe4Ncc;
    }

    public Helium totalHe4Ncc(Float totalHe4Ncc) {
        this.totalHe4Ncc = totalHe4Ncc;
        return this;
    }

    public void setTotalHe4Ncc(Float totalHe4Ncc) {
        this.totalHe4Ncc = totalHe4Ncc;
    }

    public Float getThURatio() {
        return thURatio;
    }

    public Helium thURatio(Float thURatio) {
        this.thURatio = thURatio;
        return this;
    }

    public void setThURatio(Float thURatio) {
        this.thURatio = thURatio;
    }

    public Integer getnT() {
        return nT;
    }

    public Helium nT(Integer nT) {
        this.nT = nT;
        return this;
    }

    public void setnT(Integer nT) {
        this.nT = nT;
    }

    public Float getFt() {
        return ft;
    }

    public Helium ft(Float ft) {
        this.ft = ft;
        return this;
    }

    public void setFt(Float ft) {
        this.ft = ft;
    }

    public Float getRawAge() {
        return rawAge;
    }

    public Helium rawAge(Float rawAge) {
        this.rawAge = rawAge;
        return this;
    }

    public void setRawAge(Float rawAge) {
        this.rawAge = rawAge;
    }

    public Float getRawAgeErr() {
        return rawAgeErr;
    }

    public Helium rawAgeErr(Float rawAgeErr) {
        this.rawAgeErr = rawAgeErr;
        return this;
    }

    public void setRawAgeErr(Float rawAgeErr) {
        this.rawAgeErr = rawAgeErr;
    }

    public Float getGrainAge() {
        return grainAge;
    }

    public Helium grainAge(Float grainAge) {
        this.grainAge = grainAge;
        return this;
    }

    public void setGrainAge(Float grainAge) {
        this.grainAge = grainAge;
    }

    public Float getGrainAgeErr() {
        return grainAgeErr;
    }

    public Helium grainAgeErr(Float grainAgeErr) {
        this.grainAgeErr = grainAgeErr;
        return this;
    }

    public void setGrainAgeErr(Float grainAgeErr) {
        this.grainAgeErr = grainAgeErr;
    }

    public Float getTotalHe4NmolPerGram() {
        return totalHe4NmolPerGram;
    }

    public Helium totalHe4NmolPerGram(Float totalHe4NmolPerGram) {
        this.totalHe4NmolPerGram = totalHe4NmolPerGram;
        return this;
    }

    public void setTotalHe4NmolPerGram(Float totalHe4NmolPerGram) {
        this.totalHe4NmolPerGram = totalHe4NmolPerGram;
    }

    public String getComment() {
        return comment;
    }

    public Helium comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<SingleGrainHe> getSingleGrainHes() {
        return singleGrainHes;
    }

    public Helium singleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
        return this;
    }

    public Helium addSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.add(singleGrainHe);
        singleGrainHe.setHelium(this);
        return this;
    }

    public Helium removeSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.remove(singleGrainHe);
        singleGrainHe.setHelium(null);
        return this;
    }

    public void setSingleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
    }

    public Chrono getChrono() {
        return chrono;
    }

    public Helium chrono(Chrono chrono) {
        this.chrono = chrono;
        return this;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }

    public LChrAnalyticalMethod getAnalyticalMethod() {
        return analyticalMethod;
    }

    public Helium analyticalMethod(LChrAnalyticalMethod lChrAnalyticalMethod) {
        this.analyticalMethod = lChrAnalyticalMethod;
        return this;
    }

    public void setAnalyticalMethod(LChrAnalyticalMethod lChrAnalyticalMethod) {
        this.analyticalMethod = lChrAnalyticalMethod;
    }

    public LChrAvgKind getAverageKind() {
        return averageKind;
    }

    public Helium averageKind(LChrAvgKind lChrAvgKind) {
        this.averageKind = lChrAvgKind;
        return this;
    }

    public void setAverageKind(LChrAvgKind lChrAvgKind) {
        this.averageKind = lChrAvgKind;
    }

    public LThermDiffusion getDiffusionMod() {
        return diffusionMod;
    }

    public Helium diffusionMod(LThermDiffusion lThermDiffusion) {
        this.diffusionMod = lThermDiffusion;
        return this;
    }

    public void setDiffusionMod(LThermDiffusion lThermDiffusion) {
        this.diffusionMod = lThermDiffusion;
    }

    public LErrorType getErrorType() {
        return errorType;
    }

    public Helium errorType(LErrorType lErrorType) {
        this.errorType = lErrorType;
        return this;
    }

    public void setErrorType(LErrorType lErrorType) {
        this.errorType = lErrorType;
    }

    public LLab getLab() {
        return lab;
    }

    public Helium lab(LLab lLab) {
        this.lab = lLab;
        return this;
    }

    public void setLab(LLab lLab) {
        this.lab = lLab;
    }

    public LChrMineral getMineral() {
        return mineral;
    }

    public Helium mineral(LChrMineral lChrMineral) {
        this.mineral = lChrMineral;
        return this;
    }

    public void setMineral(LChrMineral lChrMineral) {
        this.mineral = lChrMineral;
    }

    public LChrAnalyticalKind getAnalyticalKind() {
        return analyticalKind;
    }

    public Helium analyticalKind(LChrAnalyticalKind lChrAnalyticalKind) {
        this.analyticalKind = lChrAnalyticalKind;
        return this;
    }

    public void setAnalyticalKind(LChrAnalyticalKind lChrAnalyticalKind) {
        this.analyticalKind = lChrAnalyticalKind;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Helium)) {
            return false;
        }
        return id != null && id.equals(((Helium) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Helium{" +
            "id=" + getId() +
            ", grainName='" + getGrainName() + "'" +
            ", ngrains=" + getNgrains() +
            ", avgGrainLengthUm=" + getAvgGrainLengthUm() +
            ", avgGrainWidthUm=" + getAvgGrainWidthUm() +
            ", avgGrainThickUm=" + getAvgGrainThickUm() +
            ", grainEradiusUm=" + getGrainEradiusUm() +
            ", massUg=" + getMassUg() +
            ", totalUPpm=" + getTotalUPpm() +
            ", totalThPpm=" + getTotalThPpm() +
            ", totalSmPpm=" + getTotalSmPpm() +
            ", totalEUPpm=" + getTotalEUPpm() +
            ", totalUNg=" + getTotalUNg() +
            ", totalThNg=" + getTotalThNg() +
            ", totalSmNg=" + getTotalSmNg() +
            ", totalEuNg=" + getTotalEuNg() +
            ", totalHeNmol=" + getTotalHeNmol() +
            ", totalHe4Ncc=" + getTotalHe4Ncc() +
            ", thURatio=" + getThURatio() +
            ", nT=" + getnT() +
            ", ft=" + getFt() +
            ", rawAge=" + getRawAge() +
            ", rawAgeErr=" + getRawAgeErr() +
            ", grainAge=" + getGrainAge() +
            ", grainAgeErr=" + getGrainAgeErr() +
            ", totalHe4NmolPerGram=" + getTotalHe4NmolPerGram() +
            ", comment='" + getComment() + "'" +
            "}";
    }
}
