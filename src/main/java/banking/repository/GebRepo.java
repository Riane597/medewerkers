package banking.repository;

import java.util.List;

import banking.entity.Gebruiker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class GebRepo {
    private EntityManager entityManager;

    public GebRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Gebruiker> getGebruikers() {
        String query = "select g from GebruikerGegevens g";
        TypedQuery<Gebruiker> typedQuery = entityManager.createQuery(query, Gebruiker.class);
        List<Gebruiker> gebruikersList = typedQuery.getResultList();
        return gebruikersList;
    }

    public Gebruiker creatGebruikerGegevens(Gebruiker gebruiker) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gebruiker);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return gebruiker;
    }

    public List<Gebruiker> getGebruiker() {
        return null;
    }
}
