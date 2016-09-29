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
@Table(name = "lab_b_item")
@NamedQueries({
    @NamedQuery(name = "LabBItem.findAll", query = "SELECT l FROM LabBItem l")})
public class LabBItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lab_item_id")
    private String labItemId="";
    @Column(name = "lab_item_number")
    private String labItemNumber="";
    @Column(name = "lab_item_name")
    private String labItemName="";
    @Column(name = "branch_id")
    private String branchId="";
    @Column(name = "price_sale1")
    private Double priceSale1=.0;
    @Column(name = "price_sale2")
    private Double priceSale2=0.0;
    @Column(name = "price_sale3")
    private Double priceSale3=0.0;
    @Column(name = "price_sale4")
    private Double priceSale4=0.0;
    @Column(name = "price_sale5")
    private Double priceSale5=0.0;
    @Column(name = "status_price")
    private String statusPrice="";
    @Column(name = "status_discount")
    private String statusDiscount="";
    @Column(name = "remark")
    private String remark="";
    @Column(name = "lab_item_active")
    private String labItemActive="";
    @Column(name = "status_outlab")
    private String statusOutlab="";

    public LabBItem() {
    }

    public String getLabBItem(){
        return "lab_b_item";
    }

    public String getFLabItemId(){
        return "lab_item_id";
    }
    public String getFLabItemNumber(){
        return "lab_item_number";
    }
    public String getFLabItemName(){
        return "lab_item_name";
    }
    public String getFBranchId(){
        return "branch_id";
    }
    public String getFPriceSale1(){
        return "price_sale1";
    }
    public String getFPriceSale2(){
        return "price_sale2";
    }
    public String getFPriceSale3(){
        return "price_sale3";
    }
    public String getFPriceSale4(){
        return "price_sale4";
    }
    public String getFPriceSale5(){
        return "price_sale5";
    }
    public String getFStatusPrice(){
        return "status_price";
    }
    public String getFStatusDiscount(){
        return "status_discount";
    }
    public String getFRemark(){
        return "remark";
    }
    public String getFLabItemActive(){
        return "lab_item_active";
    }
    public String getFStatusOutlab(){
        return "status_outlab";
    }

    public LabBItem(String labItemId) {
        this.labItemId = labItemId;
    }

    public String getLabItemId() {
        return labItemId;
    }
    public void setLabItemId(String labItemId) {
        this.labItemId = labItemId;
    }

    public String getLabItemNumber() {
        return labItemNumber;
    }
    public void setLabItemNumber(String labItemNumber) {
        this.labItemNumber = labItemNumber;
    }

    public String getLabItemName() {
        return labItemName;
    }
    public void setLabItemName(String labItemName) {
        this.labItemName = labItemName;
    }

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public Double getPriceSale1() {
        return priceSale1;
    }
    public void setPriceSale1(Double priceSale1) {
        this.priceSale1 = priceSale1;
    }

    public Double getPriceSale2() {
        return priceSale2;
    }
    public void setPriceSale2(Double priceSale2) {
        this.priceSale2 = priceSale2;
    }

    public Double getPriceSale3() {
        return priceSale3;
    }
    public void setPriceSale3(Double priceSale3) {
        this.priceSale3 = priceSale3;
    }

    public Double getPriceSale4() {
        return priceSale4;
    }
    public void setPriceSale4(Double priceSale4) {
        this.priceSale4 = priceSale4;
    }

    public Double getPriceSale5() {
        return priceSale5;
    }
    public void setPriceSale5(Double priceSale5) {
        this.priceSale5 = priceSale5;
    }

    public String getStatusPrice() {
        return statusPrice;
    }
    public void setStatusPrice(String statusPrice) {
        this.statusPrice = statusPrice;
    }

    public String getStatusDiscount() {
        return statusDiscount;
    }
    public void setStatusDiscount(String statusDiscount) {
        this.statusDiscount = statusDiscount;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLabItemActive() {
        return labItemActive;
    }
    public void setLabItemActive(String labItemActive) {
        this.labItemActive = labItemActive;
    }

    public String getStatusOutlab() {
        return statusOutlab;
    }
    public void setStatusOutlab(String statusOutlab) {
        this.statusOutlab = statusOutlab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (labItemId != null ? labItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LabBItem)) {
            return false;
        }
        LabBItem other = (LabBItem) object;
        if ((this.labItemId == null && other.labItemId != null) || (this.labItemId != null && !this.labItemId.equals(other.labItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnalab.LabBItem[labItemId=" + labItemId + "]";
    }

}
