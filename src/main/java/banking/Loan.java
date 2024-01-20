package banking;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import banking.entity.Product;
import banking.service.ProdService;

public class Loan {
    
    private static ProdService prodService = new ProdService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Manage Products\n2. Quit\nOption: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    manageProducts();
                    break;
                case "2":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void manageProducts() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Create Product\n2. Read Products\n3. Update Product\n4. Delete Product\n5. Back\nOption: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createProduct();
                    break;
                case "2":
                    readProducts();
                    break;
                case "3":
                    updateProduct();
                    break;
                case "4":
                    deleteProduct();
                    break;
                case "5":
                    return; 
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

public static void createProduct() {
    Product product = new Product();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Product Name: ");
    product.setNaam(scanner.nextLine());

    System.out.print("Product Description: ");
    product.setBeschrijving(scanner.nextLine());

    System.out.print("Product Type: ");
    product.setType(scanner.nextLine());

    System.out.print("Product Duration: ");
    product.setLooptijd(scanner.nextLine());

    System.out.print("Product Start Date (yyyy-MM-dd): ");
    product.setStart_datum(Date.valueOf(scanner.nextLine()));

    prodService.createProduct(product);

    System.out.println("Product created successfully!");
}

public static void readProducts() {
    List<Product> products = prodService.getProducts();
    if (products.isEmpty()) {
        System.out.println("No products found.");
    } else {
        System.out.println("List of Products:");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductid());
            System.out.println("Product Name: " + product.getNaam());
            System.out.println("Product Description: " + product.getBeschrijving());
            System.out.println("Product Type: " + product.getType());
            System.out.println("Product Duration: " + product.getLooptijd());
            System.out.println("Product Start Date: " + product.getStart_datum());
        }
    }
}

public static void updateProduct() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter Product ID to update: ");
    int productId = Integer.parseInt(scanner.nextLine());

    Product existingProduct = prodService.selectProductById(productId);

    if (existingProduct == null) {
        System.out.println("Product not found with ID: " + productId);
        return;
    }

    System.out.print("New Product Name (press enter to keep existing): ");
    String newProductName = scanner.nextLine();
    existingProduct.setNaam(newProductName.isEmpty() ? existingProduct.getNaam() : newProductName);

    System.out.print("New Product Description (press enter to keep existing): ");
    String newProductDescription = scanner.nextLine();
    existingProduct.setBeschrijving(newProductDescription.isEmpty() ? existingProduct.getBeschrijving() : newProductDescription);

    prodService.updateProduct(existingProduct);
    System.out.println("Product updated successfully!");
}

public static void deleteProduct() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter Product ID to delete: ");
    int productId = Integer.parseInt(scanner.nextLine());

    Product productToDelete = prodService.selectProductById(productId);

    if (productToDelete == null) {
        System.out.println("Product not found with ID: " + productId);
        return;
    }

    prodService.deleteProduct(productToDelete);
    System.out.println("Product deleted successfully!");
    }
}
