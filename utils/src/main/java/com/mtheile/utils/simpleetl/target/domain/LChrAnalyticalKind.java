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
 * A LChrAnalyticalKind.
 */
@Entity
@Table(name = "l_chr_analytical_kind")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LChrAnalyticalKind extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "analytical_kind")
    private String analyticalKind;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "chrAnalyticalKind")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    @OneToMany(mappedBy = "analyticalKind")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Helium> heliums = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnalyticalKind() {
        return analyticalKind;
    }

    public LChrAnalyticalKind analyticalKind(String analyticalKind) {
        this.analyticalKind = analyticalKind;
        return this;
    }

    public void setAnalyticalKind(String analyticalKind) {
        this.analyticalKind = analyticalKind;
    }

    public String getDescription() {
        return description;
    }

    public LChrAnalyticalKind description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LChrAnalyticalKind chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LChrAnalyticalKind addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setChrAnalyticalKind(this);
        return this;
    }

    public LChrAnalyticalKind removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setChrAnalyticalKind(null);
        return this;
    }

    public void setChronos(Set<Chrono> chronos) {
        this.chronos = chronos;
    }

    public Set<Helium> getHeliums() {
        return heliums;
    }

    public LChrAnalyticalKind heliums(Set<Helium> heliums) {
        this.heliums = heliums;
        return this;
    }

    public LChrAnalyticalKind addHelium(Helium helium) {
        this.heliums.add(helium);
        helium.setAnalyticalKind(this);
        return this;
    }

    public LChrAnalyticalKind removeHelium(Helium helium) {
        this.heliums.remove(helium);
        helium.setAnalyticalKind(null);
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
        if (!(o instanceof LChrAnalyticalKind)) {
            return false;
        }
        return id != null && id.equals(((LChrAnalyticalKind) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LChrAnalyticalKind{" +
            "id=" + getId() +
            ", analyticalKind='" + getAnalyticalKind() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
