package utility;

import controller.EmployeeController;

import java.util.Scanner;

public class EmployeeMenu {
    private Scanner scanner = new Scanner(System.in);

    public void generateMenuEmployee() {
        while (true) {
            System.out.println("------ MENU EMPLOYEE ------");
            System.out.println("1. Register.");
            System.out.println("2. Login");
            System.out.println("3. Exit.");
            System.out.println("------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("------------------");
            switch (choice) {
                case 1:
                    System.out.println("Register User");
                    EmployeeController.register();
                    break;
                case 2:
                    System.out.println("Login User");
                    EmployeeController.login();
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

    abstract static class ApplicationController {

            public abstract void generateMenuEmployee();

            public abstract void generateMenuManage();

    }
}
