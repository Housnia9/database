/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 97056
 */
@Entity
@Table(name = "EMPLOYEE")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findBySsn", query = "SELECT e FROM Employee e WHERE e.ssn = :ssn"),
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    @NamedQuery(name = "Employee.findByBd", query = "SELECT e FROM Employee e WHERE e.bd = :bd"),
    @NamedQuery(name = "Employee.findByGmail", query = "SELECT e FROM Employee e WHERE e.gmail = :gmail"),
    @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password"),
    @NamedQuery(name = "Employee.findByFname", query = "SELECT e FROM Employee e WHERE e.fname = :fname"),
    @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary"),
    @NamedQuery(name = "Employee.findByHiredate", query = "SELECT e FROM Employee e WHERE e.hiredate = :hiredate"),
    @NamedQuery(name = "Employee.findByTourperday", query = "SELECT e FROM Employee e WHERE e.tourperday = :tourperday"),
    @NamedQuery(name = "Employee.findByResflag", query = "SELECT e FROM Employee e WHERE e.resflag = :resflag"),
    @NamedQuery(name = "Employee.findByGuideflag", query = "SELECT e FROM Employee e WHERE e.guideflag = :guideflag")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SSN")
    private BigDecimal ssn;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "BD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bd;
    @Basic(optional = false)
    @Column(name = "GMAIL")
    private String gmail;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @Column(name = "SALARY")
    private BigInteger salary;
    @Basic(optional = false)
    @Column(name = "HIREDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hiredate;
    @Column(name = "TOURPERDAY")
    private BigInteger tourperday;
    @Basic(optional = false)
    @Column(name = "RESFLAG")
    private BigInteger resflag;
    @Basic(optional = false)
    @Column(name = "GUIDEFLAG")
    private BigInteger guideflag;
    @ManyToMany(mappedBy = "employeeCollection")
    private Collection<Department> departmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Workingdays> workingdaysCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Languages> languagesCollection;

    public Employee() {
    }

    public Employee(BigDecimal ssn) {
        this.ssn = ssn;
    }

    public Employee(BigDecimal ssn, String address, Date bd, String gmail, String password, String fname, BigInteger salary, Date hiredate, BigInteger resflag, BigInteger guideflag) {
        this.ssn = ssn;
        this.address = address;
        this.bd = bd;
        this.gmail = gmail;
        this.password = password;
        this.fname = fname;
        this.salary = salary;
        this.hiredate = hiredate;
        this.resflag = resflag;
        this.guideflag = guideflag;
    }

    public BigDecimal getSsn() {
        return ssn;
    }

    public void setSsn(BigDecimal ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBd() {
        return bd;
    }

    public void setBd(Date bd) {
        this.bd = bd;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigInteger getTourperday() {
        return tourperday;
    }

    public void setTourperday(BigInteger tourperday) {
        this.tourperday = tourperday;
    }

    public BigInteger getResflag() {
        return resflag;
    }

    public void setResflag(BigInteger resflag) {
        this.resflag = resflag;
    }

    public BigInteger getGuideflag() {
        return guideflag;
    }

    public void setGuideflag(BigInteger guideflag) {
        this.guideflag = guideflag;
    }

    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    public Collection<Workingdays> getWorkingdaysCollection() {
        return workingdaysCollection;
    }

    public void setWorkingdaysCollection(Collection<Workingdays> workingdaysCollection) {
        this.workingdaysCollection = workingdaysCollection;
    }

    public Collection<Languages> getLanguagesCollection() {
        return languagesCollection;
    }

    public void setLanguagesCollection(Collection<Languages> languagesCollection) {
        this.languagesCollection = languagesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.Employee[ ssn=" + ssn + " ]";
    }
    
}
