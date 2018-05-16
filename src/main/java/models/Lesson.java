package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lessons")
public class Lesson {

    private String title;
    private int classRoom;
    private Course course;
    private int id;
    private Set<Student> students;
    private Instructor instructor;

    public Lesson(String title, int classRoom, Course course, Instructor instructor) {
        this.title = title;
        this.classRoom = classRoom;
        this.course = course;
        this.students = new HashSet<Student>();
        this.instructor = instructor;
    }

    public Lesson() {
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="classRoom")
    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="student_lesson",
            inverseJoinColumns = {@JoinColumn(name="student_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name="lesson_id", nullable = false, updatable = false)})
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="instructor_id", nullable = false)
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
