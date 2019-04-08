package controller;

import entity.Employee;
import entity.Manage;

import java.util.Scanner;

public class ManageController {
    public static Object registerManage;
    private static Scanner scanner = new Scanner(System.in);
    private static ManageController manageController = new ManageController();

    private boolean checkExistAccount(String account) {
        return false;
    }

    public static void registerManage(Manage manage) {
        System.out.println("Please enter the informations: ");
        while (true) {
            System.out.println("Manage's Name: ");
            String name = scanner.nextLine();
            System.out.println("Manage's Address: ");
            String address = scanner.nextLine();
            System.out.println("Manage's Email: ");
            String email = scanner.nextLine();
            System.out.println("Manage's Account: ");
            String mngAccount = scanner.nextLine();
            System.out.println("Manage's Password: ");
            String mngPassword = scanner.nextLine();
            System.out.println("Manage's Date Created: ");
            String createAt = scanner.nextLine();
            System.out.println("Manage's Date Updated: ");
            String updateAt = scanner.nextLine();
            Manage mng = new Manage(name, address, email, mngAccount, mngPassword, createAt, updateAt);
            if (!manageController.checkExistAccount(mngAccount)) {
                registerManage(mng);
                break;
            }
            System.out.println("Please enter the informations again: ");
        }
    }

    public static Employee loginManage(String manageAccount, String managePassword) {
        System.out.println("Please enter the informations: ");
        System.out.println("Manage's Account: ");
        String mngAccount = scanner.nextLine();
        System.out.println("Manage's Password: ");
        String mngPassword = scanner.nextLine();
        Employee mng = loginManage(mngAccount, mngPassword);
        if (mngAccount == null) {
            System.out.println("Wrong account information!");
        } else {
            System.out.println("");
            System.out.printf("%15s | %15s | %15s | %15s | %15s | %30s | %30s | %15s\n", "Name", "Address", "Email", "Account", "Password", "Created At", "Update At", "Status");
            System.out.printf("%15s | %15s | %15s | %15s | %15s | %30s | %30s | %15s\n\n",
                    mng.getName(), mng.getAddress(), mng.getEmail(), mng.getAccount(), mng.getPassword(), mng.getCreateAt(), mng.getUpdateAt(), mng.getStatus());
        }
        return mng;
    }
}