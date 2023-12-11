/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 97056
 */
@Embeddable
public class VisitorRecordsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SSN")
    private BigInteger ssn;
    @Basic(optional = false)
    @Column(name = "ENTRING_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entringDate;
    @Basic(optional = false)
    @Column(name = "ENTRING_TIME")
    private Character entringTime;

    public VisitorRecordsPK() {
    }

    public VisitorRecordsPK(BigInteger ssn, Date entringDate, Character entringTime) {
        this.ssn = ssn;
        this.entringDate = entringDate;
        this.entringTime = entringTime;
    }

    public BigInteger getSsn() {
        return ssn;
    }

    public void setSsn(BigInteger ssn) {
        this.ssn = ssn;
    }

    public Date getEntringDate() {
        return entringDate;
    }

    public void setEntringDate(Date entringDate) {
        this.entringDate = entringDate;
    }

    public Character getEntringTime() {
        return entringTime;
    }

    public void setEntringTime(Character entringTime) {
        this.entringTime = entringTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        hash += (entringDate != null ? entringDate.hashCode() : 0);
        hash += (entringTime != null ? entringTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitorRecordsPK)) {
            return false;
        }
        VisitorRecordsPK other = (VisitorRecordsPK) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        if ((this.entringDate == null && other.entringDate != null) || (this.entringDate != null && !this.entringDate.equals(other.entringDate))) {
            return false;
        }
        if ((this.entringTime == null && other.entringTime != null) || (this.entringTime != null && !this.entringTime.equals(other.entringTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.VisitorRecordsPK[ ssn=" + ssn + ", entringDate=" + entringDate + ", entringTime=" + entringTime + " ]";
    }
    
}
