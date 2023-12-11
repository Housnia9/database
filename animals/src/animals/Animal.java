/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 97056
 */
@Entity
@Table(name = "ANIMAL")
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a"),
    @NamedQuery(name = "Animal.findByAidd", query = "SELECT a FROM Animal a WHERE a.aidd = :aidd"),
    @NamedQuery(name = "Animal.findByBd", query = "SELECT a FROM Animal a WHERE a.bd = :bd"),
    @NamedQuery(name = "Animal.findByName", query = "SELECT a FROM Animal a WHERE a.name = :name")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "AIDD")
    private BigDecimal aidd;
    @Basic(optional = false)
    @Column(name = "BD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bd;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "EDEPP", referencedColumnName = "DEBNUM")
    @ManyToOne
    private Department edepp;

    public Animal() {
    }

    public Animal(BigDecimal aidd) {
        this.aidd = aidd;
    }

    public Animal(BigDecimal aidd, Date bd, String name) {
        this.aidd = aidd;
        this.bd = bd;
        this.name = name;
    }

    public BigDecimal getAidd() {
        return aidd;
    }

    public void setAidd(BigDecimal aidd) {
        this.aidd = aidd;
    }

    public Date getBd() {
        return bd;
    }

    public void setBd(Date bd) {
        this.bd = bd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getEdepp() {
        return edepp;
    }

    public void setEdepp(Department edepp) {
        this.edepp = edepp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aidd != null ? aidd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.aidd == null && other.aidd != null) || (this.aidd != null && !this.aidd.equals(other.aidd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.Animal[ aidd=" + aidd + " ]";
    }
    
}
