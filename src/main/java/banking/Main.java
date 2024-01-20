package banking;

import banking.Factory.AbstractFactory.BankingFactory;

import java.util.Scanner;

import banking.Factory.AccountFactory;
import banking.Factory.LoanFactory;
import banking.Factory.TransactionFactory;
import banking.Factory.UserFactory;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Manage Accounts\n2. Manage Products\n3. Manage Transactions\n4. Manage Users\n5. Quit\nOption: ");
            String option = scanner.nextLine();
            BankingFactory factory = null;

            switch (option) {
                case "1":
                    factory = new AccountFactory();
                    break;
                case "2":
                    factory = new LoanFactory();
                    break;
                case "3":
                    factory = new TransactionFactory();
                    break;
                case "4":
                    factory = new UserFactory();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }

            if (factory != null) {
                factory.manageEntities();
            }
        }
    }
}
