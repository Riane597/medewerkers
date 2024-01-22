package banking.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transactie {
    
    @Id
    @GeneratedValue
    private int transactieid;
    private int bedrag;
    private Date datum;
    private String type;

    private int rekeningid;
    
    public int getTransactieid() {
        return transactieid;
    }
    public void setTransactieid(int transactieid) {
        this.transactieid = transactieid;
    }
    public int getBedrag() {
        return bedrag;
    }
    public void setBedrag(int bedrag) {
        this.bedrag = bedrag;
    }
    public Date getDatum() {
        return datum;
    }
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getRekeningid() {
        return rekeningid;
    }
    public void setRekeningid(int rekening) {
        this.rekeningid = rekeningid;
    }
}
