/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnalab;

import java.io.Serializable;
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
@Table(name = "lab_b_paid")
@NamedQueries({
    @NamedQuery(name = "LabBPaid.findAll", query = "SELECT l FROM LabBPaid l")})
public class LabBPaid implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lab_paid_id")
    private String labPaidId="";
    @Column(name = "paid_namet")
    private String paidNamet="";
    @Column(name = "discount")
    private Double discount=0.0;
    @Column(name = "remark")
    private String remark="";
    @Column(name = "statusdiscount")
    private String statusdiscount="";

    public LabBPaid() {
    }
    public String getLabBPaid() {
        return "lab_b_paid";
    }
    public String getFLabPaidId() {
        return "lab_paid_id";
    }
    public String getFPaidNamet() {
        return "paid_namet";
    }
    public String getFDiscount() {
        return "discount";
    }
    public String getFRemark() {
        return "remark";
    }
    public String getFStatusDiscount() {
        return "statusdiscount";
    }

    public LabBPaid(String labPaidId) {
        this.labPaidId = labPaidId;
    }

    public String getLabPaidId() {
        return labPaidId;
    }

    public void setLabPaidId(String labPaidId) {
        this.labPaidId = labPaidId;
    }

    public String getPaidNamet() {
        return paidNamet;
    }

    public void setPaidNamet(String paidNamet) {
        this.paidNamet = paidNamet;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatusdiscount() {
        return statusdiscount;
    }

    public void setStatusdiscount(String statusdiscount) {
        this.statusdiscount = statusdiscount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labPaidId != null ? labPaidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabBPaid)) {
            return false;
        }
        LabBPaid other = (LabBPaid) object;
        if ((this.labPaidId == null && other.labPaidId != null) || (this.labPaidId != null && !this.labPaidId.equals(other.labPaidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnalab.LabBPaid[labPaidId=" + labPaidId + "]";
    }

}
