package com.howtographql.hackernews;


/**
 * Link Class is a POJO that models the Link type in the Graphql schema
 * @author Shawn.Williams
 */
public class Link {

    private final String id;
    private final String url;
    private final String description;
    private final String userId;

    /**
     * Overloaded constructor for Link
     * @param url
     * @param description
     */
    public Link(String url, String description, String userId) {
        this(null, url, description, userId);
    }

    /**
     * Overloaded constructor for Link
     * @param id
     * @param url
     * @param description
     */
    public Link(String id, String url, String description, String userId) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.userId = userId;
    }

    /**
     * Getter for url
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Getter for description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for ID
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for userID
     * @return
     */
    public String getUserId() {
        return userId;
    }
}
