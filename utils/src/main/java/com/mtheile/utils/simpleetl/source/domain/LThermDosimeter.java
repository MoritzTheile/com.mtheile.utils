package com.mtheile.utils.simpleetl.source.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * A LThermDosimeter.
 */
@Entity
@Table(name = "l_therm_dosimeter")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LThermDosimeter extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "dosimeter_glass_name")
    private String dosimeterGlassName;

    @Column(name = "u_ppm")
    private Float uPpm;

    @OneToMany(mappedBy = "thermDosimeter")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<FissionTrack> fissionTracks = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDosimeterGlassName() {
        return dosimeterGlassName;
    }

    public LThermDosimeter dosimeterGlassName(String dosimeterGlassName) {
        this.dosimeterGlassName = dosimeterGlassName;
        return this;
    }

    public void setDosimeterGlassName(String dosimeterGlassName) {
        this.dosimeterGlassName = dosimeterGlassName;
    }

    public Float getuPpm() {
        return uPpm;
    }

    public LThermDosimeter uPpm(Float uPpm) {
        this.uPpm = uPpm;
        return this;
    }

    public void setuPpm(Float uPpm) {
        this.uPpm = uPpm;
    }

    public Set<FissionTrack> getFissionTracks() {
        return fissionTracks;
    }

    public LThermDosimeter fissionTracks(Set<FissionTrack> fissionTracks) {
        this.fissionTracks = fissionTracks;
        return this;
    }

    public LThermDosimeter addFissionTrack(FissionTrack fissionTrack) {
        this.fissionTracks.add(fissionTrack);
        fissionTrack.setThermDosimeter(this);
        return this;
    }

    public LThermDosimeter removeFissionTrack(FissionTrack fissionTrack) {
        this.fissionTracks.remove(fissionTrack);
        fissionTrack.setThermDosimeter(null);
        return this;
    }

    public void setFissionTracks(Set<FissionTrack> fissionTracks) {
        this.fissionTracks = fissionTracks;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LThermDosimeter)) {
            return false;
        }
        return id != null && id.equals(((LThermDosimeter) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LThermDosimeter{" +
            "id=" + getId() +
            ", dosimeterGlassName='" + getDosimeterGlassName() + "'" +
            ", uPpm=" + getuPpm() +
            "}";
    }
}
