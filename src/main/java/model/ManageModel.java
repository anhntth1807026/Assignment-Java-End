package model;

import entity.Employee;
import entity.Manage;

import java.sql.*;

public class ManageModel {
    private Connection connection;
    Employee mng = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection =
                    DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/human_resource?user=root&password=");
        }
    }

    public boolean registerManage(Manage mng) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into manage (name, address, email, account, password," +
                            "createAt, updateAt) " +
                            "values (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, mng.getName());
            preparedStatement.setString(2, mng.getAddress());
            preparedStatement.setString(3, mng.getEmail());
            preparedStatement.setString(4, mng.getAccount());
            preparedStatement.setString(5, mng.getPassword());
            preparedStatement.setString(6, mng.getCreateAt());
            preparedStatement.setString(7, mng.getUpdateAt());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("An error occurred!");
            ex.printStackTrace();
        }
        return false;
    }

    public boolean checkExistAccount(String account){
        boolean valid = true;
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from employees where account = ?");
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                valid = false;
            } else {
                System.out.println("Account existed! Please check again!");
            }
        } catch (Exception ex){
            System.out.println("An error occurred. Please try again. Error: " + ex.getMessage());
        }
        return valid;
    }


    public Employee loginManage(String account, String password) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from employees where account = ? and password = ? ");
            preparedStatement.setString(1, mng.getAccount());
            preparedStatement.setString(2, mng.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String address = resultSet.getString(2);
                String email = resultSet.getString(3);
                String account2 = resultSet.getString(4);
                String password2 = resultSet.getString(5);
                String createdAt = resultSet.getString(6);
                String updatedAt = resultSet.getString(7);
                mng = new Employee(name, address, email, account2, password2, createdAt, updatedAt);
                if (mng == null) {
                    return null;
                } else {
                    return mng;
                }
            }
        } catch (Exception ex){
            System.out.println("An error occurred. Please try again. Error: " + ex.getMessage());
        }
        return null;
    }

    public void registerManage() {
    }

    public void loginManage() {
    }
}

