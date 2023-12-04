package banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Rekening {
    @Id
    @GeneratedValue
    private int rekening_id;
    private int saldo;
    private String type;
    private int gebruiker_id;
    
    public int getRekening_id() {
        return rekening_id;
    }
    public void setRekening_id(int rekening_id) {
        this.rekening_id = rekening_id;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getGebruiker_id() {
        return gebruiker_id;
    }
    public void setGebruiker_id(int gebruiker_id) {
        this.gebruiker_id = gebruiker_id;
    }
}
