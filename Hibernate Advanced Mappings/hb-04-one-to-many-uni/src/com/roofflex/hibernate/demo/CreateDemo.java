package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Instructor;
import com.roofflex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{

            // create the objects
            Instructor tempInstructor = new Instructor("Bill", "Parker", "Parker24@yahoo.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/BillParkerWorkout", "Crossfit");

            // associate the objects together
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            // InstructorDetail saves automatically along with Instructor because
            // we use Cascade saving declared in Instructor class - @OneToOne(cascade = CascadeType.ALL)

            System.out.println("Saving Instructor: " + tempInstructor.toString());
            session.save(tempInstructor);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
