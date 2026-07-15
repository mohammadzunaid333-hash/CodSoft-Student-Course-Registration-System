import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================================");
        System.out.println("      STUDENT COURSE REGISTRATION SYSTEM");
        System.out.println("=====================================================");

        // Student Details
        System.out.print("Enter Student ID   : ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Student Name : ");
        String studentName = scanner.nextLine();

        // Create Student Object
        Student student = new Student(studentId, studentName);

        // Create Registration System
        RegistrationSystem system = new RegistrationSystem(student);

        int choice;

        do {

            System.out.println("\n=====================================================");
            System.out.println("                  MAIN MENU");
            System.out.println("=====================================================");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. View Student Details");
            System.out.println("6. Search Course");
            System.out.println("7. Check Seat Availability");
            System.out.println("8. View Courses With Available Seats");
            System.out.println("9. View Student Summary");
            System.out.println("10. Registration Statistics");
            System.out.println("11. Remove All Registered Courses");
            System.out.println("12. Exit");
            System.out.println("=====================================================");

            System.out.print("Enter your choice : ");

            while (!scanner.hasNextInt()) {

                System.out.print("Invalid Input! Enter a number : ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    system.displayAvailableCourses();
                    break;

                case 2:

                    System.out.print("\nEnter Course Code : ");
                    String registerCode = scanner.nextLine();

                    system.registerCourse(registerCode);
                    break;

                case 3:

                    System.out.print("\nEnter Course Code to Drop : ");
                    String dropCode = scanner.nextLine();

                    system.dropCourse(dropCode);
                    break;

                case 4:

                    system.displayRegisteredCourses();
                    break;

                case 5:

                    system.displayStudentDetails();
                    break;

                case 6:

                    System.out.print("\nEnter Course Code : ");

                    String searchCode = scanner.nextLine();

                    Course course = system.searchCourse(searchCode);

                    if (course != null) {

                        course.displayCourse();

                    } else {

                        System.out.println("Course Not Found.");
                    }

                    break;

                case 7:

                    System.out.print("\nEnter Course Code : ");

                    String seatCode = scanner.nextLine();

                    system.checkSeatAvailability(seatCode);

                    break;

                case 8:

                    system.displayCoursesWithSeats();

                    break;

                case 9:

                    system.displayStudentSummary();

                    break;

                case 10:

                    system.statistics();

                    break;

                case 11:

                    System.out.print("\nAre you sure? (Y/N) : ");

                    String answer = scanner.nextLine();

                    if (answer.equalsIgnoreCase("Y")) {

                        system.clearRegistration();

                    } else {

                        System.out.println("Operation Cancelled.");
                    }

                    break;

                case 12:

                    System.out.println("\n=====================================================");
                    System.out.println(" Thank You for Using");
                    System.out.println(" STUDENT COURSE REGISTRATION SYSTEM");
                    System.out.println(" Goodbye, " + student.getStudentName() + "!");
                    System.out.println("=====================================================");
                    break;

                default:

                    System.out.println("\nInvalid Choice! Please Try Again.");
            }

        } while (choice != 12);

        scanner.close();
    }
}