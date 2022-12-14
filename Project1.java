package JAVAProjects;

import java.util.Scanner;

public class Project1 {
    private String password;

    public static void main(String[] args) {
        int mailBoxCapacity;
        

        Scanner sc=new Scanner (System.in);
        System.out.println("Please enter the first name :");
        String firstName=sc.nextLine();
        System.out.println("Please enter the last name : ");
        String lastName=sc.nextLine();
        System.out.println("Please enter the department :");
        String deptName= sc.nextLine();
        EmplInfo emp = new EmplInfo(firstName, lastName, deptName);
        System.out.println("The password generated is : " +randomPassword(8));
        System.out.println("The new password is :" +emp.setPassword("broksi"));
        System.out.println(emp.getName());
        System.out.println(emp.getNewEmail());
        System.out.println("The email capacity is: " +emp.getMailboxCapacity());


    }
    public static String randomPassword(int length){
        String password = "";
        String alphabet = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        for (int i = 0; i < length ; i++) {
            int random = (int) (Math.random() * alphabet.length());
            password += alphabet.charAt(random);
        }
        return password;
    }




        }
