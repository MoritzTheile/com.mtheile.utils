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
 * A LChrAvgKind.
 */
@Entity
@Table(name = "l_chr_avg_kind")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LChrAvgKind extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "average_method")
    private String averageMethod;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "chrAvgKind")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    @OneToMany(mappedBy = "averageKind")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Helium> heliums = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAverageMethod() {
        return averageMethod;
    }

    public LChrAvgKind averageMethod(String averageMethod) {
        this.averageMethod = averageMethod;
        return this;
    }

    public void setAverageMethod(String averageMethod) {
        this.averageMethod = averageMethod;
    }

    public String getDescription() {
        return description;
    }

    public LChrAvgKind description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LChrAvgKind chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LChrAvgKind addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setChrAvgKind(this);
        return this;
    }

    public LChrAvgKind removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setChrAvgKind(null);
        return this;
    }

    public void setChronos(Set<Chrono> chronos) {
        this.chronos = chronos;
    }

    public Set<Helium> getHeliums() {
        return heliums;
    }

    public LChrAvgKind heliums(Set<Helium> heliums) {
        this.heliums = heliums;
        return this;
    }

    public LChrAvgKind addHelium(Helium helium) {
        this.heliums.add(helium);
        helium.setAverageKind(this);
        return this;
    }

    public LChrAvgKind removeHelium(Helium helium) {
        this.heliums.remove(helium);
        helium.setAverageKind(null);
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
        if (!(o instanceof LChrAvgKind)) {
            return false;
        }
        return id != null && id.equals(((LChrAvgKind) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LChrAvgKind{" +
            "id=" + getId() +
            ", averageMethod='" + getAverageMethod() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
