package OOPS.Bank_Management_System.BankManagementSystem.src;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
