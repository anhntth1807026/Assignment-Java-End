package utility;

import controller.ManageController;
import model.ManageModel;

import java.util.Scanner;

public class ManagaMenu {
    private Scanner scanner = new Scanner(System.in);

    public void generateMenuManage() {
        while (true) {
            System.out.println("------ MENU MANAGE ------");
            System.out.println("1. Register.");
            System.out.println("2. Login");
            System.out.println("3. Exit.");
            System.out.println("------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("------------------");
            ManageModel manageModel = new ManageModel();
            switch (choice) {
                case 1:
                    System.out.println("Register User");
                    manageModel.registerManage();
                    break;
                case 2:
                    System.out.println("Login User");
                    manageModel.loginManage();
                    break;
                case 3:
                    System.out.println("Exited!");
                    break;
                default:
                    System.out.println("Your choice is false. Please choice from 1 to 3!");
                    break;
            }
            if (choice == 3) {
                System.out.println("See you later!!!");
                break;
            }
        }
    }
}