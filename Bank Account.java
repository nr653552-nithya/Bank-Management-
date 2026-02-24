import java.util.*;

abstract class BankAccount{
    protected double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    public void showBalance(){
        System.out.println("Current Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount{

    public SavingsAccount(double balance){
        super(balance);
    }

    void deposit(double amount){
        balance += amount;
        System.out.println(amount + " deposited into Savings Account");
    }

    void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn from Savings Account");
        }else{
            System.out.println("Insufficient Balance in Savings Account");
        }
    }
}

class CurrentAccount extends BankAccount{

    public CurrentAccount(double balance){
        super(balance);
    }

    void deposit(double amount){
        balance += amount;
        System.out.println("₹" + amount + " deposited into Current Account");
    }

    void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn from Current Account");
        }else{
            System.out.println("Insufficient Balance in Current Account");
        }
    }
}

public class Solution{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("-- BANK ACCOUNT SYSTEM --");
        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        int choice = sc.nextInt();

        System.out.println("Enter initial balance:");
        double balance = sc.nextDouble();

        BankAccount account = null;

        if(choice == 1){
            account = new SavingsAccount(balance);
        }else if(choice == 2){
            account = new CurrentAccount(balance);
        }else{
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        System.out.println("\nSelect Operation:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");

        int option = sc.nextInt();

        System.out.println("Enter amount:");
        double amount = sc.nextDouble();

        if(option == 1){
            account.deposit(amount);
        }else if(option == 2){
            account.withdraw(amount);
        }else{
            System.out.println("Invalid operation");
        }

        sc.close();
    }
}