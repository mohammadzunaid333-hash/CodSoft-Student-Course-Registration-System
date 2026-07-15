public class Course {

    private String courseCode;
    private String courseName;
    private String description;
    private int capacity;
    private int availableSeats;

    // Constructor
    public Course(String courseCode, String courseName, String description, int capacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Register Student
    public boolean registerStudent() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    // Drop Student
    public void dropStudent() {
        if (availableSeats < capacity) {
            availableSeats++;
        }
    }

    // Display Course Details
    public void displayCourse() {
        System.out.println("--------------------------------------------");
        System.out.println("Course Code     : " + courseCode);
        System.out.println("Course Name     : " + courseName);
        System.out.println("Description     : " + description);
        System.out.println("Capacity        : " + capacity);
        System.out.println("Available Seats : " + availableSeats);
        System.out.println("--------------------------------------------");
    }
}