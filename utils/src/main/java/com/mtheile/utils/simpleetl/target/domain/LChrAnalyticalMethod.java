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
 * A LChrAnalyticalMethod.
 */
@Entity
@Table(name = "l_chr_analytical_method")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LChrAnalyticalMethod extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "analytical_method")
    private String analyticalMethod;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "chrAnalyticalMethod")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    @OneToMany(mappedBy = "analyticalMethod")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Helium> heliums = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnalyticalMethod() {
        return analyticalMethod;
    }

    public LChrAnalyticalMethod analyticalMethod(String analyticalMethod) {
        this.analyticalMethod = analyticalMethod;
        return this;
    }

    public void setAnalyticalMethod(String analyticalMethod) {
        this.analyticalMethod = analyticalMethod;
    }

    public String getDescription() {
        return description;
    }

    public LChrAnalyticalMethod description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LChrAnalyticalMethod chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LChrAnalyticalMethod addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setChrAnalyticalMethod(this);
        return this;
    }

    public LChrAnalyticalMethod removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setChrAnalyticalMethod(null);
        return this;
    }

    public void setChronos(Set<Chrono> chronos) {
        this.chronos = chronos;
    }

    public Set<Helium> getHeliums() {
        return heliums;
    }

    public LChrAnalyticalMethod heliums(Set<Helium> heliums) {
        this.heliums = heliums;
        return this;
    }

    public LChrAnalyticalMethod addHelium(Helium helium) {
        this.heliums.add(helium);
        helium.setAnalyticalMethod(this);
        return this;
    }

    public LChrAnalyticalMethod removeHelium(Helium helium) {
        this.heliums.remove(helium);
        helium.setAnalyticalMethod(null);
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
        if (!(o instanceof LChrAnalyticalMethod)) {
            return false;
        }
        return id != null && id.equals(((LChrAnalyticalMethod) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LChrAnalyticalMethod{" +
            "id=" + getId() +
            ", analyticalMethod='" + getAnalyticalMethod() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
