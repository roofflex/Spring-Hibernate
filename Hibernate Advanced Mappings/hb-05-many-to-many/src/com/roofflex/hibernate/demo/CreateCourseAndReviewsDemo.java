package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Course;
import com.roofflex.hibernate.demo.entity.Instructor;
import com.roofflex.hibernate.demo.entity.InstructorDetail;
import com.roofflex.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // create a course
            Course tempCourse = new Course("Pacman Course");

            // add reviews
            tempCourse.addReview(new Review("Great course, love it!"));
            tempCourse.addReview(new Review("Disgusting course, you're an idiot!"));

            // save the course and leverage the cascade all
            System.out.println("Saving the course and reviews: " + tempCourse + tempCourse.getReviews());
            session.save(tempCourse);

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
