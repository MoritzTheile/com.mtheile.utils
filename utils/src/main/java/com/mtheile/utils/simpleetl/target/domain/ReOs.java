package com.mtheile.utils.simpleetl.target.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import com.mtheile.utils.simpleetl.util.WithCustomId;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ReOs.
 */
@Entity
@Table(name = "re_os")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ReOs extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "re_ppm")
    private Float rePpm;

    @Column(name = "os_187_ppb")
    private Float os187ppb;

    @ManyToOne
    @JsonIgnoreProperties("reOs")
    private Chrono chrono;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getRePpm() {
        return rePpm;
    }

    public ReOs rePpm(Float rePpm) {
        this.rePpm = rePpm;
        return this;
    }

    public void setRePpm(Float rePpm) {
        this.rePpm = rePpm;
    }

    public Float getOs187ppb() {
        return os187ppb;
    }

    public ReOs os187ppb(Float os187ppb) {
        this.os187ppb = os187ppb;
        return this;
    }

    public void setOs187ppb(Float os187ppb) {
        this.os187ppb = os187ppb;
    }

    public Chrono getChrono() {
        return chrono;
    }

    public ReOs chrono(Chrono chrono) {
        this.chrono = chrono;
        return this;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReOs)) {
            return false;
        }
        return id != null && id.equals(((ReOs) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ReOs{" +
            "id=" + getId() +
            ", rePpm=" + getRePpm() +
            ", os187ppb=" + getOs187ppb() +
            "}";
    }
}
