/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 97056
 */
@Entity
@Table(name = "VISITOR_RECORDS")
@NamedQueries({
    @NamedQuery(name = "VisitorRecords.findAll", query = "SELECT v FROM VisitorRecords v"),
    @NamedQuery(name = "VisitorRecords.findBySsn", query = "SELECT v FROM VisitorRecords v WHERE v.visitorRecordsPK.ssn = :ssn"),
    @NamedQuery(name = "VisitorRecords.findByEntringDate", query = "SELECT v FROM VisitorRecords v WHERE v.visitorRecordsPK.entringDate = :entringDate"),
    @NamedQuery(name = "VisitorRecords.findByEntringTime", query = "SELECT v FROM VisitorRecords v WHERE v.visitorRecordsPK.entringTime = :entringTime")})
public class VisitorRecords implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VisitorRecordsPK visitorRecordsPK;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Visitor visitor;

    public VisitorRecords() {
    }

    public VisitorRecords(VisitorRecordsPK visitorRecordsPK) {
        this.visitorRecordsPK = visitorRecordsPK;
    }

    public VisitorRecords(BigInteger ssn, Date entringDate, Character entringTime) {
        this.visitorRecordsPK = new VisitorRecordsPK(ssn, entringDate, entringTime);
    }

    public VisitorRecordsPK getVisitorRecordsPK() {
        return visitorRecordsPK;
    }

    public void setVisitorRecordsPK(VisitorRecordsPK visitorRecordsPK) {
        this.visitorRecordsPK = visitorRecordsPK;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitorRecordsPK != null ? visitorRecordsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitorRecords)) {
            return false;
        }
        VisitorRecords other = (VisitorRecords) object;
        if ((this.visitorRecordsPK == null && other.visitorRecordsPK != null) || (this.visitorRecordsPK != null && !this.visitorRecordsPK.equals(other.visitorRecordsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.VisitorRecords[ visitorRecordsPK=" + visitorRecordsPK + " ]";
    }
    
}
