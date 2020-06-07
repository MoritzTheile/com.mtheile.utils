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
 * A Location.
 */
@Entity
@Table(name = "location")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Location extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "lat")
    private Float lat;

    @Column(name = "lon")
    private Float lon;

    @Column(name = "precision_m")
    private Integer precisionM;

    @Column(name = "upload_idx")
    private Integer uploadIdx;

    @Column(name = "qc_idx")
    private Integer qcIdx;

    @NotNull
    @Column(name = "loc_name", nullable = false)
    private String locName;

    @Lob
    @Column(name = "jhi_comment")
    private String comment;

    @Column(name = "location_group_idx")
    private Integer locationGroupIdx;

    @OneToMany(mappedBy = "location")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<LocationProperty> locationProperties = new HashSet<>();

    @OneToMany(mappedBy = "location")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Sample> samples = new HashSet<>();

    @OneToMany(mappedBy = "location")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ThermalHistory> thermalHistories = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("locations")
    private LLocCapture locCapture;

    @ManyToOne
    @JsonIgnoreProperties("locations")
    private LLocKind lockKind;

    @ManyToOne
    @JsonIgnoreProperties("locations")
    private LLocPredefined locPredefined;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLat() {
        return lat;
    }

    public Location lat(Float lat) {
        this.lat = lat;
        return this;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public Location lon(Float lon) {
        this.lon = lon;
        return this;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Integer getPrecisionM() {
        return precisionM;
    }

    public Location precisionM(Integer precisionM) {
        this.precisionM = precisionM;
        return this;
    }

    public void setPrecisionM(Integer precisionM) {
        this.precisionM = precisionM;
    }

    public Integer getUploadIdx() {
        return uploadIdx;
    }

    public Location uploadIdx(Integer uploadIdx) {
        this.uploadIdx = uploadIdx;
        return this;
    }

    public void setUploadIdx(Integer uploadIdx) {
        this.uploadIdx = uploadIdx;
    }

    public Integer getQcIdx() {
        return qcIdx;
    }

    public Location qcIdx(Integer qcIdx) {
        this.qcIdx = qcIdx;
        return this;
    }

    public void setQcIdx(Integer qcIdx) {
        this.qcIdx = qcIdx;
    }

    public String getLocName() {
        return locName;
    }

    public Location locName(String locName) {
        this.locName = locName;
        return this;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getComment() {
        return comment;
    }

    public Location comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLocationGroupIdx() {
        return locationGroupIdx;
    }

    public Location locationGroupIdx(Integer locationGroupIdx) {
        this.locationGroupIdx = locationGroupIdx;
        return this;
    }

    public void setLocationGroupIdx(Integer locationGroupIdx) {
        this.locationGroupIdx = locationGroupIdx;
    }

    public Set<LocationProperty> getLocationProperties() {
        return locationProperties;
    }

    public Location locationProperties(Set<LocationProperty> locationProperties) {
        this.locationProperties = locationProperties;
        return this;
    }

    public Location addLocationProperty(LocationProperty locationProperty) {
        this.locationProperties.add(locationProperty);
        locationProperty.setLocation(this);
        return this;
    }

    public Location removeLocationProperty(LocationProperty locationProperty) {
        this.locationProperties.remove(locationProperty);
        locationProperty.setLocation(null);
        return this;
    }

    public void setLocationProperties(Set<LocationProperty> locationProperties) {
        this.locationProperties = locationProperties;
    }

    public Set<Sample> getSamples() {
        return samples;
    }

    public Location samples(Set<Sample> samples) {
        this.samples = samples;
        return this;
    }

    public Location addSample(Sample sample) {
        this.samples.add(sample);
        sample.setLocation(this);
        return this;
    }

    public Location removeSample(Sample sample) {
        this.samples.remove(sample);
        sample.setLocation(null);
        return this;
    }

    public void setSamples(Set<Sample> samples) {
        this.samples = samples;
    }

    public Set<ThermalHistory> getThermalHistories() {
        return thermalHistories;
    }

    public Location thermalHistories(Set<ThermalHistory> thermalHistories) {
        this.thermalHistories = thermalHistories;
        return this;
    }

    public Location addThermalHistory(ThermalHistory thermalHistory) {
        this.thermalHistories.add(thermalHistory);
        thermalHistory.setLocation(this);
        return this;
    }

    public Location removeThermalHistory(ThermalHistory thermalHistory) {
        this.thermalHistories.remove(thermalHistory);
        thermalHistory.setLocation(null);
        return this;
    }

    public void setThermalHistories(Set<ThermalHistory> thermalHistories) {
        this.thermalHistories = thermalHistories;
    }

    public LLocCapture getLocCapture() {
        return locCapture;
    }

    public Location locCapture(LLocCapture lLocCapture) {
        this.locCapture = lLocCapture;
        return this;
    }

    public void setLocCapture(LLocCapture lLocCapture) {
        this.locCapture = lLocCapture;
    }

    public LLocKind getLockKind() {
        return lockKind;
    }

    public Location lockKind(LLocKind lLocKind) {
        this.lockKind = lLocKind;
        return this;
    }

    public void setLockKind(LLocKind lLocKind) {
        this.lockKind = lLocKind;
    }

    public LLocPredefined getLocPredefined() {
        return locPredefined;
    }

    public Location locPredefined(LLocPredefined lLocPredefined) {
        this.locPredefined = lLocPredefined;
        return this;
    }

    public void setLocPredefined(LLocPredefined lLocPredefined) {
        this.locPredefined = lLocPredefined;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Location)) {
            return false;
        }
        return id != null && id.equals(((Location) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Location{" +
            "id=" + getId() +
            ", lat=" + getLat() +
            ", lon=" + getLon() +
            ", precisionM=" + getPrecisionM() +
            ", uploadIdx=" + getUploadIdx() +
            ", qcIdx=" + getQcIdx() +
            ", locName='" + getLocName() + "'" +
            ", comment='" + getComment() + "'" +
            ", locationGroupIdx=" + getLocationGroupIdx() +
            "}";
    }
}
