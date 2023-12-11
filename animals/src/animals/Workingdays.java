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
@Table(name = "WORKINGDAYS")
@NamedQueries({
    @NamedQuery(name = "Workingdays.findAll", query = "SELECT w FROM Workingdays w"),
    @NamedQuery(name = "Workingdays.findBySsn", query = "SELECT w FROM Workingdays w WHERE w.workingdaysPK.ssn = :ssn"),
    @NamedQuery(name = "Workingdays.findByTwork", query = "SELECT w FROM Workingdays w WHERE w.workingdaysPK.twork = :twork")})
public class Workingdays implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WorkingdaysPK workingdaysPK;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public Workingdays() {
    }

    public Workingdays(WorkingdaysPK workingdaysPK) {
        this.workingdaysPK = workingdaysPK;
    }

    public Workingdays(BigInteger ssn, String twork) {
        this.workingdaysPK = new WorkingdaysPK(ssn, twork);
    }

    public WorkingdaysPK getWorkingdaysPK() {
        return workingdaysPK;
    }

    public void setWorkingdaysPK(WorkingdaysPK workingdaysPK) {
        this.workingdaysPK = workingdaysPK;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workingdaysPK != null ? workingdaysPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workingdays)) {
            return false;
        }
        Workingdays other = (Workingdays) object;
        if ((this.workingdaysPK == null && other.workingdaysPK != null) || (this.workingdaysPK != null && !this.workingdaysPK.equals(other.workingdaysPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.Workingdays[ workingdaysPK=" + workingdaysPK + " ]";
    }
    
}
