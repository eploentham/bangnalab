/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnalab;

import bangnaLibrary.Config1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author root
 */
public class LabBillingDB {
    public LabBItem lbi = new LabBItem();
    public LabTBilling ltb = new LabTBilling();
    public LabTBillingItem ltb_i = new LabTBillingItem();
    public LabBPaid lbp = new LabBPaid();
    public Config1 config1 = new Config1();
    Row row = null;
    Cell c_fname = null;// first name
    Integer col_doc=0, col_date=1, col_hn=2, col_fullname=3, col_type_lab=4, col_lab_id=5, col_lab_name=6, col_price1=7, col_price2=8;
    Integer col_price3=9, col_price4=10, col_price5=11;
    StringBuilder dDoc = new StringBuilder();
    StringBuilder dDate = new StringBuilder();
    StringBuilder dFullname = new StringBuilder();
    StringBuilder dTypeLab = new StringBuilder();
    StringBuilder dLabId = new StringBuilder();
    StringBuilder dLabName = new StringBuilder();
    StringBuilder dPrice1 = new StringBuilder();
    StringBuilder dPrice2 = new StringBuilder();
    StringBuilder dPrice3 = new StringBuilder();
    StringBuilder dPrice4 = new StringBuilder();
    StringBuilder dPrice5 = new StringBuilder();
    StringBuilder dHn = new StringBuilder();

    public String getMaxRowLabBItem(Statement st) {
        String sql = "", max = "";
        try {
            //      Statement st = conn.createStatement();
            sql = "Select max(" + lbi.getFLabItemId() + ") as cnt "
                    + "From " + lbi.getLabBItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1990000001";
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowLabTBilling(Statement st) {
        String sql = "", max = "";
        try {
            //      Statement st = conn.createStatement();
            sql = "Select max(" + ltb.getFLabBillingId() + ") as cnt "
                    + "From " + ltb.getLabTBilling();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals(""))) 
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "1980000001";
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowLabTBillingItem(Statement st) {
        String sql = "", max = "";
        try {
            //      Statement st = conn.createStatement();
            sql = "Select max(" + ltb_i.getFLabBillingItemId() + ") as cnt "
                    + "From " + ltb_i.getLabTBillingItem();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if ((max != null) && (!max.equals("")))
                max = String.valueOf(Integer.parseInt(max) + 1);
            else
                max = "2000000001";
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public LabBItem getLabBItemByPK(String branch_id, String labId,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            lbi = getLabBItemByPK(stbangna, branch_id, labId, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lbi;
    }
    public LabBItem getLabBItemByPK(Statement st,String branch_id, String labId, String flag) {
        String sql = "";
        try {
            lbi = new LabBItem();
            if(flag.equals("billing_payment")){
                sql = "Select * "
                +"From "+lbi.getLabBItem() + " "
                +"Where "+lbi.getFLabItemId() + "='" + labId + "'  ";
            }else if(flag.equals("lab_number")){
                sql = "Select * From " + lbi.getLabBItem() + " "
                  + "Where " + lbi.getFLabItemNumber() + "='" + labId + "' and "+lbi.getFBranchId()+"='"+branch_id+"'";
            }else{
                sql = "Select * From " + lbi.getLabBItem() + " "
                  + "Where " + lbi.getFLabItemId() + "='" + labId + "'";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lbi = new LabBItem();
                lbi.setBranchId(config1.StringNull(rs.getString(lbi.getFBranchId())));
                lbi.setLabItemActive(config1.StringNull(rs.getString(lbi.getFLabItemActive())));
                lbi.setLabItemId(config1.StringNull(rs.getString(lbi.getFLabItemId())));
                lbi.setLabItemName(config1.StringNull(rs.getString(lbi.getFLabItemName())));
                lbi.setLabItemNumber(config1.StringNull(rs.getString(lbi.getFLabItemNumber())));

                lbi.setPriceSale1(rs.getDouble(lbi.getFPriceSale1()));
                lbi.setPriceSale2(rs.getDouble(lbi.getFPriceSale2()));
                lbi.setPriceSale3(rs.getDouble(lbi.getFPriceSale3()));
                lbi.setPriceSale4(rs.getDouble(lbi.getFPriceSale4()));
                lbi.setPriceSale5(rs.getDouble(lbi.getFPriceSale5()));

                lbi.setRemark(config1.StringNull(rs.getString(lbi.getFRemark())));
                lbi.setStatusDiscount(config1.StringNull(rs.getString(lbi.getFStatusDiscount())));
                lbi.setStatusOutlab(config1.StringNull(rs.getString(lbi.getFStatusOutlab())));
                lbi.setStatusPrice(config1.StringNull(rs.getString(lbi.getFStatusPrice())));
            }

            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lbi;
    }
    public Vector getLabBItem(String branch_id, String labId,  String flag){
        Vector v_lbi = new Vector();
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_lbi = getLabBItem(stbangna, branch_id, labId, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_lbi;
    }
    public Vector getLabBItem(Statement st,String branch_id, String labId, String flag) {
        Vector v_lbi = new Vector();
        String sql = "";
        try {
            if(flag.equals("billing_payment")){
                sql = "Select * "
                +"From "+lbi.getLabBItem() + " "
                +"Where "+lbi.getFLabItemId() + "='" + labId + "'  ";
            }else if(flag.equals("billing_payment")){
                sql = "Select * From " + lbi.getLabBItem() + " "
                  + "Where " + lbi.getFLabItemNumber() + "='" + labId + "' and "+lbi.getFBranchId()+"='"+branch_id+"'";
            }else{
                sql = "Select * From " + lbi.getLabBItem() + " "
                  + "Where " + lbi.getFLabItemId() + "='" + labId + "'";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lbi = new LabBItem();
                lbi.setBranchId(config1.StringNull(rs.getString(lbi.getFBranchId())));
                lbi.setLabItemActive(config1.StringNull(rs.getString(lbi.getFLabItemActive())));
                lbi.setLabItemId(config1.StringNull(rs.getString(lbi.getFLabItemId())));
                lbi.setLabItemName(config1.StringNull(rs.getString(lbi.getFLabItemName())));
                lbi.setLabItemNumber(config1.StringNull(rs.getString(lbi.getFLabItemNumber())));

                lbi.setPriceSale1(rs.getDouble(lbi.getFPriceSale1()));
                lbi.setPriceSale2(rs.getDouble(lbi.getFPriceSale2()));
                lbi.setPriceSale3(rs.getDouble(lbi.getFPriceSale3()));
                lbi.setPriceSale4(rs.getDouble(lbi.getFPriceSale4()));
                lbi.setPriceSale5(rs.getDouble(lbi.getFPriceSale5()));

                lbi.setRemark(config1.StringNull(rs.getString(lbi.getFRemark())));
                lbi.setStatusDiscount(config1.StringNull(rs.getString(lbi.getFStatusDiscount())));
                lbi.setStatusOutlab(config1.StringNull(rs.getString(lbi.getFStatusOutlab())));
                lbi.setStatusPrice(config1.StringNull(rs.getString(lbi.getFStatusPrice())));

                v_lbi.add(lbi);
            }

            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_lbi;
    }
    public LabTBilling getLabTBillingByPK(String branch_id, String ltb_id,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            ltb = getLabTBillingByPK(stbangna, branch_id, ltb_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltb;
    }
    public LabTBilling getLabTBillingByPK(Statement st,String branchId, String ltbId, String flag) {
        String sql = "";
        try {
            if(flag.equals("billing_payment")){
                sql = "Select * "
                +"From "+ltb.getLabTBilling() + " "
                +"Where "+ltb.getFLabBillingId() + "='" + ltbId + "' ";
            }else{
                sql = "Select * From " + ltb.getLabTBilling() + " "
                  + "Where " + ltb.getFLabBillingId() + "='" + ltbId + "' ";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ltb = new LabTBilling();
                ltb.setBranchId(config1.StringNull(rs.getString(ltb.getFBranchId())));
                ltb.setCntLab(rs.getDouble(ltb.getFCntLab()));
                ltb.setCntNoHn(rs.getDouble(ltb.getFCntNoHn()));
                ltb.setCntNoLabId(rs.getDouble(ltb.getFCntNoLabId()));
                ltb.setCntNoPriceSale1(rs.getDouble(ltb.getFCntNoPriceSale1()));

                ltb.setCntNoPriceSale2(rs.getDouble(ltb.getFCntNoPriceSale2()));
                ltb.setDescription(config1.StringNull(rs.getString(ltb.getFDescription())));
                ltb.setLabBillingActive(config1.StringNull(rs.getString(ltb.getFLabBillingActive())));
                ltb.setLabBillingDate(config1.StringNull(rs.getString(ltb.getFLabBillingDate())));
                ltb.setLabBillingId(config1.StringNull(rs.getString(ltb.getFLabBillingId())));

                ltb.setMothId(config1.StringNull(rs.getString(ltb.getFMothId())));
                ltb.setPeriodId(config1.StringNull(rs.getString(ltb.getFPeriodId())));
                ltb.setRemark(config1.StringNull(rs.getString(ltb.getFRemark())));
                ltb.setStatusImport(config1.StringNull(rs.getString(ltb.getFStatusImport())));
                ltb.setSumLab(rs.getDouble(ltb.getFSumLab()));

                ltb.setYearId(config1.StringNull(rs.getString(ltb.getFYearId())));
                ltb.setFilename(config1.StringNull(rs.getString(ltb.getFFilename())));
            }

            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltb;
    }
    public Vector getLabTBilling(String branch_id, String ltbId,  String flag){
        Vector vLtb = new Vector();
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            vLtb = getLabTBilling(stbangna, branch_id, ltbId, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vLtb;
    }
    public Vector getLabTBilling(Statement st,String branchId, String ltbId, String flag) {
        Vector v_lbt = new Vector();
        String sql = "";
        try {
            if(flag.equals("billing_payment")){
                sql = "Select * "
                +"From "+ltb.getLabTBilling() + " "
                +"Where "+ltb.getFLabBillingId() + "='" + ltbId + "' ";
            }else if(flag.equals("year_id")){
                sql = "Select * "
                +"From "+ltb.getLabTBilling() + " "
                +"Where "+ltb.getFYearId() + "='" + ltbId + "'  and "+ltb.getFLabBillingActive()+"='1' and "+ltb.getFBranchId()+"='"+branchId+"'";
            }else{
                sql = "Select * From " + ltb.getLabTBilling() + " "
                  + "Where " + ltb.getFLabBillingId() + "='" + ltbId + "'";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ltb = new LabTBilling();
                ltb.setBranchId(config1.StringNull(rs.getString(ltb.getFBranchId())));
                ltb.setCntLab(rs.getDouble(ltb.getFCntLab()));
                ltb.setCntNoHn(rs.getDouble(ltb.getFCntNoHn()));
                ltb.setCntNoLabId(rs.getDouble(ltb.getFCntNoLabId()));
                ltb.setCntNoPriceSale1(rs.getDouble(ltb.getFCntNoPriceSale1()));

                ltb.setCntNoPriceSale2(rs.getDouble(ltb.getFCntNoPriceSale2()));
                ltb.setDescription(config1.StringNull(rs.getString(ltb.getFDescription())));
                ltb.setLabBillingActive(config1.StringNull(rs.getString(ltb.getFLabBillingActive())));
                ltb.setLabBillingDate(config1.StringNull(rs.getString(ltb.getFLabBillingDate())));
                ltb.setLabBillingId(config1.StringNull(rs.getString(ltb.getFLabBillingId())));

                ltb.setMothId(config1.StringNull(rs.getString(ltb.getFMothId())));
                ltb.setPeriodId(config1.StringNull(rs.getString(ltb.getFPeriodId())));
                ltb.setRemark(config1.StringNull(rs.getString(ltb.getFRemark())));
                ltb.setStatusImport(config1.StringNull(rs.getString(ltb.getFStatusImport())));
                ltb.setSumLab(rs.getDouble(ltb.getFSumLab()));

                ltb.setYearId(config1.StringNull(rs.getString(ltb.getFYearId())));
                v_lbt.add(ltb);
            }

            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_lbt;
    }
    public LabTBillingItem getLabTBillingItemByPK(String branch_id, String labId,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            ltb_i = getLabTBillingItemByPK(stbangna, branch_id, labId, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltb_i;
    }
    public LabTBillingItem getLabTBillingItemByPK(Statement st,String branch_id, String labIId, String flag) {
        String sql = "";
        try {
            ltb_i = new LabTBillingItem();
            if(flag.equals("billing_payment")){
                sql = "Select * "
                +"From "+ltb_i.getLabTBillingItem() + " "
                +"Where "+ltb_i.getFLabBillingItemId() + "='" + labIId + "'  ";
            }else{
                sql = "Select * From " + ltb_i.getLabTBillingItem() + " "
                  + "Where " + ltb_i.getFLabBillingItemId() + "='" + labIId + "'";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ltb_i = new LabTBillingItem();
                ltb_i.setDiscountPer(rs.getDouble(ltb_i.getFDiscountPer()));
                ltb_i.setDiscountPrice(rs.getDouble(ltb_i.getFDiscountPrice()));
                ltb_i.setDocId(config1.StringNull(rs.getString(ltb_i.getFDocId())));
                ltb_i.setItemCommonName(config1.StringNull(rs.getString(ltb_i.getFItemCommonName())));
                ltb_i.setItemNumber(config1.StringNull(rs.getString(ltb_i.getFItemNumber())));

                ltb_i.setLabBillingId(config1.StringNull(rs.getString(ltb_i.getFLabBillingId())));
                ltb_i.setLabBillingItemActive(config1.StringNull(rs.getString(ltb_i.getFLabBillingItemActive())));
                ltb_i.setLabBillingItemId(config1.StringNull(rs.getString(ltb_i.getFLabBillingItemId())));
                ltb_i.setOrderDate(config1.StringNull(rs.getString(ltb_i.getFOrderDate())));
                ltb_i.setPaidNamet(config1.StringNull(rs.getString(ltb_i.getFPaidNamet())));

                ltb_i.setPatientFullname(config1.StringNull(rs.getString(ltb_i.getFPatientFullname())));
                ltb_i.setPriceNet(rs.getDouble(ltb_i.getFPriceNet()));
                ltb_i.setPriceSale(rs.getDouble(ltb_i.getFPriceSale()));
                ltb_i.setPriceSale1(rs.getDouble(ltb_i.getFPriceSale1()));
                ltb_i.setPriceSale2(rs.getDouble(ltb_i.getFPriceSale2()));

                ltb_i.setPriceSale3(rs.getDouble(ltb_i.getFPriceSale3()));
                ltb_i.setPriceSale4(rs.getDouble(ltb_i.getFPriceSale4()));
                ltb_i.setPriceSale5(rs.getDouble(ltb_i.getFPriceSale5()));
                ltb_i.setRemark(config1.StringNull(rs.getString(ltb_i.getFRemark())));
                ltb_i.setRowId(rs.getDouble(ltb_i.getFRowId()));

                ltb_i.setStatusPrice(config1.StringNull(rs.getString(ltb_i.getFStatusPrice())));
                ltb_i.setVisitHn(config1.StringNull(rs.getString(ltb_i.getFVisitHn())));
            }

            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ltb_i;
    }
    public Vector getLabTBillingItem(String branch_id, String ltb_id, String ltb_i_id,  String flag){
        Vector v_ltb_i = new Vector();
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            v_ltb_i = getLabTBillingItem(stbangna, branch_id, ltb_id, ltb_i_id, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_ltb_i;
    }
    public Vector getLabTBillingItem(Statement st,String branch_id, String ltbId, String where, String flag) {
        Vector v_ltb_i = new Vector();
        String sql = "";
        try {
            if(flag.equals("billing_payment")) {
                sql = "Select * "
                +"From "+ltb_i.getLabTBillingItem() + " "
                +"Where "+ltb_i.getFLabBillingItemId() + "='" + ltbId + "'  ";
            }else if(flag.equals("lab_t_billing")){
                sql = "Select ltb_i.* "
                + "From " + ltb_i.getLabTBillingItem() + " ltb_i "
                + "left join "+ltb.getLabTBilling()+" ltb on ltb."+ltb.getFLabBillingId()+" = ltb_i."+ltb_i.getFLabBillingId()+" "
                + "Where ltb." + ltb_i.getFLabBillingId() + "='" + ltbId + "' and ltb."+ltb.getFBranchId()+" ='"+branch_id+"'";
            }else if(flag.equals("paid_namet")){
                sql = "Select ltb_i.* "
                + "From " + ltb_i.getLabTBillingItem() + " ltb_i "
                + "left join "+ltb.getLabTBilling()+" ltb on ltb."+ltb.getFLabBillingId()+" = ltb_i."+ltb_i.getFLabBillingId()+" "
                + "Where ltb_i." + ltb_i.getFLabBillingId() + "='" + ltbId + "' and ltb."+ltb.getFBranchId()+" ='"+branch_id+"' and ltb_i."
                + ltb_i.getFPaidNamet()+" = '"+where+"' "
                + "Order By ltb_i."+ltb_i.getFRowId();
            }else {
                sql = "Select * From " + ltb_i.getLabTBillingItem() + " "
                  + "Where " + ltb_i.getFLabBillingItemId() + "='" + ltbId + "'";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ltb_i = new LabTBillingItem();
                ltb_i.setDiscountPer(rs.getDouble(ltb_i.getFDiscountPer()));
                ltb_i.setDiscountPrice(rs.getDouble(ltb_i.getFDiscountPrice()));
                ltb_i.setDocId(config1.StringNull(rs.getString(ltb_i.getFDocId())));
                ltb_i.setItemCommonName(config1.StringNull(rs.getString(ltb_i.getFItemCommonName())));
                ltb_i.setItemNumber(config1.StringNull(rs.getString(ltb_i.getFItemNumber())));

                ltb_i.setLabBillingId(config1.StringNull(rs.getString(ltb_i.getFLabBillingId())));
                ltb_i.setLabBillingItemActive(config1.StringNull(rs.getString(ltb_i.getFLabBillingItemActive())));
                ltb_i.setLabBillingItemId(config1.StringNull(rs.getString(ltb_i.getFLabBillingItemId())));
                ltb_i.setOrderDate(config1.StringNull(rs.getString(ltb_i.getFOrderDate())));
                ltb_i.setPaidNamet(config1.StringNull(rs.getString(ltb_i.getFPaidNamet())));

                ltb_i.setPatientFullname(config1.StringNull(rs.getString(ltb_i.getFPatientFullname())));
                ltb_i.setPriceNet(rs.getDouble(ltb_i.getFPriceNet()));
                ltb_i.setPriceSale(rs.getDouble(ltb_i.getFPriceSale()));
                ltb_i.setPriceSale1(rs.getDouble(ltb_i.getFPriceSale1()));
                ltb_i.setPriceSale2(rs.getDouble(ltb_i.getFPriceSale2()));

                ltb_i.setPriceSale3(rs.getDouble(ltb_i.getFPriceSale3()));
                ltb_i.setPriceSale4(rs.getDouble(ltb_i.getFPriceSale4()));
                ltb_i.setPriceSale5(rs.getDouble(ltb_i.getFPriceSale5()));
                ltb_i.setRemark(config1.StringNull(rs.getString(ltb_i.getFRemark())));
                ltb_i.setRowId(rs.getDouble(ltb_i.getFRowId()));

                ltb_i.setStatusPrice(config1.StringNull(rs.getString(ltb_i.getFStatusPrice())));
                ltb_i.setVisitHn(config1.StringNull(rs.getString(ltb_i.getFVisitHn())));
                v_ltb_i.add(ltb_i);
            }

            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_ltb_i;
    }
    public LabBPaid getLabBPaidByPK(String branchId, String labId,  String flag){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            lbp = getLabBPaidByPK(stbangna, branchId, labId, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lbp;
    }
    public LabBPaid getLabBPaidByPK(Statement st,String branchId, String labIId, String flag) {
        String sql = "";
        try {
            if(flag.equals("billing_payment")){
                sql = "Select * "
                +"From "+lbp.getLabBPaid() + " "
                +"Where "+lbp.getFLabPaidId() + "='" + labIId + "'  ";
            }else if(flag.equals("paid_namet")){
                sql = "Select * "
                +"From "+lbp.getLabBPaid() + " "
                +"Where "+lbp.getFPaidNamet() + "='" + labIId + "'  ";
            }else{
                sql = "Select * From " + lbp.getLabBPaid() + " "
                  + "Where " + lbp.getFLabPaidId() + "='" + labIId + "'";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lbp = new LabBPaid();
                lbp.setDiscount(rs.getDouble(lbp.getFDiscount()));
                lbp.setLabPaidId(config1.StringNull(rs.getString(lbp.getFLabPaidId())));
                lbp.setPaidNamet(config1.StringNull(rs.getString(lbp.getFPaidNamet())));
                lbp.setRemark(config1.StringNull(rs.getString(lbp.getFRemark())));
                lbp.setStatusdiscount(config1.StringNull(rs.getString(lbp.getFStatusDiscount())));
            }

            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lbp;
    }
    public Vector getLabBPaid(String branchId, String labId,  String flag){
        Connection conn;
        Vector vLbp = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            vLbp = getLabBPaid(stbangna, branchId, labId, flag);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vLbp;
    }
    public Vector getLabBPaid(Statement st,String branchId, String labIId, String flag) {
        String sql = "";
        Vector vLbp = new Vector();
        try {
            if(flag.equals("billing_payment")){
                sql = "Select * "
                +"From "+lbp.getLabBPaid() + " "
                +"Where "+lbp.getFLabPaidId() + "='" + labIId + "'  ";
            }else{
                sql = "Select * From " + lbp.getLabBPaid() + " "
                  + "Where " + lbp.getFLabPaidId() + "='" + labIId + "'";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lbp = new LabBPaid();
                lbp.setDiscount(rs.getDouble(lbp.getFDiscount()));
                lbp.setLabPaidId(config1.StringNull(rs.getString(lbp.getFLabPaidId())));
                lbp.setPaidNamet(config1.StringNull(rs.getString(lbp.getFPaidNamet())));
                lbp.setRemark(config1.StringNull(rs.getString(lbp.getFRemark())));
                lbp.setStatusdiscount(config1.StringNull(rs.getString(lbp.getFStatusDiscount())));
                vLbp.add(lbp);
            }

            rs.close();
        } catch (Exception ex) {
          Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vLbp;
    }
    public String setSaveLabBItem(LabBItem item){
        Connection conn;
        String max="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            max = setSaveLabBItem(stbangna, item);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setSaveLabBItem(Statement st, LabBItem item) throws Exception {
        int chk=0;
        String sql="", max="", attend_date="";
        try {
            lbi = getLabBItemByPK(st,item.getBranchId(),item.getLabItemId(),"");
            item.setLabItemName(item.getLabItemName().replace("'", "''"));
            item.setRemark(item.getRemark().replace("'", "''"));

            if(lbi.getLabItemId().equals("")){
                max = getMaxRowLabBItem(st);
                sql="Insert Into "+lbi.getLabBItem()+"("
                        +lbi.getFLabItemId()+", "+lbi.getFBranchId()+", "
                        +lbi.getFLabItemActive()+","+ lbi.getFLabItemName()+","
                        +lbi.getFLabItemNumber()+","+ lbi.getFPriceSale1()+","
                        +lbi.getFPriceSale2()+","+ lbi.getFPriceSale3()+","
                        +lbi.getFPriceSale4()+","+ lbi.getFPriceSale5()+","
                        +lbi.getFRemark()+","+ lbi.getFStatusDiscount()+","
                        +lbi.getFStatusOutlab()+","+ lbi.getFStatusPrice()+") "
                        +"Values('"+max+"','"+item.getBranchId()+"','"
                        +item.getLabItemActive() + "','"+ item.getLabItemName()+"','"
                        +item.getLabItemNumber() + "',"+ item.getPriceSale1()+","
                        +item.getPriceSale2() + ","+ item.getPriceSale3()+","
                        +item.getPriceSale4() + ","+ item.getPriceSale5()+",'"
                        +item.getRemark() + "','"+ item.getStatusDiscount()+"','"
                        +item.getStatusOutlab() + "','"+ item.getStatusPrice()+"')";
            }else{
            }
            chk = st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setSaveLabTBilling(LabTBilling item){
        Connection conn;
        String max="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            max = setSaveLabTBilling(stbangna, item);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setSaveLabTBilling(Statement st, LabTBilling item) throws Exception {
        int chk=0;
        String sql="", max="", attend_date="";
        try {
            ltb = getLabTBillingByPK(st,item.getBranchId(),item.getLabBillingId(),"");
            item.setDescription(item.getDescription().replace("'", "''"));
            item.setRemark(item.getRemark().replace("'", "''"));

            if(ltb.getLabBillingId().equals("")){
                max = getMaxRowLabTBilling(st);
                sql="Insert Into "+ltb.getLabTBilling()+"("
                        +ltb.getFLabBillingId()+", "+ltb.getFBranchId()+", "
                        +ltb.getFCntLab()+","+ ltb.getFCntNoHn()+","
                        +ltb.getFCntNoLabId()+","+ ltb.getFCntNoPriceSale1()+","
                        +ltb.getFCntNoPriceSale2()+","+ ltb.getFDescription()+","
                        +ltb.getFLabBillingActive()+","+ ltb.getFLabBillingDate()+","
                        +ltb.getFMothId()+","+ ltb.getFPeriodId()+","
                        +ltb.getFRemark()+","+ ltb.getFStatusImport()+","
                        +ltb.getFSumLab()+","+ ltb.getFYearId()+","
                        + ltb.getFFilename()+") "
                        +"Values('"+max+"','"+item.getBranchId()+"',"
                        +item.getCntLab() + ","+ item.getCntNoHn()+","
                        +item.getCntNoLabId() + ","+ item.getCntNoPriceSale1()+","
                        +item.getCntNoPriceSale2() + ",'"+ item.getDescription()+"','"
                        +item.getLabBillingActive() + "','"+ item.getLabBillingDate()+"','"
                        +item.getMothId() + "','"+ item.getPeriodId()+"','"
                        +item.getRemark() + "','"+ item.getStatusImport()+"',"
                        +item.getSumLab() + ",'"+ item.getYearId()+"','"
                        + item.getFilename()+"')";
            }else{
            }
            chk = st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setSaveLabTBillingItem(LabTBillingItem item){
        Connection conn;
        String max="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            max = setSaveLabTBillingItem(stbangna, item);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setSaveLabTBillingItem(Statement st, LabTBillingItem item) throws Exception {
        int chk=0;
        String sql="", max="";
        try {
            ltb_i = getLabTBillingItemByPK(st,"",item.getLabBillingItemId(),"");
            item.setPatientFullname(item.getPatientFullname().replace("'", "''"));
            item.setPaidNamet(item.getPaidNamet().replace("'", "''"));
            item.setItemCommonName(item.getItemCommonName().replace("'", "''"));

            if(ltb_i.getLabBillingItemId().equals("")){
                max = getMaxRowLabTBillingItem(st);
                sql="Insert Into "+ltb_i.getLabTBillingItem()+"("
                        +ltb_i.getFLabBillingItemId()+", "+ltb_i.getFDiscountPer()+", "
                        +ltb_i.getFDiscountPrice()+","+ ltb_i.getFDocId()+","
                        +ltb_i.getFItemCommonName()+","+ ltb_i.getFItemNumber()+","
                        +ltb_i.getFLabBillingId()+","+ ltb_i.getFLabBillingItemActive()+","
                        +ltb_i.getFOrderDate()+","+ ltb_i.getFPaidNamet()+","
                        +ltb_i.getFPatientFullname()+","+ ltb_i.getFPriceNet()+","
                        +ltb_i.getFPriceSale()+","+ ltb_i.getFPriceSale1()+","
                        +ltb_i.getFPriceSale2()+","+ ltb_i.getFPriceSale3()+","
                        +ltb_i.getFPriceSale4()+","+ ltb_i.getFPriceSale5()+","
                        +ltb_i.getFRemark()+","+ ltb_i.getFRowId()+","
                        +ltb_i.getFStatusPrice()+","+ ltb_i.getFVisitHn()+") "
                        +"Values('"+max+"',"+item.getDiscountPer()+","
                        +item.getDiscountPrice() + ",'"+ item.getDocId()+"','"
                        +item.getItemCommonName() + "','"+ item.getItemNumber()+"','"
                        +item.getLabBillingId() + "','"+ item.getLabBillingItemActive()+"','"
                        +item.getOrderDate() + "','"+ item.getPaidNamet()+"','"
                        +item.getPatientFullname() + "',"+ item.getPriceNet()+","
                        +item.getPriceSale() + ","+ item.getPriceSale1()+","
                        +item.getPriceSale2() + ","+ item.getPriceSale3()+","
                        +item.getPriceSale4() + ","+ item.getPriceSale5()+",'"
                        +item.getRemark() + "','"+ item.getRowId()+"','"
                        +item.getStatusPrice() + "','"+ item.getVisitHn()+"')";
            }else{
            }
            chk = st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getTrLabBilling(String branch_id, String ltb_id){
        String txt="";
        ltb = getLabTBillingByPK(branch_id, ltb_id,"");
        txt = getTrLabBillingGroup2(branch_id, ltb_id);
        return txt;
    }
    public Boolean setDeleteFile(String filename) {
        boolean exists = (new File(filename)).exists();
        boolean success = false;
        if (exists) success = (new File(filename)).delete();
        else success = true;
        return success;
    }
    public void setSaveLabBilling(String branch_id,String ltb_id, String flag){
        // step 㹡�ù���� lab ��ШӧǴ
        // 1. ����Ң����Ũҡ excel ��͹
        //    ����Ң����Ũҡ excel �µç���ͨ�������ŷ�����
        // 2. update ��¡�� lab ����ѧ������ master lab_b_item ����������Ң��Ҩ������¡�� lab ���ͧ
        //    ���������������͡ bill ��ҹ�� ������������ѡ
        // 3. Check �Ҥ� net_price ���١��ͧ������͹� ���� �Ҥҷ�������������Ҥ� master ��ͧ�����Ҥ������ͧ
        ltb = getLabTBillingByPK(branch_id, ltb_id, "");
        Vector v_sheet = openWorkBook(branch_id,ltb.getFilename(),ltb.getLabBillingId(), flag);//�֧�����Ũҡ excel
        setSaveWorkBook(branch_id, ltb_id, v_sheet, flag);//save ŧ table
        //����ͧ ���ҧ� lab master ���� ��� ������������� ������١��ͧ ��Ͷ���ա������Ҥ��������� �����繢����Ţͧ����������� ��������� lab_t_billing_item �ա���
//        setUpdateLabBItem(branch_id, ltb_id);// update lab_b_item ������Ң�
        setUpdateNetPrice(branch_id, ltb_id);
        setUpdateLabBillingSum(branch_id,ltb_id);
    }
    public Vector openWorkBook(String branch_id,String filename, String ltb_id, String flag){
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        
        Vector v_workbook = new Vector();
        File file = new File(filename);

        if(file.exists()){
            try {
//                mktcl = getMarketingTChecklistByPK(branch_id,ltb_id);
                wb = new HSSFWorkbook(new FileInputStream(filename));
//                wb.setSheetName(0, mktcl.getSheetName());
                sheet = wb.getSheet("sheet1");
                for(Integer i=1;i<=60000;i++) {
                    try {
                        setClearVarWorkBook();
                        if (sheet==null) break;
                        row = sheet.getRow(i);
                        if(row == null) break;
                        if(i==533){
//                            sheetname_name="";
                        }
                        try{
                            c_fname = row.getCell(col_lab_id);
                            if((c_fname != null) && (c_fname.getStringCellValue().equals(""))) break;
                        }catch(Exception ex){
                            if((c_fname != null) && (c_fname.getNumericCellValue()<=0)) break;
                        }
                        if(branch_id.equals("103005") || branch_id.equals("103003")){
                            getSheet1(col_doc,"",dDoc);
                            getSheet1(col_date,"date",dDate);
                            getSheet1(col_hn,"",dHn);
                            getSheet1(col_fullname,"",dFullname);
                            getSheet1(col_type_lab,"",dTypeLab);
                            getSheet1(col_lab_id,"",dLabId);
                            getSheet1(col_lab_name,"",dLabName);
                            getSheet1(col_price1,"",dPrice1);
                            getSheet1(col_price2,"",dPrice2);
                            getSheet1(col_price3,"",dPrice3);
                            getSheet1(col_price4,"",dPrice4);
                            getSheet1(col_price5,"",dPrice5);
                        }else{
                            getSheet();
                        }
                        setSheet(Double.parseDouble(i.toString()));
                        v_workbook.add(ltb_i);
                    } catch (Exception ex) {
                        Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return v_workbook;
    }
    private void getSheet1(Integer column, String flag, StringBuilder data){
        try{
            c_fname = row.getCell(column);
            if(c_fname != null && (c_fname.getCellType()==0)){//numeric
                if(flag.equals("date")){
                    Date date = new Date();
                    Integer day=0, month=0, year=0;
                    date = c_fname.getDateCellValue();
                    day = date.getDate();
                    month = date.getMonth()+1;
                    year = date.getYear()+1900;//��ͧ�ǡ�ա 1900 ���е�� javadoc �͡Ẻ���
                    String labdate="", day1="",month1="";
                    day1 = "0"+day.toString();
                    month1 = "0"+month.toString();
                    day1 = day1.substring(day1.length()-2, day1.length());
                    month1 = month1.substring(month1.length()-2, month1.length());
                    labdate = day1+"-"+month1+"-"+year;
                    data.append(labdate);
                }else{
                    Double dou = 0.0;
                    dou = c_fname.getNumericCellValue();
                    DataFormatter aaa = new DataFormatter();
                    aaa.formatCellValue(c_fname);
                    data.append(aaa.formatCellValue(c_fname));
                }
            }else if(c_fname != null && (c_fname.getCellType()==1)){//String
                data.append(c_fname.getStringCellValue());
            }
//            if(c_fname != null){
//                dDoc.append(c_fname.getStringCellValue());
//            }else{
//                dDoc.append("");
//            }
        }catch(Exception ex){
            data.append(c_fname.getNumericCellValue());
        }
    }
    private void getSheet(){
//        c_row_number = row.getCell(getColumnNumber(mktcl.getRowNumber()));
        try{
            c_fname = row.getCell(col_doc);
            if(c_fname.getCellType()==0){//numeric
                dDoc.append(c_fname.getNumericCellValue());
            }else if(c_fname.getCellType()==1){
                dDoc.append(c_fname.getStringCellValue());
            }
            if(c_fname != null){
                dDoc.append(c_fname.getStringCellValue());
            }else{
                dDoc.append("");
            }
        }catch(Exception ex){
            dDoc.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_date);
            if(c_fname != null){
                dDate.append(c_fname.getStringCellValue());
            }else{
                dDate.append("");
            }
        }catch(Exception ex){
            dDate.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_hn);
            if(c_fname != null){
                dHn.append(c_fname.getStringCellValue());
            }else{
                dHn.append("");
            }
        }catch(Exception ex){
            dHn.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_fullname);
            if(c_fname != null){
                dFullname.append(c_fname.getStringCellValue());
            }else{
                dFullname.append("");
            }
        }catch(Exception ex){
            dFullname.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_type_lab);
            if(c_fname != null){
                dTypeLab.append(c_fname.getStringCellValue());
            }else{
                dTypeLab.append("");
            }
        }catch(Exception ex){
            dTypeLab.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_lab_id);
            if(c_fname != null){
                dLabId.append(c_fname.getStringCellValue());
            }else{
                dLabId.append("");
            }
        }catch(Exception ex){
            dLabId.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_lab_name);
            if(c_fname != null){
                dLabName.append(c_fname.getStringCellValue());
            }else{
                dLabName.append("");
            }
        }catch(Exception ex){
            dLabName.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_price1);
            if(c_fname != null){
                dPrice1.append(c_fname.getStringCellValue());
            }else{
                dPrice1.append("");
            }
        }catch(Exception ex){
            dPrice1.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_price2);
            if(c_fname != null){
                dPrice2.append(c_fname.getStringCellValue());
            }else{
                dPrice2.append("");
            }
        }catch(Exception ex){
            dPrice2.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_price3);
            if(c_fname != null){
                dPrice3.append(c_fname.getStringCellValue());
            }else{
                dPrice3.append("");
            }
        }catch(Exception ex){
            dPrice3.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_price4);
            if(c_fname != null){
                dPrice4.append(c_fname.getStringCellValue());
            }else{
                dPrice4.append("");
            }
        }catch(Exception ex){
            dPrice4.append(c_fname.getNumericCellValue());
        }
        try{
            c_fname = row.getCell(col_price5);
            if(c_fname != null){
                dPrice5.append(c_fname.getStringCellValue());
            }else{
                dPrice5.append("");
            }
        }catch(Exception ex){
            dPrice5.append(c_fname.getNumericCellValue());
        }
    }
    private void setSheet(Double row){
        ltb_i = new LabTBillingItem();
        try {
            ltb_i.setRowId(row);
            ltb_i.setDocId(dDoc.toString());
            ltb_i.setOrderDate(config1.DateFormatShow2DB(dDate.toString(), "ddMMyyyy"));
            ltb_i.setVisitHn(dHn.toString());
            ltb_i.setPatientFullname(dFullname.toString());
            ltb_i.setTypeLabName(dTypeLab.toString());
            ltb_i.setPaidNamet(dTypeLab.toString());
            ltb_i.setItemNumber(dLabId.toString());
            ltb_i.setItemCommonName(dLabName.toString());
            ltb_i.setPriceSale1(Double.parseDouble(dPrice1.toString()));
            ltb_i.setPriceSale2(Double.parseDouble(dPrice2.toString()));
            ltb_i.setPriceSale3(Double.parseDouble(dPrice3.toString()));
            ltb_i.setPriceSale4(Double.parseDouble(dPrice4.toString()));
            ltb_i.setPriceSale5(Double.parseDouble(dPrice5.toString()));
            ltb_i.setLabBillingItemActive("1");
            ltb_i.setLabBillingItemId("");
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setClearVarWorkBook(){
        dDoc.delete(0, dDoc.length());
        dDate.delete(0, dDate.length());
        dHn.delete(0, dHn.length());
        dFullname.delete(0, dFullname.length());
        dTypeLab.delete(0, dTypeLab.length());
        dLabId.delete(0, dLabId.length());
        dLabName.delete(0, dLabName.length());
        dPrice1.delete(0, dPrice1.length());
        dPrice2.delete(0, dPrice2.length());
        dPrice3.delete(0, dPrice3.length());
        dPrice4.delete(0, dPrice4.length());
        dPrice5.delete(0, dPrice5.length());
    }
    private void setSaveWorkBook(String branch_id, String ltb_id, Vector v_sheet, String flag) {
        Connection conn;
        Statement stbangna;
        String max="", fullNamet="", visitHn="", orderDate="",paidNamet="", visitVn="";
        try {
            conn = config1.getConnectionBangna();
            stbangna = conn.createStatement();
            for(int i=0;i<=v_sheet.size()-1;i++) {
//                fullNamet="";
//                visitHn="";
//                orderDate="";
//                paidNamet="";
                ltb_i = (LabTBillingItem)v_sheet.get(i);
                if(!ltb_i.getPatientFullname().equals("")){//��ͧ�����ҧ�������� excel ������� fullname ����� �繢����Ţͧ hn ��� ���Ǩ�������ҧ
                    fullNamet = ltb_i.getPatientFullname();
                }
                if(!ltb_i.getVisitHn().equals("")){//��ͧ�����ҧ�������� excel ������� visithn ����� �繢����Ţͧ hn ��� ���Ǩ�������ҧ
                    visitHn = ltb_i.getVisitHn();
                }
                if(!ltb_i.getOrderDate().equals("")){//��ͧ�����ҧ�������� excel ������� order date ����� �繢����Ţͧ hn ��� ���Ǩ�������ҧ
                    orderDate = ltb_i.getOrderDate();
                }
                if(!ltb_i.getPaidNamet().equals("")){//��ͧ�����ҧ�������� excel ������� paid name ����� �繢����Ţͧ hn ��� ���Ǩ�������ҧ
                    paidNamet = ltb_i.getPaidNamet();
                }
                if(!ltb_i.getDocId().equals("")){//��ͧ�����ҧ�������� excel ������� vn ����� �繢����Ţͧ hn ��� ���Ǩ�������ҧ
                    visitVn = ltb_i.getDocId();
                }
                if(paidNamet.equals("")){
                    paidNamet = "";
                }
                ltb_i.setLabBillingId(ltb_id);
                ltb_i.setPaidNamet(paidNamet);
                ltb_i.setPatientFullname(fullNamet);
                ltb_i.setOrderDate(orderDate);
                ltb_i.setVisitHn(visitHn);
                ltb_i.setDocId(visitVn);
                max = setSaveLabTBillingItem(stbangna, ltb_i);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String setStatusOutLab(String labNamet){
        if(labNamet.indexOf("outlab")>0 || (labNamet.indexOf("Out lab")>0) || (labNamet.indexOf("Out Lab")>0) || (labNamet.indexOf("Outlab")>0)){
            return "2";
        }else{
            return "1";
        }
    }
    private String setStatusDiscount(String labNamet){
        if( setStatusOutLab(labNamet).equals("2")){//����� out lab ��������ǹŴ
            return "2";
        }else{
            return "1";
        }
    }
    public void setLabBItem(String branchId, String labNumber, String labNamet, Double price1, Double price2, Double price3,
            Double price4, Double price5){
        String statusOutLab="";
        lbi = getLabBItemByPK(branchId, labNumber, "lab_number");
        if(lbi.getLabItemNumber().equals("")){
            lbi = new LabBItem();
            lbi.setBranchId(branchId);
            lbi.setLabItemActive("1");
            lbi.setLabItemId("");
            lbi.setLabItemName(labNamet);
            lbi.setLabItemNumber(labNumber);
            lbi.setPriceSale1(price1);
            lbi.setPriceSale2(price2);
            lbi.setPriceSale3(price3);
            lbi.setPriceSale4(price4);
            lbi.setPriceSale5(price5);
            lbi.setStatusOutlab(setStatusOutLab(labNamet));
            lbi.setStatusDiscount(setStatusDiscount(labNamet));

            setSaveLabBItem(lbi);
        }
    }
    private void setUpdateLabBItem(String branchId, String ltbId){
        Vector vLtb = new Vector();
        vLtb = getLabTBillingItem(branchId, ltbId, "","lab_t_billing");
        for(int i =0; i<=vLtb.size()-1;i++){
            ltb_i = new LabTBillingItem();
            ltb_i = (LabTBillingItem)vLtb.get(i);
//            lbi = new LabBItem();
            setLabBItem(branchId, ltb_i.getItemNumber(), ltb_i.getItemCommonName(), ltb_i.getPriceSale1(), ltb_i.getPriceSale1(),
                ltb_i.getPriceSale1(), ltb_i.getPriceSale1(), ltb_i.getPriceSale1() );
        }
    }
    private Double getLabNetPrice(Statement st,String branchId, String statusOutLab, String statusDiscount,
            Double price, String paidNamet, Double discount){
        // step 㹡�� update �Ҥ�
        //1.  check lab number ����� out lab �������
        //    ��� out lab ������ͧŴ�Ҥ� �� price_sale2 �����
        //2.  ��� ����� out lab ����� check ����������ǹŴ�ҡ ������ lab �������
        //    �� check �ҡ  lab type ��һ������������ǹŴ�� bahstatusOutLabt ���� percent
        Double netPrice = 0.0;
//        ltb_i = getLabTBillingItemByPK(st,branchId, ltbIId,"");//�֧������ ����������ͧ��� update �Ҥ�
//        if(!ltb_i.getLabBillingItemId().equals("")){
//            lbi = getLabBItemByPK(branchId, ltb_i.getItemNumber(),"lab_number");

        if(statusOutLab.equals("1")){//���ͧ
            
            if(statusDiscount.equals("2")){//�� persent
                netPrice = (price - (discount*price/100));
            }else{
                netPrice = (price - discount);
            }
//                netPrice = lbi.getPriceSale2();
        }else{// out lab
            netPrice = price;//��������ǹŴ
        }
            
//        }
        return netPrice;
    }
    private void setUpdateNetPrice(String branchId, String ltbId){
        String statusOutLab="", statusDiscount="", remark="";
        Connection conn;
        Statement st;
        Vector vLtb = new Vector();
        Double netPrice=0.0, discountBaht=0.0, discountPer=0.0;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            vLtb = getLabTBillingItem(branchId, ltbId, "","lab_t_billing");//��ͧ�֧������ ���д֧��� group by �����Ҩ���� item_number ����������Է�ԡ���
            for(int i=0; i<=vLtb.size()-1;i++){
                remark="";
                discountBaht=0.0;
                discountPer = 0.0;
                ltb_i = new LabTBillingItem();
                ltb_i = (LabTBillingItem)vLtb.get(i);
                lbp = getLabBPaidByPK(st,branchId, ltb_i.getPaidNamet(),"paid_namet");
                if(ltb_i.getItemCommonName().indexOf("outlab")>0 || (ltb_i.getItemCommonName().indexOf("Out lab")>0) ||
                        (ltb_i.getItemCommonName().indexOf("Out Lab")>0) || (ltb_i.getItemCommonName().indexOf("Outlab")>0)){
                    statusOutLab = "2";
                    statusDiscount = "0 out lab";
                    //remark = "�� out lab �������ǹŴ ���Ҥ� price2";
                    remark = "�� out lab �������ǹŴ ���Ҥ� price3";
                    //netPrice = ltb_i.getPriceSale2();//��������ǹŴ
                    netPrice = ltb_i.getPriceSale3();//��������ǹŴ
                }else{
                    statusOutLab = "1";
                    statusDiscount = lbp.getStatusdiscount();
                    remark = "�� lab ���ͧ ";
                    if(lbp.getStatusdiscount().equals("1")){// discount baht
                        discountBaht = lbp.getDiscount();
                        //remark += " ��ǹŴ�� baht "+ltb_i.getPriceSale2().toString()+" - "+lbp.getDiscount().toString();
                        remark += " ��ǹŴ�� baht "+ltb_i.getPriceSale3().toString()+" - "+lbp.getDiscount().toString();
                        //netPrice = (ltb_i.getPriceSale2() - lbp.getDiscount());
                        netPrice = (ltb_i.getPriceSale3() - lbp.getDiscount());
                    }else{// discount percent
                        discountPer = lbp.getDiscount();
                        //remark += " ��ǹŴ�� percent "+ltb_i.getPriceSale3().toString()+" - ("+lbp.getDiscount().toString()+" * "+ltb_i.getPriceSale3()+"/100)";
                        remark += " ��ǹŴ�� percent "+ltb_i.getPriceSale2().toString()+" - ("+lbp.getDiscount().toString()+" * "+ltb_i.getPriceSale2()+"/100)";
                        //netPrice = (ltb_i.getPriceSale2() - (lbp.getDiscount()*ltb_i.getPriceSale2()/100));
                        netPrice = (ltb_i.getPriceSale3() - (lbp.getDiscount()*ltb_i.getPriceSale3()/100));
                    }
                }
                setUpdateLabTBillingItemNetPrice(st,branchId, ltb_i.getLabBillingItemId(), netPrice, statusOutLab,
                        statusDiscount, discountBaht, discountPer,remark);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setUpdateLabTBillingItemNetPrice(Statement st,String branchId, String ltbIId, Double netPrice,
            String statusOutLab, String statusDiscount, Double discountBaht, Double discountPer, String remark){
//        Connection conn;
//        Statement stbangna;
        String max="", sql="";
        try {
            sql = "Update "+ltb_i.getLabTBillingItem()
                    +" Set "+ltb_i.getFPriceNet()+" ="+netPrice+", "
                    +ltb_i.getFStatusOutlab()+"='"+statusOutLab+"', "
                    +ltb_i.getFStatusDiscount()+"='"+statusDiscount+"', "
                    +ltb_i.getFDiscountPer()+"="+discountPer+", "
                    +ltb_i.getFDiscountPrice()+"="+discountBaht+", "
                    +ltb_i.getFRemark()+"='"+remark+"' "
                    +" Where "+ltb_i.getFLabBillingItemId()+"='"+ltbIId+"' ";
//            conn = config1.getConnectionBangna();
//            stbangna = conn.createStatement();
            st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
                Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getTrLabBillingItemGroupPaidNamet(String branch_id, String ltbId){
        String txt="", sql="", txtH="", paidNamet="", sumPriceNet="", cnt="",txtF="", linkPaidNamet="";
        String txtHidden="";
        Connection conn;
        Statement st;
        String max="";
        Integer i=0;
        Double total_cnt=0.0, total=0.0;
        try {
            sql = "Select "+ltb_i.getFPaidNamet()+", sum("+ltb_i.getFPriceNet()+") as "+ltb_i.getFPriceNet()+", count(1) as cnt "
            + "From "+ltb_i.getLabTBillingItem()+" "
            + "Where "+ltb_i.getFLabBillingId()+"='"+ltbId+"' "
            + "Group By "+ltb_i.getFPaidNamet()+" "
            + "Order By "+ltb_i.getFPaidNamet();
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                i++;
                paidNamet = rs.getString(ltb_i.getFPaidNamet());
                if(paidNamet.equals("")){
                    paidNamet = "-";
                }
                if(rs.getString(ltb_i.getFPriceNet()) != null){
                    total += rs.getDouble(ltb_i.getFPriceNet());
                }
                if(rs.getString("cnt") != null){
                    total_cnt += rs.getDouble("cnt");
                }//<a href='javascript:showInjury(
                linkPaidNamet = "<a href='javascript:showLabBillingItemEdit("+i+")'/>"+paidNamet+"</a>";
                txtHidden = "<input type='hidden' id='txt_ltb_id"+i+"' value='"+ltbId+"'/>"
                        + "<input type='hidden' id='txt_paid_namet"+i+"' value='"+paidNamet+"'/>";
                sumPriceNet = rs.getString(ltb_i.getFPriceNet());
                cnt = rs.getString("cnt");
                txt += "<tr><td>"+i+"</td><td>"+linkPaidNamet+"</td><td>"+cnt+"</td><td>"+config1.NumberFormat(sumPriceNet)+txtHidden+"</td>"
                        + "</tr>";
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
                Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
                txt = ex.getMessage();
        }
        txtH = "<table><tr><th align='center'>�ӴѺ</th><th>������</th><th align='right'>�ӹǹ</th><th align='right'>��Ť��</th></tr>";
        txtF = "<tr><td colspan='3' align='right'>"+total_cnt+"</th><td>"+config1.NumberFormat(total)+"</td></tr></table>";
        return txtH+txt+txtF;
    }
    public String getTrLabBillingItemGroupItemNumber(String branch_id, String ltbId){
        String txt="", sql="", txtH="", paidNamet="", sumPriceNet="", cnt="",txtF="";
        Connection conn;
        Statement st;
        String max="";
        Integer i=0;
        Double total_cnt=0.0, total=0.0;
        try {
            sql = "Select "+ltb_i.getFItemNumber()+", sum("+ltb_i.getFPriceNet()+") as "+ltb_i.getFPriceNet()+", count(1) as cnt "
            + "From "+ltb_i.getLabTBillingItem()+" "
            + "Where "+ltb_i.getFLabBillingId()+"='"+ltbId+"' "
            + "Group By "+ltb_i.getFItemNumber()+" "
            + "Order By "+ltb_i.getFItemNumber();
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                i++;
                paidNamet = rs.getString(ltb_i.getFItemNumber());
                if(rs.getString(ltb_i.getFPriceNet()) != null){
                    total += rs.getDouble(ltb_i.getFPriceNet());
                }
                if(rs.getString("cnt") != null){
                    total_cnt += rs.getDouble("cnt");
                }
                sumPriceNet = rs.getString(ltb_i.getFPriceNet());
                cnt = rs.getString("cnt");
                txt += "<tr><td>"+i+"</td><td>"+paidNamet+"</td><td>"+config1.IntegerFormat(cnt)+"</td><td>"+sumPriceNet+"</td>"
                        + "</tr>";
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
                Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
                txt = ex.getMessage();
        }
        txtH = "<table><tr><th>�ӴѺ</th><th>������</th><th>�ӹǹ</th><th align='right'>��Ť��</th></tr>";
        txtF = "<tr><td colspan='3'>"+total_cnt+"</th><td>"+total+"</td></tr>";
        return txtH+txt+"</table>";
    }
    public String getTrLabBillingItemGroupOrderDate(String branch_id, String ltbId){
        String txt="", sql="", txtH="", orderDate="", sumPriceNet="", cnt="",txtF="";
        Connection conn;
        Statement st;
        String max="";
        Integer i=0;
        Double total_cnt=0.0, total=0.0;
        try {
            sql = "Select "+ltb_i.getFOrderDate()+", sum("+ltb_i.getFPriceNet()+") as "+ltb_i.getFPriceNet()+", count(1) as cnt "
            + "From "+ltb_i.getLabTBillingItem()+" "
            + "Where "+ltb_i.getFLabBillingId()+"='"+ltbId+"' "
            + "Group By "+ltb_i.getFOrderDate()+" "
            + "Order By "+ltb_i.getFOrderDate();
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                i++;
                orderDate = rs.getString(ltb_i.getFOrderDate());
                if(rs.getString(ltb_i.getFPriceNet()) != null){
                    total += rs.getDouble(ltb_i.getFPriceNet());
                }
                if(rs.getString("cnt") != null){
                    total_cnt += rs.getDouble("cnt");
                }
                sumPriceNet = rs.getString(ltb_i.getFPriceNet());
                cnt = rs.getString("cnt");
                txt += "<tr><td>"+i+"</td><td>"+config1.DateFormatDB2Show(orderDate,"ddMMyyyy")+"</td><td>"+cnt+"</td><td>"+config1.NumberFormat(sumPriceNet)+"</td>"
                        + "</tr>";
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
                Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
                txt = ex.getMessage();
        }
        txtH = "<table><tr><th align='center'>�ӴѺ</th><th>������</th><th align='right'>�ӹǹ</th><th align='right'>��Ť��</th></tr>";
        txtF = "<tr><td colspan='3' align='right'>"+config1.IntegerFormat(total_cnt)+"</th><td align='right'>"+config1.NumberFormat(total)+"</td></tr></table>";
        return txtH+txt+txtF;
    }
    public String getTrLabBillingGroup2(String branch_id, String ltbId){
        String txtPaidNamet="", txtOrderDate="";
        txtPaidNamet = getTrLabBillingItemGroupPaidNamet(branch_id, ltbId);
        txtOrderDate = getTrLabBillingItemGroupOrderDate(branch_id, ltbId);
        return "<table><tr><td valign='top'>"+txtPaidNamet+"</td><td valign='top'>"+txtOrderDate+"</td></tr></table>";
    }
    public String getTrLabTBillingView(String branchId, String yearId){
        String txt="", txtH="", txtF="", description="", linkDesciption="";
        Vector vLtb = new Vector();
        vLtb = getLabTBilling(branchId, yearId,"year_id");
        for(int i=0;i<=vLtb.size()-1;i++){
            ltb = (LabTBilling)vLtb.get(i);
            description = ltb.getDescription();
            if(description.equals("")){
                description = "-";
            }
            linkDesciption = "<a href='labbilling_add.jsp?flagpage=view&ltb_id="+ltb.getLabBillingId()+"' >"+description+"</a>";
            txt += "<tr><td>"+(i+1)+"</td><td>"+ltb.getLabBillingId()+"</td><td>"+linkDesciption+"</td><td>"+config1.getMonthNamet(ltb.getMothId(),"id_name")+"</td>"
                    + "<td>"+config1.getPeriodNamet(ltb.getPeriodId(),"id_name")+"</td><td>"+config1.IntegerFormat(ltb.getCntLab())+"</td><td>"+config1.NumberFormat(ltb.getSumLab())+"</td><td>"+ltb.getCntNoLabId()+"</td>"
                    + "<td>"+ltb.getCntNoHn()+"</td></tr>";
        }
        txtH = "<table widht='100%'><tr><th>�ӴѺ</th><th>�Ţ���</th><th width='300'>��¡��</th><th>��͹</th><th>�Ǵ</th><th>�ӹǹ</th><th>��Ť��</th><th>��辺����lab</th><th>��辺����hn</th></tr>";
        txtF="</table>";
        return txtH+txt+txtF;
    }
    public String getTrLabBillingItemPaidNamet(String branchId, String ltbId, String paidNamet){
        Vector vLtbI = new Vector();
        String txt="", sql="", txtH="", sumPriceNet="", cnt="",txtF="",txtItemNumber="",txtRow="",txtPriceNet="",txtItemCommonName="";
        Connection conn;
        Statement st;
        String max="";
//        Integer i=0;
        Double total_cnt=0.0, total=0.0;
        vLtbI = getLabTBillingItem(branchId, ltbId, paidNamet,"paid_namet");
        try {
            for(int i=0;i<=vLtbI.size()-1;i++){
                ltb_i = (LabTBillingItem)vLtbI.get(i);
                txtItemNumber="<input type='text' id='txt_item_number"+i+"' value='"+ltb_i.getItemNumber()+"' size='8' onchange='setItemNumber("+i+")'/>";
                txtRow="<input type='hidden' id='txt_ltb_i_id"+i+"' value='"+ltb_i.getLabBillingItemId()+"' size='8' />";
                txtPriceNet="<input type='text' id='txt_price_net"+i+"' value='"+ltb_i.getPriceNet()+"' size='8' onchange='setPriceNet("+i+")' class='numeric' align='right'/>";
                txtItemCommonName="<input type='text' id='txt_item_name"+i+"' value='"+ltb_i.getItemCommonName()+"' size='35' onchange='setItemName("+i+")'/>";
                txt += "<tr><td>"+i+"</td><td>"+ltb_i.getPatientFullname()+"</td><td>"+txtItemNumber+"</td><td>"
                        +txtItemCommonName+"</td><td>"+ltb_i.getPriceSale2()+"</td><td>"+txtPriceNet+txtRow+"</td>"
                        + "</tr>";
            }
        } catch (Exception ex) {
                Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
                txt = ex.getMessage();
        }
        txtH = "<table><tr><th align='center'>�ӴѺ</th><th>����-���ʡ��</th><th align='right'>����</th>"
                + "<th align='right'>��¡��</th><th align='right'>price2</th><th align='right'>�Ҥ��ط��</th></tr>";
        txtF = "</table>";
        return txtH+txt+txtF;
    }
    public void setTextLabBilling(String branchId, String ltbId){
        String txt="", pathfile="//data//document//lab//";
        Vector vLtbI = new Vector();
        ltb = getLabTBillingByPK(branchId,ltbId,"");
        vLtbI = getLabTBillingItem(branchId, ltbId,"", "lab_t_billing");
        for(int i=0;i<=vLtbI.size()-1;i++){
            try {
                ltb_i = (LabTBillingItem)vLtbI.get(i);
                txt += ltb_i.getDocId() + "|" + config1.DateFormatDB2Show(ltb_i.getOrderDate(), "ddMMyyyy")+"|"
                        +ltb_i.getVisitHn()+"|"+ltb_i.getPatientFullname()+"|"+ltb_i.getPaidNamet()+"|"
                        +ltb_i.getPriceSale2()+"|"+ltb_i.getPriceNet()+"|"+ltb_i.getItemNumber()+"|"
                        +ltb_i.getItemCommonName()+"\r\n";
            } catch (Exception ex) {
                Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        config1.fileCreate(pathfile+branchId+"_"+ltb.getYearId()+"_"+ltb.getMothId()+"_"+ltb.getPeriodId()+"_"+ltbId+".txt", txt);
    }
    public void setUpdateLabBillingItemItemNumber(String branchId, String ltbIId, String itemNumber){
        String itemnumber1="";
        itemnumber1 = itemNumber.replace("'", "''");
        String sql="Update "+ltb_i.getLabTBillingItem()+" Set "+ltb_i.getFItemNumber()+"='"+itemnumber1+"' "
                + "Where "+ltb_i.getFLabBillingItemId()+"='"+ltbIId+"'";
        Connection conn;
        String max="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            stbangna.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateLabBillingItemItemCommonName(String branchId, String ltbIId, String itemCommonName){
        String itemcommonname1="";
        itemcommonname1 = itemCommonName.replace("'", "''");
        String sql="Update "+ltb_i.getLabTBillingItem()+" Set "+ltb_i.getFItemCommonName()+"='"+itemcommonname1+"' "
                + "Where "+ltb_i.getFLabBillingItemId()+"='"+ltbIId+"'";
        Connection conn;
        String max="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            stbangna.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateLabBillingItemPriceNet(String branchId, String ltbIId, String priceNet){
//        String itemcommonname1="";
//        itemcommonname1 = itemCommonName.replace("'", "''");
        String sql="Update "+ltb_i.getLabTBillingItem()+" Set "+ltb_i.getFPriceNet()+"="+priceNet+" "
                + "Where "+ltb_i.getFLabBillingItemId()+"='"+ltbIId+"'";
        Connection conn;
        String max="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            stbangna.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateLabTBilling(String branchId, String description, String remark, String yearId, String monthId,
            String periodId, String ltbId){
        Connection conn;
        Statement st;
        String max="", sql="";
        try {
            sql = "Update "+ltb.getLabTBilling()
                    +" Set "+ltb.getFBranchId()+" ='"+branchId+"', "
                    +ltb.getFDescription()+"='"+description+"', "
                    +ltb.getFMothId()+"='"+monthId+"', "
                    +ltb.getFPeriodId()+"='"+periodId+"', "
                    +ltb.getFRemark()+"='"+remark+"', "
                    +ltb.getFYearId()+"='"+yearId+"' "
                    +" Where "+ltb.getFLabBillingId()+"='"+ltbId+"' ";
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
                Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateLabTBillingVoid(String branchId, String ltbId){
        Connection conn;
        Statement st;
        String max="", sql="";
        try {
            sql = "Update "+ltb.getLabTBilling()
                    +" Set "+ltb.getFLabBillingActive()+" ='3' "
                    +" Where "+ltb.getFLabBillingId()+"='"+ltbId+"' and "+ltb.getFBranchId()+"='"+branchId+"'";
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
                Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateLabBillingSum(String branchId, String ltbId){
        String itemnumber1="";
//        itemnumber1 = itemNumber.replace("'", "''");
        String sql="Select count(1) as cnt, sum(price_net) as price_net "
                + "From "+ltb_i.getLabTBillingItem()+" "
                + "Where "+ltb_i.getFLabBillingId()+"='"+ltbId+"'";
        Connection conn;
        String max="", cnt="", sum="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                cnt = rs.getString("cnt");
                sum = rs.getString("price_net");
            }
            rs.close();
            sql = "Update "+ltb.getLabTBilling()+" Set cnt_lab ="+cnt+", sum_lab="+sum+" Where "+ltb.getFLabBillingId()+"='"+ltbId+"'";
            stbangna.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(LabBillingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
