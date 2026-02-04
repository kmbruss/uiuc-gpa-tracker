import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPATracker {
    private List<Course> courses;
    
    public GPATracker() {
        this.courses = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        GPATracker gpaTracker = new GPATracker();
        
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the GPA Tracker!");
        while (true) {
            System.out.print("Enter course name (or 'exit' to finish): ");
            String courseName = s.nextLine();
            if (courseName.equals("exit")) {
                break;
            }
            System.out.print("Enter course credits: ");
            int credits = Integer.parseInt(s.nextLine());
            System.out.print("Enter course grade (A, A-, B+, B, B-, C+, C, C-, D+, D, F): ");
            String grade = s.nextLine();
            Course course = new Course(courseName, credits, grade);
            gpaTracker.addCourse(course);
        }
        double gpa = GPATracker.calculateGPA(gpaTracker.getCourses());
        System.out.printf("Your GPA is: %.2f%n", gpa);
        s.close();
    }


    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
    public List<Course> getCourses() {
        return this.courses;
    }

    public static double gradeToPoint(String grade) {
        switch (grade) {
            case "A+": return 4.0;
            case "A": return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B": return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C": return 2.0;
            case "C-": return 1.7;
            case "D+": return 1.3;
            case "D": return 1.0;
            case "F": return 0.0;
            default: throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }

    public static double calculateGPA(List<Course> courses) {
        double totalPoints = 0.0;
        int totalCredits = 0;

        for (Course course : courses) {
            double gradePoint = gradeToPoint(course.getGrade());
            totalPoints += gradePoint * course.getCredits();
            totalCredits += course.getCredits();
        }

        if (totalCredits == 0) {
            return 0.0;
        }

        return totalPoints / totalCredits;
    }
}