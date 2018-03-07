package com.howtographql.hackernews;


/**
 * User class is a POJO that models the User type in the schema
 * @author sjwilliams
 */
public class User {

    private final String id;
    private final String name;
    private final String email;
    private final String password;


    /**
     * Default constructor that call overloaded constructor with this
     * @param name
     * @param email
     * @param password
     */
    public User (String name, String email, String password){
        this(null, name, email,password);
    }


    /**
     * Overloaded constructor for User objects
     * @param id
     * @param name
     * @param email
     * @param password
     */
    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    /**
     * Getters for id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for password
     * @return
     */
    public String getPassword() {
        return password;
    }
}
