/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Liam-Portatil
 */
@Entity
@Table(name = "lmeredith_credentials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LmeredithCredentials.findAll", query = "SELECT l FROM LmeredithCredentials l"),
    @NamedQuery(name = "LmeredithCredentials.findByCredentialId", query = "SELECT l FROM LmeredithCredentials l WHERE l.credentialId = :credentialId"),
    @NamedQuery(name = "LmeredithCredentials.findByCredentialName", query = "SELECT l FROM LmeredithCredentials l WHERE l.credentialName = :credentialName"),
    @NamedQuery(name = "LmeredithCredentials.findByCredentialPass", query = "SELECT l FROM LmeredithCredentials l WHERE l.credentialPass = :credentialPass"),
    @NamedQuery(name = "LmeredithCredentials.findByCredentialEmail", query = "SELECT l FROM LmeredithCredentials l WHERE l.credentialEmail = :credentialEmail")})
public class LmeredithCredentials implements Serializable {

    @Column(name = "credential_active")
    private Boolean credentialActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "credentialId")
    private Collection<LmeredithScore> lmeredithScoreCollection;



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "credential_id")
    private Integer credentialId;
    @Basic(optional = false)
    @Column(name = "credential_name")
    private String credentialName;
    @Basic(optional = false)
    @Column(name = "credential_pass")
    private String credentialPass;
    @Basic(optional = false)
    @Column(name = "credential_email")
    private String credentialEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "credentialId")
    private Collection<LmeredithInicioDeSesion> lmeredithInicioDeSesionCollection;

    public LmeredithCredentials() {
    }

    public LmeredithCredentials(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public LmeredithCredentials(String credentialName, String credentialPass) {
        this.credentialName = credentialName;
        this.credentialPass = credentialPass;
    }
    
    

    public LmeredithCredentials(String credentialName, String credentialPass, String credentialEmail) {
        this.credentialName = credentialName;
        this.credentialPass = credentialPass;
        this.credentialEmail = credentialEmail;
    }

    public LmeredithCredentials( String credentialName, String credentialPass, String credentialEmail, Boolean credentialActive) {
        this.credentialName = credentialName;
        this.credentialPass = credentialPass;
        this.credentialEmail = credentialEmail;
        this.credentialActive = credentialActive;
    }

    public LmeredithCredentials(Integer credentialId, String credentialName, String credentialPass, String credentialEmail) {
        this.credentialId = credentialId;
        this.credentialName = credentialName;
        this.credentialPass = credentialPass;
        this.credentialEmail = credentialEmail;
    }

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public String getCredentialName() {
        return credentialName;
    }

    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    public String getCredentialPass() {
        return credentialPass;
    }

    public void setCredentialPass(String credentialPass) {
        this.credentialPass = credentialPass;
    }

    public String getCredentialEmail() {
        return credentialEmail;
    }

    public void setCredentialEmail(String credentialEmail) {
        this.credentialEmail = credentialEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (credentialId != null ? credentialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LmeredithCredentials)) {
            return false;
        }
        LmeredithCredentials other = (LmeredithCredentials) object;
        if ((this.credentialId == null && other.credentialId != null) || (this.credentialId != null && !this.credentialId.equals(other.credentialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LmeredithCredentials[ credentialId=" + credentialId + " ]";
    }

    @XmlTransient
    public Collection<LmeredithInicioDeSesion> getLmeredithInicioDeSesionCollection() {
        return lmeredithInicioDeSesionCollection;
    }

    public void setLmeredithInicioDeSesionCollection(Collection<LmeredithInicioDeSesion> lmeredithInicioDeSesionCollection) {
        this.lmeredithInicioDeSesionCollection = lmeredithInicioDeSesionCollection;
    }

    @XmlTransient
    public Collection<LmeredithScore> getLmeredithScoreCollection() {
        return lmeredithScoreCollection;
    }

    public void setLmeredithScoreCollection(Collection<LmeredithScore> lmeredithScoreCollection) {
        this.lmeredithScoreCollection = lmeredithScoreCollection;
    }

    public Boolean getCredentialActive() {
        return credentialActive;
    }

    public void setCredentialActive(Boolean credentialActive) {
        this.credentialActive = credentialActive;
    }
    
}
