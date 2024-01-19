package banking.repository;

import java.util.List;

import banking.entity.Gebruiker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class GebRepo {
    private EntityManager entityManager;

    public GebRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Gebruiker createGebruiker(Gebruiker gebruiker){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(gebruiker);
            entityManager.getTransaction().commit();
            return gebruiker;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                throw new RuntimeException("Failed to create User", e);
        }
    }

    public List<Gebruiker> listGebruikers() {
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT a FROM Gebruiker a";
            TypedQuery<Gebruiker> query = entityManager.createQuery(jpql, Gebruiker.class);
            List<Gebruiker> GebruikerList = query.getResultList();
            entityManager.getTransaction().commit();
            return GebruikerList;            
            }  catch (Exception e) {
                entityManager.getTransaction().rollback();
                throw new RuntimeException("Failed to list Users", e);
        }
    }

    public Gebruiker selectGebruikerByname(String voornaam, String password) {
        try {
            entityManager.getTransaction().begin();
            String jpql = "select u from Gebruiker u where u.voornaam = :voornaam and u.password = :password";
            TypedQuery<Gebruiker> query = entityManager.createQuery(jpql, Gebruiker.class);
            query.setParameter("voornaam", voornaam);
            query.setParameter("password", password);
            Gebruiker gebruiker = query.getSingleResult();
            entityManager.getTransaction().commit();
                return gebruiker;            
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
    } catch (Exception e) {
        entityManager.getTransaction().rollback();
        e.printStackTrace();
        throw new RuntimeException("Failed to select User", e);
    }
}

    public List<Gebruiker> getGebruikers() {
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT u FROM Gebruiker u";
            TypedQuery<Gebruiker> query = entityManager.createQuery(jpql, Gebruiker.class);
            List<Gebruiker> gebruikers = query.getResultList();
            entityManager.getTransaction().commit();
            return gebruikers;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Failed to get Gebruikers", e);
        }
    }

    public void updateGebruiker(Gebruiker gebruiker) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(gebruiker);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to update User", e);
        }
    }

    public void deleteGebruiker(Gebruiker gebruiker) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(gebruiker) ? gebruiker : entityManager.merge(gebruiker));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to delete User", e);
        }
    }

    public Gebruiker selectGebruikerById(int gebruikerId) {
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT u FROM Gebruiker u WHERE u.gebruiker_id = :gebruikerId";
            TypedQuery<Gebruiker> query = entityManager.createQuery(jpql, Gebruiker.class);
            query.setParameter("gebruikerId", gebruikerId);
            Gebruiker gebruiker = query.getSingleResult();
            entityManager.getTransaction().commit();
            return gebruiker;
        } catch (NoResultException e) {
            return null; // Handle when no result is found
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw new RuntimeException("Failed to select User by ID", e);
        }
    }

}
