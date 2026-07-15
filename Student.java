import java.util.ArrayList;

public class Student {

    // Student Details
    private String studentId;
    private String studentName;

    // List to store registered courses
    private ArrayList<Course> registeredCourses;

    // Constructor
    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.registeredCourses = new ArrayList<>();
    }

    // Getter Methods
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    // Display Student Details
    public void displayStudentDetails() {

        System.out.println("\n======================================");
        System.out.println("        STUDENT DETAILS");
        System.out.println("======================================");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);
        System.out.println("Courses Registered : " + registeredCourses.size());
        System.out.println("======================================");
    }

    // Register a Course
    public void registerCourse(Course course) {

        // Check if already registered
        for (Course c : registeredCourses) {

            if (c.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {

                System.out.println("\nYou are already registered for this course.");
                return;
            }
        }

        // Check seat availability
        if (course.registerStudent()) {

            registeredCourses.add(course);

            System.out.println("\n======================================");
            System.out.println("Course Registered Successfully!");
            System.out.println("Course Code : " + course.getCourseCode());
            System.out.println("Course Name : " + course.getCourseName());
            System.out.println("Remaining Seats : " + course.getAvailableSeats());
            System.out.println("======================================");

        } else {

            System.out.println("\nSorry! No seats available.");
        }
    }

    // Drop a Course
    public void dropCourse(String courseCode) {

        for (Course course : registeredCourses) {

            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {

                course.dropStudent();

                registeredCourses.remove(course);

                System.out.println("\n======================================");
                System.out.println("Course Dropped Successfully!");
                System.out.println("Course Code : " + course.getCourseCode());
                System.out.println("======================================");

                return;
            }
        }

        System.out.println("\nCourse not found in your registered list.");
    }

    // Display Registered Courses
    public void displayRegisteredCourses() {

        System.out.println("\n======================================");
        System.out.println("     REGISTERED COURSES");
        System.out.println("======================================");

        if (registeredCourses.isEmpty()) {

            System.out.println("No courses registered yet.");

        } else {

            int count = 1;

            for (Course course : registeredCourses) {

                System.out.println("--------------------------------------");
                System.out.println("Course " + count);
                System.out.println("--------------------------------------");
                System.out.println("Course Code : " + course.getCourseCode());
                System.out.println("Course Name : " + course.getCourseName());
                System.out.println("Description : " + course.getDescription());
                System.out.println("Seats Left  : " + course.getAvailableSeats());

                count++;
            }
        }

        System.out.println("======================================");
    }

    // Search Registered Course
    public boolean isRegistered(String courseCode) {

        for (Course course : registeredCourses) {

            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {

                return true;
            }
        }

        return false;
    }

    // Total Registered Courses
    public int totalCourses() {

        return registeredCourses.size();
    }

    // Remove All Courses
    public void clearAllCourses() {

        for (Course course : registeredCourses) {

            course.dropStudent();
        }

        registeredCourses.clear();

        System.out.println("\nAll registered courses have been removed.");
    }

    // Student Summary
    public void studentSummary() {

        System.out.println("\n======================================");
        System.out.println("          STUDENT SUMMARY");
        System.out.println("======================================");
        System.out.println("Student ID      : " + studentId);
        System.out.println("Student Name    : " + studentName);
        System.out.println("Total Courses   : " + totalCourses());

        if (registeredCourses.isEmpty()) {

            System.out.println("No active registrations.");

        } else {

            System.out.println("\nRegistered Course Codes:");

            for (Course course : registeredCourses) {

                System.out.println("- " + course.getCourseCode()
                        + " : "
                        + course.getCourseName());
            }
        }

        System.out.println("======================================");
    }
}