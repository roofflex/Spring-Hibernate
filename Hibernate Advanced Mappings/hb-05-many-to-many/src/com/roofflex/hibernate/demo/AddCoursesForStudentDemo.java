package com.roofflex.hibernate.demo;

import com.roofflex.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try{

            // start a transaction
            session.beginTransaction();

            // get the student John from db
            int studentId = 2;

            Student tempStudent = session.get(Student.class, studentId);

            System.out.println("Loaded student: " + tempStudent);
            System.out.println("Student's courses: " + tempStudent.getCourses());

            // create more courses
            Course tempCourse1 = new Course("Python 3");
            Course tempCourse2 = new Course("Digital Photography");
            Course tempCourse3 = new Course("Advanced design patterns");

            // add student to courses
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);
            tempCourse3.addStudent(tempStudent);

            // save courses
            System.out.println("Saving courses...");

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
