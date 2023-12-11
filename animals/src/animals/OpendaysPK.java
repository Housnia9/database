/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 97056
 */
@Embeddable
public class OpendaysPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "DEBNUM")
    private BigInteger debnum;
    @Basic(optional = false)
    @Column(name = "DAY")
    private String day;

    public OpendaysPK() {
    }

    public OpendaysPK(BigInteger debnum, String day) {
        this.debnum = debnum;
        this.day = day;
    }

    public BigInteger getDebnum() {
        return debnum;
    }

    public void setDebnum(BigInteger debnum) {
        this.debnum = debnum;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (debnum != null ? debnum.hashCode() : 0);
        hash += (day != null ? day.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpendaysPK)) {
            return false;
        }
        OpendaysPK other = (OpendaysPK) object;
        if ((this.debnum == null && other.debnum != null) || (this.debnum != null && !this.debnum.equals(other.debnum))) {
            return false;
        }
        if ((this.day == null && other.day != null) || (this.day != null && !this.day.equals(other.day))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.OpendaysPK[ debnum=" + debnum + ", day=" + day + " ]";
    }
    
}
