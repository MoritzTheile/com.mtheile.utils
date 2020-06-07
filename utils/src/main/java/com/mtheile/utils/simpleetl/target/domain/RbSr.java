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
 * A RbSr.
 */
@Entity
@Table(name = "rb_sr")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RbSr extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "m_87_sr_86_sr")
    private Float m87SR86SR;

    @Column(name = "m_uncert")
    private Float mUncert;

    @Column(name = "i_87_sr_86_sr")
    private Float i87SR86SR;

    @Column(name = "i_uncert")
    private Float iUncert;

    @ManyToOne
    @JsonIgnoreProperties("rbSrs")
    private Chrono chrono;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getm87SR86SR() {
        return m87SR86SR;
    }

    public RbSr m87SR86SR(Float m87SR86SR) {
        this.m87SR86SR = m87SR86SR;
        return this;
    }

    public void setm87SR86SR(Float m87SR86SR) {
        this.m87SR86SR = m87SR86SR;
    }

    public Float getmUncert() {
        return mUncert;
    }

    public RbSr mUncert(Float mUncert) {
        this.mUncert = mUncert;
        return this;
    }

    public void setmUncert(Float mUncert) {
        this.mUncert = mUncert;
    }

    public Float geti87SR86SR() {
        return i87SR86SR;
    }

    public RbSr i87SR86SR(Float i87SR86SR) {
        this.i87SR86SR = i87SR86SR;
        return this;
    }

    public void seti87SR86SR(Float i87SR86SR) {
        this.i87SR86SR = i87SR86SR;
    }

    public Float getiUncert() {
        return iUncert;
    }

    public RbSr iUncert(Float iUncert) {
        this.iUncert = iUncert;
        return this;
    }

    public void setiUncert(Float iUncert) {
        this.iUncert = iUncert;
    }

    public Chrono getChrono() {
        return chrono;
    }

    public RbSr chrono(Chrono chrono) {
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
        if (!(o instanceof RbSr)) {
            return false;
        }
        return id != null && id.equals(((RbSr) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "RbSr{" +
            "id=" + getId() +
            ", m87SR86SR=" + getm87SR86SR() +
            ", mUncert=" + getmUncert() +
            ", i87SR86SR=" + geti87SR86SR() +
            ", iUncert=" + getiUncert() +
            "}";
    }
}
