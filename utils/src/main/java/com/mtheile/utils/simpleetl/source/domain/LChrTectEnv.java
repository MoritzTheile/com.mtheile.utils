package com.mtheile.utils.simpleetl.source.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import com.mtheile.utils.simpleetl.util.WithCustomId;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A LChrTectEnv.
 */
@Entity
@Table(name = "l_chr_tect_env")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LChrTectEnv extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "tect_env")
    private String tectEnv;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTectEnv() {
        return tectEnv;
    }

    public LChrTectEnv tectEnv(String tectEnv) {
        this.tectEnv = tectEnv;
        return this;
    }

    public void setTectEnv(String tectEnv) {
        this.tectEnv = tectEnv;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LChrTectEnv)) {
            return false;
        }
        return id != null && id.equals(((LChrTectEnv) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LChrTectEnv{" +
            "id=" + getId() +
            ", tectEnv='" + getTectEnv() + "'" +
            "}";
    }
}
