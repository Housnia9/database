/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 97056
 */
@Entity
@Table(name = "DEPARTMENT")
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDebnum", query = "SELECT d FROM Department d WHERE d.debnum = :debnum"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByAddress", query = "SELECT d FROM Department d WHERE d.address = :address")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "DEBNUM")
    private BigDecimal debnum;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @JoinTable(name = "EMP_DEP", joinColumns = {
        @JoinColumn(name = "DEPNN", referencedColumnName = "DEBNUM")}, inverseJoinColumns = {
        @JoinColumn(name = "ESSN", referencedColumnName = "SSN")})
    @ManyToMany
    private Collection<Employee> employeeCollection;
    @OneToMany(mappedBy = "edppv")
    private Collection<Visitor> visitorCollection;
    @OneToMany(mappedBy = "edepp")
    private Collection<Animal> animalCollection;
    @OneToMany(mappedBy = "eddp")
    private Collection<Ticket> ticketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<Opendays> opendaysCollection;

    public Department() {
    }

    public Department(BigDecimal debnum) {
        this.debnum = debnum;
    }

    public Department(BigDecimal debnum, String name, String address) {
        this.debnum = debnum;
        this.name = name;
        this.address = address;
    }

    public BigDecimal getDebnum() {
        return debnum;
    }

    public void setDebnum(BigDecimal debnum) {
        this.debnum = debnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public Collection<Visitor> getVisitorCollection() {
        return visitorCollection;
    }

    public void setVisitorCollection(Collection<Visitor> visitorCollection) {
        this.visitorCollection = visitorCollection;
    }

    public Collection<Animal> getAnimalCollection() {
        return animalCollection;
    }

    public void setAnimalCollection(Collection<Animal> animalCollection) {
        this.animalCollection = animalCollection;
    }

    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public Collection<Opendays> getOpendaysCollection() {
        return opendaysCollection;
    }

    public void setOpendaysCollection(Collection<Opendays> opendaysCollection) {
        this.opendaysCollection = opendaysCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (debnum != null ? debnum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.debnum == null && other.debnum != null) || (this.debnum != null && !this.debnum.equals(other.debnum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.Department[ debnum=" + debnum + " ]";
    }
    
}
