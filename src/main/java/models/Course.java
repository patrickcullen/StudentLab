package models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {

    private String title;
    private CourseType courseType;
    private int id;
    private Set<Student> students;
    private Set<Lesson> lessons;
    private Date startdate;
    private Date enddate;

    public Course(String title, CourseType courseType, Date startdate, Date enddate) {
        this.title = title;
        this.courseType = courseType;
        this.students = new HashSet<Student>();
        this.lessons = new HashSet<Lesson>();
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Course() {
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Enumerated(EnumType.STRING)
    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
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

    @OneToMany(mappedBy ="course")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy ="course")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

//    @Column(name="start_date")
//    public Date getStartdate() {
//        return startdate;
//    }
//
//    public void setStartdate(Date startdate) {
//        this.startdate = startdate;
//    }
//
//    @Column(name="end_date")
//    public Date getEnddate() {
//        return enddate;
//    }
//
//    public void setEnddate(Date enddate) {
//        this.enddate = enddate;
//    }
}
