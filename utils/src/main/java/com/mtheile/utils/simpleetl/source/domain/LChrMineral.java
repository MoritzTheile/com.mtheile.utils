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
 * A LChrMineral.
 */
@Entity
@Table(name = "l_chr_mineral")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LChrMineral extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "mineral")
    private String mineral;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "jhi_synonym")
    private String synonym;

    @OneToMany(mappedBy = "chrMineral")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    @OneToMany(mappedBy = "mineral")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SingleGrainHe> singleGrainHes = new HashSet<>();

    @OneToMany(mappedBy = "mineral")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Helium> heliums = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMineral() {
        return mineral;
    }

    public LChrMineral mineral(String mineral) {
        this.mineral = mineral;
        return this;
    }

    public void setMineral(String mineral) {
        this.mineral = mineral;
    }

    public String getDescription() {
        return description;
    }

    public LChrMineral description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSynonym() {
        return synonym;
    }

    public LChrMineral synonym(String synonym) {
        this.synonym = synonym;
        return this;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LChrMineral chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LChrMineral addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setChrMineral(this);
        return this;
    }

    public LChrMineral removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setChrMineral(null);
        return this;
    }

    public void setChronos(Set<Chrono> chronos) {
        this.chronos = chronos;
    }

    public Set<SingleGrainHe> getSingleGrainHes() {
        return singleGrainHes;
    }

    public LChrMineral singleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
        return this;
    }

    public LChrMineral addSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.add(singleGrainHe);
        singleGrainHe.setMineral(this);
        return this;
    }

    public LChrMineral removeSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.remove(singleGrainHe);
        singleGrainHe.setMineral(null);
        return this;
    }

    public void setSingleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
    }

    public Set<Helium> getHeliums() {
        return heliums;
    }

    public LChrMineral heliums(Set<Helium> heliums) {
        this.heliums = heliums;
        return this;
    }

    public LChrMineral addHelium(Helium helium) {
        this.heliums.add(helium);
        helium.setMineral(this);
        return this;
    }

    public LChrMineral removeHelium(Helium helium) {
        this.heliums.remove(helium);
        helium.setMineral(null);
        return this;
    }

    public void setHeliums(Set<Helium> heliums) {
        this.heliums = heliums;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LChrMineral)) {
            return false;
        }
        return id != null && id.equals(((LChrMineral) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LChrMineral{" +
            "id=" + getId() +
            ", mineral='" + getMineral() + "'" +
            ", description='" + getDescription() + "'" +
            ", synonym='" + getSynonym() + "'" +
            "}";
    }
}
