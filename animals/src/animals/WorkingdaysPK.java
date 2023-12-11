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
public class WorkingdaysPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SSN")
    private BigInteger ssn;
    @Basic(optional = false)
    @Column(name = "TWORK")
    private String twork;

    public WorkingdaysPK() {
    }

    public WorkingdaysPK(BigInteger ssn, String twork) {
        this.ssn = ssn;
        this.twork = twork;
    }

    public BigInteger getSsn() {
        return ssn;
    }

    public void setSsn(BigInteger ssn) {
        this.ssn = ssn;
    }

    public String getTwork() {
        return twork;
    }

    public void setTwork(String twork) {
        this.twork = twork;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        hash += (twork != null ? twork.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkingdaysPK)) {
            return false;
        }
        WorkingdaysPK other = (WorkingdaysPK) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        if ((this.twork == null && other.twork != null) || (this.twork != null && !this.twork.equals(other.twork))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.WorkingdaysPK[ ssn=" + ssn + ", twork=" + twork + " ]";
    }
    
}
