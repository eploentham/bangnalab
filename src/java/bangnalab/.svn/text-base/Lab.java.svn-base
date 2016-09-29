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
@Table(name = "lab")
@NamedQueries({
    @NamedQuery(name = "Lab.findAll", query = "SELECT l FROM Lab l")})
public class Lab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "labid")
    private String labid="";
    @Column(name = "labnamee")
    private String labnamee="";
    @Column(name = "pricesale1")
    private Double pricesale1=0.0;
    @Column(name = "pricesale2")
    private Double pricesale2=0.0;
    @Column(name = "pricesale3")
    private Double pricesale3=0.0;
    @Column(name = "pricesale4")
    private Double pricesale4=0.0;
    @Column(name = "pricesale5")
    private Double pricesale5=0.0;
    @Column(name = "flagusprice")
    private String flagusprice="";
    @Column(name = "flagdiscount")
    private String flagdiscount="";
    @Column(name = "remark")
    private String remark="";
    @Column(name = "flag")
    private String flag="";
    @Column(name = "tlabid")
    private String tlabid="";
    @Column(name = "discountpercent")
    private Double discountpercent=0.0;
    @Column(name = "flaglab")
    private String flaglab="";

    public Lab() {
    }

    public Lab(String labid) {
        this.labid = labid;
    }

    public String getLabid() {
        return labid;
    }

    public void setLabid(String labid) {
        this.labid = labid;
    }

    public String getLabnamee() {
        return labnamee;
    }

    public void setLabnamee(String labnamee) {
        this.labnamee = labnamee;
    }

    public Double getPricesale1() {
        return pricesale1;
    }

    public void setPricesale1(Double pricesale1) {
        this.pricesale1 = pricesale1;
    }

    public Double getPricesale2() {
        return pricesale2;
    }

    public void setPricesale2(Double pricesale2) {
        this.pricesale2 = pricesale2;
    }

    public Double getPricesale3() {
        return pricesale3;
    }

    public void setPricesale3(Double pricesale3) {
        this.pricesale3 = pricesale3;
    }

    public Double getPricesale4() {
        return pricesale4;
    }

    public void setPricesale4(Double pricesale4) {
        this.pricesale4 = pricesale4;
    }

    public Double getPricesale5() {
        return pricesale5;
    }

    public void setPricesale5(Double pricesale5) {
        this.pricesale5 = pricesale5;
    }

    public String getFlagusprice() {
        return flagusprice;
    }

    public void setFlagusprice(String flagusprice) {
        this.flagusprice = flagusprice;
    }

    public String getFlagdiscount() {
        return flagdiscount;
    }

    public void setFlagdiscount(String flagdiscount) {
        this.flagdiscount = flagdiscount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTlabid() {
        return tlabid;
    }

    public void setTlabid(String tlabid) {
        this.tlabid = tlabid;
    }

    public Double getDiscountpercent() {
        return discountpercent;
    }

    public void setDiscountpercent(Double discountpercent) {
        this.discountpercent = discountpercent;
    }

    public String getFlaglab() {
        return flaglab;
    }

    public void setFlaglab(String flaglab) {
        this.flaglab = flaglab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labid != null ? labid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lab)) {
            return false;
        }
        Lab other = (Lab) object;
        if ((this.labid == null && other.labid != null) || (this.labid != null && !this.labid.equals(other.labid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnalab.Lab[labid=" + labid + "]";
    }

}
