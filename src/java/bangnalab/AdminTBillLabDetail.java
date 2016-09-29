package bangnalab;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



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
 * @author pop
 */
@Entity
@Table(name = "admin_t_bill_lab_detail", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "AdminTBillLabDetail.findAll", query = "SELECT a FROM AdminTBillLabDetail a"), @NamedQuery(name = "AdminTBillLabDetail.findByBillLabId", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.billLabId = :billLabId"), @NamedQuery(name = "AdminTBillLabDetail.findByBillLabDetailId", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.billLabDetailId = :billLabDetailId"), @NamedQuery(name = "AdminTBillLabDetail.findByLabId", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.labId = :labId"), @NamedQuery(name = "AdminTBillLabDetail.findByLabNamet", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.labNamet = :labNamet"), @NamedQuery(name = "AdminTBillLabDetail.findByPriceNormalReceive", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.priceNormalReceive = :priceNormalReceive"), @NamedQuery(name = "AdminTBillLabDetail.findByPriceDiscountReceive", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.priceDiscountReceive = :priceDiscountReceive"), @NamedQuery(name = "AdminTBillLabDetail.findByPriceApprove", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.priceApprove = :priceApprove"), @NamedQuery(name = "AdminTBillLabDetail.findByNettotalReceive", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.nettotalReceive = :nettotalReceive"), @NamedQuery(name = "AdminTBillLabDetail.findByNettotalApprove", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.nettotalApprove = :nettotalApprove"), @NamedQuery(name = "AdminTBillLabDetail.findByLabDetailActive", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.labDetailActive = :labDetailActive"), @NamedQuery(name = "AdminTBillLabDetail.findByLabStatus", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.labStatus = :labStatus"), @NamedQuery(name = "AdminTBillLabDetail.findByQtyReceive", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.qtyReceive = :qtyReceive"), @NamedQuery(name = "AdminTBillLabDetail.findByQtyApprove", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.qtyApprove = :qtyApprove"), @NamedQuery(name = "AdminTBillLabDetail.findByPatientHnNo", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.patientHnNo = :patientHnNo"), @NamedQuery(name = "AdminTBillLabDetail.findByPatientFullnamet", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.patientFullnamet = :patientFullnamet"), @NamedQuery(name = "AdminTBillLabDetail.findByDateOrder", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.dateOrder = :dateOrder"), @NamedQuery(name = "AdminTBillLabDetail.findByPatientVn", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.patientVn = :patientVn"), @NamedQuery(name = "AdminTBillLabDetail.findByStatusApprove", query = "SELECT a FROM AdminTBillLabDetail a WHERE a.statusApprove = :statusApprove")})
public class AdminTBillLabDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "bill_lab_id", length = 255)
    private String billLabId="";
    @Id
    @Basic(optional = false)
    @Column(name = "bill_lab_detail_id", nullable = false, length = 255)
    private String billLabDetailId="";
    @Column(name = "lab_id", length = 255)
    private String labId="";
    @Column(name = "lab_namet", length = 255)
    private String labNamet="";
    @Column(name = "price_normal_receive", precision = 17, scale = 17)
    private Double priceNormalReceive=0.0;
    @Column(name = "price_discount_receive", precision = 17, scale = 17)
    private Double priceDiscountReceive=0.0;
    @Column(name = "price_approve", precision = 17, scale = 17)
    private Double priceApprove=0.0;
    @Column(name = "nettotal_receive", precision = 17, scale = 17)
    private Double nettotalReceive=0.0;
    @Column(name = "nettotal_approve", precision = 17, scale = 17)
    private Double nettotalApprove=0.0;
    @Column(name = "lab_detail_active", length = 255)
    private String labDetailActive="";
    @Column(name = "lab_status", length = 255)
    private String labStatus="";
    @Column(name = "qty_receive", precision = 17, scale = 17)
    private Double qtyReceive=0.0;
    @Column(name = "qty_approve", precision = 17, scale = 17)
    private Double qtyApprove=0.0;
    @Column(name = "patient_hn_no", length = 255)
    private String patientHnNo="";
    @Column(name = "patient_fullnamet", length = 255)
    private String patientFullnamet="";
    @Column(name = "date_order", length = 255)
    private String dateOrder="";
    @Column(name = "patient_vn", length = 255)
    private String patientVn="";
    @Column(name = "status_approve", length = 255)
    private String statusApprove="";
    @Column(name = "status_audit", length = 255)
    private String statusAudit="";
    @Column(name = "qty_audit", precision = 17, scale = 17)
    private Double qtyAudit=0.0;
    @Column(name = "price_audit", precision = 17, scale = 17)
    private Double priceAudit=0.0;
    @Column(name = "nettotal_audit", precision = 17, scale = 17)
    private Double nettotalAudit=0.0;

    public AdminTBillLabDetail() {
    }
    public String getAdminTBillLabDetail() {
        return "admin_t_bill_lab_detail";
    }    
    public String getFBillLabId() {
        return "bill_lab_id";
    }
    public String getFBillLabDetailId() {
        return "bill_lab_detail_id";
    }
    public String getFLabId() {
        return "lab_id";
    }
    public String getFLabNamet() {
        return "lab_namet";
    }
    public String getFPriceNormalReceive() {
        return "price_normal_receive";
    }
    public String getFPriceDiscountReceive() {
        return "price_discount_receive";
    }
    public String getFPriceApprove() {
        return "price_approve";
    }
    public String getFPriceAudit() {
        return "price_audit";
    }
    public String getFNetTotalReceive() {
        return "nettotal_receive";
    }
    public String getFNetTotalApprove() {
        return "nettotal_approve";
    }
    public String getFNetTotalAudit() {
        return "nettotal_audit";
    }
    public String getFLabDetailActive() {
        return "lab_detail_active";
    }
    public String getFLabStatus() {
        return "lab_status";
    }
    public String getFQtyReceive() {
        return "qty_receive";
    }
    public String getFQtyApprove() {
        return "qty_approve";
    }
    public String getFQtyAudit() {
        return "qty_audit";
    }
    public String getFPatientHNNO() {
        return "patient_hn_no";
    }    
    public String getFPatientFullNamet() {
        return "patient_fullnamet";
    }
    public String getFDateOrder() {
        return "date_order";
    }
    public String getFPatientnVN() {
        return "patient_vn";
    }
    public String getFStatusApprove() {
        return "status_approve";
    }
    public String getFStatusAudit() {
        return "status_audit";
    }
    

    public AdminTBillLabDetail(String billLabDetailId) {
        this.billLabDetailId = billLabDetailId;
    }

    public String getBillLabId() {
        return billLabId;
    }

    public void setBillLabId(String billLabId) {
        this.billLabId = billLabId;
    }

    public String getBillLabDetailId() {
        return billLabDetailId;
    }

    public void setBillLabDetailId(String billLabDetailId) {
        this.billLabDetailId = billLabDetailId;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getLabNamet() {
        return labNamet;
    }

    public void setLabNamet(String labNamet) {
        this.labNamet = labNamet;
    }

    public Double getPriceNormalReceive() {
        return priceNormalReceive;
    }

    public void setPriceNormalReceive(Double priceNormalReceive) {
        this.priceNormalReceive = priceNormalReceive;
    }

    public Double getPriceDiscountReceive() {
        return priceDiscountReceive;
    }

    public void setPriceDiscountReceive(Double priceDiscountReceive) {
        this.priceDiscountReceive = priceDiscountReceive;
    }

    public Double getPriceAudit() {
        return priceAudit;
    }
    public void setPriceAudit(Double priceAudit) {
        this.priceAudit = priceAudit;
    }
    public Double getPriceApprove() {
        return priceApprove;
    }
    public void setPriceApprove(Double priceApprove) {
        this.priceApprove = priceApprove;
    }

    public Double getNettotalReceive() {
        return nettotalReceive;
    }
    public void setNettotalReceive(Double nettotalReceive) {
        this.nettotalReceive = nettotalReceive;
    }

    public Double getNettotalApprove() {
        return nettotalApprove;
    }
    public void setNettotalApprove(Double nettotalApprove) {
        this.nettotalApprove = nettotalApprove;
    }
    public Double getNettotalAudit() {
        return nettotalAudit;
    }
    public void setNettotalAudit(Double nettotalAudit) {
        this.nettotalAudit = nettotalAudit;
    }

    public String getLabDetailActive() {
        return labDetailActive;
    }

    public void setLabDetailActive(String labDetailActive) {
        this.labDetailActive = labDetailActive;
    }

    public String getLabStatus() {
        return labStatus;
    }

    public void setLabStatus(String labStatus) {
        this.labStatus = labStatus;
    }

    public Double getQtyReceive() {
        return qtyReceive;
    }

    public void setQtyReceive(Double qtyReceive) {
        this.qtyReceive = qtyReceive;
    }

    public Double getQtyApprove() {
        return qtyApprove;
    }

    public void setQtyApprove(Double qtyApprove) {
        this.qtyApprove = qtyApprove;
    }

    public String getPatientHnNo() {
        return patientHnNo;
    }

    public void setPatientHnNo(String patientHnNo) {
        this.patientHnNo = patientHnNo;
    }

    public String getPatientFullnamet() {
        return patientFullnamet;
    }

    public void setPatientFullnamet(String patientFullnamet) {
        this.patientFullnamet = patientFullnamet;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getPatientVn() {
        return patientVn;
    }

    public void setPatientVn(String patientVn) {
        this.patientVn = patientVn;
    }

    public String getStatusApprove() {
        return statusApprove;
    }
    public void setStatusApprove(String statusApprove) {
        this.statusApprove = statusApprove;
    }

    public String getStatusAudit() {
        return statusAudit;
    }
    public void setStatusAudit(String statusAudit) {
        this.statusAudit = statusAudit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billLabDetailId != null ? billLabDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminTBillLabDetail)) {
            return false;
        }
        AdminTBillLabDetail other = (AdminTBillLabDetail) object;
        if ((this.billLabDetailId == null && other.billLabDetailId != null) || (this.billLabDetailId != null && !this.billLabDetailId.equals(other.billLabDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.AdminTBillLabDetail[billLabDetailId=" + billLabDetailId + "]";
    }

}
