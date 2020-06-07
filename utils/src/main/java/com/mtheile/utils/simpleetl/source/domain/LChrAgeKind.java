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
 * A LChrAgeKind.
 */
@Entity
@Table(name = "l_chr_age_kind")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LChrAgeKind extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "age_kind")
    private String ageKind;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "chrAgeKind")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgeKind() {
        return ageKind;
    }

    public LChrAgeKind ageKind(String ageKind) {
        this.ageKind = ageKind;
        return this;
    }

    public void setAgeKind(String ageKind) {
        this.ageKind = ageKind;
    }

    public String getDescription() {
        return description;
    }

    public LChrAgeKind description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LChrAgeKind chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LChrAgeKind addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setChrAgeKind(this);
        return this;
    }

    public LChrAgeKind removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setChrAgeKind(null);
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
        if (!(o instanceof LChrAgeKind)) {
            return false;
        }
        return id != null && id.equals(((LChrAgeKind) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LChrAgeKind{" +
            "id=" + getId() +
            ", ageKind='" + getAgeKind() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
