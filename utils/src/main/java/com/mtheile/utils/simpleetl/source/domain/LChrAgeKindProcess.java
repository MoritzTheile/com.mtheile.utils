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
 * A LChrAgeKindProcess.
 */
@Entity
@Table(name = "l_chr_age_kind_process")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LChrAgeKindProcess extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "age_kind_process")
    private String ageKindProcess;

    @Lob
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "chrAgeKindProcess")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgeKindProcess() {
        return ageKindProcess;
    }

    public LChrAgeKindProcess ageKindProcess(String ageKindProcess) {
        this.ageKindProcess = ageKindProcess;
        return this;
    }

    public void setAgeKindProcess(String ageKindProcess) {
        this.ageKindProcess = ageKindProcess;
    }

    public String getDescription() {
        return description;
    }

    public LChrAgeKindProcess description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LChrAgeKindProcess chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LChrAgeKindProcess addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setChrAgeKindProcess(this);
        return this;
    }

    public LChrAgeKindProcess removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setChrAgeKindProcess(null);
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
        if (!(o instanceof LChrAgeKindProcess)) {
            return false;
        }
        return id != null && id.equals(((LChrAgeKindProcess) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LChrAgeKindProcess{" +
            "id=" + getId() +
            ", ageKindProcess='" + getAgeKindProcess() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
