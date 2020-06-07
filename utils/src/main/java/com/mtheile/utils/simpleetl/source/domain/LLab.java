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
 * A LLab.
 */
@Entity
@Table(name = "l_lab")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LLab extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "lab_name")
    private String labName;

    @Column(name = "institute")
    private String institute;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "lab")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Vitrinite> vitrinites = new HashSet<>();

    @OneToMany(mappedBy = "lab")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    @OneToMany(mappedBy = "lab")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SingleGrainHe> singleGrainHes = new HashSet<>();

    @OneToMany(mappedBy = "lab")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Helium> heliums = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabName() {
        return labName;
    }

    public LLab labName(String labName) {
        this.labName = labName;
        return this;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getInstitute() {
        return institute;
    }

    public LLab institute(String institute) {
        this.institute = institute;
        return this;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getCity() {
        return city;
    }

    public LLab city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public LLab country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Vitrinite> getVitrinites() {
        return vitrinites;
    }

    public LLab vitrinites(Set<Vitrinite> vitrinites) {
        this.vitrinites = vitrinites;
        return this;
    }

    public LLab addVitrinite(Vitrinite vitrinite) {
        this.vitrinites.add(vitrinite);
        vitrinite.setLab(this);
        return this;
    }

    public LLab removeVitrinite(Vitrinite vitrinite) {
        this.vitrinites.remove(vitrinite);
        vitrinite.setLab(null);
        return this;
    }

    public void setVitrinites(Set<Vitrinite> vitrinites) {
        this.vitrinites = vitrinites;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LLab chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LLab addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setLab(this);
        return this;
    }

    public LLab removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setLab(null);
        return this;
    }

    public void setChronos(Set<Chrono> chronos) {
        this.chronos = chronos;
    }

    public Set<SingleGrainHe> getSingleGrainHes() {
        return singleGrainHes;
    }

    public LLab singleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
        return this;
    }

    public LLab addSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.add(singleGrainHe);
        singleGrainHe.setLab(this);
        return this;
    }

    public LLab removeSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.remove(singleGrainHe);
        singleGrainHe.setLab(null);
        return this;
    }

    public void setSingleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
    }

    public Set<Helium> getHeliums() {
        return heliums;
    }

    public LLab heliums(Set<Helium> heliums) {
        this.heliums = heliums;
        return this;
    }

    public LLab addHelium(Helium helium) {
        this.heliums.add(helium);
        helium.setLab(this);
        return this;
    }

    public LLab removeHelium(Helium helium) {
        this.heliums.remove(helium);
        helium.setLab(null);
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
        if (!(o instanceof LLab)) {
            return false;
        }
        return id != null && id.equals(((LLab) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LLab{" +
            "id=" + getId() +
            ", labName='" + getLabName() + "'" +
            ", institute='" + getInstitute() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
}
