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
@Table(name = "typepricelab")
@NamedQueries({
    @NamedQuery(name = "Typepricelab.findAll", query = "SELECT t FROM Typepricelab t")})
public class Typepricelab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tpriceid")
    private Double tpriceid=0.0;
    @Column(name = "tpricenamee")
    private String tpricenamee="";
    @Column(name = "flag")
    private String flag="";

    public Typepricelab() {
    }

    public Typepricelab(Double tpriceid) {
        this.tpriceid = tpriceid;
    }

    public Double getTpriceid() {
        return tpriceid;
    }

    public void setTpriceid(Double tpriceid) {
        this.tpriceid = tpriceid;
    }

    public String getTpricenamee() {
        return tpricenamee;
    }

    public void setTpricenamee(String tpricenamee) {
        this.tpricenamee = tpricenamee;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpriceid != null ? tpriceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typepricelab)) {
            return false;
        }
        Typepricelab other = (Typepricelab) object;
        if ((this.tpriceid == null && other.tpriceid != null) || (this.tpriceid != null && !this.tpriceid.equals(other.tpriceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bangnalab.Typepricelab[tpriceid=" + tpriceid + "]";
    }

}
