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
@Table(name = "LANGUAGES")
@NamedQueries({
    @NamedQuery(name = "Languages.findAll", query = "SELECT l FROM Languages l"),
    @NamedQuery(name = "Languages.findBySsn", query = "SELECT l FROM Languages l WHERE l.languagesPK.ssn = :ssn"),
    @NamedQuery(name = "Languages.findByTlanguage", query = "SELECT l FROM Languages l WHERE l.languagesPK.tlanguage = :tlanguage")})
public class Languages implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LanguagesPK languagesPK;
    @JoinColumn(name = "SSN", referencedColumnName = "SSN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public Languages() {
    }

    public Languages(LanguagesPK languagesPK) {
        this.languagesPK = languagesPK;
    }

    public Languages(BigInteger ssn, String tlanguage) {
        this.languagesPK = new LanguagesPK(ssn, tlanguage);
    }

    public LanguagesPK getLanguagesPK() {
        return languagesPK;
    }

    public void setLanguagesPK(LanguagesPK languagesPK) {
        this.languagesPK = languagesPK;
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
        hash += (languagesPK != null ? languagesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languages)) {
            return false;
        }
        Languages other = (Languages) object;
        if ((this.languagesPK == null && other.languagesPK != null) || (this.languagesPK != null && !this.languagesPK.equals(other.languagesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.Languages[ languagesPK=" + languagesPK + " ]";
    }
    
}
