package com.mtheile.utils.simpleetl.source.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import com.mtheile.utils.simpleetl.util.WithCustomId;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Sample.
 */
@Entity
@Table(name = "sample")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Sample extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @NotNull
    @Column(name = "sample_name", nullable = false)
    private String sampleName;

    @Column(name = "sample_type_idx")
    private Integer sampleTypeIdx;

    @Column(name = "qc_idx")
    private Integer qcIdx;

    @Column(name = "upload_idx")
    private Integer uploadIdx;

    @Column(name = "depth_min")
    private Float depthMin;

    @Column(name = "depth_max")
    private Float depthMax;

    @Column(name = "vertical_datum_idx")
    private Integer verticalDatumIdx;

    @Column(name = "min_age_ma")
    private Float minAgeMa;

    @Column(name = "max_age_ma")
    private Float maxAgeMa;

    @Column(name = "min_age_idx")
    private Integer minAgeIdx;

    @Column(name = "max_age_idx")
    private Integer maxAgeIdx;

    @Column(name = "lithology_type_idx")
    private Integer lithologyTypeIdx;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "formation_name")
    private String formationName;

    @Column(name = "elevation_auto")
    private Float elevationAuto;

    @Column(name = "elevation_source")
    private Float elevationSource;

    @Column(name = "lit_idx")
    private Integer litIdx;

    @Column(name = "present_day_temp")
    private Float presentDayTemp;

    @OneToMany(mappedBy = "sample")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Vitrinite> vitrinites = new HashSet<>();

    @OneToMany(mappedBy = "sample")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    @OneToMany(mappedBy = "sample")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ThermalHistory> thermalHistories = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "sample_entry",
               joinColumns = @JoinColumn(name = "sample_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "entry_id", referencedColumnName = "id"))
    private Set<Entry> entries = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("samples")
    private Location location;

    @ManyToOne
    @JsonIgnoreProperties("samples")
    private LLithologyType lithologyType;

    @ManyToOne
    @JsonIgnoreProperties("samples")
    private LSampleType sampleType;

    @ManyToOne
    @JsonIgnoreProperties("samples")
    private LVerticalDatum verticalDatum;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSampleName() {
        return sampleName;
    }

    public Sample sampleName(String sampleName) {
        this.sampleName = sampleName;
        return this;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public Integer getSampleTypeIdx() {
        return sampleTypeIdx;
    }

    public Sample sampleTypeIdx(Integer sampleTypeIdx) {
        this.sampleTypeIdx = sampleTypeIdx;
        return this;
    }

    public void setSampleTypeIdx(Integer sampleTypeIdx) {
        this.sampleTypeIdx = sampleTypeIdx;
    }

    public Integer getQcIdx() {
        return qcIdx;
    }

    public Sample qcIdx(Integer qcIdx) {
        this.qcIdx = qcIdx;
        return this;
    }

    public void setQcIdx(Integer qcIdx) {
        this.qcIdx = qcIdx;
    }

    public Integer getUploadIdx() {
        return uploadIdx;
    }

    public Sample uploadIdx(Integer uploadIdx) {
        this.uploadIdx = uploadIdx;
        return this;
    }

    public void setUploadIdx(Integer uploadIdx) {
        this.uploadIdx = uploadIdx;
    }

    public Float getDepthMin() {
        return depthMin;
    }

    public Sample depthMin(Float depthMin) {
        this.depthMin = depthMin;
        return this;
    }

    public void setDepthMin(Float depthMin) {
        this.depthMin = depthMin;
    }

    public Float getDepthMax() {
        return depthMax;
    }

    public Sample depthMax(Float depthMax) {
        this.depthMax = depthMax;
        return this;
    }

    public void setDepthMax(Float depthMax) {
        this.depthMax = depthMax;
    }

    public Integer getVerticalDatumIdx() {
        return verticalDatumIdx;
    }

    public Sample verticalDatumIdx(Integer verticalDatumIdx) {
        this.verticalDatumIdx = verticalDatumIdx;
        return this;
    }

    public void setVerticalDatumIdx(Integer verticalDatumIdx) {
        this.verticalDatumIdx = verticalDatumIdx;
    }

    public Float getMinAgeMa() {
        return minAgeMa;
    }

    public Sample minAgeMa(Float minAgeMa) {
        this.minAgeMa = minAgeMa;
        return this;
    }

    public void setMinAgeMa(Float minAgeMa) {
        this.minAgeMa = minAgeMa;
    }

    public Float getMaxAgeMa() {
        return maxAgeMa;
    }

    public Sample maxAgeMa(Float maxAgeMa) {
        this.maxAgeMa = maxAgeMa;
        return this;
    }

    public void setMaxAgeMa(Float maxAgeMa) {
        this.maxAgeMa = maxAgeMa;
    }

    public Integer getMinAgeIdx() {
        return minAgeIdx;
    }

    public Sample minAgeIdx(Integer minAgeIdx) {
        this.minAgeIdx = minAgeIdx;
        return this;
    }

    public void setMinAgeIdx(Integer minAgeIdx) {
        this.minAgeIdx = minAgeIdx;
    }

    public Integer getMaxAgeIdx() {
        return maxAgeIdx;
    }

    public Sample maxAgeIdx(Integer maxAgeIdx) {
        this.maxAgeIdx = maxAgeIdx;
        return this;
    }

    public void setMaxAgeIdx(Integer maxAgeIdx) {
        this.maxAgeIdx = maxAgeIdx;
    }

    public Integer getLithologyTypeIdx() {
        return lithologyTypeIdx;
    }

    public Sample lithologyTypeIdx(Integer lithologyTypeIdx) {
        this.lithologyTypeIdx = lithologyTypeIdx;
        return this;
    }

    public void setLithologyTypeIdx(Integer lithologyTypeIdx) {
        this.lithologyTypeIdx = lithologyTypeIdx;
    }

    public String getDescription() {
        return description;
    }

    public Sample description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormationName() {
        return formationName;
    }

    public Sample formationName(String formationName) {
        this.formationName = formationName;
        return this;
    }

    public void setFormationName(String formationName) {
        this.formationName = formationName;
    }

    public Float getElevationAuto() {
        return elevationAuto;
    }

    public Sample elevationAuto(Float elevationAuto) {
        this.elevationAuto = elevationAuto;
        return this;
    }

    public void setElevationAuto(Float elevationAuto) {
        this.elevationAuto = elevationAuto;
    }

    public Float getElevationSource() {
        return elevationSource;
    }

    public Sample elevationSource(Float elevationSource) {
        this.elevationSource = elevationSource;
        return this;
    }

    public void setElevationSource(Float elevationSource) {
        this.elevationSource = elevationSource;
    }

    public Integer getLitIdx() {
        return litIdx;
    }

    public Sample litIdx(Integer litIdx) {
        this.litIdx = litIdx;
        return this;
    }

    public void setLitIdx(Integer litIdx) {
        this.litIdx = litIdx;
    }

    public Float getPresentDayTemp() {
        return presentDayTemp;
    }

    public Sample presentDayTemp(Float presentDayTemp) {
        this.presentDayTemp = presentDayTemp;
        return this;
    }

    public void setPresentDayTemp(Float presentDayTemp) {
        this.presentDayTemp = presentDayTemp;
    }

    public Set<Vitrinite> getVitrinites() {
        return vitrinites;
    }

    public Sample vitrinites(Set<Vitrinite> vitrinites) {
        this.vitrinites = vitrinites;
        return this;
    }

    public Sample addVitrinite(Vitrinite vitrinite) {
        this.vitrinites.add(vitrinite);
        vitrinite.setSample(this);
        return this;
    }

    public Sample removeVitrinite(Vitrinite vitrinite) {
        this.vitrinites.remove(vitrinite);
        vitrinite.setSample(null);
        return this;
    }

    public void setVitrinites(Set<Vitrinite> vitrinites) {
        this.vitrinites = vitrinites;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public Sample chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public Sample addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setSample(this);
        return this;
    }

    public Sample removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setSample(null);
        return this;
    }

    public void setChronos(Set<Chrono> chronos) {
        this.chronos = chronos;
    }

    public Set<ThermalHistory> getThermalHistories() {
        return thermalHistories;
    }

    public Sample thermalHistories(Set<ThermalHistory> thermalHistories) {
        this.thermalHistories = thermalHistories;
        return this;
    }

    public Sample addThermalHistory(ThermalHistory thermalHistory) {
        this.thermalHistories.add(thermalHistory);
        thermalHistory.setSample(this);
        return this;
    }

    public Sample removeThermalHistory(ThermalHistory thermalHistory) {
        this.thermalHistories.remove(thermalHistory);
        thermalHistory.setSample(null);
        return this;
    }

    public void setThermalHistories(Set<ThermalHistory> thermalHistories) {
        this.thermalHistories = thermalHistories;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public Sample entries(Set<Entry> entries) {
        this.entries = entries;
        return this;
    }

    public Sample addEntry(Entry entry) {
        this.entries.add(entry);
        entry.getSamples().add(this);
        return this;
    }

    public Sample removeEntry(Entry entry) {
        this.entries.remove(entry);
        entry.getSamples().remove(this);
        return this;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }

    public Location getLocation() {
        return location;
    }

    public Sample location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LLithologyType getLithologyType() {
        return lithologyType;
    }

    public Sample lithologyType(LLithologyType lLithologyType) {
        this.lithologyType = lLithologyType;
        return this;
    }

    public void setLithologyType(LLithologyType lLithologyType) {
        this.lithologyType = lLithologyType;
    }

    public LSampleType getSampleType() {
        return sampleType;
    }

    public Sample sampleType(LSampleType lSampleType) {
        this.sampleType = lSampleType;
        return this;
    }

    public void setSampleType(LSampleType lSampleType) {
        this.sampleType = lSampleType;
    }

    public LVerticalDatum getVerticalDatum() {
        return verticalDatum;
    }

    public Sample verticalDatum(LVerticalDatum lVerticalDatum) {
        this.verticalDatum = lVerticalDatum;
        return this;
    }

    public void setVerticalDatum(LVerticalDatum lVerticalDatum) {
        this.verticalDatum = lVerticalDatum;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sample)) {
            return false;
        }
        return id != null && id.equals(((Sample) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Sample{" +
            "id=" + getId() +
            ", sampleName='" + getSampleName() + "'" +
            ", sampleTypeIdx=" + getSampleTypeIdx() +
            ", qcIdx=" + getQcIdx() +
            ", uploadIdx=" + getUploadIdx() +
            ", depthMin=" + getDepthMin() +
            ", depthMax=" + getDepthMax() +
            ", verticalDatumIdx=" + getVerticalDatumIdx() +
            ", minAgeMa=" + getMinAgeMa() +
            ", maxAgeMa=" + getMaxAgeMa() +
            ", minAgeIdx=" + getMinAgeIdx() +
            ", maxAgeIdx=" + getMaxAgeIdx() +
            ", lithologyTypeIdx=" + getLithologyTypeIdx() +
            ", description='" + getDescription() + "'" +
            ", formationName='" + getFormationName() + "'" +
            ", elevationAuto=" + getElevationAuto() +
            ", elevationSource=" + getElevationSource() +
            ", litIdx=" + getLitIdx() +
            ", presentDayTemp=" + getPresentDayTemp() +
            "}";
    }
}
