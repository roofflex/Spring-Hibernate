package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Course;
import com.roofflex.hibernate.demo.entity.Instructor;
import com.roofflex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {

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

            // get the instructor from the db
            int instructorId = 1;

            Instructor tempInstructor = session.get(Instructor.class, instructorId);

            System.out.println(tempInstructor);
            System.out.println(tempInstructor.getCourses());

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
