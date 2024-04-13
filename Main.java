import java.util.Scanner;

class BankAccount{
    private double balance;
    public BankAccount(double intialbalance){
        balance=intialbalance;
    }
    public double getbalance(){
        return balance;

    }
    public void deposit(double amount ){
        balance += amount;
    }
    public boolean withdraw(double amount){
        if(balance >= amount){
            balance-= amount;
            return true;

        }
        else{
            return false;

        }
    }

}
class Atm{
    private BankAccount bankAccount;
    public Atm(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    public void displayMenu(){
        System.out.println("1. CheckBalance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void performTransaction(int option, Scanner sc){
        switch (option){
            case 1:
                System.out.println("Your Balance is : "+ bankAccount.getbalance());
                break;
            case 2:
                System.out.println("Enter Deposit amount : ");
                double DepositAmount = sc.nextDouble();
                bankAccount.deposit(DepositAmount);
                System.out.println("Deposit successful. New Balance : "+ bankAccount.getbalance());
                break;
            case 3:
                System.out.println("Enetr the Amount to Withdraw : ");
                double WithdrawAmount = sc.nextDouble();
                boolean success =  bankAccount.withdraw(WithdrawAmount);
                if(success){
                    System.out.println("withdrawal successful. New balance "+bankAccount.getbalance());
                }
                else{
                    System.out.println("Insufficient funds. Withdrawal failed. ");
                }
                break;
            case 4:
                System.out.println("Thank you for using our ATM");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choise. please select again.");                
        }
    }
}

public class Main{
    public static void main(String[] args){
        BankAccount userAccount = new BankAccount(1000.0);

        Atm atm = new Atm(userAccount);
        Scanner sc = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choise : ");
            int choice= sc.nextInt();
            atm.performTransaction(choice, sc);
            
            
        }
    }
}