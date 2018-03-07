package com.howtographql.hackernews;


import java.time.ZonedDateTime;

/**
 * The Vote class models the type in schema
 * @author sjwilliams
 */
public class Vote {

    private final String id;
    private final ZonedDateTime createdAt;
    private final String userId;
    private final String linkId;


    /**
     * Default Constructor
     * @param createdAt
     * @param userId
     * @param linkId
     */
    public Vote(ZonedDateTime createdAt, String userId, String linkId) {
       this(null, createdAt, userId, linkId);
    }

    /**
     * Overloaded Constructor
     * @param id
     * @param createdAt
     * @param userId
     * @param linkId
     */
    public Vote(String id, ZonedDateTime createdAt, String userId, String linkId) {
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.linkId = linkId;
    }

    /**
     * Getter methods
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Getter Method
     * @return
     */
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter Method
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Getter Method
     * @return
     */
    public String getLinkId() {
        return linkId;
    }
}
