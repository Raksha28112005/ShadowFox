package ContantMangement;
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone: " + phone + "\nEmail: " + email;
    }
}

public class ContactManagementSystem {
	private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            
            switch (choice) {
                case 1: addContact(); break;
                case 2: viewContacts(); break;
                case 3: updateContact(); break;
                case 4: deleteContact(); break;
                case 5: searchContact(); break;
                case 6: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Contact Management System ===");
        System.out.println("1. Add Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Update Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Search Contact");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n=== All Contacts ===");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("\nContact " + (i + 1) + ":");
            System.out.println(contacts.get(i));
            System.out.println("----------------");
        }
    }

    private static void updateContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to update.");
            return;
        }

        viewContacts();
        System.out.print("Enter contact number to update (1-" + contacts.size() + "): ");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            
            if (index >= 0 && index < contacts.size()) {
                Contact contact = contacts.get(index);
                
                System.out.print("Enter new name (current: " + contact.getName() + "): ");
                String name = scanner.nextLine().trim();
                if (!name.isEmpty()) contact.setName(name);

                System.out.print("Enter new phone (current: " + contact.getPhone() + "): ");
                String phone = scanner.nextLine().trim();
                if (!phone.isEmpty()) contact.setPhone(phone);

                System.out.print("Enter new email (current: " + contact.getEmail() + "): ");
                String email = scanner.nextLine().trim();
                if (!email.isEmpty()) contact.setEmail(email);

                System.out.println("Contact updated successfully!");
            } else {
                System.out.println("Invalid contact number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private static void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to delete.");
            return;
        }

        viewContacts();
        System.out.print("Enter contact number to delete (1-" + contacts.size() + "): ");
        try {
            int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
            
            if (index >= 0 && index < contacts.size()) {
                contacts.remove(index);
                System.out.println("Contact deleted successfully!");
            } else {
                System.out.println("Invalid contact number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private static void searchContact() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available to search.");
            return;
        }
        
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine().trim().toLowerCase();
        
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchName)) {
                System.out.println("\nContact Found:");
                System.out.println(contact);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No matching contacts found.");
        }
    }
}


