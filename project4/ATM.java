package JAVAProjects.project4;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Bank theBank= new Bank ("Bank of America");
        User aUser= theBank.addUser("Rabeel","Ali","7860");
        Account newAccount=new Account("Checkings",aUser,theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User currentUser;
        while (true){
            currentUser=ATM.mainMenuPrompt(theBank,sc);
            ATM.printUserMenu(currentUser,sc);
        }


    }

    private static void printUserMenu(User currentUser, Scanner sc) {
        currentUser.printAccountsSummary();
        int choice;
        do{
            System.out.printf("Welcome %s, what would you like to do?\n",
                    currentUser.getFirstName());
            System.out.println(" 1: Show account transaction history");
            System.out.println(" 2: Withdrawal ");
            System.out.println(" 3: Deposit");
            System.out.println(" 4: Transfer");
            System.out.println(" 5: Quit");
            System.out.println();
            System.out.println("Enter choice");
            choice= sc.nextInt();

            if (choice <1 || choice >5){
                System.out.println("Invalid choice\n Please enter choice 1-5");
            }
        } while (choice <1 || choice >5);
        switch (choice){
            case 1:
                ATM.showTransHistory(currentUser,sc);
                break;
            case 2:
                ATM.withdrawalFunds(currentUser,sc);
                break;
            case 3:
                ATM.depositFunds(currentUser,sc);
                break;
            case 4:
                ATM.transferFunds(currentUser,sc);
                break;
        }
        if (choice!=5){
            ATM.printUserMenu(currentUser,sc);
        }
    }

    private static void depositFunds(User currentUser, Scanner sc) {
        int toAcct;
        String memo;
        double amount;
        double acctBal;
        do{
            System.out.printf("Enter the number (1-%d) of the account\n" +"to transfer from:",currentUser.numAccounts() );
            toAcct=sc.nextInt()-1;
            if (toAcct <0 ||toAcct>=currentUser.numAccounts()){
                System.out.println("Invalid account. Please try again");
            }
        }while(toAcct<0 || toAcct>= currentUser.numAccounts());
        acctBal=currentUser.getAcctBalance(toAcct);

        //get the account to transfer to
        do{
            System.out.printf("Enter the number (1-%d) of the account\n" +"to transfer from:",currentUser.numAccounts() );
            toAcct=sc.nextInt()-1;
            if (toAcct <0 ||toAcct>=currentUser.numAccounts()){
                System.out.println("Invalid account. Please try again");
            }
        }while(toAcct<0 || toAcct>= currentUser.numAccounts());

        //get the amount to transfer to
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $",acctBal);
            amount=sc.nextDouble();
            if (amount<0){
                System.out.println("Amount must be greater than zero");
            }else if (amount>acctBal){
                System.out.printf("Amount cannot be greater than account balance\n " +
                        "balance of $%.02f.\n",acctBal);
            }
        }while (amount < 0||amount>acctBal);

        sc.nextLine();
        System.out.println("Enter a memo:");
        memo= sc.nextLine();

        //do the withdrawal
        currentUser.addAcctTransaction(toAcct,amount,memo);
    }

    private static void withdrawalFunds(User currentUser,Scanner sc) {
        int fromAcct;
        String memo;
        double amount;
        double acctBal;
        do{
            System.out.printf("Enter the number (1-%d) of the account\n" +"to transfer from:",currentUser.numAccounts());
            fromAcct=sc.nextInt()-1;
            if (fromAcct <0 ||fromAcct>=currentUser.numAccounts()){
                System.out.println("Invalid account. Please try again");
            }
        }while(fromAcct<0 || fromAcct>= currentUser.numAccounts());
        acctBal=currentUser.getAcctBalance(fromAcct);

        //get the amount to transfer to
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $",acctBal);
            amount=sc.nextDouble();
            if (amount<0){
                System.out.println("Amount must be greater than zero");
            }else if (amount>acctBal){
                System.out.printf("Amount cannot be greater than account balance\n " +
                        "balance of $%.02f.\n",acctBal);
            }
        }while (amount < 0||amount>acctBal);

        sc.nextLine();
        System.out.println("Enter a memo:");
        memo= sc.nextLine();

        //do the withdrawal
        currentUser.addAcctTransaction(fromAcct,-1*amount,memo);
    }

    private static void transferFunds(User currentUser, Scanner sc) {
        int fromAcct;
        int toAcct = 0;
        double amount;
        double acctBal;

        do{
            System.out.printf("Enter the number (1-%d) of the account\n" +"to transfer from:");
            fromAcct=sc.nextInt()-1;
            if (fromAcct <0 ||fromAcct>=currentUser.numAccounts()){
                System.out.println("Invalid account. Please try again");
            }
        }while(fromAcct<0 || fromAcct>= currentUser.numAccounts());
        acctBal=currentUser.getAcctBalance(fromAcct);

        //get the account to transfer to
        do{
            System.out.printf("Enter the number (1-%d) of the account\n" +"to transfer from:");
            fromAcct=sc.nextInt()-1;
            if (fromAcct <0 ||fromAcct>=currentUser.numAccounts()){
                System.out.println("Invalid account. Please try again");
            }
        }while(fromAcct<0 || fromAcct>= currentUser.numAccounts());

        //get the amount to transfer to
        do {
            System.out.printf("Enter the amount to transfer (max $%.02f): $",acctBal);
            amount=sc.nextDouble();
            if (amount<0){
                System.out.println("Amount must be greater than zero");
            }else if (amount>acctBal){
                System.out.printf("Amount cannot be greater than account balance\n " +
                        "balance of $%.02f.\n",acctBal);
            }
        }while (amount < 0||amount>acctBal);

        //do the transfer
        currentUser.addAcctTransaction(fromAcct,-1*amount, "Transfer to account " + currentUser
                .getAcctUUID(toAcct));
        currentUser.addAcctTransaction(toAcct,-1*amount,String.format("Transfer to account %s",currentUser
                .getAcctUUID(fromAcct))); 

    }

    private static void showTransHistory(User currentUser, Scanner sc) {
        int theAcct;
        do{
            System.out.printf("Enter the number (1-%d) of the account\n" + "whose transactions you want to see: ",
                    currentUser.numAccounts());
            theAcct=sc.nextInt()-1;
            if (theAcct <0 ||theAcct>=currentUser.numAccounts()){
                System.out.println("Invalid account. Please try again");
            }
        }while(theAcct<0 || theAcct>= currentUser.numAccounts());
        currentUser.printAcctTransHistory(theAcct);
    }

    private static User mainMenuPrompt(Bank theBank, Scanner sc) {
        String userID;
        String pin;
        User authUser;
        do{
            System.out.println("Welcome to Bank of America!");
            System.out.println("Enter user ID: ");
            userID=sc.nextLine();
            System.out.println("Enter pin: ");
            pin= sc.nextLine();

            authUser=theBank.user(userID,pin);
            if (authUser == null ){
                System.out.println("Incorrect userID/pin combination" +" Please try again! ");
            }
        } while(authUser == null);
        return authUser;
    }

}
