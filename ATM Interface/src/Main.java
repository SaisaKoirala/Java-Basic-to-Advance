
// Main class to run the ATM system
public class Main {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance of Rs. 1000
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.start();
    }
}
