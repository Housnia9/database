/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "OPENDAYS")
@NamedQueries({
    @NamedQuery(name = "Opendays.findAll", query = "SELECT o FROM Opendays o"),
    @NamedQuery(name = "Opendays.findByDebnum", query = "SELECT o FROM Opendays o WHERE o.opendaysPK.debnum = :debnum"),
    @NamedQuery(name = "Opendays.findByDay", query = "SELECT o FROM Opendays o WHERE o.opendaysPK.day = :day")})
public class Opendays implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpendaysPK opendaysPK;
    @JoinColumn(name = "DEBNUM", referencedColumnName = "DEBNUM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Department department;

    public Opendays() {
    }

    public Opendays(OpendaysPK opendaysPK) {
        this.opendaysPK = opendaysPK;
    }

    public Opendays(BigInteger debnum, String day) {
        this.opendaysPK = new OpendaysPK(debnum, day);
    }

    public OpendaysPK getOpendaysPK() {
        return opendaysPK;
    }

    public void setOpendaysPK(OpendaysPK opendaysPK) {
        this.opendaysPK = opendaysPK;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opendaysPK != null ? opendaysPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opendays)) {
            return false;
        }
        Opendays other = (Opendays) object;
        if ((this.opendaysPK == null && other.opendaysPK != null) || (this.opendaysPK != null && !this.opendaysPK.equals(other.opendaysPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.Opendays[ opendaysPK=" + opendaysPK + " ]";
    }
    
}
