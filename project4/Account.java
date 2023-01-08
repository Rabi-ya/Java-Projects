package JAVAProjects.project4;

import java.util.ArrayList;

public class Account {
    private String acctName;
    //private double acctBalance;
    private String uuID;
    private User holder; //this references the User object that holds this account
    private ArrayList<Transaction>transactions; //this is the list of transactions for this account

    //constructor
    public Account(String acctName,User holder, Bank theBank){
        //set the account name and holder
        this.acctName=acctName;
        this.holder=holder;

        //getitng the new account uniqueID
        this.uuID=theBank.getNewAccountID();

        //initialize transactions
        this.transactions=new ArrayList<Transaction>();

//        //add account to the holder and bank list
//        holder.addAccount(this);
//        theBank.addAccount(this);

    }

    public String getUniqueID() {

        return this.uuID;
    }

    public String getSummaryLine() {
        double  balance=this.getBalance();
        if (balance >= 0){
            return String.format("%s: $%.02f: %s", this.uuID, balance, this.acctName);
        }
        else {
            return String.format("%s: $(%.02f): %s", this.uuID,balance,this.acctName);
        }
    }
    public double getBalance(){
        double balance=0;
        for(Transaction t: this.transactions){
            balance  += t.getAmount();
        }
        return balance;
    }

    public void printTranshistory() {
        System.out.printf("\nTransaction history for account %s\n",this.uuID);
        for (int t=this.transactions.size()-1;t>=0;t--){
            System.out.printf(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }

    //add new transaction
    public void addTransaction(double amount, String memo) {
        Transaction newTrans=new Transaction(amount, memo, this);
        this.transactions.add(newTrans);
    }
}
