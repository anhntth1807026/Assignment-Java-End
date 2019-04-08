package mainthread;

import controller.ManageController;
import model.EmployeeModel;
import model.ManageModel;
import utility.EmployeeMenu;
import utility.ManagaMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------ MENU ------");
            System.out.println("1. Register Manage.");
            System.out.println("2. Register Employee.");
            System.out.println("3. Login Manage");
            System.out.println("4. Login Employee");
            System.out.println("5. Exit.");
            System.out.println("------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("------------------");
            ManageModel manageModel = new ManageModel();
            EmployeeModel employeeModel = new EmployeeModel();
            switch (choice) {
                case 1:
                    System.out.println("Register Manage");
                    manageModel.registerManage();
                    break;
                case 2:
                    System.out.println("Register Employ");
                    employeeModel.register();
                    break;
                case 3:
                    System.out.println("Login Manage");
                    manageModel.loginManage();
                    break;
                case 4:
                    System.out.println("Login Employee");
                    employeeModel.login();
                case 5:
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
