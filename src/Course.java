public class Course {
    private String name;
    private int credits;
    private String grade;
    
    public Course(String name, int credits, String grade) {
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public String getGrade() {
        return grade;
    }
}