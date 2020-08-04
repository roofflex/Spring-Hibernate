package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

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
            Student tempStudent = new Student("Mike", "Welp", "MikeWe2@ya.ru");

            // start a transaction
            session.beginTransaction();

            // save the Student object
            System.out.println("Saving the Student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();



            // find out the student's id - primary key
            System.out.println("Saved the student! Generated id: " + tempStudent.getId());
            System.out.println("Done!");


            // get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve the Student based on id: primary key
            System.out.println("\n Getting student by id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent.toString());

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
