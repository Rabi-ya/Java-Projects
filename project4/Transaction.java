package JAVAProjects.project4;

import java.util.Date;

public class Transaction {
    private double amount;
    private Date timeStamp;
    private String memo;
    private Account userAcct; // this is the account in which transactions are performed

    public Transaction(double amount, Account userAcct){
    this.amount=amount;
    this.userAcct=userAcct;
    this.timeStamp=new Date();
    this.memo="";
    }
    public Transaction(double amount, String memo, Account userAcct){
    this (amount,userAcct);
    this.memo=memo;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getSummaryLine() {
        if (this.amount >=0){
            return String.format("%s: $%.02f: %s",this.timeStamp.toString(),this.amount,this.memo);
        }
        else{
            return String.format("%s: $%.02f :%s",this.timeStamp.toString(),this.amount,this.memo);
        }

    }
}
