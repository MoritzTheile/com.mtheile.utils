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
 * A LChrThMod.
 */
@Entity
@Table(name = "l_chr_th_mod")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LChrThMod extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "author")
    private String author;

    @Column(name = "jhi_year")
    private Float year;

    @OneToMany(mappedBy = "chrThMod")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Chrono> chronos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public LChrThMod model(String model) {
        this.model = model;
        return this;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAuthor() {
        return author;
    }

    public LChrThMod author(String author) {
        this.author = author;
        return this;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getYear() {
        return year;
    }

    public LChrThMod year(Float year) {
        this.year = year;
        return this;
    }

    public void setYear(Float year) {
        this.year = year;
    }

    public Set<Chrono> getChronos() {
        return chronos;
    }

    public LChrThMod chronos(Set<Chrono> chronos) {
        this.chronos = chronos;
        return this;
    }

    public LChrThMod addChrono(Chrono chrono) {
        this.chronos.add(chrono);
        chrono.setChrThMod(this);
        return this;
    }

    public LChrThMod removeChrono(Chrono chrono) {
        this.chronos.remove(chrono);
        chrono.setChrThMod(null);
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
        if (!(o instanceof LChrThMod)) {
            return false;
        }
        return id != null && id.equals(((LChrThMod) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LChrThMod{" +
            "id=" + getId() +
            ", model='" + getModel() + "'" +
            ", author='" + getAuthor() + "'" +
            ", year=" + getYear() +
            "}";
    }
}
