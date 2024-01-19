package banking.repository;

import java.util.ArrayList;
import java.util.List;

import banking.entity.Gebruiker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GebProdRepo {
    
    private EntityManager entityManager;

    public GebProdRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Gebruiker> getGebruikers() {
        List<Gebruiker> result = new ArrayList<>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("Select a from Gebruiker a").getResultList();            
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return result;
    }
}
