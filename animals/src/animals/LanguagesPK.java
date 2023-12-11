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
public class LanguagesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "SSN")
    private BigInteger ssn;
    @Basic(optional = false)
    @Column(name = "TLANGUAGE")
    private String tlanguage;

    public LanguagesPK() {
    }

    public LanguagesPK(BigInteger ssn, String tlanguage) {
        this.ssn = ssn;
        this.tlanguage = tlanguage;
    }

    public BigInteger getSsn() {
        return ssn;
    }

    public void setSsn(BigInteger ssn) {
        this.ssn = ssn;
    }

    public String getTlanguage() {
        return tlanguage;
    }

    public void setTlanguage(String tlanguage) {
        this.tlanguage = tlanguage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        hash += (tlanguage != null ? tlanguage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LanguagesPK)) {
            return false;
        }
        LanguagesPK other = (LanguagesPK) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        if ((this.tlanguage == null && other.tlanguage != null) || (this.tlanguage != null && !this.tlanguage.equals(other.tlanguage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.LanguagesPK[ ssn=" + ssn + ", tlanguage=" + tlanguage + " ]";
    }
    
}
