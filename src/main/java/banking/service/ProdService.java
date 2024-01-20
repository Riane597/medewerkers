package banking.service;

import java.util.List;

import banking.configuration.JPAConfig;
import banking.entity.Product;
import banking.repository.ProdRepo;

public class ProdService {
    private ProdRepo productRepo;

    public ProdService() {
        this.productRepo = new ProdRepo(JPAConfig.getEntityManager());
    }

    public List<Product> getProducts() {
        return productRepo.listProducts();
    }

    public Product createProduct(Product product) {
        return productRepo.createProduct(product);
    }

    public Product selectProductById(int productId) {
        return productRepo.selectProductById(productId);
    }

    public void updateProduct(Product product) {
        productRepo.updateProduct(product);
    }

    public void deleteProduct(Product product) {
        productRepo.deleteProduct(product);
    }
}
