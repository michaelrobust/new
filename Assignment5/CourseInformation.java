
import java.util.Scanner;

public class CourseInformation {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Input for Course
        String courseNumber = scnr.nextLine();
        String courseTitle = scnr.nextLine();
        
        // Create Course object and set data
        Course course1 = new Course();
        course1.setCourseNumber(courseNumber);
        course1.setCourseTitle(courseTitle);
        course1.displayCourseInfo();

        // Input for OfferedCourse
        String courseNumber2 = scnr.nextLine();
        String courseTitle2 = scnr.nextLine();
        String instructorName = scnr.nextLine();
        String term = scnr.nextLine();
        String classTime = scnr.nextLine();
        
        // Create OfferedCourse object and set data
        OfferedCourse course2 = new OfferedCourse();
        course2.setCourseNumber(courseNumber2);
        course2.setCourseTitle(courseTitle2);
        course2.setInstructorName(instructorName);
        course2.setTerm(term);
        course2.setClassTime(classTime);
        course2.displayCourseInfo();
        
        scnr.close();
    }
}
