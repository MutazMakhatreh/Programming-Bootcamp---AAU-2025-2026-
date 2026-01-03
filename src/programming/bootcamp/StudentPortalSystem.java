package programming.bootcamp;

import java.util.ArrayList;

/**
 *
 * @author Eng. Mutaz Makhatreh
 */
// Abstract class: Demonstrates Abstraction
// Student class cannot be instantiated directly
abstract class Student {

    // Encapsulation: private attributes, accessed via getters/setters
    private String name;
    private String studentID;
    private String email;
    private double[] grades;
    private int gradeCount; // To track how many grades added

    // Constructor
    public Student(String name, String studentID, String email, int maxGrades) {
        this.name = name;
        this.studentID = studentID;
        this.email = email;
        this.grades = new double[maxGrades];
        this.gradeCount = 0;
    }

    // Method to add grade
    public void addGrade(double grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
        } else {
            System.out.println("Cannot add more grades.");
        }
    }

    // Method to calculate average grade
    public double getAverage() {
        if (gradeCount == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return sum / gradeCount;
    }

    // Getters for encapsulated attributes
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    // Abstract method: Polymorphism
    public abstract String getAccountType();
}

// Inheritance: Undergraduate extends Student
class Undergraduate extends Student {

    private String major; // Specific attribute for undergraduates

    public Undergraduate(String name, String studentID, String email, String major, int maxGrades) {
        super(name, studentID, email, maxGrades);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    // Polymorphism: Override abstract method
    @Override
    public String getAccountType() {
        return "Undergraduate";
    }
}

// Inheritance: Graduate extends Student
class Graduate extends Student {

    private String researchTopic; // Specific attribute for graduates

    public Graduate(String name, String studentID, String email, String researchTopic, int maxGrades) {
        super(name, studentID, email, maxGrades);
        this.researchTopic = researchTopic;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    // Polymorphism: Override abstract method
    @Override
    public String getAccountType() {
        return "Graduate";
    }
}


// Class to manage multiple students
 class StudentPortal {

    private ArrayList<Student> students;

    public StudentPortal() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public boolean removeStudent(String studentID) {
        for (Student s : students) {
            if (s.getStudentID().equals(studentID)) {
                students.remove(s);
                return true;
            }
        }
        return false;
    }

    public void displayAllStudents() {
        for (Student s : students) {
            System.out.println("---------------------------");
            System.out.println("Name: " + s.getName());
            System.out.println("Student ID: " + s.getStudentID());
            System.out.println("Account Type: " + s.getAccountType()); // Polymorphism
            System.out.println("Average Grade: " + s.getAverage());
        }
    }
}

public class StudentPortalSystem {

    public static void main(String[] args) {

        // Create Undergraduate and Graduate students
        Undergraduate ug = new Undergraduate("Mutaz Makhatreh", "UG001", "Mutaz@ammanu.edu.jo", "Computer Science", 5);
        Graduate grad = new Graduate("Anas", "GR001", "Anas@ammanu.edu.jo", "AI Research", 5);

        // Add grades
        ug.addGrade(85);
        ug.addGrade(90);
        ug.addGrade(78);

        grad.addGrade(92);
        grad.addGrade(88);
        grad.addGrade(95);

        // Display information
        System.out.println("--- Student Info ---");
        System.out.println("Name: " + ug.getName());
        System.out.println("ID: " + ug.getStudentID());
        System.out.println("Account Type: " + ug.getAccountType());
        System.out.println("Average Grade: " + ug.getAverage());

        System.out.println();

        System.out.println("Name: " + grad.getName());
        System.out.println("ID: " + grad.getStudentID());
        System.out.println("Account Type: " + grad.getAccountType());
        System.out.println("Average Grade: " + grad.getAverage());

        // Optional: Test StudentPortal
        StudentPortal portal = new StudentPortal();
        portal.addStudent(ug);
        portal.addStudent(grad);

        System.out.println("\n--- All Students in Portal ---");
        portal.displayAllStudents();
    }
}
