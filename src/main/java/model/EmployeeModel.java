package model;

import entity.Employee;

import java.sql.*;

public class EmployeeModel {
    private Connection connection;
    Employee emp = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection =
                    DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/human_resource?user=root&password=");
        }
    }

    public boolean register(Employee emp) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into employees (name, address, email, account, password," +
                            "createAt, updateAt) " +
                            "values (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getAddress());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getAccount());
            preparedStatement.setString(5, emp.getPassword());
            preparedStatement.setString(6, emp.getCreateAt());
            preparedStatement.setString(7, emp.getUpdateAt());
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


    public Employee login(String account, String password) {
        try {
            initConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from employees where account = ? and password = ? ");
            preparedStatement.setString(1, emp.getAccount());
            preparedStatement.setString(2, emp.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(1);
                String address = resultSet.getString(2);
                String email = resultSet.getString(3);
                String account2 = resultSet.getString(4);
                String password2 = resultSet.getString(5);
                String createdAt = resultSet.getString(6);
                String updatedAt = resultSet.getString(7);
                emp = new Employee(name, address, email, account2, password2, createdAt, updatedAt);
                if (emp == null) {
                    return null;
                } else {
                    return emp;
                }
            }
        } catch (Exception ex){
            System.out.println("An error occurred. Please try again. Error: " + ex.getMessage());
        }
        return null;
    }

    public void register() {
    }

    public void login() {
    }
}
