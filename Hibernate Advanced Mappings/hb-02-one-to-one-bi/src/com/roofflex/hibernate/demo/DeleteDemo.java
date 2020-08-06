package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Instructor;
import com.roofflex.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {

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

            // get instructor by primary key(id)
            int theId = 1;

            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("Found Instructor: " + tempInstructor);

            // delete the instructor
            // InstructorDetail deletes automatically along with Instructor because
            // we use Cascade deleting declared in Instructor class - @OneToOne(cascade = CascadeType.ALL)
            if (tempInstructor != null){
                System.out.println("Deleting instructor...");

                session.delete(tempInstructor);

            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
