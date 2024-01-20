package banking;

import java.util.List;
import java.util.Scanner;

import banking.entity.Rekening;
import banking.service.RekService;

public class Account {

    private static RekService rekService = new RekService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Manage Accounts\n2. Quit\nOption: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    manageRekeningen();
                    break;
                case "2":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void manageRekeningen() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Create Rekening\n2. Read Rekeningen\n3. Update Rekening\n4. Delete Rekening\n5. Back\nOption: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createRekening();
                    break;
                case "2":
                    readRekeningen();
                    break;
                case "3":
                    updateRekening();
                    break;
                case "4":
                    deleteRekening();
                    break;
                case "5":
                    return; 
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void createRekening() {
        Scanner scanner = new Scanner(System.in);

            Rekening rekening = new Rekening();

            System.out.print("Enter saldo: ");
            rekening.setSaldo(Integer.parseInt(scanner.nextLine()));

            System.out.print("Enter type: ");
            rekening.setType(scanner.nextLine());

            System.out.print("Enter gebruiker_id: ");
            rekening.setGebruiker_id(Integer.parseInt(scanner.nextLine()));

            rekService.createRekening(rekening);

            System.out.println("Rekening created successfully!");
            System.out.println("Rekening ID: " + rekening.getRekening_id());
            System.out.println("Saldo: " + rekening.getSaldo());
            System.out.println("Type: " + rekening.getType());
            System.out.println("Gebruiker ID: " + rekening.getGebruiker_id());
        }

    public static void readRekeningen() {
        List<Rekening> rekeningen = rekService.getRekeningen();
        if (rekeningen.isEmpty()) {
            System.out.println("No rekeningen found.");
        } else {
            System.out.println("List of Rekeningen:");
            for (Rekening rekening : rekeningen) {
                System.out.println("Rekening ID: " + rekening.getRekening_id());
                System.out.println("Saldo: " + rekening.getSaldo());
                System.out.println("Type: " + rekening.getType());
                System.out.println("Gebruiker ID: " + rekening.getGebruiker_id());
            }
        }
    }

    public static void updateRekening() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Rekening ID to update: ");
        int rekeningId = Integer.parseInt(scanner.nextLine());

        Rekening existingRekening = rekService.selectRekeningById(rekeningId);

        if (existingRekening == null) {
            System.out.println("Rekening not found with ID: " + rekeningId);
            return;
        }

        System.out.print("New Saldo (press enter to keep existing): ");
        String newSaldo = scanner.nextLine();
        existingRekening.setSaldo(newSaldo.isEmpty() ? existingRekening.getSaldo() : Integer.parseInt(newSaldo));

        System.out.print("New Type (press enter to keep existing): ");
        String newType = scanner.nextLine();
        existingRekening.setType(newType.isEmpty() ? existingRekening.getType() : newType);

        System.out.print("New Gebruiker ID (press enter to keep existing): ");
        String newGebruikerId = scanner.nextLine();
        existingRekening.setGebruiker_id(newGebruikerId.isEmpty() ? existingRekening.getGebruiker_id() : Integer.parseInt(newGebruikerId));

        rekService.updateRekening(existingRekening);
        System.out.println("Rekening updated successfully!");
    }

    public static void deleteRekening() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Rekening ID to delete: ");
        int rekeningId = Integer.parseInt(scanner.nextLine());

        Rekening rekeningToDelete = rekService.selectRekeningById(rekeningId);

        if (rekeningToDelete == null) {
            System.out.println("Rekening not found with ID: " + rekeningId);
            return;
        }

        rekService.deleteRekening(rekeningToDelete);
        System.out.println("Rekening deleted successfully!");
    }
} 
