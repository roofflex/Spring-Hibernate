package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            int studentId = 1;

            // get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve the Student based on id: primary key
            System.out.println("\nGetting student by id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating Student...");
            myStudent.setFirstName("Scooby");

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

            // Updating all students' email

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Updating all students' email to foo@gmail.com");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }
}
