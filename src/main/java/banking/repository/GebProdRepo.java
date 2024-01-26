package banking.repository;

import java.util.List;

import banking.entity.GebruikerProduct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GebProdRepo {
    
   private EntityManager entityManager;

    public GebProdRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<GebruikerProduct> getGebruikerProducts() {
        List<GebruikerProduct> result = null;
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("SELECT gp FROM GebruikerProduct gp").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public GebruikerProduct getGebruikerProductById(int gebruikerProductId) {
        return entityManager.find(GebruikerProduct.class, gebruikerProductId);
    }

    public void createGebruikerProduct(GebruikerProduct gebruikerProduct) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(gebruikerProduct);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateGebruikerProduct(GebruikerProduct gebruikerProduct) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(gebruikerProduct);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteGebruikerProduct(int gebruikerProductId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            GebruikerProduct gebruikerProduct = entityManager.find(GebruikerProduct.class, gebruikerProductId);
            if (gebruikerProduct != null) {
                entityManager.remove(gebruikerProduct);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
