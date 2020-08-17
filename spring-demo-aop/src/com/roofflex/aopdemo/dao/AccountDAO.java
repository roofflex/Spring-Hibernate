package com.roofflex.aopdemo.dao;

import com.roofflex.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;

    private String email;

    public void addAccount(Account theAccount) {
        System.out.println(getClass() + "Doing my DB work - adding an account!");
    }

    public List<Account> createAccounts(boolean tripwire) {

        // for academic purpose simulate an exception
        if (tripwire){
            throw new RuntimeException("No Soup for you!!");
        }
        List<Account> accounts = new ArrayList<>();

        Account tempaccount1 = new Account("Mike", "Shmike@gmail.com");
        Account tempaccount2 = new Account("Phillip", "PhilMeUP@gmail.com");
        Account tempaccount3 = new Account("Oleg", "itguy92@gmail.com");

        accounts.add(tempaccount1);
        accounts.add(tempaccount2);
        accounts.add(tempaccount3);

        return accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
