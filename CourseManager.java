import java.util.ArrayList;

public class CourseManager {

    private ArrayList<Course> courses;

    public CourseManager() {
        courses = new ArrayList<>();
    }

    // Add Course
    public void addCourse(Course course) {
        courses.add(course);
    }

    // Get All Courses
    public ArrayList<Course> getCourses() {
        return courses;
    }

    // Find Course by Code
    public Course findCourse(String courseCode) {

        for (Course course : courses) {

            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }

        return null;
    }

    // Display All Courses
    public void displayCourses() {

        if (courses.isEmpty()) {

            System.out.println("\nNo Courses Available.");
            return;
        }

        System.out.println("\n============= COURSE LIST =============");

        for (Course course : courses) {

            course.displayCourse();
        }

        System.out.println("=======================================");
    }

    // Display Only Available Courses
    public void displayAvailableCourses() {

        System.out.println("\n======= AVAILABLE COURSES =======");

        boolean found = false;

        for (Course course : courses) {

            if (course.getAvailableSeats() > 0) {

                course.displayCourse();
                found = true;
            }
        }

        if (!found) {

            System.out.println("No Courses Available.");
        }
    }

    // Total Courses
    public int totalCourses() {
        return courses.size();
    }

    // Total Available Seats
    public int totalAvailableSeats() {

        int total = 0;

        for (Course course : courses) {

            total += course.getAvailableSeats();
        }

        return total;
    }

    // Remove Course
    public boolean removeCourse(String courseCode) {

        Course course = findCourse(courseCode);

        if (course != null) {

            courses.remove(course);
            return true;
        }

        return false;
    }
}