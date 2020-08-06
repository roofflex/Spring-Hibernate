package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Course;
import com.roofflex.hibernate.demo.entity.Instructor;
import com.roofflex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

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

            // Hibernate query with HQL

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                                    + "JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);

            // set parameter on query
            query.setParameter("theInstructorId", instructorId);

            // execute query and get Instructor
            Instructor tempInstructor = query.getSingleResult();

            System.out.println("debug: Instructor: " + tempInstructor);


            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("debug: Courses: " + tempInstructor.getCourses());

            System.out.println("debug: Done!");

        } finally {

            // add clean up code
            session.close();
            
            factory.close();
        }
    }
}
