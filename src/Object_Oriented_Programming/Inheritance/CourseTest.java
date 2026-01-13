package Object_Oriented_Programming.Inheritance;

import java.util.Scanner;


public class CourseTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Course Name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter Course Duration (weeks): ");
        int duration = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Platform: ");
        String platform = sc.nextLine();

        System.out.print("Is the course recorded? (true/false): ");
        boolean isRecorded = sc.nextBoolean();

        System.out.print("Enter Course Fee: ");
        double fee = sc.nextDouble();

        System.out.print("Enter Discount (%): ");
        double discount = sc.nextDouble();

        PaidOnlineCourse course = new PaidOnlineCourse(
                courseName,
                duration,
                platform,
                isRecorded,
                fee,
                discount
        );

        System.out.println("\n--- Course Details ---");
        course.displayDetails();

        sc.close();
    }
}

class Course {
    String courseName;
    int duration;

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Subclass
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration,
                 String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}

// Subclass
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration,
                     String platform, boolean isRecorded,
                     double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: ₹" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}
