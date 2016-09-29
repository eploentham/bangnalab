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
@Table(name = "typeprice")
@NamedQueries({
    @NamedQuery(name = "Typeprice.findAll", query = "SELECT t FROM Typeprice t")})
public class Typeprice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "tpricode")
    private String tpricode="";
    @Column(name = "tprinamet")
    private String tprinamet="";
    @Id
    @Basic(optional = false)
    @Column(name = "sort1")
    private Double sort1=0.0;
    @Column(name = "remark")
    private String remark="";

    public Typeprice() {
    }

    public Typeprice(Double sort1) {
        this.sort1 = sort1;
    }

    public String getTpricode() {
        return tpricode;
    }
    public void setTpricode(String tpricode) {
        this.tpricode = tpricode;
    }

    public String getTprinamet() {
        return tprinamet;
    }
    public void setTprinamet(String tprinamet) {
        this.tprinamet = tprinamet;
    }

    public Double getSort1() {
        return sort1;
    }
    public void setSort1(Double sort1) {
        this.sort1 = sort1;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sort1 != null ? sort1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeprice)) {
            return false;
        }
        Typeprice other = (Typeprice) object;
        if ((this.sort1 == null && other.sort1 != null) || (this.sort1 != null && !this.sort1.equals(other.sort1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnalab.Typeprice[sort1=" + sort1 + "]";
    }

}
