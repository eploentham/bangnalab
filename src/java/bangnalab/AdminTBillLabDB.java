package bangnalab;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import bangnaLibrary.BBranch;
import bangnaLibrary.Config1;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.sql.*;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pop
 */
public class AdminTBillLabDB {
    public Config1 config1 = new Config1();
    public AdminTBillLab abl = new AdminTBillLab();
    public AdminTBillLabDetail abl_d = new AdminTBillLabDetail();
    public String getMaxRowAdminTBillLab(){
        String sql="", max="";
        try {
            Connection conn = config1.getConnectionBangna();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();
            sql="Select max("+abl.getFBillLabId()+") as cnt From "+abl.getAdminTBillLab();
            rs = st.executeQuery(sql);
            while(rs.next()){
                max = rs.getString("cnt");
            }
            rs.close();
            conn.close();
            if(max!=null)
                max =  String.valueOf(Integer.parseInt(max)+1);
            else
                max = "11100001";
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowAdminTBillLabDetail(Statement st){
        String sql="", max="";
        try {
            ResultSet rs;
            sql="Select max("+abl_d.getFBillLabDetailId()+") as cnt From "
                    +abl_d.getAdminTBillLabDetail();
            rs = st.executeQuery(sql);
            while(rs.next()){
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals(""))
                max =  String.valueOf(Integer.parseInt(max)+1);
            else
                max = "1120000001";
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public AdminTBillLab getBillLabByPK(String wound_care_id){
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            abl = new AdminTBillLab();
            String sql="";
            sql="Select * "
                +"From "+abl.getAdminTBillLab()+" as nr "
                +"Where "+abl.getFBillLabId()+" = '"+wound_care_id+"' ";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                abl = new AdminTBillLab();
                abl.setBillLabId(config1.StringNull(rs.getString(abl.getFBillLabId())));
                abl.setBillLabDescription(config1.StringNull(rs.getString(abl.getFBillLabDescription())));
                abl.setBillLabDate(config1.StringNull(rs.getString(abl.getFBillLabDate())));
                abl.setBillLabMonth(config1.StringNull(rs.getString(abl.getFBillLabMonth())));
                abl.setBillLabYear(config1.StringNull(rs.getString(abl.getFBillLabYear())));

                abl.setBillLabPeriod(config1.StringNull(rs.getString(abl.getFBillLabPeriod())));
                abl.setBillLabActive(config1.StringNull(rs.getString(abl.getFBillLabActive())));
                abl.setBillLabRemark(config1.StringNull(rs.getString(abl.getFBillLabRemark())));
                abl.setBillLabStatus(config1.StringNull(rs.getString(abl.getFBillLabStatus())));
                abl.setDateBillMake(config1.StringNull(rs.getString(abl.getFDateBillMake())));

                abl.setDateBillReceive(config1.StringNull(rs.getString(abl.getFDateBillReceive())));
                abl.setUserIdModify(config1.StringNull(rs.getString(abl.getFUserIdModify())));
                abl.setDateCreate(config1.StringNull(rs.getString(abl.getFDateCreate())));
                abl.setDateModify(config1.StringNull(rs.getString(abl.getFDateModify())));
                abl.setDateCancel(config1.StringNull(rs.getString(abl.getFDateCancel())));

                abl.setTotalAmountApprove(Double.parseDouble(rs.getString(abl.getFTotalAmountApprove())));
                abl.setTotalAmountReceive(Double.parseDouble(rs.getString(abl.getFTotalAmountReceive())));
                abl.setTotalRecordApprove(Integer.parseInt(rs.getString(abl.getFTotalRecordApprove())));
                abl.setTotalRecordReceive(Integer.parseInt(rs.getString(abl.getFTotalRecordReveive())));
                abl.setUserIdCancel(config1.StringNull(rs.getString(abl.getFUserIdCancel())));

                abl.setUserIdCreate(config1.StringNull(rs.getString(abl.getFUserIdCreate())));
                abl.setTotalRecordUnApprove(Double.parseDouble(rs.getString(abl.getFTotalRecordUnApprove())));
                abl.setTotalAmountUnApprove(Double.parseDouble(rs.getString(abl.getFTotalAmountUnApprove())));
                abl.setBranchId(config1.StringNull(rs.getString(abl.getFBranchId())));
                abl.setFilename(config1.StringNull(rs.getString(abl.getFFilename())));
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return abl;
    }
    public Vector getBillLab(String branch_id,String awhere, String field){
        Connection conn;
        Vector v_admintbilllab = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            abl = new AdminTBillLab();
            String sql="";
            if(field.equals("year")){
                sql="Select * "
                +"From "+abl.getAdminTBillLab()+" as nr "
                +"Where "+abl.getFBillLabYear()+" = '"
                + awhere + "' and " +abl.getFBillLabActive()+" = '1' and "+abl.getFBranchId() +" = '"+branch_id + "' "
                +"Order By "+abl.getFBillLabId()+" desc";
            }else{
                sql="Select * "
                +"From "+abl.getAdminTBillLab()+" as nr "
                +"Where "+abl.getFBillLabActive()+" = '1' and "+abl.getFBranchId() +" = '"+branch_id + "' "
                +"Order By "+abl.getBillLabId()+" desc";
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                abl = new AdminTBillLab();
                abl.setBillLabId(config1.StringNull(rs.getString(abl.getFBillLabId())));
                abl.setBillLabDescription(config1.StringNull(rs.getString(abl.getFBillLabDescription())));
                abl.setBillLabDate(config1.StringNull(rs.getString(abl.getFBillLabDate())));
                abl.setBillLabMonth(config1.StringNull(rs.getString(abl.getFBillLabMonth())));
                abl.setBillLabYear(config1.StringNull(rs.getString(abl.getFBillLabYear())));

                abl.setBillLabPeriod(config1.StringNull(rs.getString(abl.getFBillLabPeriod())));
                abl.setBillLabActive(config1.StringNull(rs.getString(abl.getFBillLabActive())));
                abl.setBillLabRemark(config1.StringNull(rs.getString(abl.getFBillLabRemark())));
                abl.setBillLabStatus(config1.StringNull(rs.getString(abl.getFBillLabStatus())));
                abl.setDateBillMake(config1.StringNull(rs.getString(abl.getFDateBillMake())));

                abl.setDateBillReceive(config1.StringNull(rs.getString(abl.getFDateBillReceive())));
                abl.setUserIdModify(config1.StringNull(rs.getString(abl.getFUserIdModify())));
                abl.setDateCreate(config1.StringNull(rs.getString(abl.getFDateCreate())));
                abl.setDateModify(config1.StringNull(rs.getString(abl.getFDateModify())));
                abl.setDateCancel(config1.StringNull(rs.getString(abl.getFDateCancel())));

                abl.setTotalAmountApprove(Double.parseDouble(rs.getString(abl.getFTotalAmountApprove())));
                abl.setTotalAmountReceive(Double.parseDouble(rs.getString(abl.getFTotalAmountReceive())));
                abl.setTotalRecordApprove(Integer.parseInt(rs.getString(abl.getFTotalRecordApprove())));
                abl.setTotalRecordReceive(Integer.parseInt(rs.getString(abl.getFTotalRecordReveive())));
                abl.setUserIdCancel(config1.StringNull(rs.getString(abl.getFUserIdCancel())));

                abl.setUserIdCreate(config1.StringNull(rs.getString(abl.getFUserIdCreate())));
                abl.setTotalRecordUnApprove(Double.parseDouble(rs.getString(abl.getFTotalRecordUnApprove())));
                abl.setTotalAmountUnApprove(Double.parseDouble(rs.getString(abl.getFTotalAmountUnApprove())));
                abl.setBranchId(config1.StringNull(rs.getString(abl.getFBranchId())));
                abl.setFilename(config1.StringNull(rs.getString(abl.getFFilename())));
                
                v_admintbilllab.add(abl);
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_admintbilllab;
    }
    public AdminTBillLabDetail getBillLabDetailByPK(Statement stbangna,String bill_lab_detail_id){
//        Connection conn;
        try {
//            conn = config1.getConnectionBangna();
//            Statement stbangna = conn.createStatement();
            abl_d = new AdminTBillLabDetail();
            String sql="";
            sql="Select * "
                +"From "+abl_d.getAdminTBillLabDetail()+" as nr "
                +"Where "+abl_d.getFBillLabDetailId()+" = '"+bill_lab_detail_id+"' ";
                //+"Order By "+admintbilllabdetail.getBillLabDetailId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                abl_d = new AdminTBillLabDetail();
                abl_d.setBillLabId(config1.StringNull(rs.getString(abl_d.getFBillLabId())));
                abl_d.setBillLabDetailId(config1.StringNull(rs.getString(abl_d.getFBillLabDetailId())));
                abl_d.setDateOrder(config1.StringNull(rs.getString(abl_d.getFDateOrder())));
                abl_d.setLabDetailActive(config1.StringNull(rs.getString(abl_d.getFLabDetailActive())));
                abl_d.setLabId(config1.StringNull(rs.getString(abl_d.getFLabId())));

                abl_d.setLabNamet(config1.StringNull(rs.getString(abl_d.getFLabNamet())));
                abl_d.setLabStatus(config1.StringNull(rs.getString(abl_d.getFLabStatus())));
                abl_d.setNettotalApprove(Double.parseDouble(rs.getString(abl_d.getFNetTotalReceive())));
                abl_d.setNettotalReceive(Double.parseDouble(rs.getString(abl_d.getFNetTotalApprove())));
                abl_d.setPatientFullnamet(config1.StringNull(rs.getString(abl_d.getFPatientFullNamet())));

                abl_d.setPatientHnNo(config1.StringNull(rs.getString(abl_d.getFPatientHNNO())));
                abl_d.setPatientVn(config1.StringNull(rs.getString(abl_d.getFPatientnVN())));
                abl_d.setPriceApprove(Double.parseDouble(rs.getString(abl_d.getFPriceApprove())));
                abl_d.setPriceDiscountReceive(Double.parseDouble(rs.getString(abl_d.getFPriceDiscountReceive())));
                abl_d.setPriceNormalReceive(Double.parseDouble(rs.getString(abl_d.getFPriceNormalReceive())));

                abl_d.setQtyApprove(Double.parseDouble(rs.getString(abl_d.getFQtyApprove())));
                abl_d.setQtyReceive(Double.parseDouble(rs.getString(abl_d.getFQtyReceive())));
                abl_d.setStatusApprove(config1.StringNull(rs.getString(abl_d.getFStatusApprove())));
                //admintbilllabdetail.setTotalRecordReceive(Integer.parseInt(rs.getString(admintbilllabdetail.getFTotalRecordReveive())));
                //admintbilllabdetail.setUserIdCancel(config1.StringNull(rs.getString(admintbilllabdetail.getFUserIdCancel())));

                //admintbilllabdetail.setUserIdCreate(config1.StringNull(rs.getString(admintbilllabdetail.getFUserIdCreate())));
                //admintbilllab.setUserIdModify(config1.StringNull(rs.getString(admintbilllab.WoundCareStatus())));
                //admintbilllab.set(config1.StringNull(rs.getString(admintbilllab.WoundCareStatus())));
                }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return abl_d;
    }
    public Vector getBillLabDetail(String awhere, String day, String field){
        Connection conn;
        String sql="";
        Vector v_billlab_detail = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            abl_d = new AdminTBillLabDetail();
            if(field.equals("bill_lab")){
                sql="Select * "
                +"From "+abl_d.getAdminTBillLabDetail()+" as nr "
                +"Where "+abl_d.getFBillLabId()+" = '"+awhere+"' "
                +"Order By "+abl_d.getBillLabDetailId()+" desc";
            }else if(field.equals("date")){
                sql="Select "+abl_d.getFDateOrder() + ", "+abl_d.getFBillLabId() + ", "+abl_d.getFStatusAudit() + ", "
                +"count("+abl_d.getFPatientHNNO()+") as patient_hn_no, "+"count("+abl_d.getFLabId()+") as lab_id, "
                +"sum("+abl_d.getFNetTotalApprove()+") as nettotal_approve, "+"sum("+abl_d.getFNetTotalReceive()+") as nettotal_receive "
                +"From "+abl_d.getAdminTBillLabDetail()+" as adbl "
                +"Where "+abl_d.getFBillLabId()+" = '"+awhere+"' "
                +"Group By "+abl_d.getFDateOrder() + ", "+abl_d.getFBillLabId() + ", "+abl_d.getFStatusAudit() + " "
                +"Order By "+abl_d.getFDateOrder()+" desc";
            }else if(field.equals("date_audit_uncorrect")){
                sql="Select "+abl_d.getFStatusAudit()+", "+"count("+abl_d.getFLabId()+") as lab_id "
                +"From "+abl_d.getAdminTBillLabDetail()+" as adbl "
                +"Where "+abl_d.getFBillLabId()+" = '"+awhere+"' and "
                +abl_d.getFDateOrder() + " = '"+day+"' "
                +"Group By "+abl_d.getFDateOrder() + ", "
                +abl_d.getFStatusAudit() + " "
                +"Order By "+abl_d.getFStatusAudit();
            }else if(field.equals("date_day")){
                    sql="Select * "
                +"From "+abl_d.getAdminTBillLabDetail()+" as nr "
                +"Where "+abl_d.getFBillLabId()+" = '"+awhere+"' and "
                +abl_d.getFDateOrder()+ " = '"+day + "' "
                +"Order By "+abl_d.getFBillLabDetailId()+" desc";
                }
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                abl_d = new AdminTBillLabDetail();
                if(field.equals("bill_lab") || field.equals("date_day")){
                    abl_d.setBillLabId(config1.StringNull(rs.getString(abl_d.getFBillLabId())));
                    abl_d.setBillLabDetailId(config1.StringNull(rs.getString(abl_d.getFBillLabDetailId())));
                    abl_d.setDateOrder(config1.StringNull(rs.getString(abl_d.getFDateOrder())));
                    abl_d.setLabDetailActive(config1.StringNull(rs.getString(abl_d.getFLabDetailActive())));
                    abl_d.setLabId(config1.StringNull(rs.getString(abl_d.getFLabId())));

                    abl_d.setLabNamet(config1.StringNull(rs.getString(abl_d.getFLabNamet())));
                    abl_d.setLabStatus(config1.StringNull(rs.getString(abl_d.getFLabStatus())));
                    abl_d.setNettotalApprove(Double.parseDouble(rs.getString(abl_d.getFNetTotalReceive())));
                    abl_d.setNettotalReceive(Double.parseDouble(rs.getString(abl_d.getFNetTotalApprove())));
                    abl_d.setPatientFullnamet(config1.StringNull(rs.getString(abl_d.getFPatientFullNamet())));

                    abl_d.setPatientHnNo(config1.StringNull(rs.getString(abl_d.getFPatientHNNO())));
                    abl_d.setPatientVn(config1.StringNull(rs.getString(abl_d.getFPatientnVN())));
                    abl_d.setPriceApprove(Double.parseDouble(rs.getString(abl_d.getFPriceApprove())));
                    abl_d.setPriceDiscountReceive(Double.parseDouble(rs.getString(abl_d.getFPriceDiscountReceive())));
                    abl_d.setPriceNormalReceive(Double.parseDouble(rs.getString(abl_d.getFPriceNormalReceive())));

                    abl_d.setQtyApprove(Double.parseDouble(rs.getString(abl_d.getFQtyApprove())));
                    abl_d.setQtyReceive(Double.parseDouble(rs.getString(abl_d.getFQtyReceive())));
                    abl_d.setStatusApprove(config1.StringNull(rs.getString(abl_d.getFStatusApprove())));
                }else if(field.equals("date")){
                    abl_d.setBillLabId(config1.StringNull(rs.getString(abl_d.getFBillLabId())));
                    abl_d.setDateOrder(config1.StringNull(rs.getString(abl_d.getFDateOrder())));
                    abl_d.setPatientHnNo(config1.StringNull(rs.getString(abl_d.getFPatientHNNO())));
                    abl_d.setLabId(config1.StringNull(rs.getString(abl_d.getFLabId())));
                    abl_d.setStatusAudit(config1.StringNull(rs.getString(abl_d.getFStatusAudit())));
                    abl_d.setNettotalReceive(Double.parseDouble(rs.getString(abl_d.getFNetTotalReceive())));
                    abl_d.setNettotalApprove(Double.parseDouble(rs.getString(abl_d.getFNetTotalApprove())));
                }else if(field.equals("date_audit_uncorrect")){
                    abl_d.setStatusAudit(config1.StringNull(rs.getString(abl_d.getFStatusAudit())));
                    abl_d.setLabId(config1.StringNull(rs.getString(abl_d.getFLabId())));
//                    admintbilllabdetail.setPatientHnNo(config1.StringNull(rs.getString(admintbilllabdetail.getFPatientHNNO())));
//                    admintbilllabdetail.setNettotalApprove(Double.parseDouble(rs.getString(admintbilllabdetail.getFNetTotalReceive())));
//                    admintbilllabdetail.setNettotalReceive(Double.parseDouble(rs.getString(admintbilllabdetail.getFNetTotalApprove())));
                }
                
                //admintbilllabdetail.setTotalRecordReceive(Integer.parseInt(rs.getString(admintbilllabdetail.getFTotalRecordReveive())));
                //admintbilllabdetail.setUserIdCancel(config1.StringNull(rs.getString(admintbilllabdetail.getFUserIdCancel())));

                //admintbilllabdetail.setUserIdCreate(config1.StringNull(rs.getString(admintbilllabdetail.getFUserIdCreate())));
                //admintbilllab.setUserIdModify(config1.StringNull(rs.getString(admintbilllab.WoundCareStatus())));
                //admintbilllab.set(config1.StringNull(rs.getString(admintbilllab.WoundCareStatus())));
                v_billlab_detail.add(abl_d);
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_billlab_detail;
    }
    public String SaveBillLab(AdminTBillLab item, String flagpage) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
//        AdminTBillLab abl = new AdminTBillLab();
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            abl = getBillLabByPK(item.getBillLabId());
//            attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
            item.setBillLabDescription(item.getBillLabDescription().replace("'", "''"));
//            itemdetail.setAttendRemark(itemdetail.getAttendRemark().replace("'", "''"));
//            itemdetail.setMaDescription(itemdetail.getMaDescription().replace("'", "''"));
//            itemdetail.setMaRemark(itemdetail.getMaRemark().replace("'", "''"));
//            itemdetail.setVendorRemark(itemdetail.getVendorRemark().replace("'", "''"));
//            itemdetail.setSymptoms(itemdetail.getSymptoms().replace("'", "''"));

            if(abl.getBillLabId().equals("")){
                max = getMaxRowAdminTBillLab();
                sql="Insert Into "+abl.getAdminTBillLab()+"("
                        +abl.getFBillLabId()+", "+abl.getFBillLabDescription()+", "
                        +abl.getFBillLabDate()+","+ abl.getFBillLabActive()+","
                        +abl.getFBillLabMonth()+","+ abl.getFBillLabPeriod()+","
                        +abl.getFBillLabYear()+","+ abl.getFBillLabRemark()+","
                        +abl.getFBillLabStatus()+","+ abl.getFDateBillMake()+","
                        +abl.getFDateBillReceive()+","+ abl.getFDateCancel()+","
                        +abl.getFDateCreate()+","+ abl.getFDateModify()+","
                        +abl.getFTotalAmountApprove()+","+ abl.getFTotalAmountReceive()+","
                        +abl.getFUserIdCancel()+","+ abl.getFUserIdCreate()+","
                        +abl.getFUserIdModify()+","+abl.getFBranchId()+","
                        + abl.getFFilename()+") "
                        +"Values('"+max+"','"+item.getBillLabDescription()+"','"
                        +item.getBillLabDate() + "','"+ item.getBillLabActive()+"','"
                        +item.getBillLabMonth() + "','"+ item.getBillLabPeriod()+"','"
                        +item.getBillLabYear() + "','"+ item.getBillLabRemark()+"','"
                        +item.getBillLabStatus() + "','"+ item.getDateBillMake()+"','"
                        +item.getDateBillReceive() + "','"+ item.getDateCancel()+"','"
                        +item.getDateCreate() + "','"+ item.getDateModify()+"','"
                        +item.getTotalAmountApprove() + "','"+ item.getTotalAmountReceive()+"','"
                        +item.getUserIdCancel() + "','"+ item.getUserIdCreate()+"','"
                        +item.getUserIdModify()+"','"+item.getBranchId()+"','"
                        + item.getFilename()+"')";
            }
            else{
//                attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
//                wound_care_date=config1.DateFormatShow2DB(itemdetail.getMaDate(), "ddMMyyyy");
                sql = "Update "+abl.getAdminTBillLab()+" set "
                //+woundcaredetail.PatientHnNo()+" = '"+itemdetail.getPatientHnNo()+"', "
                +abl.getFBillLabDescription()+" = '"+item.getBillLabDescription()+"', "
                +abl.getFBillLabDate()+" = '"+item.getBillLabDate()+"', "
                +abl.getFBillLabActive()+" = '"+item.getBillLabActive()+"', "
                +abl.getFBillLabMonth()+" = '"+item.getBillLabMonth()+"', "
                +abl.getFBillLabPeriod()+" = '"+item.getBillLabPeriod()+"', "
                +abl.getFBillLabYear()+" = '"+item.getBillLabYear()+"', "
                +abl.getFBillLabRemark()+" = '"+item.getBillLabRemark()+"', "
                +abl.getFBillLabStatus()+" = '"+item.getBillLabStatus()+"', "
                +abl.getFDateBillMake()+" = '"+item.getDateBillMake()+"', "
                +abl.getFDateBillReceive()+" = '"+item.getDateBillReceive()+"', "
                +abl.getFDateCancel()+" = '"+item.getDateCancel()+"', "
                +abl.getFDateCreate()+" = '"+item.getDateCreate()+"', "
                +abl.getFDateModify()+" = '"+item.getDateModify()+"', "
                +abl.getFTotalAmountApprove()+" = '"+item.getTotalAmountApprove()+"', "
                +abl.getFTotalAmountReceive()+" = '"+item.getTotalAmountReceive()+"', "
                +abl.getFUserIdCancel()+" = '"+item.getUserIdCancel()+"', "
                +abl.getFUserIdCreate()+" = '"+item.getUserIdCreate()+"', "
                +abl.getFUserIdModify()+" = '"+item.getUserIdModify()+"', "
                +abl.getFBranchId()+" = '"+item.getBranchId()+"' "
                +"Where "+abl.getFBillLabId()+" = '"+item.getBillLabId()+"'";
                max = item.getBillLabId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public int setUpdateBillLabDetailStatusAudit(String bill_lab_detail_id, String data){
        int chk=0;
        String sql="";
        Connection conn;
        Statement st;
//        AdminTBillLabDetail abl_d = new AdminTBillLabDetail();
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            setUpdateBillLabDetailStatusAudit(st, bill_lab_detail_id,data);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public int setUpdateBillLabDetailStatusAudit(Statement st,String abl_dId, String data){
        int chk=0;
        String sql="";
//        Connection conn;
//        Statement st;
//        AdminTBillLabDetail abl_d = new AdminTBillLabDetail();
        try {
//            conn = config1.getConnectionBangna();
//            st = conn.createStatement();
            sql = "Update "+abl_d.getAdminTBillLabDetail()+" set "
                +abl_d.getFStatusAudit() +" = '"+data+"', "
                +abl_d.getFNetTotalAudit() + "="+abl_d.getFNetTotalReceive() + ", "
                +abl_d.getFPriceAudit() + "="+abl_d.getFPriceNormalReceive() + " "
                +"Where "+abl_d.getFBillLabDetailId() +" = '"+abl_dId+"'";
            chk = st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public int setUpdateBillLabDetailStatusApprove(String bill_lab_detail_id, String data, String priceapprove){
        int chk=0;
        String sql="";
        Connection conn;
        Statement st;
//        AdminTBillLabDetail abl_d = new AdminTBillLabDetail();
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Update "+abl_d.getAdminTBillLabDetail()+" set "
                +abl_d.getFStatusApprove() +" = '"+data+"' "
                +abl_d.getFPriceApprove() + "="+priceapprove+ " "
                +"Where "+abl_d.getFBillLabDetailId() +" = '"+bill_lab_detail_id+"'";
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public int SaveBillLabDetail(Connection conn,Statement st, AdminTBillLabDetail item) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="";
//        AdminTBillLabDetail abl_d = new AdminTBillLabDetail();
//        Connection conn;
//        Statement st;
        try {
//            conn = config1.getConnectionBangna();
//            st = conn.createStatement();
            abl_d = getBillLabDetailByPK(st,item.getBillLabDetailId());
//            attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
            item.setLabNamet(item.getLabNamet().replace("'", "''"));
            item.setPatientFullnamet(item.getPatientFullnamet().replace("'", "''"));
//            item.set(item.getMaDescription().replace("'", "''"));
//            itemdetail.setMaRemark(itemdetail.getMaRemark().replace("'", "''"));
//            itemdetail.setVendorRemark(itemdetail.getVendorRemark().replace("'", "''"));
//            itemdetail.setSymptoms(itemdetail.getSymptoms().replace("'", "''"));

            if(abl_d.getBillLabDetailId().equals("")){
                String max = getMaxRowAdminTBillLabDetail(st);
                sql="Insert Into "+abl_d.getAdminTBillLabDetail()+"("
                        +abl_d.getFBillLabDetailId()+", "+abl_d.getFBillLabId()+", "
                        +abl_d.getFDateOrder()+","+ abl_d.getFLabDetailActive()+","
                        +abl_d.getFLabId()+","+ abl_d.getFLabNamet()+","
                        +abl_d.getFLabStatus()+","+ abl_d.getFNetTotalApprove()+","
                        +abl_d.getFNetTotalReceive()+","+ abl_d.getFPatientFullNamet()+","
                        +abl_d.getFPatientHNNO()+","+ abl_d.getFPatientnVN()+","
                        +abl_d.getFPriceApprove()+","+ abl_d.getFPriceDiscountReceive()+","
                        +abl_d.getFPriceNormalReceive()+","+ abl_d.getFQtyApprove()+","
                        +abl_d.getFQtyReceive()+","+ abl_d.getFStatusApprove()+", "
                        +abl_d.getFStatusAudit()+ ") "
                        +"Values('"+max+"','"+item.getBillLabId()+"','"
                        +item.getDateOrder() + "','"+ item.getLabDetailActive()+"','"
                        +item.getLabId() + "','"+ item.getLabNamet()+"','"
                        +item.getLabStatus() + "',"+ item.getNettotalApprove()+","
                        +item.getNettotalReceive() + ",'"+ item.getPatientFullnamet()+"','"
                        +item.getPatientHnNo() + "','"+ item.getPatientVn()+"','"
                        +item.getPriceApprove() + "','"+ item.getPriceDiscountReceive()+"',"
                        +item.getPriceNormalReceive() + ","+ item.getQtyApprove()+","
                        +item.getQtyReceive() + ",'"+ item.getStatusApprove()+"','"
                        +item.getStatusAudit()+ "')";
            }else{
//                attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
//                wound_care_date=config1.DateFormatShow2DB(itemdetail.getMaDate(), "ddMMyyyy");
                sql = "Update "+abl_d.getAdminTBillLabDetail()+" set "
                //+woundcaredetail.PatientHnNo()+" = '"+itemdetail.getPatientHnNo()+"', "
                +abl_d.getFBillLabId()+" = '"+item.getBillLabId()+"', "
                +abl_d.getFDateOrder()+" = '"+item.getDateOrder()+"', "
                +abl_d.getFLabDetailActive()+" = '"+item.getLabDetailActive()+"', "
                +abl_d.getFLabId()+" = '"+item.getLabId()+"', "
                +abl_d.getFLabNamet()+" = '"+item.getLabNamet()+"', "
                +abl_d.getFLabStatus()+" = '"+item.getLabStatus()+"', "
//                +billlabdetail.getFNetTotalApprove()+" = '"+item.getNettotalApprove()+"', "
                +abl_d.getFNetTotalReceive()+" = '"+item.getNettotalReceive()+"', "
                +abl_d.getFPatientFullNamet()+" = '"+item.getPatientFullnamet()+"', "
                +abl_d.getFPatientHNNO()+" = '"+item.getPatientHnNo()+"', "
                +abl_d.getFPatientnVN()+" = '"+item.getFPatientnVN()+"', "
//                +billlabdetail.getFPriceApprove()+" = '"+item.getPriceApprove()+"', "
                +abl_d.getFPriceDiscountReceive()+" = '"+item.getPriceDiscountReceive()+"', "
                +abl_d.getFPriceNormalReceive()+" = '"+item.getPriceNormalReceive()+"', "
//                +billlabdetail.getFQtyApprove()+" = '"+item.getQtyApprove()+"', "
                +abl_d.getFQtyReceive()+" = '"+item.getQtyReceive()+"', "
//                +billlabdetail.getFStatusApprove()+" = '"+item.getStatusApprove()+"', "
                +abl_d.getFStatusAudit()+" = '"+item.getStatusAudit()+"' "
                +"Where "+abl_d.getFBillLabDetailId()+" = '"+item.getBillLabDetailId()+"'";
            }
            if(item.getDateOrder().equals("2558-01-05")){
                chk=0;
            }
            chk = st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public Integer setSaveBillLabDetailFromMDB(String bill_lab_id, String filename) throws Exception{
        Integer chk=0;
        Connection connbilllab;
        String sql="";
        try {
            //AdminTBillLabDB admintbilllabdb = new AdminTBillLabDB();
            connbilllab = config1.getConnectionBillLab(filename);
            Statement stbilllab;
            ResultSet rsbilllab;
            stbilllab = connbilllab.createStatement();
            sql = "Select * From billlab";
            rsbilllab = stbilllab.executeQuery(sql);
            while(rsbilllab.next()){
                abl_d = new AdminTBillLabDetail();
                abl_d.setBillLabDetailId("");
                abl_d.setBillLabId(bill_lab_id);
                abl_d.setDateOrder(config1.DateFormatShow2DB(rsbilllab.getString("dateorder"),"ddMMyyyy"));
                abl_d.setLabDetailActive("1");
                abl_d.setLabId(rsbilllab.getString("labid"));
                abl_d.setLabNamet(rsbilllab.getString("labnamet"));
                abl_d.setLabStatus("1");
                abl_d.setNettotalApprove(0.0);
                abl_d.setNettotalReceive(Double.parseDouble(rsbilllab.getString("netprice")));
                abl_d.setPatientFullnamet(rsbilllab.getString("fullnamet"));
                abl_d.setPatientHnNo(rsbilllab.getString("hn_no"));
                abl_d.setPatientVn("");
                abl_d.setPriceApprove(0.0);
                abl_d.setPriceDiscountReceive(Double.parseDouble(rsbilllab.getString("discountcash")));
                abl_d.setPriceNormalReceive(Double.parseDouble(rsbilllab.getString("price1")));
                abl_d.setQtyApprove(0.0);
                abl_d.setQtyReceive(0.0);
                abl_d.setStatusApprove("0");
                SaveBillLabDetail(connbilllab, stbilllab, abl_d);
            }
            rsbilllab.close();
            connbilllab.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
            throw (ex);
        }
        return chk;
    }
    public void setSaveBillingDetailFromText2(String alb_id){
        Integer colVn=0,colOrderDate=1, colHn=2, colFullNamet=3, colPaidNamet=4, colPrice2=5, colPriceNet=6, colItemNumber=7, colItemName=8;
        BufferedReader br;
        String line = "",err="";
        String visitVn="", orderDate="", visitHn="", fullNamet="", paidNamet="", price2="", pricenet="", itemNumber="", itemName="";
        Connection conn;
        Statement st;
        Integer i=0;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            abl = getBillLabByPK(alb_id);
            //br = new BufferedReader(new FileReader(abl.getFilename()));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(abl.getFilename()), "UTF-8"));
            try {
                while ((line = br.readLine()) != null) {
                    try {
                        i++;
                        if(i==151){
                            err="";
                        }
                        if(i==9000){
                            err="";
                        }
                        if(i==9030){
                            err="";
                        }
                        if(i==9049){
                            err="";
                        }
                        String[] aaa = line.split("\\|");
                        if(aaa.length<colItemName) continue;
                        visitVn = aaa[colVn];
                        orderDate = aaa[colOrderDate];
                        visitHn = aaa[colHn];
                        fullNamet = aaa[colFullNamet];
                        paidNamet = aaa[colPaidNamet];
                        price2 = aaa[colPrice2];
                        pricenet = aaa[colPriceNet];
                        itemNumber = aaa[colItemNumber];
                        itemName = aaa[colItemName];
                        if(visitVn.equals("314/18-04-2560")){
                            err="";
                        }
                        abl_d = new AdminTBillLabDetail();
                        abl_d.setBillLabId(alb_id);
                        abl_d.setPatientFullnamet(fullNamet);
                        abl_d.setLabNamet("");
                        abl_d.setStatusApprove("0");
                        abl_d.setStatusAudit("0");
                        abl_d.setPatientVn(visitVn);
                        abl_d.setPriceNormalReceive(Double.parseDouble(price2));
                        abl_d.setPriceDiscountReceive(Double.parseDouble(pricenet));
                        abl_d.setLabId(itemNumber);
                        abl_d.setLabNamet(itemName);
                        abl_d.setDateOrder(config1.DateFormatShow2DB(orderDate,"ddMMyyyy"));
                        abl_d.setLabDetailActive("1");
                        abl_d.setPatientHnNo(visitHn);
                        abl_d.setQtyReceive(1.0);
                        abl_d.setNettotalReceive(Double.parseDouble(pricenet));
                        abl_d.setStatusApprove("0");
                        abl_d.setStatusAudit("0");
                        abl_d.setLabStatus("1");
                        SaveBillLabDetail(conn,st,abl_d);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch (Exception ex) {
                        Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            setUpdateAblReceive(alb_id);
            conn.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Integer setSaveBillLabDetailFromText(String bill_lab_id, String filename) throws FileNotFoundException{
        Integer chk=0,ii=0;
        String UTF8Str="", nettotal="", recordtotal="";
        BufferedReader input;
        BufferedReader in = null;
        Connection conn;
        Statement st;
            try {
                conn = config1.getConnectionBangna();
                st = conn.createStatement();
                input = new BufferedReader(new FileReader(filename));
                String line = "";
//                StringBuilder line1 = new StringBuilder();
                
                String a = "", num="", date="", year="";
                //in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "iso-8859-1"));
                //String[] aa ;
//                try {
//                    line1.append(input.readLine());
                    while ((line = input.readLine()) != null) {
//                    while (!line1.equals(null)) {
                        chk++;
                        try{
                            //UTF8Str = new String(line.getBytes(), "UTF-8");
                            abl_d = new AdminTBillLabDetail();
                            abl_d.setBillLabId(bill_lab_id);
                            StringTokenizer stz = new StringTokenizer(line, "|");
                            while (stz.hasMoreTokens()) {
                                a = stz.nextToken();
                                if(chk>=7163){
                                    //nettotal="";
                                    ii = stz.countTokens();
                                }
                                if(a.equals("Nettotal")){
                                    //nettotal = st.nextToken();
                                    nettotal = stz.nextToken();
                                    recordtotal = stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                }else if(a.equals("code")){
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                    stz.nextToken();
                                }else{
                                    abl_d.setPatientVn(a);
                                    date = config1.DateFormatShow2DB(stz.nextToken(),"ddMMyyyy");
                                    if(date.length()>=10){
                                        year = date.substring(0, 4);
                                        year = String.valueOf(Integer.parseInt(year) -543);
                                        date = year+date.substring(4, date.length());
                                        abl_d.setDateOrder(date);
                                        abl_d.setPatientHnNo(stz.nextToken());
                                        abl_d.setPatientFullnamet(stz.nextToken());
                                        stz.nextToken();
                                        abl_d.setLabId(stz.nextToken());
                                        abl_d.setLabNamet(stz.nextToken());

                                        num = stz.nextToken();
                                        if(num.equals("")){
                                            num="0.0";
                                        }
                                        abl_d.setPriceDiscountReceive(Double.parseDouble(num));

                                        stz.nextToken();
                                        stz.nextToken();
                                        stz.nextToken();
                                        num = stz.nextToken();
                                        if(num.equals("")) {
                                            num="0.0";
                                        }
                                        abl_d.setPriceNormalReceive(Double.parseDouble(num));
                                        stz.nextToken();
                                        num = stz.nextToken();
                                        if(num.equals("")){
                                            num="0.0";
                                        }
                                        abl_d.setNettotalReceive(Double.parseDouble(num));
                                        stz.nextToken();
                                        stz.nextToken();
                                        abl_d.setPatientFullnamet("");
                                        abl_d.setLabNamet("");
                                        abl_d.setStatusApprove("0");
                                        abl_d.setStatusAudit("0");
                                        SaveBillLabDetail(conn,st,abl_d);
                                    }else{
                                        stz.nextToken();
                                        stz.nextToken();
                                        stz.nextToken();
                                        stz.nextToken();
                                        
                                        stz.nextToken();
                                        if(stz.hasMoreTokens()){
                                            stz.nextToken();
                                            stz.nextToken();
                                            stz.nextToken();
                                            stz.nextToken();
                                            stz.nextToken();
                                            stz.nextToken();
                                            stz.nextToken();
                                            stz.nextToken();
                                        }
                                    }
                                }
                            }
                        } catch(Exception ex){
                            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {

                        }
                    }
                    input.close();
//                } catch (Exception ex) {
//                    Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
//                } finally {
//
//                }
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        if(!nettotal.equals("")){
            recordtotal = String.valueOf(Integer.parseInt(recordtotal)-1);
            setUpdateBillLabReveive(bill_lab_id, nettotal, recordtotal);
        }
        return chk;
    }
    public String getTRBillLabDetail(String bill_lab_id, String date_order, String field){
        String txt="",sql="", date_order1="",txt_uncorrect="'", row_color="", font_color1="";
        String txt_color="", txt_color1="", selected="",txtH="", txtF="";
        Vector v_bill_lab_detail = new Vector();
        AdminTBillLabDetail ablD = new AdminTBillLabDetail();
        v_bill_lab_detail = getBillLabDetail(bill_lab_id,date_order, field);
        boolean chk=false;
        Double discount=0.0;
        for(int i=0;i<=v_bill_lab_detail.size()-1;i++) {
            ablD = (AdminTBillLabDetail) v_bill_lab_detail.get(i);
            date_order1 = ablD.getDateOrder();
            date_order1 = date_order1.replace("-", "");
            //bill_lab_id1 = bill_lab_detail.getBillLabId();
            if(field.equals("date")) {
                try {
                    AdminTBillLabDetail bill_lab_detail_uncorrect = new AdminTBillLabDetail();
                    Vector v_bill_lab_detail_uncorrect = new Vector();
                    txt_uncorrect="";
                    if(ablD.getDateOrder().equals("2009-07-06")){
                        sql="2009-07-06";
                    }
                    if (ablD.getStatusAudit().equals("1")){
                        v_bill_lab_detail_uncorrect = getBillLabDetail(bill_lab_id,ablD.getDateOrder(), "date_audit_uncorrect");
                        for(int j=0;j<=v_bill_lab_detail_uncorrect.size()-1;j++){
                            bill_lab_detail_uncorrect = (AdminTBillLabDetail) v_bill_lab_detail_uncorrect.get(j);
                            txt_uncorrect+="<td align='center' width='20'>" +txt_color+ bill_lab_detail_uncorrect.getLabId()+txt_color1 + "</td>";
                            if(v_bill_lab_detail_uncorrect.size()==1){
                                txt_uncorrect+="<td align='center' width='20'>0</td>";
                                chk=false;
                                row_color="";
                                txt_color="";
                                txt_color1="";
                            }else{
                                chk=true;
                                row_color = "bgcolor='#FCF1F6'";
                                txt_color="<font color='#FF7F00'>";//#CC3333
                                txt_color1="</font>";
                            }
                        }
                    }
                    
                    if(txt_uncorrect.equals("")){
                        txt_uncorrect="<td align='center' width='20'>0</td><td align='center' width='20'>0</td>";
                    }
                    txt += "<tr  class='style14r' "+row_color+"><td align='center'>" + String.valueOf(i + 1) + "</td>"
+ "<td align='center' width='8'><A HREF='javascript:showDetail("
+ date_order1 + ")'  >"
    +txt_color+ config1.DateFormatDB2Show(ablD.getDateOrder(), "ddMMyyyy") +txt_color1+ "</A></td>"
    + "<td align='center' width='10'>"+txt_color + ablD.getPatientHnNo() +txt_color1+ "</td>"
    + "<td align='center' width='10'>"+txt_color + ablD.getLabId() +txt_color1+ "</td>"
    +"<td align='center' width='10'>"+txt_color + config1.NumberFormat(ablD.getNettotalReceive()) +txt_color1+ "</td>"    ;
    
    txt = txt+txt_uncorrect
+ "<td align='center' width='10'>"+txt_color + config1.NumberFormat(ablD.getNettotalApprove()) +txt_color1+ "</td></tr>";
//                txt += "<tr  class='style14r'><td align='center'>"+String.valueOf(i+1)+"</td>"
//                +"<td align='center' width='10'><A HREF='javascript:window.open(admin_bill_lab_detail_show.jsp?date_order="
//                +bill_lab_detail.getDateOrder()+"&bill_lab_id="+bill_lab_detail.getBillLabId()+",_blank,width=500, height=150, left=300,top=100,channelmode=no,status=no,fullscreen=no,menubar=no,resizable=no,scrollbars=no,location=no,directories=no,true);'>"
//                +bill_lab_detail.getDateOrder()+"</A></td>"
//                +"<td align='center' width='10'>"+bill_lab_detail.getPatientHnNo()+"</td><td></td>"
//                +"<td align='center' width='10'>"+bill_lab_detail.getNettotalReceive()+"</td>"
//                +"<td align='center' width='10'>"+bill_lab_detail.getNettotalApprove()+"</td></tr>";
                } catch (Exception ex) {
                    Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
                }
//                txt += "<tr  class='style14r'><td align='center'>"+String.valueOf(i+1)+"</td>"
//                +"<td align='center' width='10'><A HREF='javascript:window.open(admin_bill_lab_detail_show.jsp?date_order="
//                +bill_lab_detail.getDateOrder()+"&bill_lab_id="+bill_lab_detail.getBillLabId()+",_blank,width=500, height=150, left=300,top=100,channelmode=no,status=no,fullscreen=no,menubar=no,resizable=no,scrollbars=no,location=no,directories=no,true);'>"
//                +bill_lab_detail.getDateOrder()+"</A></td>"
//                +"<td align='center' width='10'>"+bill_lab_detail.getPatientHnNo()+"</td><td></td>"
//                +"<td align='center' width='10'>"+bill_lab_detail.getNettotalReceive()+"</td>"
//                +"<td align='center' width='10'>"+bill_lab_detail.getNettotalApprove()+"</td></tr>";
            txtH="<table border='0' width='100%' align='center'><thead>"
        +"<tr align='center' class='style14r'><th width='5' align='center'>ลำดับที่</th>"
            +"<th width='8'>วันที่</th>"+"<th width='10'>จน ผู้ป่วย</th>"+"<th width='10'>จน รายการ</th>"+"<th width='10'>จน เงินวางบิล</th>"
            +"<th width='20'>จน ที่ตรวจพบ</th>"+"<th width='20'>จน ที่ตรวจไม่พบ</th>"+"<th width='10'>จน เงินอนุมัติ</th>"+"</tr></thead><tbody>";
        txtF=" </tbody></table>";
            }else if(field.equals("date_day")){
                if(ablD.getStatusApprove().equals("3")){
                    row_color = "bgcolor='#FCF1F6'";
                    txt_color="<font color='#FF7F00'>";//#CC3333
                    txt_color1="</font>";
                }else{
                    row_color="";
                    txt_color="";
                    txt_color1="";
                }
                if(ablD.getStatusApprove().equals("1")){
                    selected="checked='checked'";
                }else{
                    selected="";
                }
                discount = ablD.getPriceNormalReceive() - ablD.getPriceDiscountReceive();
                txt += "<tr  class='style14r' "+row_color+"><td align='center'>"+String.valueOf(i+1)+"</td>"
                +"<td align='center' width='70'><label>"
        +"<input type='checkbox' name='chk_repair_status' value='on' id='chk_status_approve_"
    +ablD.getPatientHnNo()+"_"+ablD.getLabId()+"' name='chk_status_approve_"
    +ablD.getPatientHnNo()+"_"+ablD.getLabId()+"' "+selected+">"
        +"อนุมัติ</label></td>"
                +"<td align='center' width='10'><A HREF='javascript:showDetail("
                +date_order1+");'>"
                +txt_color+ablD.getPatientHnNo()+txt_color1+"</A></td>"
                +"<td align='left' width='200'>"+txt_color+ablD.getPatientFullnamet()+txt_color1+"</td>"
                +"<td align='center' width='25'>"+txt_color+ablD.getLabId()+txt_color1+"</td>"
                +"<td align='left' width='200'>"+txt_color+ablD.getLabNamet()+txt_color1+"</td>"
                +"<td align='center' width='10'>"+txt_color+config1.IntegerFormat(ablD.getQtyReceive())+txt_color1+"</td>"
                +"<td align='center' width='10'>"
    +"<input type='input' value='"+config1.IntegerFormat(ablD.getQtyApprove())+"' id='txt_qty_approve_"
    +ablD.getPatientHnNo()+"_"+ablD.getLabId()+"' name='txt_qty_approve_"
    +ablD.getPatientHnNo()+"_"+ablD.getLabId()+"' align='right' size='1' ></td>"
                +"<td align='center' width='50'>"+txt_color+config1.NumberFormat(ablD.getPriceNormalReceive())+txt_color1+"</td>"
                +"<td align='center' width='50'>"+txt_color+config1.NumberFormat(discount)+txt_color1+"</td>"
                +"<td align='center' width='50'>"
        +"<input type='input' value='"+config1.NumberFormat(ablD.getNettotalReceive())+"' id='txt_price_approve_"
        +ablD.getPatientHnNo()+"_"+ablD.getLabId()+"' name='txt_price_approve_"
        +ablD.getPatientHnNo()+"_"+ablD.getLabId()+"' align='right' size='5'></td>"
                +"<td align='center' width='50' bgcolor='#FCF1F6'>"
        +"<input type='input' value='"+ablD.getNettotalApprove()+"' id='txt_nettotal_approve_"
        +ablD.getPatientHnNo()+"_"+ablD.getLabId()+"' name='txt_nettotal_approve_"
        +ablD.getPatientHnNo()+"_"+ablD.getLabId()+"' align='right' size='5'> </td></tr>";
            }
            if(i==4){
                sql="";
            }
        }
        if(txt.equals("")){
            txt="<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>";
        }
        
        return txtH+txt+txtF;
    }
    public void setPatientFullNameT(String branch_id,String bill_lab_id){
        String sql="", patient_fullnamet="", patient_hn_no="";
        //Integer i=0;
        Connection connmainhis, connbangna;
        Statement stmainhis, stbangna;
        ResultSet rsmainhis, rsbangna;
        Vector v_patient = new Vector();
        AdminTBillLabDetail bill_lab_detail = new AdminTBillLabDetail();
        //Vector v_full_namet = new Vector();
        try {
            connmainhis = config1.getConnectionMainHIS(branch_id);
            connbangna = config1.getConnectionBangna();
            stbangna = connbangna.createStatement();
            stmainhis = connmainhis.createStatement();
            sql="Select "+abl_d.getFPatientHNNO()+" "
                +"From "+abl_d.getAdminTBillLabDetail()+" "
                +"Where "+abl_d.getFBillLabId()+"='"+bill_lab_id+"' "
                +"Group By "+abl_d.getFPatientHNNO();
            rsbangna = stbangna.executeQuery(sql);
            while(rsbangna.next()){
                bill_lab_detail = new AdminTBillLabDetail();
                patient_hn_no = rsbangna.getString("patient_hn_no");
                bill_lab_detail.setPatientHnNo(patient_hn_no);
                v_patient.add(bill_lab_detail);
                sql="Update ";
            }
            rsbangna.close();
            connbangna.close();


            for(int i=0;i<=v_patient.size()-1;i++){
                bill_lab_detail = (AdminTBillLabDetail)v_patient.get(i);
                sql="Select pm02.mnc_pfix_dsc + ' ' + pm01.mnc_fname_t + ' ' + pm01.mnc_lname_t as patient_fullnamet "
                    +"From patient_m01 as pm01 inner join "
                    +"patient_m02 pm02 on pm01.mnc_pfix_cdt = pm02.mnc_pfix_cd "
                    +"Where pm01.mnc_hn_no ='"+bill_lab_detail.getPatientHnNo()+"'";
                rsmainhis = stmainhis.executeQuery(sql);
                while(rsmainhis.next()){
                    patient_fullnamet = rsmainhis.getString("patient_fullnamet");
                    bill_lab_detail.setPatientFullnamet(patient_fullnamet);
                    v_patient.set(i, bill_lab_detail);
                }
                rsmainhis.close();
            }
            connmainhis.close();

            connbangna = config1.getConnectionBangna();
            stbangna = connbangna.createStatement();
            for(int i=0;i<=v_patient.size()-1;i++){
                bill_lab_detail = (AdminTBillLabDetail)v_patient.get(i);
                sql="Update "+abl_d.getAdminTBillLabDetail()
                    +" Set "+abl_d.getFPatientFullNamet()+"='"+bill_lab_detail.getPatientFullnamet()+"' "
                    +"Where "+abl_d.getFPatientHNNO()+"='"+bill_lab_detail.getPatientHnNo()+"'";
                stbangna.executeUpdate(sql);
            }
            connbangna.close();
            
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setLabNameT(String branch_id,String bill_lab_id){
        String sql="", lab_namet="", lab_id="";
        //Integer i=0;
        Connection connmainhis, connbangna;
        Statement stmainhis, stbangna;
        ResultSet rsmainhis, rsbangna;
        Vector v_lab = new Vector();
        AdminTBillLabDetail bill_lab_detail = new AdminTBillLabDetail();
        //Vector v_full_namet = new Vector();
        try {
            connmainhis = config1.getConnectionMainHIS(branch_id);
            connbangna = config1.getConnectionBangna();
            stbangna = connbangna.createStatement();
            stmainhis = connmainhis.createStatement();
            sql="Select "+abl_d.getFLabId()+" "
                +"From "+abl_d.getAdminTBillLabDetail()+" "
                +"Where "+abl_d.getFBillLabId()+"='"+bill_lab_id+"' "
                +"Group By "+abl_d.getFLabId();
            rsbangna = stbangna.executeQuery(sql);
            while(rsbangna.next()){
                bill_lab_detail = new AdminTBillLabDetail();
                lab_id = rsbangna.getString("lab_id");
                bill_lab_detail.setLabId(lab_id);
                v_lab.add(bill_lab_detail);
                sql="Update ";
            }
            rsbangna.close();
            connbangna.close();

            for(int i=0;i<=v_lab.size()-1;i++){
                bill_lab_detail = (AdminTBillLabDetail)v_lab.get(i);
                sql="Select mnc_lb_dsc "
                    +"From lab_m01 "
                    +"Where mnc_lb_cd ='"+bill_lab_detail.getLabId()+"'";
                rsmainhis = stmainhis.executeQuery(sql);
                while(rsmainhis.next()){
                    lab_namet = rsmainhis.getString("mnc_lb_dsc");
                    bill_lab_detail.setLabNamet(lab_namet);
                    v_lab.set(i, bill_lab_detail);
                }
                rsmainhis.close();
            }
            connmainhis.close();

            connbangna = config1.getConnectionBangna();
            stbangna = connbangna.createStatement();
            for(int i=0;i<=v_lab.size()-1;i++){
                bill_lab_detail = (AdminTBillLabDetail)v_lab.get(i);
                lab_namet =bill_lab_detail.getLabNamet();
                lab_namet = lab_namet.replace("'", "''");
                sql="Update "+abl_d.getAdminTBillLabDetail()
                    +" Set "+abl_d.getFLabNamet()+"='"+lab_namet+"' "
                    +"Where "+abl_d.getFLabId()+"='"+bill_lab_detail.getLabId()+"'";
                stbangna.executeUpdate(sql);
            }
            connbangna.close();

        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getBillLabMainHIS(String branchId, String DateOrder, String hnNo, String labNumber){
        String sql="", txt="";
        Integer i=0;
        boolean chk=false;
        Connection connmainhis;
        Statement st;
//        ResultSet rs;
        try {
            connmainhis = config1.getConnectionMainHIS(branchId);
            st = connmainhis.createStatement();
            txt = getBillLabMainHIS(st, branchId, DateOrder, hnNo, labNumber);
            connmainhis.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       return txt;
    }
    public String getBillLabMainHIS(Statement st,String branch_id, String date_order, String hn_no, String lab_id){
        String sql="", txt="";
        Integer i=0;
        boolean chk=false;
//        Connection connmainhis;
//        Statement st;
        ResultSet rs;
        try {
//            connmainhis = config1.getConnectionMainHIS(branch_id);
//            st = connmainhis.createStatement();
            if(lab_id.equals("")){
                sql = "SELECT (pm02.mnc_pfix_dsc + ' ' + pm26.MNC_DOT_FNAME + ' ' + pm26.MNC_DOT_LNAME) as doctor_name, "
                    +"fm02.MNC_FN_STS, labm02.MNC_LB_PRI, labm01.mnc_lb_dsc , labt01.MNC_ORD_DOT, labt01.mnc_patname, labt02.mnc_lb_cd "
                    +"FROM LAB_T01 as labt01 "
                    +"left JOIN LAB_T02 as labt02 ON labt01.MNC_REQ_YR = labt02.MNC_REQ_YR "
                    +"AND labt01.MNC_REQ_NO = labt02.MNC_REQ_NO AND labt01.MNC_REQ_DAT = labt02.MNC_REQ_DAT "
                    +"left JOIN LAB_M02 as labm02 ON labt02.MNC_LB_CD = labm02.MNC_LB_CD "
                    +"left JOIN finance_m02 as fm02 ON labt01.MNC_FN_TYP_CD = fm02.MNC_FN_TYP_CD "
                    +"left JOIN patient_m26 as pm26 ON labt01.MNC_DOT_CD = pm26.MNC_DOT_CD "
                    +"left join lab_m01 as labm01 on labm01.mnc_lb_cd = labm02.mnc_lb_cd "
                    +"left join patient_m02 as pm02 on pm26.mnc_dot_pfix = pm02.mnc_pfix_cd "
                    +"WHERE (labt01.MNC_REQ_STS <> 'C') AND (labt01.MNC_REQ_DAT between '"+date_order+"' and '"+date_order+"') "
                    +"and labt01.mnc_hn_no = '"+hn_no+"' "
                    +"Order by pm26.MNC_DOT_FNAME, pm26.MNC_DOT_LNAME, fm02.MNC_FN_STS, labm01.mnc_lb_dsc ";
            }
            else{
                sql = "SELECT (pm02.mnc_pfix_dsc + ' ' + pm26.MNC_DOT_FNAME + ' ' + pm26.MNC_DOT_LNAME) as doctor_name, "
                    +"fm02.MNC_FN_STS, labm02.MNC_LB_PRI, labm01.mnc_lb_dsc , labt01.MNC_ORD_DOT, labt01.mnc_patname, labt02.mnc_lb_cd "
                    +"FROM LAB_T01 as labt01 "
                    +"left JOIN LAB_T02 as labt02 ON labt01.MNC_REQ_YR = labt02.MNC_REQ_YR "
                    +"AND labt01.MNC_REQ_NO = labt02.MNC_REQ_NO AND labt01.MNC_REQ_DAT = labt02.MNC_REQ_DAT "
                    +"left JOIN LAB_M02 as labm02 ON labt02.MNC_LB_CD = labm02.MNC_LB_CD "
                    +"left JOIN finance_m02 as fm02 ON labt01.MNC_FN_TYP_CD = fm02.MNC_FN_TYP_CD "
                    +"left JOIN patient_m26 as pm26 ON labt01.MNC_DOT_CD = pm26.MNC_DOT_CD "
                    +"left join lab_m01 as labm01 on labm01.mnc_lb_cd = labm02.mnc_lb_cd "
                    +"left join patient_m02 as pm02 on pm26.mnc_dot_pfix = pm02.mnc_pfix_cd "
                    +"WHERE (labt01.MNC_REQ_STS <> 'C') AND (labt01.MNC_REQ_DAT between '"+date_order+"' and '"+date_order+"') "
                    +"and labt01.mnc_hn_no = '"+hn_no+"' and labt02.mnc_lb_cd = '"+lab_id+"' "
                    +"Order by pm26.MNC_DOT_FNAME, pm26.MNC_DOT_LNAME, fm02.MNC_FN_STS, labm01.mnc_lb_dsc ";
            }
//            st = connmainhis.createStatement();
            rs = st.executeQuery(sql);
            chk=false;
            while(rs.next()){
                i++;
                txt += "<tr  class='style14r'><td align='center'>" + i.toString() + "</td>"
                + "<td align='left' width='200'>"
                    + rs.getString("doctor_name") + "</td>"
                    + "<td align='center' width='7'>" + rs.getString("MNC_FN_STS") + "</td>"
                    + "<td align='left' width='100'>" + rs.getString("mnc_patname") + "</td>"
                    + "<td align='center' width='10'>" + rs.getString("mnc_lb_cd") + "</td>"
                    + "<td align='left' width='80'>" + rs.getString("mnc_lb_dsc") + "</td>"
                    + "<td align='center' width='50'>" + rs.getString("MNC_ORD_DOT") + "</td>"
                    + "<td align='center' width='50'>" + rs.getString("MNC_LB_PRI") + "</td></tr>";
                chk=true;
            }
            rs.close();
//            connmainhis.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       return txt;
    }
    public String getBillLabHospitalOS(Statement st,String branchId, String dateOrder, String hnNo, String labNumber){
        String sql="", txt="", labNumberSearch="";
        Integer i=0;
        ResultSet rs;
        try {
            if(labNumber.equals("")){
            }else{
                labNumberSearch = " and ";
            }
            sql = "Select trl.* "
                    + "From t_result_lab trl "
                    + "left join b_item bi on bi.b_item_id = trl.b_item_id "
                    + "left join t_patient tp on tp.t_patient_id = tp.t_patient_id "
                    + "left join t_order tor on tor.t_order_id = trl.t_order_id "
                    + "Where trl.result_lab_active = '1' and tp.patient_hn = '"+hnNo+"' and substring(tor.order_date_time,0,11) = '"+dateOrder+"' and "
                    + "bi.item_number = '"+labNumber+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                i++;
                txt += "<tr  class='style14r'><td align='center'>" + i.toString() + "</td>";
//                + "<td align='left' width='200'>"
//                    + rs.getString("doctor_name") + "</td>"
//                    + "<td align='center' width='7'>" + rs.getString("MNC_FN_STS") + "</td>"
//                    + "<td align='left' width='100'>" + rs.getString("mnc_patname") + "</td>"
//                    + "<td align='center' width='10'>" + rs.getString("mnc_lb_cd") + "</td>"
//                    + "<td align='left' width='80'>" + rs.getString("mnc_lb_dsc") + "</td>"
//                    + "<td align='center' width='50'>" + rs.getString("MNC_ORD_DOT") + "</td>"
//                    + "<td align='center' width='50'>" + rs.getString("MNC_LB_PRI") + "</td></tr>";
            }
            rs.close();
//            connmainhis.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       return txt;
    }
    public void setBillLabAudit(String branch_id, String bill_lab_id, String date_order, String field) {
        //asdfjalksdfjal;sdkfjla;skdfjla;sdkf
        String sql="", dateOrderdb="", txt="";
        boolean chk=false;
        Connection conn, connUpdate;
        Statement stSelect, stUpdate;
        Vector v_bill_lab_detail = new Vector();
        AdminTBillLabDetail bill_lab_detail = new AdminTBillLabDetail();
        BBranch branch = new BBranch();
        try {
            
            branch = config1.getBranch(branch_id);
            if(branch.getBranchProgram().equals("mainhis")) conn = config1.getConnectionMainHIS(branch_id);
            else conn = config1.getConnectionHospital(branch_id);
            connUpdate = config1.getConnectionBangna();
            stSelect = conn.createStatement();
            stUpdate = connUpdate.createStatement();
            v_bill_lab_detail = getBillLabDetail(bill_lab_id,date_order, field);
            for(int i=0;i<=v_bill_lab_detail.size()-1;i++) {
                bill_lab_detail = (AdminTBillLabDetail) v_bill_lab_detail.get(i);
                try {
                    chk=false;
                    if(field.equals("date_day")){
                        if(branch.getBranchProgram().equals("mainhis")){
                            dateOrderdb = config1.DateFormatShowHospital2DB(config1.DateFormatDB2Show(bill_lab_detail.getDateOrder(), "ddMMyyyy"),"ddMMyyyy");
                            txt=getBillLabMainHIS(stSelect,branch_id,dateOrderdb,bill_lab_detail.getPatientHnNo(),bill_lab_detail.getLabId());
                        }else{
                            txt=getBillLabHospitalOS(stSelect,branch_id,bill_lab_detail.getDateOrder(),bill_lab_detail.getPatientHnNo(),bill_lab_detail.getLabId());
                        }
                        if(!txt.equals("")){
                            setUpdateBillLabDetailStatusAudit(stUpdate,bill_lab_detail.getBillLabDetailId(),"1");
                        }else{
                            setUpdateBillLabDetailStatusAudit(stUpdate,bill_lab_detail.getBillLabDetailId(),"3");
                        }
                    }else if(field.equals("date")){

                    }
                } catch (Exception ex) {
                    Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
                }
    //            dateOrderdb = dateOrderdb.replace("-", "");
                //bill_lab_id1 = bill_lab_detail.getBillLabId();
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        setUpdateBillLabAudit(bill_lab_id);
    }
    public void setBillLabAuditAllBillId(String branch_id, String bill_lab_id){
        String sql="", date_order="", txt="";
        boolean chk=false;
        Vector v_bill_lab_detail = new Vector();
        AdminTBillLabDetail bill_lab_detail = new AdminTBillLabDetail();
        //AdminTBillLabDetail bill_lab_detail1 = new AdminTBillLabDetail();
        v_bill_lab_detail = getBillLabDetail(bill_lab_id,"", "date");
        for(int i=0;i<=v_bill_lab_detail.size()-1;i++){
            bill_lab_detail = (AdminTBillLabDetail)v_bill_lab_detail.get(i);
            date_order = bill_lab_detail.getDateOrder();
            setBillLabAudit(branch_id, bill_lab_id, date_order,"date_day");
        }
    }
    public void setBillLabApproveAllBillId(String bill_lab_id){
        String sql="", date_order="", txt="";
        boolean chk=false;
        Connection conn;
        Statement st;
        Integer chk1=0;
//        Vector v_bill_lab_detail = new Vector();
//        AdminTBillLabDetail abl_d = new AdminTBillLabDetail();
        //AdminTBillLabDetail bill_lab_detail1 = new AdminTBillLabDetail();
//        sql="Update "+abl_d.getAdminTBillLabDetail()
//            +" Set "+abl_d.getFStatusApprove()+" = '1', "
//            +abl_d.getFPriceApprove()+" = "+abl_d.getFPriceAudit() + ", "
//            +abl_d.getFNetTotalApprove()+" = "+abl_d.getFNetTotalAudit()+" "
//            +"Where "+abl_d.getFBillLabId() + "='"+bill_lab_id+"' and "
//            +abl_d.getFStatusApprove()+"='0' and "+abl_d.getFStatusAudit()+"='1'";
        sql="Update "+abl_d.getAdminTBillLabDetail()
            +" Set "+abl_d.getFStatusApprove()+" = '1', "
            +abl_d.getFPriceApprove()+" = "+abl_d.getFPriceAudit() + ", "
            +abl_d.getFNetTotalApprove()+" = "+abl_d.getFNetTotalAudit()+", "
            +abl_d.getFQtyApprove()+" = "+abl_d.getFQtyAudit()+" "
            +"Where "+abl_d.getFBillLabId() + "='"+bill_lab_id+"' ";
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            chk1 = st.executeUpdate(sql);
            sql="Update "+abl_d.getAdminTBillLabDetail()
                +" Set "+abl_d.getFStatusApprove()+" = '3' "
                +"Where "+abl_d.getFBillLabId() + "='"+bill_lab_id+"' and "
                +abl_d.getFStatusApprove()+"='0' and "+abl_d.getFStatusAudit()+"='3'";
            chk1 = st.executeUpdate(sql);
            setUpdateBillLabApprove(bill_lab_id,conn);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateBillLabApprove(String bill_lab_id,Connection conn){
        String sql="", cnt_receive="", cnt_approve="", cnt_unapprove="";
        String sum_approve="", sum_unapprove="",sum_receive="";
//        Connection conn;
        Statement st;
        ResultSet rs;
        try {
//            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select count("+abl_d.getFBillLabId()+") as cnt_approve, "
                    +abl_d.getFStatusApprove() + ", "
                    +"sum("+abl_d.getFNetTotalApprove() + ") as sum_approve "
                +"From "+abl_d.getAdminTBillLabDetail() +" "
                +"Where "+abl_d.getFBillLabId()+" ='"+bill_lab_id+"' "
                +"Group By "+abl_d.getFStatusApprove();
            rs = st.executeQuery(sql);
            while(rs.next()){
                if(rs.getString(abl_d.getFStatusApprove()).equals("1")){
                    cnt_approve=rs.getString("cnt_approve");
                    sum_approve=rs.getString("sum_approve");
                }else if(rs.getString(abl_d.getFStatusApprove()).equals("3")){
                    cnt_unapprove=rs.getString("cnt_approve");
                    sum_unapprove=rs.getString("sum_approve");
                }
            }
            rs.close();
            if(cnt_approve == null ||cnt_approve.equals("")){
                cnt_approve="0";
            }
            if(cnt_unapprove == null ||cnt_unapprove.equals("")){
                cnt_unapprove="0";
            }
            if(sum_unapprove == null ||sum_unapprove.equals("")){
                sum_unapprove="0";
            }
            if(sum_approve == null ||sum_approve.equals("")){
                sum_approve="0";
            }
            sql="Select count("+abl_d.getFBillLabId()+") as cnt_receive, "
                    +"sum("+abl_d.getFNetTotalApprove()+") as sum_receive "
                    +"From "+abl_d.getAdminTBillLabDetail() +" "
                    +"Where "+abl_d.getFBillLabId()+" ='"+bill_lab_id+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
//                if(rs.getString(admintbilllabdetail.getFStatusApprove()).equals("1")){
                    cnt_receive=rs.getString("cnt_receive");
                    sum_receive=rs.getString("sum_receive");
//                }
            }
            rs.close();
            if(cnt_receive== null ||cnt_receive.equals("")){
                cnt_receive="0";
            }
            
            sql="Update "+abl.getAdminTBillLab() +" Set "
//                    +admintbilllab.getFTotalRecordReveive()+" = "+cnt_receive+", "                    
//                    +admintbilllab.getFTotalAmountReceive()+" = "+sum_receive+", "
                    +abl.getFTotalRecordApprove()+" = "+cnt_approve+", "
                    +abl.getFTotalAmountApprove()+" = "+sum_approve+", "
                    +abl.getFTotalRecordUnApprove()+" = "+cnt_unapprove+", "
                    +abl.getFTotalAmountUnApprove()+" = "+sum_unapprove+" "
                    +"Where "+abl.getFBillLabId()+" = '"+bill_lab_id+"'";
            st.executeUpdate(sql);
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setUpdateBillLabReveive(String bill_lab_id,String netotal, String recordtotal){
        Connection conn;
        Statement st;
        String sql="";
        try {
            netotal = netotal.replace(",", "");
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+abl.getAdminTBillLab() +" Set "
                    +abl.getFTotalRecordReveive()+" = "+recordtotal+", "
                    +abl.getFTotalAmountReceive()+" = "+netotal+" "
                    +"Where "+abl.getFBillLabId()+" = '"+bill_lab_id+"'";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setDeleteBillLabDetailByBillLabId(String bill_lab_id){
        Connection conn;
        Statement st;
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Delete From "+abl_d.getAdminTBillLabDetail()
                + " Where "+abl_d.getFBillLabId() + " ='"+bill_lab_id +"'";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setUpdateAblReceive(String ablId){
        Connection conn;
        Statement st;
        String sql="", netPrice="", cnt="";
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Select sum("+abl_d.getFPriceDiscountReceive()+") as net_price,count(1) as cnt "//ต้องใช้ price discount เพราะเป็นราคาที่ลดแล้ว
                    + "From "+abl_d.getAdminTBillLabDetail()+" "
                + " Where "+abl.getFBillLabId() + " ='"+ablId +"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cnt = rs.getString("cnt");
                netPrice = rs.getString("net_price");
            }
            rs.close();
            sql = "Update "+abl.getAdminTBillLab()+" Set "
                    +abl.getFTotalAmountReceive()+"="+netPrice+","+abl.getFTotalRecordReveive()+"="+cnt
                    +" Where "+abl.getFBillLabId()+"='"+ablId+"'";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getTrBillingLab(String branchId, String yearId){
        String text="",row_color="",txt_color="",txt_color1="", txtH="",txtF="";
        Vector v_bill_lab = getBillLab(branchId,yearId,"year");
        for(Integer i=0;i<=v_bill_lab.size()-1;i++){
            abl = (AdminTBillLab)v_bill_lab.get(i);
            text+="<tr class='style14r' "+row_color+"> <td align='center' width='30'>"+(i+1)+"</td>"
                +"<td align='center' width='30'>"+abl.getBillLabId()+"</td>"
                +"<td width='150'><div align='left'><A HREF='billinglab_add.jsp?abl_id="+abl.getBillLabId()
                +"&flagpage=viewdetail' name='admin_bill_lab_add' id='admin_bill_lab_add'> "+txt_color+abl.getBillLabDescription()+txt_color1+"</a></div></td>"
                +"<td width='150'>"+txt_color+abl.getBillLabRemark()+txt_color1+"</td>"
                +"<td width='50'>"+txt_color+config1.IntegerFormat(abl.getTotalRecordReceive())+txt_color1+"</td>"
                +"<td width='50'>"+txt_color+config1.NumberFormat(abl.getTotalAmountReceive())+txt_color1+"</td>"
                +"<td width='50'>"+txt_color+config1.NumberFormat(abl.getTotalAmountApprove())+txt_color1+"</td>"
                +"</tr>";
        }
        if(text.equals("")){
            text="<tr class='style14r' "+row_color+"> <td align='center'>1</td><td>ไม่พบข้อมูล</td><td></td><td></td></tr>";
        }
        txtH="<table border='0' width='100%'><thead><tr bgcolor='#336699'  class='style14w'>"
                + "<th width='15' ><div align='center'>ลำดับ</div></th>"
                + "<th width='15' ><div align='center'>เลขที่</div></th>"
                + "<th width='150' ><div align='center'>รายละเอียด</div></th>"
                + "<th width='150' bgcolor='#336699' ><div align='center'>หมายเหตุ</div></th>"
                + "<th width='90' bgcolor='#336699' ><div align='center'>จำนวนข้อมูล</div></th>"
                + "<th width='90' bgcolor='#336699' ><div align='center'>เงินวางบิล</div></th>"
                + "<th width='90' bgcolor='#336699' ><div align='center'>เงินอนุมัติ</div></th>"
                + "</tr></thead>";
        txtF="</table>";
        return txtH+text+txtF;
    }
    public void setUpdateBillLabVoid(String ablId){
        Connection conn;
        Statement st;
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+abl.getAdminTBillLab() +" Set "
                    +abl.getFBillLabActive()+" = '3' "
                    +"Where "+abl.getFBillLabId()+" = '"+ablId+"'";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String setUpateAdminTBillingLab(String branchId,String ablId, String yearId, String monthId, String periodId,
            String description, String remark){
        Connection conn;
        Statement st;
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql="Update "+abl.getAdminTBillLab() +" Set "
                +abl.getFBillLabMonth()+" = '"+monthId+"', "+abl.getFBillLabPeriod()+"='"+periodId+"', "
                +abl.getFBillLabYear()+"='"+yearId+"', "+abl.getFBillLabDescription()+"='"+description+"', "
                +abl.getFBillLabRemark()+"='"+remark+"' "
                +"Where "+abl.getFBillLabId()+" = '"+ablId+"' and "+abl.getFBranchId()+"='"+branchId+"'";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(AdminTBillLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
