/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animals;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TICKET")
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByTickid", query = "SELECT t FROM Ticket t WHERE t.tickid = :tickid"),
    @NamedQuery(name = "Ticket.findByPrice", query = "SELECT t FROM Ticket t WHERE t.price = :price"),
    @NamedQuery(name = "Ticket.findByMultyflag", query = "SELECT t FROM Ticket t WHERE t.multyflag = :multyflag"),
    @NamedQuery(name = "Ticket.findByOneflag", query = "SELECT t FROM Ticket t WHERE t.oneflag = :oneflag"),
    @NamedQuery(name = "Ticket.findByTicketmultytype", query = "SELECT t FROM Ticket t WHERE t.ticketmultytype = :ticketmultytype")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TICKID")
    private BigDecimal tickid;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private BigInteger price;
    @Basic(optional = false)
    @Column(name = "MULTYFLAG")
    private BigInteger multyflag;
    @Basic(optional = false)
    @Column(name = "ONEFLAG")
    private BigInteger oneflag;
    @Column(name = "TICKETMULTYTYPE")
    private Character ticketmultytype;
    @JoinColumn(name = "EDDP", referencedColumnName = "DEBNUM")
    @ManyToOne
    private Department eddp;
    @JoinColumn(name = "VISTID", referencedColumnName = "SSN")
    @ManyToOne
    private Visitor vistid;

    public Ticket() {
    }

    public Ticket(BigDecimal tickid) {
        this.tickid = tickid;
    }

    public Ticket(BigDecimal tickid, BigInteger price, BigInteger multyflag, BigInteger oneflag) {
        this.tickid = tickid;
        this.price = price;
        this.multyflag = multyflag;
        this.oneflag = oneflag;
    }

    public BigDecimal getTickid() {
        return tickid;
    }

    public void setTickid(BigDecimal tickid) {
        this.tickid = tickid;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public BigInteger getMultyflag() {
        return multyflag;
    }

    public void setMultyflag(BigInteger multyflag) {
        this.multyflag = multyflag;
    }

    public BigInteger getOneflag() {
        return oneflag;
    }

    public void setOneflag(BigInteger oneflag) {
        this.oneflag = oneflag;
    }

    public Character getTicketmultytype() {
        return ticketmultytype;
    }

    public void setTicketmultytype(Character ticketmultytype) {
        this.ticketmultytype = ticketmultytype;
    }

    public Department getEddp() {
        return eddp;
    }

    public void setEddp(Department eddp) {
        this.eddp = eddp;
    }

    public Visitor getVistid() {
        return vistid;
    }

    public void setVistid(Visitor vistid) {
        this.vistid = vistid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tickid != null ? tickid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.tickid == null && other.tickid != null) || (this.tickid != null && !this.tickid.equals(other.tickid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "animals.Ticket[ tickid=" + tickid + " ]";
    }
    
}
