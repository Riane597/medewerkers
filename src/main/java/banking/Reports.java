package banking;

import java.util.List;
import java.util.Scanner;

import banking.configuration.JPAConfig;
import banking.entity.Gebruiker;
import banking.repository.GebRepo;
import banking.repository.RekRepo;

public class Reports {

private static GebRepo gebRepo = new GebRepo(JPAConfig.getEntityManager());
private static RekRepo rekRepo = new RekRepo(JPAConfig.getEntityManager());


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Manage Reports\n2. Quit\nOption: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    manageReports();
                    break;
                case "2":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void manageReports() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. User and Product\n2. Rekening Update\n3. Back\nOption: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    generateUserProductReport();
                    break;
                case "2":
                    generateRekeningUpdateReport();
                    break;
                case "3":
                    return; 
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void generateUserProductReport() {
        List<Gebruiker> gebruikersWithProducts = gebRepo.getGebruikersWithProducts();

        if (gebruikersWithProducts.isEmpty()) {
            System.out.println("No data found for the report.");
            return;
        }

        System.out.println("User Product Report:");
        System.out.printf("%-15s %-15s%n", "User ID", "Product Count");
        System.out.println("----------------------------");

        for (Gebruiker gebruiker : gebruikersWithProducts) {
            int userId = gebruiker.getGebruiker_id();
            int productCount = gebruiker.getProducts().size();
            System.out.printf("%-15s %-15s%n", userId, productCount);
        }
    }

    public static void generateRekeningUpdateReport() {
        List<Object[]> rekeningUpdateCounts = rekRepo.getRekeningUpdateCounts();
    
        if (rekeningUpdateCounts.isEmpty()) {
            System.out.println("No data found for the report.");
            return;
        }
    
        System.out.println("Rekening Update Report:");
        System.out.printf("%-15s %-15s%n", "Rekening ID", "Update Count");
        System.out.println("----------------------------");
    
        for (Object[] row : rekeningUpdateCounts) {
            int rekeningId = (int) row[0];
            int updateCount = (int) row[1];
            System.out.printf("%-15s %-15s%n", rekeningId, updateCount);
        }
    }
    
}
