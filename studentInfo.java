package JAVAProjects;
import java.util.*;
import java.util.stream.Collectors;

public class studentInfo {
    Scanner sc=new Scanner(System.in);

    public String firstName;
    public String lastName;
    public int input;
    public int studentID;
    public int gradeLvl;
    public String courses;
    public int TuitionBalance= 0;
    public static int courseCost = 600;
    ArrayList<String> coursesEnrolled=new ArrayList <> ();
    private String newString;


    //Constructor:
    public studentInfo() {
        System.out.println("Enter a student first name: ");
         firstName = sc.next();


        System.out.println("Enter the students last name: ");
         lastName= sc.next();

        System.out.println("Enter the student's year: ");
        gradeLvl = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("The student ID is :" + gradeLvl+ uniqueID());
        System.out.println("--------------------------------------------------------------------------------------------");
    }
    public int uniqueID() {
        Random random = new Random();
        return studentID=random.nextInt(4444 - 1000 + 1) + 1000;
    }

    public ArrayList enrollCourse(){

        List<String> uniqueCourses = coursesEnrolled.stream().distinct().collect(Collectors.toList());
        System.out.println("The enrolled course/s are: " +uniqueCourses);

        return (ArrayList) uniqueCourses;
    }

    //getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public int getGradeLvl() {
        return gradeLvl;
    }

    public int getTuitionBalance() {
        return TuitionBalance;
    }

    public void courseSelection (){
        System.out.println("Please select a course by entering the corresponding number:");
        System.out.println("1. Computer Science 101");
        System.out.println("2. English Literature 201");
        System.out.println("3. History 301");
        System.out.println("4. Mathematics 401");

        Scanner in = new Scanner(System.in);
        int selection = in.nextInt();

        switch (selection) {
            case 1:
                System.out.println("You have selected Computer Science 101.");
                coursesEnrolled.add("Computer Science 101");
                TuitionBalance+=courseCost;
                break;
            case 2:
                System.out.println("You have selected English Literature 201.");
                coursesEnrolled.add("English Literature 201");
                TuitionBalance+=courseCost;
                break;
            case 3:
                System.out.println("You have selected History 301.");
                coursesEnrolled.add("History 301");
                TuitionBalance+=courseCost;
                break;
            case 4:
                System.out.println("You have selected Mathematics 401.");
                coursesEnrolled.add("Mathematics 101");
                TuitionBalance+=courseCost;
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
                break;
        }

    }
    public void payTuitionFees(){
        System.out.println("How much would you like to pay?: ");
        float payment=sc.nextFloat();
        if (payment>TuitionBalance) {
            System.out.println("This payments exceeds the balance!");
        }
        else if (payment<=TuitionBalance){
            TuitionBalance-=payment;
        }
    }

}