package banking.service;

import java.util.List;

import banking.configuration.JPAConfig;
import banking.entity.Gebruiker;
import banking.repository.GebRepo;

public class GebService {
  
    private GebRepo gebRepo;

    public GebService() {
        this.gebRepo = new GebRepo(JPAConfig.getEntityManager());
    }

    public List<Gebruiker> getGebruikers() {
        return gebRepo.listGebruikers();
    }

    public Gebruiker createGebruiker(Gebruiker gebruiker) {
        return gebRepo.createGebruiker(gebruiker);
    }

    public Gebruiker selectGebruikerByname(String voornaam, String password) {
        return gebRepo.selectGebruikerByname(voornaam, password);
    }

    public List<Gebruiker> getAllGebruikers() {
        return gebRepo.getGebruikers();
    }  

    public void updateGebruiker(Gebruiker gebruiker) {
        gebRepo.updateGebruiker(gebruiker);
    }

    public void deleteGebruiker(Gebruiker gebruiker) {
        gebRepo.deleteGebruiker(gebruiker);
    }

    public Gebruiker selectGebruikerById(int gebruikerId) {
        return gebRepo.selectGebruikerById(gebruikerId);
    }
}
