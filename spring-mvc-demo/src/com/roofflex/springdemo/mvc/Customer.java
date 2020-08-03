package com.roofflex.springdemo.mvc;


import com.roofflex.springdemo.mvc.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;


    // validation rules

    // Can use @NotBlank to not pass whitespaces, with default error message, instead of @NotNull

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "Select a number from 0..10")
    @Max(value = 10, message = "Select a number from 0..10")
    private Integer numberOfPasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters/digits")
    private String postalCode;


    // added a custom Annotation to apply custom business logic
    @CourseCode(value = "LUV", message = "Should start with LUV")
    private String courseCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfPasses() {
        return numberOfPasses;
    }

    public void setNumberOfPasses(Integer numberOfPasses) {
        this.numberOfPasses = numberOfPasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
