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
 * A LThermDiffusion.
 */
@Entity
@Table(name = "l_therm_diffusion")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LThermDiffusion extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "diffusion_mod_name")
    private String diffusionModName;

    @Column(name = "diffusion_mod_author")
    private String diffusionModAuthor;

    @Column(name = "jhi_year")
    private Integer year;

    @OneToMany(mappedBy = "diffusionMod")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SingleGrainHe> singleGrainHes = new HashSet<>();

    @OneToMany(mappedBy = "diffusionMod")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Helium> heliums = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiffusionModName() {
        return diffusionModName;
    }

    public LThermDiffusion diffusionModName(String diffusionModName) {
        this.diffusionModName = diffusionModName;
        return this;
    }

    public void setDiffusionModName(String diffusionModName) {
        this.diffusionModName = diffusionModName;
    }

    public String getDiffusionModAuthor() {
        return diffusionModAuthor;
    }

    public LThermDiffusion diffusionModAuthor(String diffusionModAuthor) {
        this.diffusionModAuthor = diffusionModAuthor;
        return this;
    }

    public void setDiffusionModAuthor(String diffusionModAuthor) {
        this.diffusionModAuthor = diffusionModAuthor;
    }

    public Integer getYear() {
        return year;
    }

    public LThermDiffusion year(Integer year) {
        this.year = year;
        return this;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Set<SingleGrainHe> getSingleGrainHes() {
        return singleGrainHes;
    }

    public LThermDiffusion singleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
        return this;
    }

    public LThermDiffusion addSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.add(singleGrainHe);
        singleGrainHe.setDiffusionMod(this);
        return this;
    }

    public LThermDiffusion removeSingleGrainHe(SingleGrainHe singleGrainHe) {
        this.singleGrainHes.remove(singleGrainHe);
        singleGrainHe.setDiffusionMod(null);
        return this;
    }

    public void setSingleGrainHes(Set<SingleGrainHe> singleGrainHes) {
        this.singleGrainHes = singleGrainHes;
    }

    public Set<Helium> getHeliums() {
        return heliums;
    }

    public LThermDiffusion heliums(Set<Helium> heliums) {
        this.heliums = heliums;
        return this;
    }

    public LThermDiffusion addHelium(Helium helium) {
        this.heliums.add(helium);
        helium.setDiffusionMod(this);
        return this;
    }

    public LThermDiffusion removeHelium(Helium helium) {
        this.heliums.remove(helium);
        helium.setDiffusionMod(null);
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
        if (!(o instanceof LThermDiffusion)) {
            return false;
        }
        return id != null && id.equals(((LThermDiffusion) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LThermDiffusion{" +
            "id=" + getId() +
            ", diffusionModName='" + getDiffusionModName() + "'" +
            ", diffusionModAuthor='" + getDiffusionModAuthor() + "'" +
            ", year=" + getYear() +
            "}";
    }
}
