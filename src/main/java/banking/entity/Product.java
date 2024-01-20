package banking.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int productid;
    private String naam;
    private String beschrijving;
    private String type;
    private String looptijd;
    private Date start_datum;

    @ManyToMany(mappedBy = "products")
    private Set<Gebruiker> gebruikers = new HashSet<>();
    
    public int getProductid() {
        return productid;
    }
    public void setProductid(int productid) {
        this.productid = productid;
    }
    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public String getBeschrijving() {
        return beschrijving;
    }
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getLooptijd() {
        return looptijd;
    }
    public void setLooptijd(String looptijd) {
        this.looptijd = looptijd;
    }
    public Date getStart_datum() {
        return start_datum;
    }
    public void setStart_datum(Date start_datum) {
        this.start_datum = start_datum;
    }

    public Set<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(Set<Gebruiker> gebruikers) {
        this.gebruikers = gebruikers;
    }

    
}
