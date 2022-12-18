/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kant2
 */
@Entity
@Table(name = "COVID19_STATISTICS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Covid19Statistics.findAll", query = "SELECT c FROM Covid19Statistics c"),
    @NamedQuery(name = "Covid19Statistics.findById", query = "SELECT c FROM Covid19Statistics c WHERE c.id = :id"),
    @NamedQuery(name = "Covid19Statistics.findByYears", query = "SELECT c FROM Covid19Statistics c WHERE c.years = :years"),
    @NamedQuery(name = "Covid19Statistics.findByWeeknum", query = "SELECT c FROM Covid19Statistics c WHERE c.weeknum = :weeknum"),
    @NamedQuery(name = "Covid19Statistics.findByNewCase", query = "SELECT c FROM Covid19Statistics c WHERE c.newCase = :newCase"),
    @NamedQuery(name = "Covid19Statistics.findByTotalCase", query = "SELECT c FROM Covid19Statistics c WHERE c.totalCase = :totalCase"),
    @NamedQuery(name = "Covid19Statistics.findByNewCaseExcludeabroad", query = "SELECT c FROM Covid19Statistics c WHERE c.newCaseExcludeabroad = :newCaseExcludeabroad"),
    @NamedQuery(name = "Covid19Statistics.findByTotalCaseExcludeabroad", query = "SELECT c FROM Covid19Statistics c WHERE c.totalCaseExcludeabroad = :totalCaseExcludeabroad"),
    @NamedQuery(name = "Covid19Statistics.findByNewRecovered", query = "SELECT c FROM Covid19Statistics c WHERE c.newRecovered = :newRecovered"),
    @NamedQuery(name = "Covid19Statistics.findByTotalRecovered", query = "SELECT c FROM Covid19Statistics c WHERE c.totalRecovered = :totalRecovered"),
    @NamedQuery(name = "Covid19Statistics.findByNewDeath", query = "SELECT c FROM Covid19Statistics c WHERE c.newDeath = :newDeath"),
    @NamedQuery(name = "Covid19Statistics.findByTotalDeath", query = "SELECT c FROM Covid19Statistics c WHERE c.totalDeath = :totalDeath"),
    @NamedQuery(name = "Covid19Statistics.findByCaseForeign", query = "SELECT c FROM Covid19Statistics c WHERE c.caseForeign = :caseForeign"),
    @NamedQuery(name = "Covid19Statistics.findByCasePrison", query = "SELECT c FROM Covid19Statistics c WHERE c.casePrison = :casePrison"),
    @NamedQuery(name = "Covid19Statistics.findByCaseWalkin", query = "SELECT c FROM Covid19Statistics c WHERE c.caseWalkin = :caseWalkin"),
    @NamedQuery(name = "Covid19Statistics.findByCaseNewPrev", query = "SELECT c FROM Covid19Statistics c WHERE c.caseNewPrev = :caseNewPrev"),
    @NamedQuery(name = "Covid19Statistics.findByCaseNewDiff", query = "SELECT c FROM Covid19Statistics c WHERE c.caseNewDiff = :caseNewDiff"),
    @NamedQuery(name = "Covid19Statistics.findByDeathNewPrev", query = "SELECT c FROM Covid19Statistics c WHERE c.deathNewPrev = :deathNewPrev"),
    @NamedQuery(name = "Covid19Statistics.findByDeathNewDiff", query = "SELECT c FROM Covid19Statistics c WHERE c.deathNewDiff = :deathNewDiff"),
    @NamedQuery(name = "Covid19Statistics.findByUpdateDate", query = "SELECT c FROM Covid19Statistics c WHERE c.updateDate = :updateDate")})
public class Covid19Statistics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "YEARS")
    private Integer years;
    @Column(name = "WEEKNUM")
    private Integer weeknum;
    @Column(name = "NEW_CASE")
    private Integer newCase;
    @Column(name = "TOTAL_CASE")
    private Integer totalCase;
    @Column(name = "NEW_CASE_EXCLUDEABROAD")
    private Integer newCaseExcludeabroad;
    @Column(name = "TOTAL_CASE_EXCLUDEABROAD")
    private Integer totalCaseExcludeabroad;
    @Column(name = "NEW_RECOVERED")
    private Integer newRecovered;
    @Column(name = "TOTAL_RECOVERED")
    private Integer totalRecovered;
    @Column(name = "NEW_DEATH")
    private Integer newDeath;
    @Column(name = "TOTAL_DEATH")
    private Integer totalDeath;
    @Column(name = "CASE_FOREIGN")
    private Integer caseForeign;
    @Column(name = "CASE_PRISON")
    private Integer casePrison;
    @Column(name = "CASE_WALKIN")
    private Integer caseWalkin;
    @Column(name = "CASE_NEW_PREV")
    private Integer caseNewPrev;
    @Column(name = "CASE_NEW_DIFF")
    private Integer caseNewDiff;
    @Column(name = "DEATH_NEW_PREV")
    private Integer deathNewPrev;
    @Column(name = "DEATH_NEW_DIFF")
    private Integer deathNewDiff;
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    public Covid19Statistics() {
    }

    public Covid19Statistics(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getWeeknum() {
        return weeknum;
    }

    public void setWeeknum(Integer weeknum) {
        this.weeknum = weeknum;
    }

    public Integer getNewCase() {
        return newCase;
    }

    public void setNewCase(Integer newCase) {
        this.newCase = newCase;
    }

    public Integer getTotalCase() {
        return totalCase;
    }

    public void setTotalCase(Integer totalCase) {
        this.totalCase = totalCase;
    }

    public Integer getNewCaseExcludeabroad() {
        return newCaseExcludeabroad;
    }

    public void setNewCaseExcludeabroad(Integer newCaseExcludeabroad) {
        this.newCaseExcludeabroad = newCaseExcludeabroad;
    }

    public Integer getTotalCaseExcludeabroad() {
        return totalCaseExcludeabroad;
    }

    public void setTotalCaseExcludeabroad(Integer totalCaseExcludeabroad) {
        this.totalCaseExcludeabroad = totalCaseExcludeabroad;
    }

    public Integer getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Integer getNewDeath() {
        return newDeath;
    }

    public void setNewDeath(Integer newDeath) {
        this.newDeath = newDeath;
    }

    public Integer getTotalDeath() {
        return totalDeath;
    }

    public void setTotalDeath(Integer totalDeath) {
        this.totalDeath = totalDeath;
    }

    public Integer getCaseForeign() {
        return caseForeign;
    }

    public void setCaseForeign(Integer caseForeign) {
        this.caseForeign = caseForeign;
    }

    public Integer getCasePrison() {
        return casePrison;
    }

    public void setCasePrison(Integer casePrison) {
        this.casePrison = casePrison;
    }

    public Integer getCaseWalkin() {
        return caseWalkin;
    }

    public void setCaseWalkin(Integer caseWalkin) {
        this.caseWalkin = caseWalkin;
    }

    public Integer getCaseNewPrev() {
        return caseNewPrev;
    }

    public void setCaseNewPrev(Integer caseNewPrev) {
        this.caseNewPrev = caseNewPrev;
    }

    public Integer getCaseNewDiff() {
        return caseNewDiff;
    }

    public void setCaseNewDiff(Integer caseNewDiff) {
        this.caseNewDiff = caseNewDiff;
    }

    public Integer getDeathNewPrev() {
        return deathNewPrev;
    }

    public void setDeathNewPrev(Integer deathNewPrev) {
        this.deathNewPrev = deathNewPrev;
    }

    public Integer getDeathNewDiff() {
        return deathNewDiff;
    }

    public void setDeathNewDiff(Integer deathNewDiff) {
        this.deathNewDiff = deathNewDiff;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Covid19Statistics)) {
            return false;
        }
        Covid19Statistics other = (Covid19Statistics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Covid19Statistics[ id=" + id + " ]";
    }
    
}
