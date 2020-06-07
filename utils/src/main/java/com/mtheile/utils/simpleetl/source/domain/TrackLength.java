package com.mtheile.utils.simpleetl.source.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import com.mtheile.utils.simpleetl.util.WithCustomId;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A TrackLength.
 */
@Entity
@Table(name = "track_length")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TrackLength extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "track_length")
    private Float trackLength;

    @Column(name = "track_length_err")
    private Float trackLengthErr;

    @Column(name = "c_axis_ang")
    private Float cAxisAng;

    @Column(name = "i_0_x_2")
    private Float i0x2;

    @Column(name = "i_2_x_4")
    private Float i2x4;

    @Column(name = "i_4_x_6")
    private Float i4x6;

    @Column(name = "i_6_x_8")
    private Float i6x8;

    @Column(name = "i_8_x_10")
    private Float i8x10;

    @Column(name = "i_10_x_12")
    private Float i10x12;

    @Column(name = "i_12_x_14")
    private Float i12x14;

    @Column(name = "i_14_x_16")
    private Float i14x16;

    @Column(name = "i_16_x_18")
    private Float i16x18;

    @Column(name = "i_1_x_2")
    private Float i1x2;

    @Column(name = "i_2_x_3")
    private Float i2x3;

    @Column(name = "i_3_x_4")
    private Float i3x4;

    @Column(name = "i_4_x_5")
    private Float i4x5;

    @Column(name = "i_5_x_6")
    private Float i5x6;

    @Column(name = "i_6_x_7")
    private Float i6x7;

    @Column(name = "i_7_x_8")
    private Float i7x8;

    @Column(name = "i_8_x_9")
    private Float i8x9;

    @Column(name = "i_9_x_10")
    private Float i9x10;

    @Column(name = "i_10_x_11")
    private Float i10x11;

    @Column(name = "i_11_x_12")
    private Float i11x12;

    @Column(name = "i_12_x_13")
    private Float i12x13;

    @Column(name = "i_13_x_14")
    private Float i13x14;

    @Column(name = "i_14_x_15")
    private Float i14x15;

    @Column(name = "i_15_x_16")
    private Float i15x16;

    @Column(name = "i_16_x_17")
    private Float i16x17;

    @Column(name = "i_17_x_18")
    private Float i17x18;

    @Column(name = "i_18_x_19")
    private Float i18x19;

    @Column(name = "i_18_x_20")
    private Float i18x20;

    @Column(name = "i_19_x_20")
    private Float i19x20;

    @Column(name = "i_0_x_1")
    private Float i0x1;

    @Column(name = "corr_track_length")
    private Float corrTrackLength;

    @Column(name = "dpar")
    private Float dpar;

    @Column(name = "dper")
    private Float dper;

    @Column(name = "kurtosis_percent")
    private Float kurtosisPercent;

    @Column(name = "skewness_percent")
    private Float skewnessPercent;

    @ManyToOne
    @JsonIgnoreProperties("trackLengths")
    private Chrono chrono;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTrackLength() {
        return trackLength;
    }

    public TrackLength trackLength(Float trackLength) {
        this.trackLength = trackLength;
        return this;
    }

    public void setTrackLength(Float trackLength) {
        this.trackLength = trackLength;
    }

    public Float getTrackLengthErr() {
        return trackLengthErr;
    }

    public TrackLength trackLengthErr(Float trackLengthErr) {
        this.trackLengthErr = trackLengthErr;
        return this;
    }

    public void setTrackLengthErr(Float trackLengthErr) {
        this.trackLengthErr = trackLengthErr;
    }

    public Float getcAxisAng() {
        return cAxisAng;
    }

    public TrackLength cAxisAng(Float cAxisAng) {
        this.cAxisAng = cAxisAng;
        return this;
    }

    public void setcAxisAng(Float cAxisAng) {
        this.cAxisAng = cAxisAng;
    }

    public Float geti0x2() {
        return i0x2;
    }

    public TrackLength i0x2(Float i0x2) {
        this.i0x2 = i0x2;
        return this;
    }

    public void seti0x2(Float i0x2) {
        this.i0x2 = i0x2;
    }

    public Float geti2x4() {
        return i2x4;
    }

    public TrackLength i2x4(Float i2x4) {
        this.i2x4 = i2x4;
        return this;
    }

    public void seti2x4(Float i2x4) {
        this.i2x4 = i2x4;
    }

    public Float geti4x6() {
        return i4x6;
    }

    public TrackLength i4x6(Float i4x6) {
        this.i4x6 = i4x6;
        return this;
    }

    public void seti4x6(Float i4x6) {
        this.i4x6 = i4x6;
    }

    public Float geti6x8() {
        return i6x8;
    }

    public TrackLength i6x8(Float i6x8) {
        this.i6x8 = i6x8;
        return this;
    }

    public void seti6x8(Float i6x8) {
        this.i6x8 = i6x8;
    }

    public Float geti8x10() {
        return i8x10;
    }

    public TrackLength i8x10(Float i8x10) {
        this.i8x10 = i8x10;
        return this;
    }

    public void seti8x10(Float i8x10) {
        this.i8x10 = i8x10;
    }

    public Float geti10x12() {
        return i10x12;
    }

    public TrackLength i10x12(Float i10x12) {
        this.i10x12 = i10x12;
        return this;
    }

    public void seti10x12(Float i10x12) {
        this.i10x12 = i10x12;
    }

    public Float geti12x14() {
        return i12x14;
    }

    public TrackLength i12x14(Float i12x14) {
        this.i12x14 = i12x14;
        return this;
    }

    public void seti12x14(Float i12x14) {
        this.i12x14 = i12x14;
    }

    public Float geti14x16() {
        return i14x16;
    }

    public TrackLength i14x16(Float i14x16) {
        this.i14x16 = i14x16;
        return this;
    }

    public void seti14x16(Float i14x16) {
        this.i14x16 = i14x16;
    }

    public Float geti16x18() {
        return i16x18;
    }

    public TrackLength i16x18(Float i16x18) {
        this.i16x18 = i16x18;
        return this;
    }

    public void seti16x18(Float i16x18) {
        this.i16x18 = i16x18;
    }

    public Float geti1x2() {
        return i1x2;
    }

    public TrackLength i1x2(Float i1x2) {
        this.i1x2 = i1x2;
        return this;
    }

    public void seti1x2(Float i1x2) {
        this.i1x2 = i1x2;
    }

    public Float geti2x3() {
        return i2x3;
    }

    public TrackLength i2x3(Float i2x3) {
        this.i2x3 = i2x3;
        return this;
    }

    public void seti2x3(Float i2x3) {
        this.i2x3 = i2x3;
    }

    public Float geti3x4() {
        return i3x4;
    }

    public TrackLength i3x4(Float i3x4) {
        this.i3x4 = i3x4;
        return this;
    }

    public void seti3x4(Float i3x4) {
        this.i3x4 = i3x4;
    }

    public Float geti4x5() {
        return i4x5;
    }

    public TrackLength i4x5(Float i4x5) {
        this.i4x5 = i4x5;
        return this;
    }

    public void seti4x5(Float i4x5) {
        this.i4x5 = i4x5;
    }

    public Float geti5x6() {
        return i5x6;
    }

    public TrackLength i5x6(Float i5x6) {
        this.i5x6 = i5x6;
        return this;
    }

    public void seti5x6(Float i5x6) {
        this.i5x6 = i5x6;
    }

    public Float geti6x7() {
        return i6x7;
    }

    public TrackLength i6x7(Float i6x7) {
        this.i6x7 = i6x7;
        return this;
    }

    public void seti6x7(Float i6x7) {
        this.i6x7 = i6x7;
    }

    public Float geti7x8() {
        return i7x8;
    }

    public TrackLength i7x8(Float i7x8) {
        this.i7x8 = i7x8;
        return this;
    }

    public void seti7x8(Float i7x8) {
        this.i7x8 = i7x8;
    }

    public Float geti8x9() {
        return i8x9;
    }

    public TrackLength i8x9(Float i8x9) {
        this.i8x9 = i8x9;
        return this;
    }

    public void seti8x9(Float i8x9) {
        this.i8x9 = i8x9;
    }

    public Float geti9x10() {
        return i9x10;
    }

    public TrackLength i9x10(Float i9x10) {
        this.i9x10 = i9x10;
        return this;
    }

    public void seti9x10(Float i9x10) {
        this.i9x10 = i9x10;
    }

    public Float geti10x11() {
        return i10x11;
    }

    public TrackLength i10x11(Float i10x11) {
        this.i10x11 = i10x11;
        return this;
    }

    public void seti10x11(Float i10x11) {
        this.i10x11 = i10x11;
    }

    public Float geti11x12() {
        return i11x12;
    }

    public TrackLength i11x12(Float i11x12) {
        this.i11x12 = i11x12;
        return this;
    }

    public void seti11x12(Float i11x12) {
        this.i11x12 = i11x12;
    }

    public Float geti12x13() {
        return i12x13;
    }

    public TrackLength i12x13(Float i12x13) {
        this.i12x13 = i12x13;
        return this;
    }

    public void seti12x13(Float i12x13) {
        this.i12x13 = i12x13;
    }

    public Float geti13x14() {
        return i13x14;
    }

    public TrackLength i13x14(Float i13x14) {
        this.i13x14 = i13x14;
        return this;
    }

    public void seti13x14(Float i13x14) {
        this.i13x14 = i13x14;
    }

    public Float geti14x15() {
        return i14x15;
    }

    public TrackLength i14x15(Float i14x15) {
        this.i14x15 = i14x15;
        return this;
    }

    public void seti14x15(Float i14x15) {
        this.i14x15 = i14x15;
    }

    public Float geti15x16() {
        return i15x16;
    }

    public TrackLength i15x16(Float i15x16) {
        this.i15x16 = i15x16;
        return this;
    }

    public void seti15x16(Float i15x16) {
        this.i15x16 = i15x16;
    }

    public Float geti16x17() {
        return i16x17;
    }

    public TrackLength i16x17(Float i16x17) {
        this.i16x17 = i16x17;
        return this;
    }

    public void seti16x17(Float i16x17) {
        this.i16x17 = i16x17;
    }

    public Float geti17x18() {
        return i17x18;
    }

    public TrackLength i17x18(Float i17x18) {
        this.i17x18 = i17x18;
        return this;
    }

    public void seti17x18(Float i17x18) {
        this.i17x18 = i17x18;
    }

    public Float geti18x19() {
        return i18x19;
    }

    public TrackLength i18x19(Float i18x19) {
        this.i18x19 = i18x19;
        return this;
    }

    public void seti18x19(Float i18x19) {
        this.i18x19 = i18x19;
    }

    public Float geti18x20() {
        return i18x20;
    }

    public TrackLength i18x20(Float i18x20) {
        this.i18x20 = i18x20;
        return this;
    }

    public void seti18x20(Float i18x20) {
        this.i18x20 = i18x20;
    }

    public Float geti19x20() {
        return i19x20;
    }

    public TrackLength i19x20(Float i19x20) {
        this.i19x20 = i19x20;
        return this;
    }

    public void seti19x20(Float i19x20) {
        this.i19x20 = i19x20;
    }

    public Float geti0x1() {
        return i0x1;
    }

    public TrackLength i0x1(Float i0x1) {
        this.i0x1 = i0x1;
        return this;
    }

    public void seti0x1(Float i0x1) {
        this.i0x1 = i0x1;
    }

    public Float getCorrTrackLength() {
        return corrTrackLength;
    }

    public TrackLength corrTrackLength(Float corrTrackLength) {
        this.corrTrackLength = corrTrackLength;
        return this;
    }

    public void setCorrTrackLength(Float corrTrackLength) {
        this.corrTrackLength = corrTrackLength;
    }

    public Float getDpar() {
        return dpar;
    }

    public TrackLength dpar(Float dpar) {
        this.dpar = dpar;
        return this;
    }

    public void setDpar(Float dpar) {
        this.dpar = dpar;
    }

    public Float getDper() {
        return dper;
    }

    public TrackLength dper(Float dper) {
        this.dper = dper;
        return this;
    }

    public void setDper(Float dper) {
        this.dper = dper;
    }

    public Float getKurtosisPercent() {
        return kurtosisPercent;
    }

    public TrackLength kurtosisPercent(Float kurtosisPercent) {
        this.kurtosisPercent = kurtosisPercent;
        return this;
    }

    public void setKurtosisPercent(Float kurtosisPercent) {
        this.kurtosisPercent = kurtosisPercent;
    }

    public Float getSkewnessPercent() {
        return skewnessPercent;
    }

    public TrackLength skewnessPercent(Float skewnessPercent) {
        this.skewnessPercent = skewnessPercent;
        return this;
    }

    public void setSkewnessPercent(Float skewnessPercent) {
        this.skewnessPercent = skewnessPercent;
    }

    public Chrono getChrono() {
        return chrono;
    }

    public TrackLength chrono(Chrono chrono) {
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
        if (!(o instanceof TrackLength)) {
            return false;
        }
        return id != null && id.equals(((TrackLength) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "TrackLength{" +
            "id=" + getId() +
            ", trackLength=" + getTrackLength() +
            ", trackLengthErr=" + getTrackLengthErr() +
            ", cAxisAng=" + getcAxisAng() +
            ", i0x2=" + geti0x2() +
            ", i2x4=" + geti2x4() +
            ", i4x6=" + geti4x6() +
            ", i6x8=" + geti6x8() +
            ", i8x10=" + geti8x10() +
            ", i10x12=" + geti10x12() +
            ", i12x14=" + geti12x14() +
            ", i14x16=" + geti14x16() +
            ", i16x18=" + geti16x18() +
            ", i1x2=" + geti1x2() +
            ", i2x3=" + geti2x3() +
            ", i3x4=" + geti3x4() +
            ", i4x5=" + geti4x5() +
            ", i5x6=" + geti5x6() +
            ", i6x7=" + geti6x7() +
            ", i7x8=" + geti7x8() +
            ", i8x9=" + geti8x9() +
            ", i9x10=" + geti9x10() +
            ", i10x11=" + geti10x11() +
            ", i11x12=" + geti11x12() +
            ", i12x13=" + geti12x13() +
            ", i13x14=" + geti13x14() +
            ", i14x15=" + geti14x15() +
            ", i15x16=" + geti15x16() +
            ", i16x17=" + geti16x17() +
            ", i17x18=" + geti17x18() +
            ", i18x19=" + geti18x19() +
            ", i18x20=" + geti18x20() +
            ", i19x20=" + geti19x20() +
            ", i0x1=" + geti0x1() +
            ", corrTrackLength=" + getCorrTrackLength() +
            ", dpar=" + getDpar() +
            ", dper=" + getDper() +
            ", kurtosisPercent=" + getKurtosisPercent() +
            ", skewnessPercent=" + getSkewnessPercent() +
            "}";
    }
}
