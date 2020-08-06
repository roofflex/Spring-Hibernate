package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Course;
import com.roofflex.hibernate.demo.entity.Instructor;
import com.roofflex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseDemo {

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

            // create courses
            Course tempCourse1 = new Course("Machine learning for beginners");
            Course tempCourse2 = new Course("Python 3 advanced");
            Course tempCourse3 = new Course("Algorithms Basics");

            // add courses to the instructor
            tempInstructor.addCourse(tempCourse1);
            tempInstructor.addCourse(tempCourse2);
            tempInstructor.addCourse(tempCourse3);

            // save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);
            session.save(tempCourse3);

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
