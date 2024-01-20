package banking.repository;

import java.util.List;

import banking.entity.Transactie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class TransRepo {
    private EntityManager entityManager;

    public TransRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Transactie createTransactie(Transactie transactie) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(transactie);
            entityManager.getTransaction().commit();
            return transactie;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to create Transactie", e);
        }
    }

    public List<Transactie> listTransacties() {
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT t FROM Transactie t";
            TypedQuery<Transactie> query = entityManager.createQuery(jpql, Transactie.class);
            List<Transactie> transactieList = query.getResultList();
            entityManager.getTransaction().commit();
            return transactieList;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to list Transacties", e);
        }
    }

    public Transactie selectTransactieById(int transactieId) {
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT t FROM Transactie t WHERE t.transactieid = :transactieId";
            TypedQuery<Transactie> query = entityManager.createQuery(jpql, Transactie.class);
            query.setParameter("transactieId", transactieId);
            Transactie transactie = query.getSingleResult();
            entityManager.getTransaction().commit();
            return transactie;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to select Transactie by ID", e);
        }
    }

    public void updateTransactie(Transactie transactie) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(transactie);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to update Transactie", e);
        }
    }

    public void deleteTransactie(Transactie transactie) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(transactie) ? transactie : entityManager.merge(transactie));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to delete Transactie", e);
        }
    }
}
