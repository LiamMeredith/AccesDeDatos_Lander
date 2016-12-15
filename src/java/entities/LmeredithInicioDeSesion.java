/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Liam-Portatil
 */
@Entity
@Table(name = "lmeredith_inicio_de_sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LmeredithInicioDeSesion.findAll", query = "SELECT l FROM LmeredithInicioDeSesion l"),
    @NamedQuery(name = "LmeredithInicioDeSesion.findByInicioDeSesionId", query = "SELECT l FROM LmeredithInicioDeSesion l WHERE l.inicioDeSesionId = :inicioDeSesionId"),
    @NamedQuery(name = "LmeredithInicioDeSesion.findByCredentialId", query = "SELECT l FROM LmeredithInicioDeSesion l WHERE l.credentialId = :credentialId"),
    @NamedQuery(name = "LmeredithInicioDeSesion.findByInicioDeSesionTimestamp", query = "SELECT l FROM LmeredithInicioDeSesion l WHERE l.inicioDeSesionTimestamp = :inicioDeSesionTimestamp")})
public class LmeredithInicioDeSesion implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inicio_de_sesion_id")
    private Integer inicioDeSesionId;
    @JoinColumn(name = "credential_id", referencedColumnName = "credential_id")
    @ManyToOne(optional = false)
    private LmeredithCredentials credentialId;
    @Basic(optional = false)
    @Column(name = "inicio_de_sesion_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicioDeSesionTimestamp;

    public LmeredithInicioDeSesion() {
    }

    public LmeredithInicioDeSesion(Integer inicioDeSesionId) {
        this.inicioDeSesionId = inicioDeSesionId;
    }

    public LmeredithInicioDeSesion(LmeredithCredentials credentialId, Date inicioDeSesionTimestamp) {
        this.credentialId = credentialId;
        this.inicioDeSesionTimestamp = inicioDeSesionTimestamp;
    }

    public LmeredithInicioDeSesion(Integer inicioDeSesionId, LmeredithCredentials credentialId, Date inicioDeSesionTimestamp) {
        this.inicioDeSesionId = inicioDeSesionId;
        this.credentialId = credentialId;
        this.inicioDeSesionTimestamp = inicioDeSesionTimestamp;
    }

    public Integer getInicioDeSesionId() {
        return inicioDeSesionId;
    }

    public void setInicioDeSesionId(Integer inicioDeSesionId) {
        this.inicioDeSesionId = inicioDeSesionId;
    }

    public LmeredithCredentials getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(LmeredithCredentials credentialId) {
        this.credentialId = credentialId;
    }

    public Date getInicioDeSesionTimestamp() {
        return inicioDeSesionTimestamp;
    }

    public void setInicioDeSesionTimestamp(Date inicioDeSesionTimestamp) {
        this.inicioDeSesionTimestamp = inicioDeSesionTimestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inicioDeSesionId != null ? inicioDeSesionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LmeredithInicioDeSesion)) {
            return false;
        }
        LmeredithInicioDeSesion other = (LmeredithInicioDeSesion) object;
        if ((this.inicioDeSesionId == null && other.inicioDeSesionId != null) || (this.inicioDeSesionId != null && !this.inicioDeSesionId.equals(other.inicioDeSesionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LmeredithInicioDeSesion[ inicioDeSesionId=" + inicioDeSesionId + " ]";
    }

//    public LmeredithCredentials getCredentialId() {
//        return credentialId;
//    }
//
//    public void setCredentialId(LmeredithCredentials credentialId) {
//        this.credentialId = credentialId;
//    }
    
}
