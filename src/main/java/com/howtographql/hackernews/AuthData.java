package com.howtographql.hackernews;


/**
 * AuthData Class is a POJO that models the AuthData needed in the Schema
 * @author sjwilliams
 */
public class AuthData {

    private String email;
    private String password;


    /**
     * Default constructor
     */
    public AuthData() {
    }

    /**
     * Overloaded Constructor
     * @param email
     * @param password
     */
    public AuthData(String email, String password) {
        this.email = email;
        this.password = password;
    }


    /**
     * Getter for email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for Email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
