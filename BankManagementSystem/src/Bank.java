package OOPS.Bank_Management_System.BankManagementSystem.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bank {

    // CREATE ACCOUNT
    public void createAccount(Account account) {

        if (findAccount(account.getAccountNumber())) {
            System.out.println("Account number already exists!");
            return;
        }

        Connection con = null;
        Statement stmt = null;

        try {

            con = DBConnection.getConnection();
            stmt = con.createStatement();

            String query =
                    "INSERT INTO accounts VALUES ("
                            + account.getAccountNumber() + ", '"
                            + account.getAccountHolderName() + "', "
                            + account.getBalance() + ")";

            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Account created successfully!");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (stmt != null)
                    stmt.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    // FIND ACCOUNT
    public boolean findAccount(int accountNumber) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            con = DBConnection.getConnection();
            stmt = con.createStatement();

            String query =
                    "SELECT * FROM accounts WHERE account_number = "
                            + accountNumber;

            rs = stmt.executeQuery(query);

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (rs != null)
                    rs.close();

                if (stmt != null)
                    stmt.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return false;
    }

    // READ ALL ACCOUNTS
    public void displayAllAccounts() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            con = DBConnection.getConnection();
            stmt = con.createStatement();

            String query = "SELECT * FROM accounts";

            rs = stmt.executeQuery(query);

            while (rs.next()) {

                System.out.println("Account Number : "
                        + rs.getInt("account_number"));

                System.out.println("Account Holder : "
                        + rs.getString("account_holder_name"));

                System.out.println("Balance        : ₹"
                        + rs.getDouble("balance"));

                System.out.println("-----------------------------");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (rs != null)
                    rs.close();

                if (stmt != null)
                    stmt.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    // UPDATE (DEPOSIT)
    public void depositMoney(int accountNumber, double amount) {

        if (!findAccount(accountNumber)) {
            System.out.println("Account does not exist!");
            return;
        }

        Connection con = null;
        Statement stmt = null;

        try {

            con = DBConnection.getConnection();
            stmt = con.createStatement();

            String query =
                    "UPDATE accounts SET balance = balance + "
                            + amount
                            + " WHERE account_number = "
                            + accountNumber;

            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Deposit successful!");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (stmt != null)
                    stmt.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    // UPDATE (WITHDRAW)
    public void withdrawMoney(int accountNumber, double amount) {

        if (!findAccount(accountNumber)) {
            System.out.println("Account does not exist!");
            return;
        }

        Connection con = null;
        Statement stmt = null;

        try {

            con = DBConnection.getConnection();
            stmt = con.createStatement();

            String query =
                    "UPDATE accounts SET balance = balance - "
                            + amount
                            + " WHERE account_number = "
                            + accountNumber;

            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Withdraw successful!");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (stmt != null)
                    stmt.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    // CHECK BALANCE
    public void checkBalance(int accountNumber) {

        if (!findAccount(accountNumber)) {
            System.out.println("Account does not exist!");
            return;
        }

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            con = DBConnection.getConnection();
            stmt = con.createStatement();

            String query =
                    "SELECT balance FROM accounts WHERE account_number = "
                            + accountNumber;

            rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Current Balance : ₹"
                        + rs.getDouble("balance"));
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (rs != null)
                    rs.close();

                if (stmt != null)
                    stmt.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    // DELETE ACCOUNT
    public void deleteAccount(int accountNumber) {

        if (!findAccount(accountNumber)) {
            System.out.println("Account does not exist!");
            return;
        }

        Connection con = null;
        Statement stmt = null;

        try {

            con = DBConnection.getConnection();
            stmt = con.createStatement();

            String query =
                    "DELETE FROM accounts WHERE account_number = "
                            + accountNumber;

            int rows = stmt.executeUpdate(query);

            if (rows > 0) {
                System.out.println("Account deleted successfully!");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                if (stmt != null)
                    stmt.close();

                if (con != null)
                    con.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}