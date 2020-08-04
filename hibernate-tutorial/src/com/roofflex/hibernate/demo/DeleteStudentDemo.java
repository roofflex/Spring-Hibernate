package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{

            // Deleting student with given id - METHOD ONE

            int studentId = 2;

            // get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve the Student based on id: primary key
            System.out.println("\nGetting student by id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            // deleting the student
            System.out.println("Deleting Student...");
            session.delete(myStudent);

            // commiting the transaction
            session.getTransaction().commit();




            // Deleting student with given id(or given fields) - METHOD TWO
            session = factory.getCurrentSession();
            session.beginTransaction();

            // we can put any field here, like 'where email="Mike2@ya.ru"'
            session.createQuery("delete from Student where id=5").executeUpdate();

            session.getTransaction().commit();



        } finally {
            factory.close();
        }
    }
}
