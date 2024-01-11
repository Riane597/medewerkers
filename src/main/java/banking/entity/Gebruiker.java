package banking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Gebruiker {
    
    @Id
    @GeneratedValue
    private int gebruiker_id;
    private String voornaam;
    private String achternaam;    
    private String werkplek;
    private String functie;
    private int salaris;
    private int telefoonnummer; 
    private int idnummer;
    
    public int getGebruiker_id() {
        return gebruiker_id;
    }
    public void setGebruiker_id(int gebruiker_id) {
        this.gebruiker_id = gebruiker_id;
    }
    public String getVoornaam() {
        return voornaam;
    }
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }
    public String getAchternaam() {
        return achternaam;
    }
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
    public String getWerkplek() {
        return werkplek;
    }
    public void setWerkplek(String werkplek) {
        this.werkplek = werkplek;
    }
    public String getFunctie() {
        return functie;
    }
    public void setFunctie(String functie) {
        this.functie = functie;
    }
    public int getSalaris() {
        return salaris;
    }
    public void setSalaris(int salaris) {
        this.salaris = salaris;
    }
    public int getTelefoonnummer() {
        return telefoonnummer;
    }
    public void setTelefoonnummer(int telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }
    public int getIdnummer() {
        return idnummer;
    }
    public void setIdnummer(int idnummer) {
        this.idnummer = idnummer;
    }
}
