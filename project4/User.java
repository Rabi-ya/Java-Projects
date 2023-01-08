package JAVAProjects.project4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    //public String getUniqueID;
    private String firstName;
    private String lastName;
    private String uuID;
    private byte pinHash[];
    private ArrayList <Account>accounts; // this arraylist will store all the accounts of the user

    //this is the constructor for the User
    public User(String firstName, String lastName, String pin, Bank theBank){
    this.firstName=firstName;
    this.lastName=lastName;

    // hash the pin (MD5) and store it as String

        try {
            MessageDigest md=  MessageDigest.getInstance("MD5");
            this.pinHash=md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error, caught NoSuchAlgorithmException");
            throw new RuntimeException(e);
        }
    this.uuID=theBank.getNewUserID();
    this.accounts=new ArrayList<Account>(); //this creates an empty list of accounts
        System.out.printf("New user %s,%s with ID %s created.\n " ,lastName ,firstName ,this.uuID);
    }
    public void addAccount(Account anAcct){

        this.accounts.add(anAcct);
    }

    public String getUniqueID() {

        return uuID;
    }

    //this method will check whether the pin is true
    public boolean validatePin(String pin) {
        try {
            MessageDigest md=MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(pin.getBytes()),
                   this.pinHash );

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error, caught NoSuchAlgorithmException");
            throw new RuntimeException(e);
        }

    }

    public String getFirstName() {
        return this.firstName;
    }

    public void printAccountsSummary() {
        System.out.printf("\n\n%'s accounts summary\n", this.firstName);
        for (int a = 0; a <this.accounts.size() ; a++) {
            System.out.printf("%d) %s\n",
                     this.accounts.get(a).getSummaryLine());
        }
        System.out.println();
    }

    public int numAccounts() {
        return this.accounts.size();
    }

    public void printAcctTransHistory(int acctIdx) {
        this.accounts.get(acctIdx).printTranshistory();
    }

    public double getAcctBalance(int acctIdx) {
        return this.accounts.get(acctIdx).getBalance();
    }

    public  String getAcctUUID(int acctIdx) {
        return this.accounts.get(acctIdx).getUniqueID();

    }

    public void addAcctTransaction(int acctIdx , double amount, String memo) {
        this.accounts.get(acctIdx).addTransaction(amount,memo);
    }
}
