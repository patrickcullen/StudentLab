package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;



public class DBStudent {

    private static Session session;
//    private static Transaction transaction;

    public static List<Lesson> getAllLessonsForStudent(Student student){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> lessonList = null;

        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.createAlias("students", "individual_student");
            cr.add(Restrictions.eq("individual_student.id", student.getId()));
            lessonList = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lessonList;
    }
}
