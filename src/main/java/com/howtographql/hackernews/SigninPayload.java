package com.howtographql.hackernews;

/**
 * This class models the type SigninPayload defined in the schema
 * @author sjwilliams
 */
public class SigninPayload {


    private final String token;
    private final User user;

    /**
     * Default constructor
     * @param token
     * @param user
     */
    public SigninPayload(String token, User user) {
        this.token = token;
        this.user = user;
    }

    /**
     * Getter for token
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     * Getter for user
     * @return
     */
    public User getUser() {
        return user;
    }
}
