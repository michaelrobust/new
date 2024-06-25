
public class Course {
    private String courseNumber;
    private String courseTitle;

    // Constructor
    public Course() {}

    // Setters
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    // Getters
    public String getCourseNumber() {
        return courseNumber;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    // Display method
    public void displayCourseInfo() {
        System.out.println("Course Information: ");
        System.out.println("   Course Number: " + courseNumber);
        System.out.println("   Course Title: " + courseTitle);
    }
}
