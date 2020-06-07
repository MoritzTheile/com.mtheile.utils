package com.mtheile.utils.simpleetl.target.domain;


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
 * A LThermEtch.
 */
@Entity
@Table(name = "l_therm_etch")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LThermEtch extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "etchant")
    private String etchant;

    @Column(name = "strength_molar")
    private Float strengthMolar;

    @Column(name = "strength_percent")
    private Float strengthPercent;

    @OneToMany(mappedBy = "thermEtch")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<FissionTrack> fissionTracks = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtchant() {
        return etchant;
    }

    public LThermEtch etchant(String etchant) {
        this.etchant = etchant;
        return this;
    }

    public void setEtchant(String etchant) {
        this.etchant = etchant;
    }

    public Float getStrengthMolar() {
        return strengthMolar;
    }

    public LThermEtch strengthMolar(Float strengthMolar) {
        this.strengthMolar = strengthMolar;
        return this;
    }

    public void setStrengthMolar(Float strengthMolar) {
        this.strengthMolar = strengthMolar;
    }

    public Float getStrengthPercent() {
        return strengthPercent;
    }

    public LThermEtch strengthPercent(Float strengthPercent) {
        this.strengthPercent = strengthPercent;
        return this;
    }

    public void setStrengthPercent(Float strengthPercent) {
        this.strengthPercent = strengthPercent;
    }

    public Set<FissionTrack> getFissionTracks() {
        return fissionTracks;
    }

    public LThermEtch fissionTracks(Set<FissionTrack> fissionTracks) {
        this.fissionTracks = fissionTracks;
        return this;
    }

    public LThermEtch addFissionTrack(FissionTrack fissionTrack) {
        this.fissionTracks.add(fissionTrack);
        fissionTrack.setThermEtch(this);
        return this;
    }

    public LThermEtch removeFissionTrack(FissionTrack fissionTrack) {
        this.fissionTracks.remove(fissionTrack);
        fissionTrack.setThermEtch(null);
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
        if (!(o instanceof LThermEtch)) {
            return false;
        }
        return id != null && id.equals(((LThermEtch) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LThermEtch{" +
            "id=" + getId() +
            ", etchant='" + getEtchant() + "'" +
            ", strengthMolar=" + getStrengthMolar() +
            ", strengthPercent=" + getStrengthPercent() +
            "}";
    }
}
