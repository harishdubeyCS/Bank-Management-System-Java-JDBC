package OOPS.Bank_Management_System.BankManagementSystem.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
      private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
      private static final String USERNAME = "root";
      private static final String PASSWORD = "your_password";

      public static Connection getConnection() {
          try{
              Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

              System.out.println("Database Connected Successfully");
              return connection;
          }catch (SQLException e){
              System.out.println("Database Connection Failed");
              e.printStackTrace();
              return null;
          }
      }
}
