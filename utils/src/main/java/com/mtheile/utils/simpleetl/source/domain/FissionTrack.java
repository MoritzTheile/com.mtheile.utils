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
 * A FissionTrack.
 */
@Entity
@Table(name = "fission_track")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FissionTrack extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "u_ppm")
    private Float uPpm;

    @Lob
    @Column(name = "etching_comment")
    private String etchingComment;

    @Column(name = "etching_time")
    private Float etchingTime;

    @Column(name = "rho_d")
    private Float rhoD;

    @Column(name = "rho_i")
    private Float rhoI;

    @Column(name = "rho_s")
    private Float rhoS;

    @Column(name = "dosimeter_idx")
    private Integer dosimeterIdx;

    @Column(name = "c_axis_corr")
    private Boolean cAxisCorr;

    @Column(name = "cf_irrad")
    private Boolean cfIrrad;

    @Column(name = "grain_cnt")
    private Integer grainCnt;

    @Column(name = "track_cnt")
    private Integer trackCnt;

    @Column(name = "mtl_um")
    private Float mtlUm;

    @Column(name = "mtl_error")
    private Float mtlError;

    @Column(name = "mtl_sd")
    private Float mtlSd;

    @Column(name = "chi_sq_pct")
    private Float chiSqPct;

    @Column(name = "cl_wtpct")
    private Float clWtpct;

    @Column(name = "oh_wtpct")
    private Float ohWtpct;

    @Column(name = "dpar_um")
    private Float dparUm;

    @Column(name = "dpar_err")
    private Float dparErr;

    @Column(name = "dpar_sd")
    private Float dparSd;

    @Column(name = "dpar_cnt")
    private Integer dparCnt;

    @Column(name = "neutron_flux")
    private Float neutronFlux;

    @Column(name = "u_ca_ratio")
    private Float uCaRatio;

    @Column(name = "area_cnt_cm_2")
    private Float areaCntCm2;

    @Column(name = "dper_um")
    private Float dperUm;

    @Column(name = "ns")
    private Integer ns;

    @Column(name = "ni")
    private Integer ni;

    @Column(name = "nd")
    private Integer nd;

    @Column(name = "zeta")
    private Float zeta;

    @Column(name = "zeta_err")
    private Float zetaErr;

    @Column(name = "sing_track_len")
    private Boolean singTrackLen;

    @Column(name = "incomplete_data")
    private Boolean incompleteData;

    @Column(name = "disp_pct")
    private Float dispPct;

    @Column(name = "single_grain")
    private Boolean singleGrain;

    @Column(name = "u_ppm_calc")
    private Float uPpmCalc;

    @Column(name = "u_ppm_error")
    private Float uPpmError;

    @Column(name = "xi_calib")
    private Float xiCalib;

    @ManyToOne
    @JsonIgnoreProperties("fissionTracks")
    private Chrono chrono;

    @ManyToOne
    @JsonIgnoreProperties("fissionTracks")
    private LThermEtch thermEtch;

    @ManyToOne
    @JsonIgnoreProperties("fissionTracks")
    private LThermDosimeter thermDosimeter;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getuPpm() {
        return uPpm;
    }

    public FissionTrack uPpm(Float uPpm) {
        this.uPpm = uPpm;
        return this;
    }

    public void setuPpm(Float uPpm) {
        this.uPpm = uPpm;
    }

    public String getEtchingComment() {
        return etchingComment;
    }

    public FissionTrack etchingComment(String etchingComment) {
        this.etchingComment = etchingComment;
        return this;
    }

    public void setEtchingComment(String etchingComment) {
        this.etchingComment = etchingComment;
    }

    public Float getEtchingTime() {
        return etchingTime;
    }

    public FissionTrack etchingTime(Float etchingTime) {
        this.etchingTime = etchingTime;
        return this;
    }

    public void setEtchingTime(Float etchingTime) {
        this.etchingTime = etchingTime;
    }

    public Float getRhoD() {
        return rhoD;
    }

    public FissionTrack rhoD(Float rhoD) {
        this.rhoD = rhoD;
        return this;
    }

    public void setRhoD(Float rhoD) {
        this.rhoD = rhoD;
    }

    public Float getRhoI() {
        return rhoI;
    }

    public FissionTrack rhoI(Float rhoI) {
        this.rhoI = rhoI;
        return this;
    }

    public void setRhoI(Float rhoI) {
        this.rhoI = rhoI;
    }

    public Float getRhoS() {
        return rhoS;
    }

    public FissionTrack rhoS(Float rhoS) {
        this.rhoS = rhoS;
        return this;
    }

    public void setRhoS(Float rhoS) {
        this.rhoS = rhoS;
    }

    public Integer getDosimeterIdx() {
        return dosimeterIdx;
    }

    public FissionTrack dosimeterIdx(Integer dosimeterIdx) {
        this.dosimeterIdx = dosimeterIdx;
        return this;
    }

    public void setDosimeterIdx(Integer dosimeterIdx) {
        this.dosimeterIdx = dosimeterIdx;
    }

    public Boolean iscAxisCorr() {
        return cAxisCorr;
    }

    public FissionTrack cAxisCorr(Boolean cAxisCorr) {
        this.cAxisCorr = cAxisCorr;
        return this;
    }

    public void setcAxisCorr(Boolean cAxisCorr) {
        this.cAxisCorr = cAxisCorr;
    }

    public Boolean isCfIrrad() {
        return cfIrrad;
    }

    public FissionTrack cfIrrad(Boolean cfIrrad) {
        this.cfIrrad = cfIrrad;
        return this;
    }

    public void setCfIrrad(Boolean cfIrrad) {
        this.cfIrrad = cfIrrad;
    }

    public Integer getGrainCnt() {
        return grainCnt;
    }

    public FissionTrack grainCnt(Integer grainCnt) {
        this.grainCnt = grainCnt;
        return this;
    }

    public void setGrainCnt(Integer grainCnt) {
        this.grainCnt = grainCnt;
    }

    public Integer getTrackCnt() {
        return trackCnt;
    }

    public FissionTrack trackCnt(Integer trackCnt) {
        this.trackCnt = trackCnt;
        return this;
    }

    public void setTrackCnt(Integer trackCnt) {
        this.trackCnt = trackCnt;
    }

    public Float getMtlUm() {
        return mtlUm;
    }

    public FissionTrack mtlUm(Float mtlUm) {
        this.mtlUm = mtlUm;
        return this;
    }

    public void setMtlUm(Float mtlUm) {
        this.mtlUm = mtlUm;
    }

    public Float getMtlError() {
        return mtlError;
    }

    public FissionTrack mtlError(Float mtlError) {
        this.mtlError = mtlError;
        return this;
    }

    public void setMtlError(Float mtlError) {
        this.mtlError = mtlError;
    }

    public Float getMtlSd() {
        return mtlSd;
    }

    public FissionTrack mtlSd(Float mtlSd) {
        this.mtlSd = mtlSd;
        return this;
    }

    public void setMtlSd(Float mtlSd) {
        this.mtlSd = mtlSd;
    }

    public Float getChiSqPct() {
        return chiSqPct;
    }

    public FissionTrack chiSqPct(Float chiSqPct) {
        this.chiSqPct = chiSqPct;
        return this;
    }

    public void setChiSqPct(Float chiSqPct) {
        this.chiSqPct = chiSqPct;
    }

    public Float getClWtpct() {
        return clWtpct;
    }

    public FissionTrack clWtpct(Float clWtpct) {
        this.clWtpct = clWtpct;
        return this;
    }

    public void setClWtpct(Float clWtpct) {
        this.clWtpct = clWtpct;
    }

    public Float getOhWtpct() {
        return ohWtpct;
    }

    public FissionTrack ohWtpct(Float ohWtpct) {
        this.ohWtpct = ohWtpct;
        return this;
    }

    public void setOhWtpct(Float ohWtpct) {
        this.ohWtpct = ohWtpct;
    }

    public Float getDparUm() {
        return dparUm;
    }

    public FissionTrack dparUm(Float dparUm) {
        this.dparUm = dparUm;
        return this;
    }

    public void setDparUm(Float dparUm) {
        this.dparUm = dparUm;
    }

    public Float getDparErr() {
        return dparErr;
    }

    public FissionTrack dparErr(Float dparErr) {
        this.dparErr = dparErr;
        return this;
    }

    public void setDparErr(Float dparErr) {
        this.dparErr = dparErr;
    }

    public Float getDparSd() {
        return dparSd;
    }

    public FissionTrack dparSd(Float dparSd) {
        this.dparSd = dparSd;
        return this;
    }

    public void setDparSd(Float dparSd) {
        this.dparSd = dparSd;
    }

    public Integer getDparCnt() {
        return dparCnt;
    }

    public FissionTrack dparCnt(Integer dparCnt) {
        this.dparCnt = dparCnt;
        return this;
    }

    public void setDparCnt(Integer dparCnt) {
        this.dparCnt = dparCnt;
    }

    public Float getNeutronFlux() {
        return neutronFlux;
    }

    public FissionTrack neutronFlux(Float neutronFlux) {
        this.neutronFlux = neutronFlux;
        return this;
    }

    public void setNeutronFlux(Float neutronFlux) {
        this.neutronFlux = neutronFlux;
    }

    public Float getuCaRatio() {
        return uCaRatio;
    }

    public FissionTrack uCaRatio(Float uCaRatio) {
        this.uCaRatio = uCaRatio;
        return this;
    }

    public void setuCaRatio(Float uCaRatio) {
        this.uCaRatio = uCaRatio;
    }

    public Float getAreaCntCm2() {
        return areaCntCm2;
    }

    public FissionTrack areaCntCm2(Float areaCntCm2) {
        this.areaCntCm2 = areaCntCm2;
        return this;
    }

    public void setAreaCntCm2(Float areaCntCm2) {
        this.areaCntCm2 = areaCntCm2;
    }

    public Float getDperUm() {
        return dperUm;
    }

    public FissionTrack dperUm(Float dperUm) {
        this.dperUm = dperUm;
        return this;
    }

    public void setDperUm(Float dperUm) {
        this.dperUm = dperUm;
    }

    public Integer getNs() {
        return ns;
    }

    public FissionTrack ns(Integer ns) {
        this.ns = ns;
        return this;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public Integer getNi() {
        return ni;
    }

    public FissionTrack ni(Integer ni) {
        this.ni = ni;
        return this;
    }

    public void setNi(Integer ni) {
        this.ni = ni;
    }

    public Integer getNd() {
        return nd;
    }

    public FissionTrack nd(Integer nd) {
        this.nd = nd;
        return this;
    }

    public void setNd(Integer nd) {
        this.nd = nd;
    }

    public Float getZeta() {
        return zeta;
    }

    public FissionTrack zeta(Float zeta) {
        this.zeta = zeta;
        return this;
    }

    public void setZeta(Float zeta) {
        this.zeta = zeta;
    }

    public Float getZetaErr() {
        return zetaErr;
    }

    public FissionTrack zetaErr(Float zetaErr) {
        this.zetaErr = zetaErr;
        return this;
    }

    public void setZetaErr(Float zetaErr) {
        this.zetaErr = zetaErr;
    }

    public Boolean isSingTrackLen() {
        return singTrackLen;
    }

    public FissionTrack singTrackLen(Boolean singTrackLen) {
        this.singTrackLen = singTrackLen;
        return this;
    }

    public void setSingTrackLen(Boolean singTrackLen) {
        this.singTrackLen = singTrackLen;
    }

    public Boolean isIncompleteData() {
        return incompleteData;
    }

    public FissionTrack incompleteData(Boolean incompleteData) {
        this.incompleteData = incompleteData;
        return this;
    }

    public void setIncompleteData(Boolean incompleteData) {
        this.incompleteData = incompleteData;
    }

    public Float getDispPct() {
        return dispPct;
    }

    public FissionTrack dispPct(Float dispPct) {
        this.dispPct = dispPct;
        return this;
    }

    public void setDispPct(Float dispPct) {
        this.dispPct = dispPct;
    }

    public Boolean isSingleGrain() {
        return singleGrain;
    }

    public FissionTrack singleGrain(Boolean singleGrain) {
        this.singleGrain = singleGrain;
        return this;
    }

    public void setSingleGrain(Boolean singleGrain) {
        this.singleGrain = singleGrain;
    }

    public Float getuPpmCalc() {
        return uPpmCalc;
    }

    public FissionTrack uPpmCalc(Float uPpmCalc) {
        this.uPpmCalc = uPpmCalc;
        return this;
    }

    public void setuPpmCalc(Float uPpmCalc) {
        this.uPpmCalc = uPpmCalc;
    }

    public Float getuPpmError() {
        return uPpmError;
    }

    public FissionTrack uPpmError(Float uPpmError) {
        this.uPpmError = uPpmError;
        return this;
    }

    public void setuPpmError(Float uPpmError) {
        this.uPpmError = uPpmError;
    }

    public Float getXiCalib() {
        return xiCalib;
    }

    public FissionTrack xiCalib(Float xiCalib) {
        this.xiCalib = xiCalib;
        return this;
    }

    public void setXiCalib(Float xiCalib) {
        this.xiCalib = xiCalib;
    }

    public Chrono getChrono() {
        return chrono;
    }

    public FissionTrack chrono(Chrono chrono) {
        this.chrono = chrono;
        return this;
    }

    public void setChrono(Chrono chrono) {
        this.chrono = chrono;
    }

    public LThermEtch getThermEtch() {
        return thermEtch;
    }

    public FissionTrack thermEtch(LThermEtch lThermEtch) {
        this.thermEtch = lThermEtch;
        return this;
    }

    public void setThermEtch(LThermEtch lThermEtch) {
        this.thermEtch = lThermEtch;
    }

    public LThermDosimeter getThermDosimeter() {
        return thermDosimeter;
    }

    public FissionTrack thermDosimeter(LThermDosimeter lThermDosimeter) {
        this.thermDosimeter = lThermDosimeter;
        return this;
    }

    public void setThermDosimeter(LThermDosimeter lThermDosimeter) {
        this.thermDosimeter = lThermDosimeter;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FissionTrack)) {
            return false;
        }
        return id != null && id.equals(((FissionTrack) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "FissionTrack{" +
            "id=" + getId() +
            ", uPpm=" + getuPpm() +
            ", etchingComment='" + getEtchingComment() + "'" +
            ", etchingTime=" + getEtchingTime() +
            ", rhoD=" + getRhoD() +
            ", rhoI=" + getRhoI() +
            ", rhoS=" + getRhoS() +
            ", dosimeterIdx=" + getDosimeterIdx() +
            ", cAxisCorr='" + iscAxisCorr() + "'" +
            ", cfIrrad='" + isCfIrrad() + "'" +
            ", grainCnt=" + getGrainCnt() +
            ", trackCnt=" + getTrackCnt() +
            ", mtlUm=" + getMtlUm() +
            ", mtlError=" + getMtlError() +
            ", mtlSd=" + getMtlSd() +
            ", chiSqPct=" + getChiSqPct() +
            ", clWtpct=" + getClWtpct() +
            ", ohWtpct=" + getOhWtpct() +
            ", dparUm=" + getDparUm() +
            ", dparErr=" + getDparErr() +
            ", dparSd=" + getDparSd() +
            ", dparCnt=" + getDparCnt() +
            ", neutronFlux=" + getNeutronFlux() +
            ", uCaRatio=" + getuCaRatio() +
            ", areaCntCm2=" + getAreaCntCm2() +
            ", dperUm=" + getDperUm() +
            ", ns=" + getNs() +
            ", ni=" + getNi() +
            ", nd=" + getNd() +
            ", zeta=" + getZeta() +
            ", zetaErr=" + getZetaErr() +
            ", singTrackLen='" + isSingTrackLen() + "'" +
            ", incompleteData='" + isIncompleteData() + "'" +
            ", dispPct=" + getDispPct() +
            ", singleGrain='" + isSingleGrain() + "'" +
            ", uPpmCalc=" + getuPpmCalc() +
            ", uPpmError=" + getuPpmError() +
            ", xiCalib=" + getXiCalib() +
            "}";
    }
}
