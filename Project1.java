package JAVAProjects;

import java.util.Scanner;

import static JAVAProjects.EmplInfo.randomPassword;

public class Project1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner (System.in);
        System.out.println("Please enter the first name :");
        String firstName=sc.nextLine();
        System.out.println("Please enter the last name : ");
        String lastName=sc.nextLine();
        System.out.println("Please enter the department :");
        String deptName= sc.nextLine();
        EmplInfo emp = new EmplInfo(firstName, lastName, deptName);
        System.out.println("The password generated is : " +randomPassword(8));
        boolean changePassword = promptForPasswordChange();
        if (changePassword) {
            System.out.println("The new password is :"  +emp.setPassword("password"));
        }
        else {
            System.out.println("The new randomly generated password is: "+ randomPassword(8));
        }
        System.out.println("The full name is :"  + emp.getName());
        System.out.println("Your email generated is: "  +emp.getNewEmail());
        System.out.println("The email capacity is: " +emp.getMailboxCapacity());
    }
    public static boolean promptForPasswordChange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to change your password? (y/n)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("y")) return true;
        else return false;
    }
}
