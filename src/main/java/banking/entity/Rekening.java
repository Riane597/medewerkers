package banking.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import banking.Observer.Observer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Rekening {
    @Id
    @GeneratedValue
    private int rekening_id;
    private int saldo;
    private String type;
    private int gebruiker_id;
    
    @Transient
    public List<Observer> observers = new ArrayList<>();

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
        notifyObservers();
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

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.updateBalance(rekening_id, BigDecimal.valueOf(saldo));
        }
    }
}
