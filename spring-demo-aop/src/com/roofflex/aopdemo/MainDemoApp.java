package com.roofflex.aopdemo;

import com.roofflex.aopdemo.dao.AccountDAO;
import com.roofflex.aopdemo.dao.MembershipDAO;
import com.roofflex.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        // call business method
        theAccountDAO.addAccount(new Account("Mike", "Mike2@ya.ru"));

        // call setter and getter methods
        theAccountDAO.setName("Ivan");
        System.out.println(theAccountDAO.getName());


        // call another method
        theMembershipDAO.addMembership();

        // make some whitespace
        System.out.println("\n\n\n\n\n\n\n");

        // call method to create accounts
        List<Account> accounts = null;
        try{

            // add a boolean flag to simulate exceptions
            boolean tripwire = false;
            accounts = theAccountDAO.createAccounts(tripwire);
        } catch (Exception exc){
            System.out.println("\n\nMain Program caught exception: " + exc);
        }

        // display accounts
        System.out.println("\n\nMain Demo App\n------\n" + accounts + "\n");

        // call the FortuneService method
        System.out.println("\n\n\n\n\n\nCalling getFortune()");

        // boolean value to simulate exceptions
        boolean tripwire = true;
        String fortune = trafficFortuneService.getFortune(tripwire);

        System.out.println("Your fortune is: " + fortune);

        System.out.println("Finished!");

        // close context
        context.close();
    }
}
