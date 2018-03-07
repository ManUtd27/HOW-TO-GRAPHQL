package com.howtographql.hackernews;

import graphql.servlet.GraphQLContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


/**This class exteds the context object functionality provided by GraphQL Context
 * @author sjwilliams
 */
public class AuthContext extends GraphQLContext {

    private final User user;


    /**
     * Default Constructor for AuthContex
     * @param user
     * @param request
     * @param response
     */
    public AuthContext(User user, Optional<HttpServletRequest> request, Optional<HttpServletResponse> response){
        super(request, response);
        this.user = user;
    }

    /**
     * Getter for user
     * @return
     */
    public User getUser() {
        return user;
    }
}
