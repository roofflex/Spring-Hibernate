package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Course;
import com.roofflex.hibernate.demo.entity.Instructor;
import com.roofflex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // get a course
            int courseId = 11;
            Course tempCourse = session.get(Course.class, courseId);

            // delete course
            System.out.println("Deleting course: " + tempCourse);
            session.delete(tempCourse);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            // add clean up code
            session.close();
            
            factory.close();
        }
    }
}
