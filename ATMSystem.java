import java.util.Scanner;

class BankAccount {

    int balance = 5000;

    void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited: ₹" + amount);
    }

    void withdraw(int amount) {

        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: ₹" + amount);
        }

        else {
            System.out.println("Insufficient Balance");
        }
    }

    void checkBalance() {
        System.out.println("Balance: ₹" + balance);
    }
}

public class ATMSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount b = new BankAccount();

        int choice;

        do {
            System.out.println("\n ATM MACHINE");
            System.out.println("\n1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Check Balance");
            System.out.println("4.Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Amount: ");
                    int d = sc.nextInt();
                    b.deposit(d);
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    int w = sc.nextInt();
                    b.withdraw(w);
                    break;

                case 3:
                    b.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}