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
@Table(name = "lab_t_billing")
@NamedQueries({
    @NamedQuery(name = "LabTBilling.findAll", query = "SELECT l FROM LabTBilling l")})
public class LabTBilling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lab_billing_id")
    private String labBillingId="";
    @Column(name = "lab_billing_date")
    private String labBillingDate="";
    @Column(name = "year_id")
    private String yearId="";
    @Column(name = "moth_id")
    private String mothId="";
    @Column(name = "branch_id")
    private String branchId="";
    @Column(name = "description")
    private String description="";
    @Column(name = "remark")
    private String remark="";
    @Column(name = "lab_billing_active")
    private String labBillingActive="";
    @Column(name = "status_import")
    private String statusImport="";
    @Column(name = "cnt_lab")
    private Double cntLab=0.0;
    @Column(name = "sum_lab")
    private Double sumLab=0.0;
    @Column(name = "cnt_no_lab_id")
    private Double cntNoLabId=0.0;
    @Column(name = "cnt_no_hn")
    private Double cntNoHn=0.0;
    @Column(name = "cnt_no_price_sale1")
    private Double cntNoPriceSale1=0.0;
    @Column(name = "cnt_no_price_sale2")
    private Double cntNoPriceSale2=0.0;
    @Column(name = "period_id")
    private String periodId="";
    @Column(name = "filename")
    private String filename="";

    public LabTBilling() {
    }
    public String getLabTBilling() {
        return "lab_t_billing";
    }

    public String getFLabBillingId() {
        return "lab_billing_id";
    }
    public String getFLabBillingDate() {
        return "lab_billing_date";
    }
    public String getFYearId() {
        return "year_id";
    }
    public String getFMothId() {
        return "moth_id";
    }
    public String getFBranchId() {
        return "branch_id";
    }
    public String getFDescription() {
        return "description";
    }
    public String getFRemark() {
        return "remark";
    }
    public String getFLabBillingActive() {
        return "lab_billing_active";
    }
    public String getFStatusImport() {
        return "status_import";
    }
    public String getFCntLab() {
        return "cnt_lab";
    }
    public String getFSumLab() {
        return "sum_lab";
    }
    public String getFCntNoLabId() {
        return "cnt_no_lab_id";
    }
    public String getFCntNoHn() {
        return "cnt_no_hn";
    }
    public String getFCntNoPriceSale1() {
        return "cnt_no_price_sale1";
    }
    public String getFCntNoPriceSale2() {
        return "cnt_no_price_sale2";
    }
    public String getFPeriodId() {
        return "period_id";
    }
    public String getFFilename() {
        return "filename";
    }

    public LabTBilling(String labBillingId) {
        this.labBillingId = labBillingId;
    }

    public String getLabBillingId() {
        return labBillingId;
    }

    public void setLabBillingId(String labBillingId) {
        this.labBillingId = labBillingId;
    }

    public String getLabBillingDate() {
        return labBillingDate;
    }

    public void setLabBillingDate(String labBillingDate) {
        this.labBillingDate = labBillingDate;
    }

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

    public String getMothId() {
        return mothId;
    }

    public void setMothId(String mothId) {
        this.mothId = mothId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
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

    public String getLabBillingActive() {
        return labBillingActive;
    }

    public void setLabBillingActive(String labBillingActive) {
        this.labBillingActive = labBillingActive;
    }

    public String getStatusImport() {
        return statusImport;
    }

    public void setStatusImport(String statusImport) {
        this.statusImport = statusImport;
    }

    public Double getCntLab() {
        return cntLab;
    }

    public void setCntLab(Double cntLab) {
        this.cntLab = cntLab;
    }

    public Double getSumLab() {
        return sumLab;
    }

    public void setSumLab(Double sumLab) {
        this.sumLab = sumLab;
    }

    public Double getCntNoLabId() {
        return cntNoLabId;
    }

    public void setCntNoLabId(Double cntNoLabId) {
        this.cntNoLabId = cntNoLabId;
    }

    public Double getCntNoHn() {
        return cntNoHn;
    }

    public void setCntNoHn(Double cntNoHn) {
        this.cntNoHn = cntNoHn;
    }

    public Double getCntNoPriceSale1() {
        return cntNoPriceSale1;
    }

    public void setCntNoPriceSale1(Double cntNoPriceSale1) {
        this.cntNoPriceSale1 = cntNoPriceSale1;
    }

    public Double getCntNoPriceSale2() {
        return cntNoPriceSale2;
    }

    public void setCntNoPriceSale2(Double cntNoPriceSale2) {
        this.cntNoPriceSale2 = cntNoPriceSale2;
    }

    public String getPeriodId() {
        return periodId;
    }
    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labBillingId != null ? labBillingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabTBilling)) {
            return false;
        }
        LabTBilling other = (LabTBilling) object;
        if ((this.labBillingId == null && other.labBillingId != null) || (this.labBillingId != null && !this.labBillingId.equals(other.labBillingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnalab.LabTBilling[labBillingId=" + labBillingId + "]";
    }

}
