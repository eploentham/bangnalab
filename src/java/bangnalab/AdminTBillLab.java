package bangnalab;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;
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
@Table(name = "admin_t_bill_lab", catalog = "bangna", schema = "public")
@NamedQueries({@NamedQuery(name = "AdminTBillLab.findAll", query = "SELECT a FROM AdminTBillLab a"), @NamedQuery(name = "AdminTBillLab.findByBillLabId", query = "SELECT a FROM AdminTBillLab a WHERE a.billLabId = :billLabId"), @NamedQuery(name = "AdminTBillLab.findByBillLabDescription", query = "SELECT a FROM AdminTBillLab a WHERE a.billLabDescription = :billLabDescription"), @NamedQuery(name = "AdminTBillLab.findByBillLabDate", query = "SELECT a FROM AdminTBillLab a WHERE a.billLabDate = :billLabDate"), @NamedQuery(name = "AdminTBillLab.findByDateBillReceive", query = "SELECT a FROM AdminTBillLab a WHERE a.dateBillReceive = :dateBillReceive"), @NamedQuery(name = "AdminTBillLab.findByDateBillMake", query = "SELECT a FROM AdminTBillLab a WHERE a.dateBillMake = :dateBillMake"), @NamedQuery(name = "AdminTBillLab.findByTotalRecordReceive", query = "SELECT a FROM AdminTBillLab a WHERE a.totalRecordReceive = :totalRecordReceive"), @NamedQuery(name = "AdminTBillLab.findByTotalAmountReceive", query = "SELECT a FROM AdminTBillLab a WHERE a.totalAmountReceive = :totalAmountReceive"), @NamedQuery(name = "AdminTBillLab.findByBillLabRemark", query = "SELECT a FROM AdminTBillLab a WHERE a.billLabRemark = :billLabRemark"), @NamedQuery(name = "AdminTBillLab.findByUserIdCreate", query = "SELECT a FROM AdminTBillLab a WHERE a.userIdCreate = :userIdCreate"), @NamedQuery(name = "AdminTBillLab.findByUserIdModify", query = "SELECT a FROM AdminTBillLab a WHERE a.userIdModify = :userIdModify"), @NamedQuery(name = "AdminTBillLab.findByUserIdCancel", query = "SELECT a FROM AdminTBillLab a WHERE a.userIdCancel = :userIdCancel"), @NamedQuery(name = "AdminTBillLab.findByDateCreate", query = "SELECT a FROM AdminTBillLab a WHERE a.dateCreate = :dateCreate"), @NamedQuery(name = "AdminTBillLab.findByDateModify", query = "SELECT a FROM AdminTBillLab a WHERE a.dateModify = :dateModify"), @NamedQuery(name = "AdminTBillLab.findByDateCancel", query = "SELECT a FROM AdminTBillLab a WHERE a.dateCancel = :dateCancel"), @NamedQuery(name = "AdminTBillLab.findByBillLabActive", query = "SELECT a FROM AdminTBillLab a WHERE a.billLabActive = :billLabActive"), @NamedQuery(name = "AdminTBillLab.findByBillLabStatus", query = "SELECT a FROM AdminTBillLab a WHERE a.billLabStatus = :billLabStatus"), @NamedQuery(name = "AdminTBillLab.findByBillLabMonth", query = "SELECT a FROM AdminTBillLab a WHERE a.billLabMonth = :billLabMonth"), @NamedQuery(name = "AdminTBillLab.findByBillLabYear", query = "SELECT a FROM AdminTBillLab a WHERE a.billLabYear = :billLabYear"), @NamedQuery(name = "AdminTBillLab.findByBillLabPeriod", query = "SELECT a FROM AdminTBillLab a WHERE a.billLabPeriod = :billLabPeriod"), @NamedQuery(name = "AdminTBillLab.findByTotalRecordApprove", query = "SELECT a FROM AdminTBillLab a WHERE a.totalRecordApprove = :totalRecordApprove"), @NamedQuery(name = "AdminTBillLab.findByTotalAmountApprove", query = "SELECT a FROM AdminTBillLab a WHERE a.totalAmountApprove = :totalAmountApprove")})
public class AdminTBillLab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "bill_lab_id", nullable = false, length = 255)
    private String billLabId="",billLabFilename="/Data/UpLoad/"+billLabId+".txt";
    @Column(name = "bill_lab_description", length = 255)
    private String billLabDescription="";
    @Column(name = "bill_lab_date", length = 255)
    private String billLabDate="";
    @Column(name = "date_bill_receive", length = 255)
    private String dateBillReceive="";
    @Column(name = "date_bill_make", length = 255)
    private String dateBillMake="";
    @Column(name = "total_record_receive")
    private Integer totalRecordReceive=0;
    @Column(name = "total_amount_receive", precision = 17, scale = 17)
    private Double totalAmountReceive=0.0;
    @Column(name = "bill_lab_remark", length = 255)
    private String billLabRemark="";
    @Column(name = "user_id_create", length = 255)
    private String userIdCreate="";
    @Column(name = "user_id_modify", length = 255)
    private String userIdModify="";
    @Column(name = "user_id_cancel", length = 255)
    private String userIdCancel="";
    @Column(name = "date_create", length = 255)
    private String dateCreate="";
    @Column(name = "date_modify", length = 255)
    private String dateModify="";
    @Column(name = "date_cancel", length = 255)
    private String dateCancel="";
    @Column(name = "bill_lab_active", length = 255)
    private String billLabActive="";
    @Column(name = "bill_lab_status", length = 255)
    private String billLabStatus="";
    @Column(name = "bill_lab_month", length = 255)
    private String billLabMonth="";
    @Column(name = "bill_lab_year", length = 255)
    private String billLabYear="";
    @Column(name = "bill_lab_period", length = 255)
    private String billLabPeriod="";
    @Column(name = "total_record_approve")
    private Integer totalRecordApprove=0;
    @Column(name = "total_amount_approve", precision = 17, scale = 17)
    private Double totalAmountApprove=0.0;
    @Column(name = "total_amount_unapprove", precision = 17, scale = 17)
    private Double totalAmountUnApprove=0.0;
    @Column(name = "total_record_unapprove", precision = 17, scale = 17)
    private Double totalRecordUnApprove=0.0;
    @Column(name = "branch_id", length = 255)
    private String branchId="";
    @Column(name = "filename")
    private String filename="";

    public String getFBillLabId() {
        return "bill_lab_id";
    }
    public String getFBillLabDescription() {
        return "bill_lab_description";
    }
    public String getFBillLabDate() {
        return "bill_lab_date";
    }
    public String getFDateBillReceive() {
        return "date_bill_receive";
    }
    public String getFDateBillMake() {
        return "date_bill_make";
    }
    public String getFTotalRecordReveive() {
        return "total_record_receive";
    }
    public String getFTotalAmountReceive() {
        return "total_amount_receive";
    }
    public String getFBillLabRemark() {
        return "bill_lab_remark";
    }
    public String getFUserIdCreate() {
        return "user_id_create";
    }
    public String getFUserIdModify() {
        return "user_id_modify";
    }
    public String getFUserIdCancel() {
        return "user_id_cancel";
    }
    public String getFDateCreate() {
        return "date_create";
    }
    public String getFDateModify() {
        return "date_modify";
    }
    public String getFDateCancel() {
        return "date_cancel";
    }
    public String getFBillLabActive() {
        return "bill_lab_active";
    }
    public String getFBillLabStatus() {
        return "bill_lab_status";
    }
    public String getFBillLabMonth() {
        return "bill_lab_month";
    }
    public String getFBillLabYear() {
        return "bill_lab_year";
    }
    public String getFBillLabPeriod() {
        return "bill_lab_period";
    }
    public String getFTotalRecordApprove() {
        return "total_record_approve";
    }
    public String getFTotalAmountApprove() {
        return "total_amount_approve";
    }
    public String getFTotalRecordUnApprove() {
        return "total_record_unapprove";
    }
    public String getFTotalAmountUnApprove() {
        return "total_amount_unapprove";
    }
    public String getFBranchId() {
        return "branch_id";
    }
    public String getFFilename() {
        return "filename";
    }

    public AdminTBillLab() {
    }
    public String getAdminTBillLab() {
        return "admin_t_bill_lab";
    }

    public AdminTBillLab(String billLabId) {
        this.billLabId = billLabId;
    }

    public String getBillLabId() {
        return billLabId;
    }
    public void setBillLabId(String billLabId) {
        this.billLabId = billLabId;
    }
    public Boolean setBillBlabDelete(String filename) {
        boolean exists = (new File(filename)).exists();
        boolean success = false;
        if (exists) {
            // File or directory exists
            success = (new File(filename)).delete();
        } else {
            success = true;
        }
        return success;
    }

    public String getBillLabDescription() {
        return billLabDescription;
    }

    public void setBillLabDescription(String billLabDescription) {
        this.billLabDescription = billLabDescription;
    }

    public String getBillLabDate() {
        return billLabDate;
    }

    public void setBillLabDate(String billLabDate) {
        this.billLabDate = billLabDate;
    }

    public String getDateBillReceive() {
        return dateBillReceive;
    }

    public void setDateBillReceive(String dateBillReceive) {
        this.dateBillReceive = dateBillReceive;
    }

    public String getDateBillMake() {
        return dateBillMake;
    }

    public void setDateBillMake(String dateBillMake) {
        this.dateBillMake = dateBillMake;
    }

    public Integer getTotalRecordReceive() {
        return totalRecordReceive;
    }

    public void setTotalRecordReceive(Integer totalRecordReceive) {
        this.totalRecordReceive = totalRecordReceive;
    }

    public Double getTotalAmountReceive() {
        return totalAmountReceive;
    }

    public void setTotalAmountReceive(Double totalAmountReceive) {
        this.totalAmountReceive = totalAmountReceive;
    }

    public String getBillLabRemark() {
        return billLabRemark;
    }

    public void setBillLabRemark(String billLabRemark) {
        this.billLabRemark = billLabRemark;
    }

    public String getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(String userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    public String getUserIdModify() {
        return userIdModify;
    }

    public void setUserIdModify(String userIdModify) {
        this.userIdModify = userIdModify;
    }

    public String getUserIdCancel() {
        return userIdCancel;
    }

    public void setUserIdCancel(String userIdCancel) {
        this.userIdCancel = userIdCancel;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateModify() {
        return dateModify;
    }

    public void setDateModify(String dateModify) {
        this.dateModify = dateModify;
    }

    public String getDateCancel() {
        return dateCancel;
    }

    public void setDateCancel(String dateCancel) {
        this.dateCancel = dateCancel;
    }

    public String getBillLabActive() {
        return billLabActive;
    }
    public void setBillLabActive(String billLabActive) {
        this.billLabActive = billLabActive;
    }

    public String getBillLabStatus() {
        return billLabStatus;
    }

    public void setBillLabStatus(String billLabStatus) {
        this.billLabStatus = billLabStatus;
    }

    public String getBillLabMonth() {
        return billLabMonth;
    }

    public void setBillLabMonth(String billLabMonth) {
        this.billLabMonth = billLabMonth;
    }

    public String getBillLabYear() {
        return billLabYear;
    }

    public void setBillLabYear(String billLabYear) {
        this.billLabYear = billLabYear;
    }

    public String getBillLabPeriod() {
        return billLabPeriod;
    }

    public void setBillLabPeriod(String billLabPeriod) {
        this.billLabPeriod = billLabPeriod;
    }

    public Integer getTotalRecordApprove() {
        return totalRecordApprove;
    }
    public void setTotalRecordApprove(Integer totalRecordApprove) {
        this.totalRecordApprove = totalRecordApprove;
    }

    public Double getTotalAmountApprove() {
        return totalAmountApprove;
    }
    public void setTotalAmountApprove(Double totalAmountApprove) {
        this.totalAmountApprove = totalAmountApprove;
    }

    public Double getTotalAmountUnApprove() {
        return totalAmountUnApprove;
    }
    public void setTotalAmountUnApprove(Double totalAmountUnApprove) {
        this.totalAmountUnApprove = totalAmountUnApprove;
    }

    public Double getTotalRecordUnApprove() {
        return totalRecordUnApprove;
    }
    public void setTotalRecordUnApprove(Double totalRecordUnApprove) {
        this.totalRecordUnApprove = totalRecordUnApprove;
    }

    public Boolean setBillLabDelete() {
        boolean exists = (new File(billLabFilename)).exists();
        boolean success = false;
        if (exists) {
            // File or directory exists
            success = (new File(billLabFilename)).delete();
        } else {
            success = true;
        }
        return success;
    }

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
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
        hash += (billLabId != null ? billLabId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminTBillLab)) {
            return false;
        }
        AdminTBillLab other = (AdminTBillLab) object;
        if ((this.billLabId == null && other.billLabId != null) || (this.billLabId != null && !this.billLabId.equals(other.billLabId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnaintranet.AdminTBillLab[billLabId=" + billLabId + "]";
    }

}
