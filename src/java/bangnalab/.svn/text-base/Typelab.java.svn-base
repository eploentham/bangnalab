/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnalab;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "typelab")
@NamedQueries({
    @NamedQuery(name = "Typelab.findAll", query = "SELECT t FROM Typelab t")})
public class Typelab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tlabid")
    private String tlabid="";
    @Column(name = "tlabnamet")
    private String tlabnamet="";
    @Column(name = "flag")
    private String flag="";
    @Column(name = "sort1")
    private Double sort1=0.0;
    @Column(name = "percent")
    private Double percent=0.0;
    @Column(name = "flagusprice")
    private String flagusprice="";

    public Typelab() {
    }

    public Typelab(String tlabid) {
        this.tlabid = tlabid;
    }

    public String getTlabid() {
        return tlabid;
    }

    public void setTlabid(String tlabid) {
        this.tlabid = tlabid;
    }

    public String getTlabnamet() {
        return tlabnamet;
    }

    public void setTlabnamet(String tlabnamet) {
        this.tlabnamet = tlabnamet;
    }

    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Double getSort1() {
        return sort1;
    }

    public void setSort1(Double sort1) {
        this.sort1 = sort1;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getFlagusprice() {
        return flagusprice;
    }

    public void setFlagusprice(String flagusprice) {
        this.flagusprice = flagusprice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tlabid != null ? tlabid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typelab)) {
            return false;
        }
        Typelab other = (Typelab) object;
        if ((this.tlabid == null && other.tlabid != null) || (this.tlabid != null && !this.tlabid.equals(other.tlabid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnalab.Typelab[tlabid=" + tlabid + "]";
    }

}
