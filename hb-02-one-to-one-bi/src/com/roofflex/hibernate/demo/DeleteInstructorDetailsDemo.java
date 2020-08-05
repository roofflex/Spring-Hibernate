package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Instructor;
import com.roofflex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailsDemo {

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

            // start a transaction
            session.beginTransaction();

            // get the InstructorDetail Object
            int instructorDetailId = 4;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, instructorDetailId);

            // print the Instructor detail
            System.out.println("Instructor detail: " + tempInstructorDetail);

            // print the associated instructor
            System.out.println("Associated instructor: " + tempInstructorDetail.getInstructor());


            // remove the associated object reference
            // break bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            // delete the Instructor Detail
            System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
            session.delete(tempInstructorDetail);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // handle connection leak issue
            session.close();

            factory.close();
        }
    }
}
