package controller;

import entity.Employee;
import model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeModel employeeModel = new EmployeeModel();

    public static void register() {
        System.out.println("Please enter the informations: ");
        while (true) {
            System.out.println("Your Name: ");
            String name = scanner.nextLine();
            System.out.println("Your Address: ");
            String address = scanner.nextLine();
            System.out.println("Your Email: ");
            String email = scanner.nextLine();
            System.out.println("Your Account: ");
            String account = scanner.nextLine();
            System.out.println("Your Password: ");
            String password = scanner.nextLine();
            System.out.println("Your Date Created: ");
            String createAt = scanner.nextLine();
            System.out.println("Your Date Updated: ");
            String updateAt = scanner.nextLine();
            Employee emp = new Employee(name, address, email, account, password, createAt, updateAt);
            if (!employeeModel.checkExistAccount(account)) {
                employeeModel.register(emp);
                break;
            }
                System.out.println("Please enter the informations again: ");
        }
    }

    public static void login() {
        System.out.println("Please enter the informations: ");
        System.out.println("Your Account: ");
        String account = scanner.nextLine();
        System.out.println("Your Password: ");
        String password = scanner.nextLine();
        Employee emp = employeeModel.login(account, password);
        if (emp == null) {
            System.out.println("Wrong account information!");
        } else {
            System.out.println("");
            System.out.printf("%15s | %15s | %15s | %15s | %15s | %30s | %30s | %15s\n", "Name", "Address", "Email", "Account", "Password", "Created At", "Update At", "Status");
            System.out.printf("%15s | %15s | %15s | %15s | %15s | %30s | %30s | %15s\n\n",
                    emp.getName(), emp.getAddress(), emp.getEmail(), emp.getAccount(), emp.getPassword(), emp.getCreateAt(), emp.getUpdateAt(), emp.getStatus());
        }
    }
}

