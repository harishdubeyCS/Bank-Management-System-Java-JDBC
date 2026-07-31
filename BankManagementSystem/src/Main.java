package OOPS.Bank_Management_System.BankManagementSystem.src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {

            System.out.println();
            System.out.println("===== Bank Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit In Account");
            System.out.println("4. Withdraw From Account");
            System.out.println("5. Check Account Balance");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account Number: ");
                    int accNo = input.nextInt();

                    if (bank.findAccount(accNo)) {
                        System.out.println("Account number already exists!");
                        break;
                    }

                    input.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = input.nextDouble();

                    Account account = new Account(accNo, name, balance);

                    bank.createAccount(account);

                    break;

                case 2:

                    bank.displayAllAccounts();

                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    int accNoDeposit = input.nextInt();

                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = input.nextDouble();

                    bank.depositMoney(accNoDeposit, depositAmount);

                    break;

                case 4:

                    System.out.print("Enter Account Number: ");
                    int accNoWithdraw = input.nextInt();

                    System.out.print("Enter Withdraw Amount: ");
                    double withdrawAmount = input.nextDouble();

                    bank.withdrawMoney(accNoWithdraw, withdrawAmount);

                    break;

                case 5:

                    System.out.print("Enter Account Number: ");
                    int accNoCheck = input.nextInt();

                    bank.checkBalance(accNoCheck);

                    break;

                case 6:

                    System.out.print("Enter Account Number: ");
                    int accNoDelete = input.nextInt();

                    bank.deleteAccount(accNoDelete);

                    break;

                case 7:

                    System.out.println("Thank you for using Bank Management System!");
                    input.close();
                    return;

                default:

                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}