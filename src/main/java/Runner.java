import db.*;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course = new Course("Comp Sci 101", CourseType.BSC);
        Student student1 = new Student("Andrew Lowrie", 24, "SAL01", course);
        Student student2 = new Student("Patrick Cullen", 56, "SAL02", course);

        DBHelper.save(course);
        DBHelper.save(student1);
        DBHelper.save(student2);

        List<Student> studentList = DBCourse.getStudentsForCourse(course);

        Instructor instructor = new Instructor("Mr Data", 55);
        Instructor instructor2 = new Instructor("Ms Data", 52);

        DBHelper.save(instructor);
        DBHelper.save(instructor2);

        Lesson lesson1 = new Lesson("Java", 1, course, instructor);
        Lesson lesson2 = new Lesson("Databases", 2, course, instructor);
        Lesson lesson3 = new Lesson("Python", 3, course, instructor2);

        DBHelper.save(lesson1);
        DBHelper.save(lesson2);
        DBHelper.save(lesson3);

        List<Lesson> lessonList = DBCourse.getLessonsForCourse(course);

        DBHelper.addStudentToLesson(lesson1, student1);
        DBHelper.addStudentToLesson(lesson1, student2);
        DBHelper.addStudentToLesson(lesson2, student1);
        DBHelper.addStudentToLesson(lesson2, student2);
        DBHelper.addStudentToLesson(lesson3, student1);
        DBHelper.addStudentToLesson(lesson3, student2);

        // We want a list of all students taking a specific lesson:
        List<Lesson> allStudentsTakingLesson = DBStudent.getAllLessonsForStudent(student1);

        List<Student> allLessonsTakenByStudent = DBLesson.getAllStudentsForLesson(lesson1);

        List<Lesson> allLessonsTaughtByInstructor = DBInstructor.getLessonsInstructorTeaches(instructor);

    }
}
