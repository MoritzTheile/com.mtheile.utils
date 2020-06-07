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
 * A LChrAnalyticalSystem.
 */
@Entity
@Table(name = "l_chr_analytical_system")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LChrAnalyticalSystem extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "analytical_system")
    private String analyticalSystem;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "chrAnalyticalSystem")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnalyticalSystem() {
        return analyticalSystem;
    }

    public LChrAnalyticalSystem analyticalSystem(String analyticalSystem) {
        this.analyticalSystem = analyticalSystem;
        return this;
    }

    public void setAnalyticalSystem(String analyticalSystem) {
        this.analyticalSystem = analyticalSystem;
    }

    public String getDescription() {
        return description;
    }

    public LChrAnalyticalSystem description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LChrAnalyticalSystem chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LChrAnalyticalSystem addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setChrAnalyticalSystem(this);
        return this;
    }

    public LChrAnalyticalSystem removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setChrAnalyticalSystem(null);
        return this;
    }

    public void setChronos(Set<Chrono> chronos) {
        this.chronos = chronos;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LChrAnalyticalSystem)) {
            return false;
        }
        return id != null && id.equals(((LChrAnalyticalSystem) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LChrAnalyticalSystem{" +
            "id=" + getId() +
            ", analyticalSystem='" + getAnalyticalSystem() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
