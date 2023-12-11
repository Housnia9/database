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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "VISITOR")
@NamedQueries({
    @NamedQuery(name = "Visitor.findAll", query = "SELECT v FROM Visitor v"),
    @NamedQuery(name = "Visitor.findBySsn", query = "SELECT v FROM Visitor v WHERE v.ssn = :ssn"),
    @NamedQuery(name = "Visitor.findByAdress", query = "SELECT v FROM Visitor v WHERE v.adress = :adress"),
    @NamedQuery(name = "Visitor.findByBd", query = "SELECT v FROM Visitor v WHERE v.bd = :bd"),
    @NamedQuery(name = "Visitor.findByGmail", query = "SELECT v FROM Visitor v WHERE v.gmail = :gmail"),
    @NamedQuery(name = "Visitor.findByPassword", query = "SELECT v FROM Visitor v WHERE v.password = :password"),
    @NamedQuery(name = "Visitor.findByFname", query = "SELECT v FROM Visitor v WHERE v.fname = :fname"),
    @NamedQuery(name = "Visitor.findByLname", query = "SELECT v FROM Visitor v WHERE v.lname = :lname"),
    @NamedQuery(name = "Visitor.findBySeniorflag", query = "SELECT v FROM Visitor v WHERE v.seniorflag = :seniorflag"),
    @NamedQuery(name = "Visitor.findByRegularflag", query = "SELECT v FROM Visitor v WHERE v.regularflag = :regularflag"),
    @NamedQuery(name = "Visitor.findByDiscountrate", query = "SELECT v FROM Visitor v WHERE v.discountrate = :discountrate")})
public class Visitor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SSN")
    private BigDecimal ssn;
    @Basic(optional = false)
    @Column(name = "ADRESS")
    private String adress;
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
    @Column(name = "LNAME")
    private String lname;
    @Basic(optional = false)
    @Column(name = "SENIORFLAG")
    private BigInteger seniorflag;
    @Basic(optional = false)
    @Column(name = "REGULARFLAG")
    private BigInteger regularflag;
    @Column(name = "DISCOUNTRATE")
    private Double discountrate;
    @JoinColumn(name = "EDPPV", referencedColumnName = "DEBNUM")
    @ManyToOne
    private Department edppv;
    @OneToMany(mappedBy = "vistid")
    private Collection<Ticket> ticketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitor")
    private Collection<VisitorRecords> visitorRecordsCollection;

    public Visitor() {
    }

    public Visitor(BigDecimal ssn) {
        this.ssn = ssn;
    }

    public Visitor(BigDecimal ssn, String adress, Date bd, String gmail, String password, String fname, String lname, BigInteger seniorflag, BigInteger regularflag) {
        this.ssn = ssn;
        this.adress = adress;
        this.bd = bd;
        this.gmail = gmail;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.seniorflag = seniorflag;
        this.regularflag = regularflag;
    }

    public BigDecimal getSsn() {
        return ssn;
    }

    public void setSsn(BigDecimal ssn) {
        this.ssn = ssn;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public BigInteger getSeniorflag() {
        return seniorflag;
    }

    public void setSeniorflag(BigInteger seniorflag) {
        this.seniorflag = seniorflag;
    }

    public BigInteger getRegularflag() {
        return regularflag;
    }

    public void setRegularflag(BigInteger regularflag) {
        this.regularflag = regularflag;
    }

    public Double getDiscountrate() {
        return discountrate;
    }

    public void setDiscountrate(Double discountrate) {
        this.discountrate = discountrate;
    }

    public Department getEdppv() {
        return edppv;
    }

    public void setEdppv(Department edppv) {
        this.edppv = edppv;
    }

    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    public Collection<VisitorRecords> getVisitorRecordsCollection() {
        return visitorRecordsCollection;
    }

    public void setVisitorRecordsCollection(Collection<VisitorRecords> visitorRecordsCollection) {
        this.visitorRecordsCollection = visitorRecordsCollection;
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
        if (!(object instanceof Visitor)) {
            return false;
        }
        Visitor other = (Visitor) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.Visitor[ ssn=" + ssn + " ]";
    }
    
}
