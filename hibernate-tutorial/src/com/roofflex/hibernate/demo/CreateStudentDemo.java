package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{
            // use the session object to save Java object
            // create a Student object
            System.out.println("Creating new Student object...");
            Student tempStudent = new Student("Paul", "White", "paulW@ya.ru");

            // start a transaction
            session.beginTransaction();

            // save the Student object
            System.out.println("Saving the Student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
