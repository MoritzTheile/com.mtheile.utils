package com.mtheile.utils.simpleetl.target.domain;


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
 * A Chrono.
 */
@Entity
@Table(name = "chrono")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Chrono extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "jhi_comment")
    private String comment;

    @Column(name = "upload_idx")
    private Integer uploadIdx;

    @Column(name = "chrono_age")
    private Float chronoAge;

    @Column(name = "chrono_age_error_low")
    private Float chronoAgeErrorLow;

    @Column(name = "chrono_age_error_high")
    private Float chronoAgeErrorHigh;

    @Column(name = "mswd")
    private Float mswd;

    @Column(name = "analysis_cnt")
    private Integer analysisCnt;

    @Column(name = "standard_used")
    private String standardUsed;

    @OneToMany(mappedBy = "chrono")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ChronoProperty> chronoProperties = new HashSet<>();

    @OneToMany(mappedBy = "chrono")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SingleGrain> singleGrains = new HashSet<>();

    @OneToMany(mappedBy = "chrono")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ReOs> reOs = new HashSet<>();

    @OneToMany(mappedBy = "chrono")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<RbSr> rbSrs = new HashSet<>();

    @OneToMany(mappedBy = "chrono")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SmNd> smNds = new HashSet<>();

    @OneToMany(mappedBy = "chrono")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<KArgon> kArgons = new HashSet<>();

    @OneToMany(mappedBy = "chrono")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<TrackLength> trackLengths = new HashSet<>();

    @OneToMany(mappedBy = "chrono")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<FissionTrack> fissionTracks = new HashSet<>();

    @OneToMany(mappedBy = "chrono")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Helium> heliums = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "chrono_entry",
               joinColumns = @JoinColumn(name = "chrono_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "entry_id", referencedColumnName = "id"))
    private Set<Entry> entries = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private Sample sample;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LChrAgeKind chrAgeKind;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LChrAgeKindProcess chrAgeKindProcess;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LChrAnalyticalKind chrAnalyticalKind;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LChrAnalyticalMethod chrAnalyticalMethod;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LChrAnalyticalSystem chrAnalyticalSystem;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LChrMineral chrMineral;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LChrThMod chrThMod;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LChrAvgKind chrAvgKind;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LLab lab;

    @ManyToOne
    @JsonIgnoreProperties("chronos")
    private LErrorType errorType;

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

    public Chrono name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public Chrono comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getUploadIdx() {
        return uploadIdx;
    }

    public Chrono uploadIdx(Integer uploadIdx) {
        this.uploadIdx = uploadIdx;
        return this;
    }

    public void setUploadIdx(Integer uploadIdx) {
        this.uploadIdx = uploadIdx;
    }

    public Float getChronoAge() {
        return chronoAge;
    }

    public Chrono chronoAge(Float chronoAge) {
        this.chronoAge = chronoAge;
        return this;
    }

    public void setChronoAge(Float chronoAge) {
        this.chronoAge = chronoAge;
    }

    public Float getChronoAgeErrorLow() {
        return chronoAgeErrorLow;
    }

    public Chrono chronoAgeErrorLow(Float chronoAgeErrorLow) {
        this.chronoAgeErrorLow = chronoAgeErrorLow;
        return this;
    }

    public void setChronoAgeErrorLow(Float chronoAgeErrorLow) {
        this.chronoAgeErrorLow = chronoAgeErrorLow;
    }

    public Float getChronoAgeErrorHigh() {
        return chronoAgeErrorHigh;
    }

    public Chrono chronoAgeErrorHigh(Float chronoAgeErrorHigh) {
        this.chronoAgeErrorHigh = chronoAgeErrorHigh;
        return this;
    }

    public void setChronoAgeErrorHigh(Float chronoAgeErrorHigh) {
        this.chronoAgeErrorHigh = chronoAgeErrorHigh;
    }

    public Float getMswd() {
        return mswd;
    }

    public Chrono mswd(Float mswd) {
        this.mswd = mswd;
        return this;
    }

    public void setMswd(Float mswd) {
        this.mswd = mswd;
    }

    public Integer getAnalysisCnt() {
        return analysisCnt;
    }

    public Chrono analysisCnt(Integer analysisCnt) {
        this.analysisCnt = analysisCnt;
        return this;
    }

    public void setAnalysisCnt(Integer analysisCnt) {
        this.analysisCnt = analysisCnt;
    }

    public String getStandardUsed() {
        return standardUsed;
    }

    public Chrono standardUsed(String standardUsed) {
        this.standardUsed = standardUsed;
        return this;
    }

    public void setStandardUsed(String standardUsed) {
        this.standardUsed = standardUsed;
    }

    public Set<ChronoProperty> getChronoProperties() {
        return chronoProperties;
    }

    public Chrono chronoProperties(Set<ChronoProperty> chronoProperties) {
        this.chronoProperties = chronoProperties;
        return this;
    }

    public Chrono addChronoProperty(ChronoProperty chronoProperty) {
        this.chronoProperties.add(chronoProperty);
        chronoProperty.setChrono(this);
        return this;
    }

    public Chrono removeChronoProperty(ChronoProperty chronoProperty) {
        this.chronoProperties.remove(chronoProperty);
        chronoProperty.setChrono(null);
        return this;
    }

    public void setChronoProperties(Set<ChronoProperty> chronoProperties) {
        this.chronoProperties = chronoProperties;
    }

    public Set<SingleGrain> getSingleGrains() {
        return singleGrains;
    }

    public Chrono singleGrains(Set<SingleGrain> singleGrains) {
        this.singleGrains = singleGrains;
        return this;
    }

    public Chrono addSingleGrain(SingleGrain singleGrain) {
        this.singleGrains.add(singleGrain);
        singleGrain.setChrono(this);
        return this;
    }

    public Chrono removeSingleGrain(SingleGrain singleGrain) {
        this.singleGrains.remove(singleGrain);
        singleGrain.setChrono(null);
        return this;
    }

    public void setSingleGrains(Set<SingleGrain> singleGrains) {
        this.singleGrains = singleGrains;
    }

    public Set<ReOs> getReOs() {
        return reOs;
    }

    public Chrono reOs(Set<ReOs> reOs) {
        this.reOs = reOs;
        return this;
    }

    public Chrono addReOs(ReOs reOs) {
        this.reOs.add(reOs);
        reOs.setChrono(this);
        return this;
    }

    public Chrono removeReOs(ReOs reOs) {
        this.reOs.remove(reOs);
        reOs.setChrono(null);
        return this;
    }

    public void setReOs(Set<ReOs> reOs) {
        this.reOs = reOs;
    }

    public Set<RbSr> getRbSrs() {
        return rbSrs;
    }

    public Chrono rbSrs(Set<RbSr> rbSrs) {
        this.rbSrs = rbSrs;
        return this;
    }

    public Chrono addRbSr(RbSr rbSr) {
        this.rbSrs.add(rbSr);
        rbSr.setChrono(this);
        return this;
    }

    public Chrono removeRbSr(RbSr rbSr) {
        this.rbSrs.remove(rbSr);
        rbSr.setChrono(null);
        return this;
    }

    public void setRbSrs(Set<RbSr> rbSrs) {
        this.rbSrs = rbSrs;
    }

    public Set<SmNd> getSmNds() {
        return smNds;
    }

    public Chrono smNds(Set<SmNd> smNds) {
        this.smNds = smNds;
        return this;
    }

    public Chrono addSmNd(SmNd smNd) {
        this.smNds.add(smNd);
        smNd.setChrono(this);
        return this;
    }

    public Chrono removeSmNd(SmNd smNd) {
        this.smNds.remove(smNd);
        smNd.setChrono(null);
        return this;
    }

    public void setSmNds(Set<SmNd> smNds) {
        this.smNds = smNds;
    }

    public Set<KArgon> getKArgons() {
        return kArgons;
    }

    public Chrono kArgons(Set<KArgon> kArgons) {
        this.kArgons = kArgons;
        return this;
    }

    public Chrono addKArgon(KArgon kArgon) {
        this.kArgons.add(kArgon);
        kArgon.setChrono(this);
        return this;
    }

    public Chrono removeKArgon(KArgon kArgon) {
        this.kArgons.remove(kArgon);
        kArgon.setChrono(null);
        return this;
    }

    public void setKArgons(Set<KArgon> kArgons) {
        this.kArgons = kArgons;
    }

    public Set<TrackLength> getTrackLengths() {
        return trackLengths;
    }

    public Chrono trackLengths(Set<TrackLength> trackLengths) {
        this.trackLengths = trackLengths;
        return this;
    }

    public Chrono addTrackLength(TrackLength trackLength) {
        this.trackLengths.add(trackLength);
        trackLength.setChrono(this);
        return this;
    }

    public Chrono removeTrackLength(TrackLength trackLength) {
        this.trackLengths.remove(trackLength);
        trackLength.setChrono(null);
        return this;
    }

    public void setTrackLengths(Set<TrackLength> trackLengths) {
        this.trackLengths = trackLengths;
    }

    public Set<FissionTrack> getFissionTracks() {
        return fissionTracks;
    }

    public Chrono fissionTracks(Set<FissionTrack> fissionTracks) {
        this.fissionTracks = fissionTracks;
        return this;
    }

    public Chrono addFissionTrack(FissionTrack fissionTrack) {
        this.fissionTracks.add(fissionTrack);
        fissionTrack.setChrono(this);
        return this;
    }

    public Chrono removeFissionTrack(FissionTrack fissionTrack) {
        this.fissionTracks.remove(fissionTrack);
        fissionTrack.setChrono(null);
        return this;
    }

    public void setFissionTracks(Set<FissionTrack> fissionTracks) {
        this.fissionTracks = fissionTracks;
    }

    public Set<Helium> getHeliums() {
        return heliums;
    }

    public Chrono heliums(Set<Helium> heliums) {
        this.heliums = heliums;
        return this;
    }

    public Chrono addHelium(Helium helium) {
        this.heliums.add(helium);
        helium.setChrono(this);
        return this;
    }

    public Chrono removeHelium(Helium helium) {
        this.heliums.remove(helium);
        helium.setChrono(null);
        return this;
    }

    public void setHeliums(Set<Helium> heliums) {
        this.heliums = heliums;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public Chrono entries(Set<Entry> entries) {
        this.entries = entries;
        return this;
    }

    public Chrono addEntry(Entry entry) {
        this.entries.add(entry);
        entry.getChronos().add(this);
        return this;
    }

    public Chrono removeEntry(Entry entry) {
        this.entries.remove(entry);
        entry.getChronos().remove(this);
        return this;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }

    public Sample getSample() {
        return sample;
    }

    public Chrono sample(Sample sample) {
        this.sample = sample;
        return this;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public LChrAgeKind getChrAgeKind() {
        return chrAgeKind;
    }

    public Chrono chrAgeKind(LChrAgeKind lChrAgeKind) {
        this.chrAgeKind = lChrAgeKind;
        return this;
    }

    public void setChrAgeKind(LChrAgeKind lChrAgeKind) {
        this.chrAgeKind = lChrAgeKind;
    }

    public LChrAgeKindProcess getChrAgeKindProcess() {
        return chrAgeKindProcess;
    }

    public Chrono chrAgeKindProcess(LChrAgeKindProcess lChrAgeKindProcess) {
        this.chrAgeKindProcess = lChrAgeKindProcess;
        return this;
    }

    public void setChrAgeKindProcess(LChrAgeKindProcess lChrAgeKindProcess) {
        this.chrAgeKindProcess = lChrAgeKindProcess;
    }

    public LChrAnalyticalKind getChrAnalyticalKind() {
        return chrAnalyticalKind;
    }

    public Chrono chrAnalyticalKind(LChrAnalyticalKind lChrAnalyticalKind) {
        this.chrAnalyticalKind = lChrAnalyticalKind;
        return this;
    }

    public void setChrAnalyticalKind(LChrAnalyticalKind lChrAnalyticalKind) {
        this.chrAnalyticalKind = lChrAnalyticalKind;
    }

    public LChrAnalyticalMethod getChrAnalyticalMethod() {
        return chrAnalyticalMethod;
    }

    public Chrono chrAnalyticalMethod(LChrAnalyticalMethod lChrAnalyticalMethod) {
        this.chrAnalyticalMethod = lChrAnalyticalMethod;
        return this;
    }

    public void setChrAnalyticalMethod(LChrAnalyticalMethod lChrAnalyticalMethod) {
        this.chrAnalyticalMethod = lChrAnalyticalMethod;
    }

    public LChrAnalyticalSystem getChrAnalyticalSystem() {
        return chrAnalyticalSystem;
    }

    public Chrono chrAnalyticalSystem(LChrAnalyticalSystem lChrAnalyticalSystem) {
        this.chrAnalyticalSystem = lChrAnalyticalSystem;
        return this;
    }

    public void setChrAnalyticalSystem(LChrAnalyticalSystem lChrAnalyticalSystem) {
        this.chrAnalyticalSystem = lChrAnalyticalSystem;
    }

    public LChrMineral getChrMineral() {
        return chrMineral;
    }

    public Chrono chrMineral(LChrMineral lChrMineral) {
        this.chrMineral = lChrMineral;
        return this;
    }

    public void setChrMineral(LChrMineral lChrMineral) {
        this.chrMineral = lChrMineral;
    }

    public LChrThMod getChrThMod() {
        return chrThMod;
    }

    public Chrono chrThMod(LChrThMod lChrThMod) {
        this.chrThMod = lChrThMod;
        return this;
    }

    public void setChrThMod(LChrThMod lChrThMod) {
        this.chrThMod = lChrThMod;
    }

    public LChrAvgKind getChrAvgKind() {
        return chrAvgKind;
    }

    public Chrono chrAvgKind(LChrAvgKind lChrAvgKind) {
        this.chrAvgKind = lChrAvgKind;
        return this;
    }

    public void setChrAvgKind(LChrAvgKind lChrAvgKind) {
        this.chrAvgKind = lChrAvgKind;
    }

    public LLab getLab() {
        return lab;
    }

    public Chrono lab(LLab lLab) {
        this.lab = lLab;
        return this;
    }

    public void setLab(LLab lLab) {
        this.lab = lLab;
    }

    public LErrorType getErrorType() {
        return errorType;
    }

    public Chrono errorType(LErrorType lErrorType) {
        this.errorType = lErrorType;
        return this;
    }

    public void setErrorType(LErrorType lErrorType) {
        this.errorType = lErrorType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Chrono)) {
            return false;
        }
        return id != null && id.equals(((Chrono) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Chrono{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", comment='" + getComment() + "'" +
            ", uploadIdx=" + getUploadIdx() +
            ", chronoAge=" + getChronoAge() +
            ", chronoAgeErrorLow=" + getChronoAgeErrorLow() +
            ", chronoAgeErrorHigh=" + getChronoAgeErrorHigh() +
            ", mswd=" + getMswd() +
            ", analysisCnt=" + getAnalysisCnt() +
            ", standardUsed='" + getStandardUsed() + "'" +
            "}";
    }
}
