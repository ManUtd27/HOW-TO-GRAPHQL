package com.howtographql.hackernews;


import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ExceptionWhileDataFetching;

/**
 * Simple wrapper class to help with forwarding data-fetching exception messages
 * @author sjwilliams
 */
public class SanitizedError extends ExceptionWhileDataFetching {


    /**
     * Default constrcutor that takes exception as arguments and passes it to super
     * @param inner
     */
    public SanitizedError(ExceptionWhileDataFetching inner) {
        super(inner.getException());
    }



    @Override
    @JsonIgnore
    public Throwable getException() {
        return super.getException();
    }
}
