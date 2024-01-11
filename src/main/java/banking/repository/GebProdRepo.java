package banking.repository;

import banking.entity.GebruikerProduct;
import jakarta.persistence.EntityManager;

public class GebProdRepo {
    
    private EntityManager entityManager;

    public GebProdRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GebruikerProduct gebruikerProduct(GebruikerProduct gebruikerProduct) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gebruikerProduct);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gebruikerProduct;
    }
}
