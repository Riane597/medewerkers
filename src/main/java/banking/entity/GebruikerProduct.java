package banking.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class GebruikerProduct {
    @Id
    @GeneratedValue
    private int GebruikerProductid;
    private Date datum;
    private int  gebruikerid;
    private int productid;
    
    public int getGebruikerProductid() {
        return GebruikerProductid;
    }
    public void setGebruikerProductid(int gebruikerProductid) {
        GebruikerProductid = gebruikerProductid;
    }
    public Date getDatum() {
        return datum;
    }
    public void setDatum(Date datum) {
        this.datum = datum;
    }
    public int getGebruikerid() {
        return gebruikerid;
    }
    public void setGebruikerid(int gebruikerid) {
        this.gebruikerid = gebruikerid;
    }
    public int getProductid() {
        return productid;
    }
    public void setProductid(int productid) {
        this.productid = productid;
    }

}
