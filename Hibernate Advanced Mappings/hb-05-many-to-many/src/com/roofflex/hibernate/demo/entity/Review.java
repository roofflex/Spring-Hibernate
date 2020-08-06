package com.roofflex.hibernate.demo.entity;

import javax.persistence.*;

// annotate the class as an entity and map to db table

@Entity
@Table(name = "review")
public class Review {

    // define the fields and annotate with db column names
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;


    // create constructors

    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    // generate getters & setters and add toString


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '}';
    }
}
