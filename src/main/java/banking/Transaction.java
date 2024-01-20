package banking;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import banking.entity.Transactie;
import banking.service.TransService;

public class Transaction {
        private static TransService transService = new TransService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Manage Transactions\n2. Quit\nOption: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    manageTransaction();
                    break;
                case "2":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void manageTransaction() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Create Transaction\n2. Read Transactions\n3. Back\nOption: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createTransaction();
                    break;
                case "2":
                    readTransactions();
                    break;
                case "3":
                    return; 
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void createTransaction() {
        Scanner scanner = new Scanner(System.in);

            Transactie transactie = new Transactie();

            System.out.print("Enter bedrag: ");
            transactie.setBedrag(Integer.parseInt(scanner.nextLine()));

            System.out.print("Enter type: ");
            transactie.setType(scanner.nextLine());

            System.out.print("Enter datum (yyyy-mm-dd): ");
            transactie.setDatum(Date.valueOf(scanner.nextLine()));

            System.out.print("Enter rekeningid: ");
            transactie.setRekeningid(Integer.parseInt(scanner.nextLine()));

            transService.createTransactie(transactie);

            System.out.println("Transaction created successfully!");
            System.out.println("Transaction ID: " + transactie.getTransactieid());
            System.out.println("Bedrag: " + transactie.getBedrag());
            System.out.println("Type: " + transactie.getType());
            System.out.println("Datum: " + transactie.getDatum());
            System.out.println("Rekening ID: " + transactie.getRekeningid());
        }

        public static void readTransactions() {
            List<Transactie> transacties = transService.getTransacties();
            if (transacties.isEmpty()) {
                System.out.println("No transactions found.");
            } else {
                System.out.println("List of transactions:");
                for (Transactie transactie : transacties) {
                    System.out.println("Transaction ID: " + transactie.getTransactieid());
                    System.out.println("Bedrag: " + transactie.getBedrag());
                    System.out.println("Type: " + transactie.getType());
                    System.out.println("Datum: " + transactie.getDatum());
                    System.out.println("Rekening ID: " + transactie.getRekeningid());
                }
            }
        }
        
}
