package JAVAProjects.project4;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String bankName;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank (String name){
        this.bankName=bankName;
        this.users=new ArrayList<User>();
        this.accounts=new ArrayList<Account>(); 
    }

    //this method gets a unique ID for the user
    public String getNewUserID(){
    String uuID;
    Random number= new Random();
    int len=6;
    boolean nonUnique=false;
    do {
        uuID="";
        for (int c=0; c<len;c++){
            uuID+=((Integer)number.nextInt(10)).toString();
        }
        nonUnique=false;
        for (User u:this.users){
            if (uuID.compareTo(u.getUniqueID()) ==0){
                 nonUnique=true;
                 break;
            }
        }

    }while (nonUnique) ;
        return uuID;
    }

    public String getNewAccountID(){
        String uuID;
        Random number= new Random();
        int len=10;
        boolean nonUnique=false;
        do {
            uuID="";
            for (int c=0; c<len;c++){
                uuID+=((Integer)number.nextInt(10)).toString();
            }
            nonUnique=false;
            for (Account a:this.accounts){
                if (uuID.compareTo(a.getUniqueID()) ==0){
                    nonUnique=true;
                    break;
                }
            }

        }while (nonUnique) ;
        return uuID;

    }

    public void addAccount(Account anAcct){
    this.accounts.add(anAcct);
    }

    public User addUser(String firstName, String lastName, String pin){
    User newUser=new User(firstName,lastName,pin,this);
    this.users.add(newUser);

    Account newAccount= new Account("Savings",newUser,this);
        //add account to the holder and bank list
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);
        return newUser;
    }

    public User user(String userID,String pin) {
        for (User u:this.users){
            if (u.getUniqueID().compareTo(userID) == 0 && u.validatePin(pin)){
            return u;
            }
        }
        return null;
    }

    public String getName() {
        return this.bankName;
    }
}
