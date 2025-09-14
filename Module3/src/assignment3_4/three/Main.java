package assignment3_4.three;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Adam", 16);
        Student student2 = new Student(2, "Alex", 17);
        Student student3 = new Student(3, "John", 18);

        Course course = new Course("oop1", "Object-Oriented Programming 1", "Jarkko");

        ArrayList<Enrollment> enrollments = new ArrayList<>();

        Enrollment enrollment1 = new Enrollment(student1, course, String.valueOf(LocalDate.now()));
        Enrollment enrollment2 = new Enrollment(student2, course, String.valueOf(LocalDate.now()));
        Enrollment enrollment3 = new Enrollment(student3, course, String.valueOf(LocalDate.now()));

        enrollments.add(enrollment1);
        enrollments.add(enrollment2);
        enrollments.add(enrollment3);

        try (
                FileOutputStream fos = new FileOutputStream("enrollments.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            Enrollment[] enrollmentsSave = enrollments.toArray(new Enrollment[0]);
            oos.writeObject(enrollmentsSave);
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

        try (
                FileInputStream fis = new FileInputStream("enrollments.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Enrollment[] enrollmentsRead = (Enrollment[]) ois.readObject();
            for (Enrollment enrollment: enrollments) {
                System.out.println(enrollment);
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
