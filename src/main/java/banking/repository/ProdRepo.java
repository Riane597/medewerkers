package banking.repository;

import java.util.List;

import banking.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ProdRepo {
    private EntityManager entityManager;

    public ProdRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Product createProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            return product;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to create Product", e);
        }
    }

    public List<Product> listProducts() {
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT p FROM Product p";
            TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
            List<Product> productList = query.getResultList();
            entityManager.getTransaction().commit();
            return productList;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to list Products", e);
        }
    }

    public Product selectProductById(int productId) {
        try {
            entityManager.getTransaction().begin();
            String jpql = "SELECT p FROM Product p WHERE p.productid = :productId";
            TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
            query.setParameter("productId", productId);
            Product product = query.getSingleResult();
            entityManager.getTransaction().commit();
            return product;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to select Product by ID", e);
        }
    }

    public void updateProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to update Product", e);
        }
    }

    public void deleteProduct(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Failed to delete Product", e);
        }
    }
}
