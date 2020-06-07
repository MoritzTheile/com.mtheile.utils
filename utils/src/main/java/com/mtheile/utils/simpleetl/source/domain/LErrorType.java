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
 * A LErrorType.
 */
@Entity
@Table(name = "l_error_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LErrorType extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "error_type")
    private String errorType;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "errorType")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    @OneToMany(mappedBy = "errorType")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SingleGrainHe> singleGrainHes = new HashSet<>();

    @OneToMany(mappedBy = "errorType")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Helium> heliums = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getErrorType() {
        return errorType;
    }

    public LErrorType errorType(String errorType) {
        this.errorType = errorType;
        return this;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getDescription() {
        return description;
    }

    public LErrorType description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LErrorType chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LErrorType addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setErrorType(this);
        return this;
    }

    public LErrorType removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setErrorType(null);
        return this;
    }

    public void setChronos(Set<Chrono> chronos) {
        this.chronos = chronos;
    }

    public Set<SingleGrainHe> getSingleGrainHes() {
        return singleGrainHes;
    }

    public LErrorType singleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
        return this;
    }

    public LErrorType addSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.add(singleGrainHe);
        singleGrainHe.setErrorType(this);
        return this;
    }

    public LErrorType removeSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.remove(singleGrainHe);
        singleGrainHe.setErrorType(null);
        return this;
    }

    public void setSingleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
    }

    public Set<Helium> getHeliums() {
        return heliums;
    }

    public LErrorType heliums(Set<Helium> heliums) {
        this.heliums = heliums;
        return this;
    }

    public LErrorType addHelium(Helium helium) {
        this.heliums.add(helium);
        helium.setErrorType(this);
        return this;
    }

    public LErrorType removeHelium(Helium helium) {
        this.heliums.remove(helium);
        helium.setErrorType(null);
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
        if (!(o instanceof LErrorType)) {
            return false;
        }
        return id != null && id.equals(((LErrorType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LErrorType{" +
            "id=" + getId() +
            ", errorType='" + getErrorType() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
