/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnalab;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author root
 */
@Entity
@Table(name = "labimport")
@NamedQueries({
    @NamedQuery(name = "Labimport.findAll", query = "SELECT l FROM Labimport l")})
public class Labimport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "labimportid")
    private Double labimportid=0.0;
    @Column(name = "importdate")
    private String importdate="";
    @Column(name = "description")
    private String description;
    @Column(name = "remark")
    private String remark="";
    @Column(name = "sysdate")
    private String sysdate="";
    @Column(name = "user1")
    private String user1="";
    @Column(name = "flag")
    private String flag="";
    @Column(name = "flagimport")
    private String flagimport="";
    @Column(name = "importrow")
    private Double importrow=0.0;
    @Column(name = "nolabid")
    private Double nolabid=0.0;
    @Column(name = "nohn")
    private Double nohn=0.0;
    @Column(name = "nopricelab1")
    private Double nopricelab1=0.0;
    @Column(name = "nopricelab2")
    private Double nopricelab2=0.0;
    @Column(name = "custid")
    private String custid="";
    @Column(name = "total")
    private Double total=0.0;
    @Column(name = "tpayid")
    private String tpayid="";
    @Column(name = "lotstatement")
    private String lotstatement="";
    @Column(name = "year1")
    private String year1="";
    @Column(name = "month1")
    private String month1="";
    @Column(name = "period1")
    private String period1="";

    public Labimport() {
    }

    public Labimport(Double labimportid) {
        this.labimportid = labimportid;
    }

    public Double getLabimportid() {
        return labimportid;
    }
    public void setLabimportid(Double labimportid) {
        this.labimportid = labimportid;
    }

    public String getImportdate() {
        return importdate;
    }
    public void setImportdate(String importdate) {
        this.importdate = importdate;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSysdate() {
        return sysdate;
    }
    public void setSysdate(String sysdate) {
        this.sysdate = sysdate;
    }

    public String getUser() {
        return user1;
    }
    public void setUser(String user1) {
        this.user1 = user1;
    }

    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlagimport() {
        return flagimport;
    }
    public void setFlagimport(String flagimport) {
        this.flagimport = flagimport;
    }

    public Double getImportrow() {
        return importrow;
    }
    public void setImportrow(Double importrow) {
        this.importrow = importrow;
    }

    public Double getNolabid() {
        return nolabid;
    }
    public void setNolabid(Double nolabid) {
        this.nolabid = nolabid;
    }

    public Double getNohn() {
        return nohn;
    }
    public void setNohn(Double nohn) {
        this.nohn = nohn;
    }

    public Double getNopricelab1() {
        return nopricelab1;
    }
    public void setNopricelab1(Double nopricelab1) {
        this.nopricelab1 = nopricelab1;
    }

    public Double getNopricelab2() {
        return nopricelab2;
    }
    public void setNopricelab2(Double nopricelab2) {
        this.nopricelab2 = nopricelab2;
    }

    public String getCustid() {
        return custid;
    }
    public void setCustid(String custid) {
        this.custid = custid;
    }

    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTpayid() {
        return tpayid;
    }
    public void setTpayid(String tpayid) {
        this.tpayid = tpayid;
    }

    public String getLotstatement() {
        return lotstatement;
    }
    public void setLotstatement(String lotstatement) {
        this.lotstatement = lotstatement;
    }

    public String getYear() {
        return year1;
    }
    public void setYear(String year1) {
        this.year1 = year1;
    }

    public String getMonth() {
        return month1;
    }
    public void setMonth(String month1) {
        this.month1 = month1;
    }

    public String getPeriod() {
        return period1;
    }
    public void setPeriod(String period1) {
        this.period1 = period1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labimportid != null ? labimportid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Labimport)) {
            return false;
        }
        Labimport other = (Labimport) object;
        if ((this.labimportid == null && other.labimportid != null) || (this.labimportid != null && !this.labimportid.equals(other.labimportid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnalab.Labimport[labimportid=" + labimportid + "]";
    }

}
