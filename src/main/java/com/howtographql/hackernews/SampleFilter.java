package com.howtographql.hackernews;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * This class helps with Filtering data provided to allSamples query
 * @author sjwilliams
 */
public class SampleFilter {

    private String speciesContains;
    private String killTypeContains;


    /**
     * Getter method
     * @return speciesContains
     */
    @JsonProperty("species_contains")
    public String getSpeciesContains() {
        return speciesContains;
    }

    /**
     * Setter method
     * @param speciesContains
     */
    public void setSpeciesContains(String speciesContains) {
        this.speciesContains = speciesContains;
    }

    /**
     * Setter method
     * @return killTypeContains
     */
    @JsonProperty("killType_contains")
    public String getKillTypeContains() {
        return killTypeContains;
    }

    /**
     * Setter Method
     * @param killTypeContains
     */
    public void setKillTypeContains(String killTypeContains) {
        this.killTypeContains = killTypeContains;
    }
}