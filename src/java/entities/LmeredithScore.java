/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Liam-Portatil
 */
@Entity
@Table(name = "lmeredith_score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LmeredithScore.findAll", query = "SELECT l FROM LmeredithScore l"),
    @NamedQuery(name = "LmeredithScore.findByScoreId", query = "SELECT l FROM LmeredithScore l WHERE l.scoreId = :scoreId"),
    @NamedQuery(name = "LmeredithScore.findByCredentialId", query = "SELECT l FROM LmeredithScore l WHERE l.credentialId = :credentialId"),
    @NamedQuery(name = "LmeredithScore.findByScoreValue", query = "SELECT l FROM LmeredithScore l WHERE l.scoreValue = :scoreValue")})
public class LmeredithScore implements Serializable {


    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "score_id")
    private Integer scoreId;
    @JoinColumn(name = "credential_id", referencedColumnName = "credential_id")
    @ManyToOne(optional = false)
    private LmeredithCredentials credentialId;
    @Basic(optional = false)
    @Column(name = "score_value")
    private double scoreValue;

    public LmeredithScore() {
    }

    public LmeredithScore(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public LmeredithScore(LmeredithCredentials credentialId, double scoreValue) {
        this.credentialId = credentialId;
        this.scoreValue = scoreValue;
    }
    
    public LmeredithScore(Integer scoreId, LmeredithCredentials credentialId, double scoreValue) {
        this.scoreId = scoreId;
        this.credentialId = credentialId;
        this.scoreValue = scoreValue;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public LmeredithCredentials getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(LmeredithCredentials credentialId) {
        this.credentialId = credentialId;
    }

    public double getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(double scoreValue) {
        this.scoreValue = scoreValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scoreId != null ? scoreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LmeredithScore)) {
            return false;
        }
        LmeredithScore other = (LmeredithScore) object;
        if ((this.scoreId == null && other.scoreId != null) || (this.scoreId != null && !this.scoreId.equals(other.scoreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LmeredithScore[ scoreId=" + scoreId + " ]";
    }

//    public LmeredithCredentials getCredentialId() {
//        return credentialId;
//    }
//
//    public void setCredentialId(LmeredithCredentials credentialId) {
//        this.credentialId = credentialId;
//    }
    
}
