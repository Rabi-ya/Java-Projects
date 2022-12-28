package JAVAProjects;

import java.util.Scanner;

public class proyectoTwo {
    public static void main(String[] args) {
//        //Ask the user how many new students will be added to the database.
        Scanner sc=new Scanner(System.in);
        System.out.println("How many students will be added to this database? :");
        int input=sc.nextInt();
        studentInfo[] students = new studentInfo[input];

        for (int i =0; i < input; i++){
            studentInfo newStudent = new studentInfo();
            while (true) {
                System.out.println("Enter a choice: ");
                System.out.println("1. Enroll in a course");
                System.out.println("2. Check tuition balance");
                System.out.println("3. Pay tuition");
                System.out.println("4. Display student status");
                System.out.println("5. Exit");
                int choice = sc.nextInt();

                if (choice == 1) {
                    newStudent.courseSelection();
                    newStudent.enrollCourse();
                } else if (choice == 2) {
                    System.out.println("Tuition balance: $" + newStudent.getTuitionBalance());
                    newStudent.enrollCourse();
                } else if (choice ==3) {
                    newStudent.payTuitionFees();
                    System.out.println("Tuition balance: $" + newStudent.getTuitionBalance());

                } else if (choice ==4) {
                    System.out.println("\t\t\t\t\t\t\t\t\tStudent Status");
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.println("Student enrolled is: " +newStudent.getFirstName() + " " +newStudent.getLastName());
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    newStudent.enrollCourse();
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.println("Tuition balance: $" + newStudent.getTuitionBalance());
                    System.out.println("-------------------------------------------------------------------------------------------------");
                } else if (choice == 5) {
                    break;
                } else {
                    System.out.println("Invalid choice");
                }
            }
        }

    }
}
