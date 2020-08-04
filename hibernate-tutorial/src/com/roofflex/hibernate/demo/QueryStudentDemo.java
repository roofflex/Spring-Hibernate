package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // query the students
            List<Student> studentList = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(studentList);

            // query Students: lastName='Welp'
            List<Student> tempStudentList = session.createQuery("from Student s where s.lastName='Welp'").getResultList();

            // display students with 'Welp' lastName
            displayStudents(tempStudentList);

            // query students with email like '%@ya.ru'
            List<Student> emailStudentList = session.createQuery("from Student s where s.email LIKE '%@ya.ru'").getResultList();

            // display specified students
            displayStudents(emailStudentList);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");



        } finally {
            factory.close();
        }
    }

    // display specified students
    public static void displayStudents(List<Student> tempStudentList) {
        for (Student tempStudent : tempStudentList) {
            System.out.println(tempStudent.toString() + "\n");
        }
    }
}
