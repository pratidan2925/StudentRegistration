package com.codeWayTask5;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private final String code;
    private final String title;
    private final String description;
    private final int capacity;
    private final String schedule;
    private int enrolledStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        enrolledStudents++;
    }

    public void removeStudent() {
        enrolledStudents--;
    }

    public boolean isFull() {
        return enrolledStudents >= capacity;
    }
}

class Student {
    private final int id;
    private final String name;
    private final List<Course> coursesRegistered;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.coursesRegistered = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCoursesRegistered() {
        return coursesRegistered;
    }

    public void registerCourse(Course course) {
        coursesRegistered.add(course);
        course.enrollStudent();
    }

    public void dropCourse(Course course) {
        coursesRegistered.remove(course);
        course.removeStudent();
    }
}

public class CourseRegistrationSystem {
    private final List<Course> courses;
    private final List<Student> students;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course.getCode() + " - " + course.getTitle() + " (" + course.getEnrolledStudents() + "/" + course.getCapacity() + ")");
            System.out.println("Description: " + course.getDescription());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // Adding sample courses
        Course course1 = new Course("CSCI101", "Introduction to Computer Science", "Basic concepts of programming and algorithms.", 50, "Monday 9:00 AM - 11:00 AM");
        Course course2 = new Course("MATH202", "Calculus II", "Advanced topics in calculus.", 40, "Tuesday 10:00 AM - 12:00 PM");
        system.addCourse(course1);
        system.addCourse(course2);

        // Adding sample students
        Student student1 = new Student(1001, "John Doe");
        Student student2 = new Student(1002, "Alice Smith");
        system.addStudent(student1);
        system.addStudent(student2);

        // Display available courses
        system.displayAvailableCourses();

        // Sample registration process
        student1.registerCourse(course1);
        student2.registerCourse(course2);

        // Display courses after registration
        System.out.println("Courses after registration:");
        system.displayAvailableCourses();
    }
}

