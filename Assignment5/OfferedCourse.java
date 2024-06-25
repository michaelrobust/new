
public class OfferedCourse extends Course {
    private String instructorName;
    private String term;
    private String classTime;

    // Constructor
    public OfferedCourse() {}

    // Setters
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    // Getters
    public String getInstructorName() {
        return instructorName;
    }

    public String getTerm() {
        return term;
    }

    public String getClassTime() {
        return classTime;
    }

    // Override display method
    @Override
    public void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("   Instructor Name: " + instructorName);
        System.out.println("   Term: " + term);
        System.out.println("   Class Time: " + classTime);
    }
}
