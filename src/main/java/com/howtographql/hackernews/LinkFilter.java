package com.howtographql.hackernews;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class helps with Filtering data provided to allLinks query
 * @author sjwilliams
 */
public class LinkFilter {

    private String descriptionContains;
    private String urlContains;


    /**
     * Getter for descriptionContains
     * @return desscriptionContains
     */
    @JsonProperty("description_contains")
    public String getDescriptionContains(){
        return descriptionContains;
    }

    /**
     * Setter method
     * @param descriptionContains
     */
    public void setDescriptionContains(String descriptionContains) {
        this.descriptionContains = descriptionContains;
    }

    /**
     * Getter method
     * @return
     */
    @JsonProperty("url_contains")
    public String getUrlContains() {
        return urlContains;
    }

    /**
     * Setter Method
     * @param urlContains
     */
    public void setUrlContains(String urlContains) {
        this.urlContains = urlContains;
    }
}
