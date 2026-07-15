import java.util.ArrayList;

public class RegistrationSystem {

    // List of available courses
    private ArrayList<Course> courses;

    // Student object
    private Student student;

    // Constructor
    public RegistrationSystem(Student student) {

        this.student = student;
        courses = new ArrayList<>();

        loadCourses();
    }

    // Load default courses
    private void loadCourses() {

        courses.add(new Course(
                "CS101",
                "Java Programming",
                "Learn Java programming from basics to advanced.",
                5));

        courses.add(new Course(
                "CS102",
                "Data Structures",
                "Study arrays, linked lists, stacks, queues, trees and graphs.",
                4));

        courses.add(new Course(
                "CS103",
                "Database Management System",
                "Learn SQL, normalization and database design.",
                3));

        courses.add(new Course(
                "CS104",
                "Operating Systems",
                "Understand memory management, scheduling and processes.",
                4));

        courses.add(new Course(
                "CS105",
                "Computer Networks",
                "Study networking models, protocols and routing.",
                2));

        courses.add(new Course(
                "CS106",
                "Software Engineering",
                "Software Development Life Cycle and Agile methodology.",
                3));

        courses.add(new Course(
                "CS107",
                "Artificial Intelligence",
                "Introduction to AI concepts and machine learning.",
                4));

        courses.add(new Course(
                "CS108",
                "Cloud Computing",
                "Virtualization, AWS, Azure and cloud services.",
                3));

        courses.add(new Course(
                "CS109",
                "Cyber Security",
                "Network security, cryptography and ethical hacking.",
                2));

        courses.add(new Course(
                "CS110",
                "Web Development",
                "HTML, CSS, JavaScript and backend basics.",
                5));
    }

    // Display all available courses
    public void displayAvailableCourses() {

        System.out.println("\n==============================================================");
        System.out.println("                 AVAILABLE COURSES");
        System.out.println("==============================================================");

        for (Course course : courses) {

            course.displayCourse();
        }

        System.out.println("Total Courses Available : " + courses.size());
    }

    // Search course by course code
    public Course searchCourse(String courseCode) {

        for (Course course : courses) {

            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {

                return course;
            }
        }

        return null;
    }

    // Register student for course
    public void registerCourse(String courseCode) {

        Course course = searchCourse(courseCode);

        if (course == null) {

            System.out.println("\nCourse does not exist.");
            return;
        }

        student.registerCourse(course);
    }

    // Drop registered course
    public void dropCourse(String courseCode) {

        student.dropCourse(courseCode);
    }

    // Display student registered courses
    public void displayRegisteredCourses() {

        student.displayRegisteredCourses();
    }

    // Display student information
    public void displayStudentDetails() {

        student.displayStudentDetails();
    }

    // Display complete summary
    public void displayStudentSummary() {

        student.studentSummary();
    }

    // Total available courses
    public void totalCourses() {

        System.out.println("\nTotal Available Courses : " + courses.size());
    }

    // Check seat availability
    public void checkSeatAvailability(String courseCode) {

        Course course = searchCourse(courseCode);

        if (course == null) {

            System.out.println("Invalid Course Code");
            return;
        }

        System.out.println("\nCourse Name : " + course.getCourseName());
        System.out.println("Available Seats : " + course.getAvailableSeats());
        System.out.println("Maximum Capacity : " + course.getCapacity());
    }

    // Display only courses with seats
    public void displayCoursesWithSeats() {

        System.out.println("\n========== COURSES WITH AVAILABLE SEATS ==========");

        for (Course course : courses) {

            if (course.getAvailableSeats() > 0) {

                System.out.println(
                        course.getCourseCode()
                                + " - "
                                + course.getCourseName()
                                + " (Seats Left : "
                                + course.getAvailableSeats()
                                + ")");
            }
        }
    }

    // Display full course details
    public void displayCourseDetails(String courseCode) {

        Course course = searchCourse(courseCode);

        if (course == null) {

            System.out.println("Course Not Found");
            return;
        }

        course.displayCourse();
    }

    // Remove all registrations
    public void clearRegistration() {

        student.clearAllCourses();
    }

    // Check whether student already registered
    public void isRegistered(String courseCode) {

        if (student.isRegistered(courseCode)) {

            System.out.println("Student already registered.");

        } else {

            System.out.println("Student not registered.");
        }
    }

    // Display statistics
    public void statistics() {

        int occupied = 0;
        int available = 0;

        for (Course course : courses) {

            occupied += course.getCapacity() - course.getAvailableSeats();
            available += course.getAvailableSeats();
        }

        System.out.println("\n================= SYSTEM STATISTICS =================");
        System.out.println("Total Courses           : " + courses.size());
        System.out.println("Registered Courses      : " + student.totalCourses());
        System.out.println("Occupied Seats          : " + occupied);
        System.out.println("Available Seats         : " + available);
        System.out.println("=====================================================");
    }

    // Welcome message
    public void welcome() {

        System.out.println("\n=====================================================");
        System.out.println("     STUDENT COURSE REGISTRATION SYSTEM");
        System.out.println("=====================================================");
        System.out.println("Welcome, " + student.getStudentName());
        System.out.println("Student ID : " + student.getStudentId());
        System.out.println("=====================================================");
    }
}