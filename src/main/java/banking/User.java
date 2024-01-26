package banking;

import java.util.List;
import java.util.Scanner;

import banking.entity.Gebruiker;
import banking.service.GebService;

public class User {

    private static GebService gebService = new GebService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Create User\n2. Read Users\n3. Update User\n4. Delete User\n5. Quit\n Option: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createUser();
                    break;
                case "2":
                    readUsers();
                    break;
                case "3":
                    updateUser();
                    break;
                case "4":
                    deleteUser();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Create User\n2. Read Users\n3. Update User\n4. Delete User\n5. Back\nOption: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createUser();
                    break;
                case "2":
                    readUsers();
                    break;
                case "3":
                    updateUser();
                case "4":
                    deleteUser();
                case "5":
                    return; 
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void createUser() {

        Gebruiker gebruiker = new Gebruiker();
        Scanner scanner = new Scanner(System.in);

        System.out.print("First name: ");
        gebruiker.setVoornaam(scanner.nextLine());

        System.out.print("Last name: ");
        gebruiker.setAchternaam(scanner.nextLine());

        System.out.print("Password: ");
        gebruiker.setPassword(scanner.nextLine());

        System.out.print("Workplace: ");
        gebruiker.setWerkplek(scanner.nextLine());

        System.out.print("Function: ");
        gebruiker.setFunctie(scanner.nextLine());

        System.out.print("Salary: ");
        gebruiker.setSalaris(Integer.parseInt(scanner.nextLine()));

        System.out.print("Phone number: ");
        gebruiker.setTelefoonnummer(Integer.parseInt(scanner.nextLine()));

        System.out.print("ID number: ");
        gebruiker.setIdnummer(Integer.parseInt(scanner.nextLine()));

        gebService.createGebruiker(gebruiker);
        System.out.println("User created successfully!");
    }

    public static void readUsers() {
        List<Gebruiker> gebruikers = gebService.getGebruikers();
        if (gebruikers.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("List of Users:");
            for (Gebruiker gebruiker : gebruikers) {
                System.out.println("Gebruiker ID: " + gebruiker.getGebruiker_id());
                System.out.println("voornaam: " + gebruiker.getVoornaam());
                System.out.println("Achternaam: " + gebruiker.getAchternaam());
                System.out.println("Password: ********");
                System.out.println("Workplace: " + gebruiker.getWerkplek());
                System.out.println("Function: " + gebruiker.getFunctie());
                System.out.println("Salary: " + gebruiker.getSalaris());
                System.out.println("Phone Number: " + gebruiker.getTelefoonnummer());
                System.out.println("ID Number: " + gebruiker.getIdnummer());
            }
        }
    }

    public static void updateUser() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter User ID to update: ");
        int userId = Integer.parseInt(scanner.nextLine());
    
        // Fetch the existing user by ID
        Gebruiker existingUser = gebService.selectGebruikerById(userId);
    
        if (existingUser == null) {
            System.out.println("User not found with ID: " + userId);
            return;
        }
    
        System.out.print("New First name (press enter to keep existing): ");
        String newFirstName = scanner.nextLine();
        existingUser.setVoornaam(newFirstName.isEmpty() ? existingUser.getVoornaam() : newFirstName);
    
        System.out.print("New Last name (press enter to keep existing): ");
        String newLastName = scanner.nextLine();
        existingUser.setAchternaam(newLastName.isEmpty() ? existingUser.getAchternaam() : newLastName);
    
        System.out.print("New Password (press enter to keep existing): ");
        String newPassword = scanner.nextLine();
        existingUser.setPassword(newPassword.isEmpty() ? existingUser.getPassword() : newPassword);
    
        // Update the existing user
        gebService.updateGebruiker(existingUser);
        System.out.println("User updated successfully!");
    }
    

    public static void deleteUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID to delete: ");
        int userId = Integer.parseInt(scanner.nextLine());

        Gebruiker userToDelete = gebService.selectGebruikerById(userId);

        if (userToDelete == null) {
            System.out.println("User not found with ID: " + userId);
            return;
        }

        gebService.deleteGebruiker(userToDelete);
        System.out.println("User deleted successfully!");
    }
}
