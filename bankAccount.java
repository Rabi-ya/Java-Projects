package JAVAProjects;
import java.util.Scanner;

public class bankAccount {
    private static String calcInterest;
    private static int accntNumber;
    private double accntBalance;
    private static String acctName;
    private String acctType;
    private double previousTransaction;
    private Scanner scanner;

    //Default constructor
    public bankAccount(String acctName, int accntNumber, String acctType) {
        Scanner sc = new Scanner(System.in);
        this.acctName = acctName;
        this.accntNumber = accntNumber;
        this.acctType = acctType;
    }

    //display menu option
    public void displayMenu() {

    }
    //make a deposit
    public void makeDeposit(double amount) {
        if (amount > 0) {
            accntBalance += amount;
            previousTransaction = amount;
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Amount deposited: " + amount);
            System.out.println("--------------------------------------------------------------------------------------");
        } else {
            System.out.println(" You cannot deposit a negative amount!");
        }

    }

    // switch between checkings and savings account
    public void switchAccount() {
        if (acctType.equals("checking")) {
            acctType = "savings";
        } else {
            acctType = "checking";
        }
    }

    //make a withdrawal
    public void makeWithdrawal(double amount) {
        if (amount < accntBalance) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Amount withdrawn: " + amount);
            accntBalance -= amount;
            previousTransaction = -amount;
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Your new balance is :" + accntBalance);
        } else {
            System.out.println("You do not have enough balance to withdraw this amount!");
        }
    }

    //show previous transaction
    public double getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("You deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("You withdrew: " + Math.abs(previousTransaction));

        } else
            System.out.println("No such transaction occured!");
        return previousTransaction;
    }

    // calculate Interest
    public double calculateInterest() {
        double result = 0;
        if (acctType.equals("savings")) {
//            double interest = ((principal) * ((annualInterestRate/100) * (numYears*12)));
//            return interest;
            scanner = new Scanner(System.in);

            System.out.println("--------------------------------------------------------------------------------------");
            System.out.print("Enter the principal: ");
            double principal = scanner.nextDouble();

            System.out.println("---------------------------------------------------------------------------------------");
            System.out.print("Enter the annual interest rate (in percent): ");
            double interestRate = scanner.nextDouble();

            System.out.println("--------------------------------------------------------------------------------------");
            System.out.print("Enter the number of years: ");
            int numYears = scanner.nextInt();

            double calcInterest = (1.0+((interestRate / 100.0) /12.0));
            double calcInterest2= (numYears * 12.0);
            double calcInterest3= principal* calcInterest;
            result = Math.pow(calcInterest3,calcInterest2);

        }
        return result;
    }

    public double getAccntBalance() {

        return accntBalance;
    }

    public String getAcctName(Scanner input) {

        return acctName;
    }

    public String getAcctType() {

        return acctType;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bankAccount accountObj = new bankAccount("Rabeel23", 12345, "checking");
        accountObj.displayMenu();
        while (true) {
            System.out.println("Welcome:" + acctName + " accntNumber: " + accntNumber);
            System.out.println("What would you like to do?");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display previous transaction");
            System.out.println("5. Switch account");
            System.out.println("6. Calculate interest");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your balance is: $" + accountObj.getAccntBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    double amount = scanner.nextDouble();
                    accountObj.makeDeposit(amount);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw:");
                    amount = scanner.nextDouble();
                    accountObj.makeWithdrawal(amount);
                    break;
                case 4:
                    System.out.println(accountObj.getPreviousTransaction());
                    break;
                case 5:
                    accountObj.switchAccount();
                    System.out.println("Your account is now a " + accountObj.getAcctType() + " account.");
                    break;
                //calculate interest
                case 6:
                    scanner = new Scanner(System.in);
                    System.out.println(accountObj.calculateInterest());
                    //System.out.println("The interest is: " + );
                    break;
                case 7:
                    System.out.println("Exiting program. Thank you for using us for all your financial needs!");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
