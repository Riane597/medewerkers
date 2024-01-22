package banking.repository;

import java.util.ArrayList;
import java.util.List;

import banking.entity.Gebruiker;
import banking.entity.Rekening;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class RekRepo {
     private EntityManager entityManager;

    public RekRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Rekening createRekening(Rekening rekening) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rekening);
            entityManager.getTransaction().commit();
            return rekening;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to create Rekening", e);
        }
    }

    public List<Rekening> listRekeningen() {
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT r FROM Rekening r";
            TypedQuery<Rekening> query = entityManager.createQuery(jpql, Rekening.class);
            List<Rekening> rekeningList = query.getResultList();
            entityManager.getTransaction().commit();
            return rekeningList;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to list Rekeningen", e);
        }
    }

    public Rekening selectRekeningById(int rekeningId) {
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT r FROM Rekening r WHERE r.rekening_id = :rekeningId";
            TypedQuery<Rekening> query = entityManager.createQuery(jpql, Rekening.class);
            query.setParameter("rekeningId", rekeningId);
            Rekening rekening = query.getSingleResult();
            entityManager.getTransaction().commit();
            return rekening;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to select Rekening by ID", e);
        }
    }

    public void updateRekening(Rekening rekening) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(rekening);
            entityManager.getTransaction().commit();
            rekening.notifyObservers();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to update Rekening", e);
        }
    }

    public void deleteRekening(Rekening rekening) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(rekening) ? rekening : entityManager.merge(rekening));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to delete Rekening", e);
        }
    }

}
