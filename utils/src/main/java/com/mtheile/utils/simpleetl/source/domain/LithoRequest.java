package com.mtheile.utils.simpleetl.source.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import com.mtheile.utils.simpleetl.util.WithCustomId;


import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A LithoRequest.
 */
@Entity
@Table(name = "litho_request")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LithoRequest extends WithCustomId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "prod-generator")
@GenericGenerator(name = "prod-generator", strategy = "com.mtheile.utils.simpleetl.util.CustomIdGenerator")
    private Long id;

    @Column(name = "req_timestamp")
    private Instant reqTimestamp;

    @Column(name = "req_method")
    private String reqMethod;

    @Column(name = "req_uri")
    private String reqUri;

    @Column(name = "req_query")
    private String reqQuery;

    @Column(name = "req_remote_ip")
    private String reqRemoteIp;

    @Column(name = "req_remote_addr")
    private String reqRemoteAddr;

    @Column(name = "req_protocol")
    private String reqProtocol;

    @Lob
    @Column(name = "req_args")
    private String reqArgs;

    @ManyToOne
    @JsonIgnoreProperties("lithoRequests")
    private LithoUser lithoUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getReqTimestamp() {
        return reqTimestamp;
    }

    public LithoRequest reqTimestamp(Instant reqTimestamp) {
        this.reqTimestamp = reqTimestamp;
        return this;
    }

    public void setReqTimestamp(Instant reqTimestamp) {
        this.reqTimestamp = reqTimestamp;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public LithoRequest reqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
        return this;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public String getReqUri() {
        return reqUri;
    }

    public LithoRequest reqUri(String reqUri) {
        this.reqUri = reqUri;
        return this;
    }

    public void setReqUri(String reqUri) {
        this.reqUri = reqUri;
    }

    public String getReqQuery() {
        return reqQuery;
    }

    public LithoRequest reqQuery(String reqQuery) {
        this.reqQuery = reqQuery;
        return this;
    }

    public void setReqQuery(String reqQuery) {
        this.reqQuery = reqQuery;
    }

    public String getReqRemoteIp() {
        return reqRemoteIp;
    }

    public LithoRequest reqRemoteIp(String reqRemoteIp) {
        this.reqRemoteIp = reqRemoteIp;
        return this;
    }

    public void setReqRemoteIp(String reqRemoteIp) {
        this.reqRemoteIp = reqRemoteIp;
    }

    public String getReqRemoteAddr() {
        return reqRemoteAddr;
    }

    public LithoRequest reqRemoteAddr(String reqRemoteAddr) {
        this.reqRemoteAddr = reqRemoteAddr;
        return this;
    }

    public void setReqRemoteAddr(String reqRemoteAddr) {
        this.reqRemoteAddr = reqRemoteAddr;
    }

    public String getReqProtocol() {
        return reqProtocol;
    }

    public LithoRequest reqProtocol(String reqProtocol) {
        this.reqProtocol = reqProtocol;
        return this;
    }

    public void setReqProtocol(String reqProtocol) {
        this.reqProtocol = reqProtocol;
    }

    public String getReqArgs() {
        return reqArgs;
    }

    public LithoRequest reqArgs(String reqArgs) {
        this.reqArgs = reqArgs;
        return this;
    }

    public void setReqArgs(String reqArgs) {
        this.reqArgs = reqArgs;
    }

    public LithoUser getLithoUser() {
        return lithoUser;
    }

    public LithoRequest lithoUser(LithoUser lithoUser) {
        this.lithoUser = lithoUser;
        return this;
    }

    public void setLithoUser(LithoUser lithoUser) {
        this.lithoUser = lithoUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LithoRequest)) {
            return false;
        }
        return id != null && id.equals(((LithoRequest) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "LithoRequest{" +
            "id=" + getId() +
            ", reqTimestamp='" + getReqTimestamp() + "'" +
            ", reqMethod='" + getReqMethod() + "'" +
            ", reqUri='" + getReqUri() + "'" +
            ", reqQuery='" + getReqQuery() + "'" +
            ", reqRemoteIp='" + getReqRemoteIp() + "'" +
            ", reqRemoteAddr='" + getReqRemoteAddr() + "'" +
            ", reqProtocol='" + getReqProtocol() + "'" +
            ", reqArgs='" + getReqArgs() + "'" +
            "}";
    }
}
