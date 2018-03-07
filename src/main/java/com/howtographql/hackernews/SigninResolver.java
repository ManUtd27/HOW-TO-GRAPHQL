package com.howtographql.hackernews;


import com.coxautodev.graphql.tools.GraphQLResolver;

/** Because SigninPayload data class contains a complex (non-scalar) object User, it needs a companion resolver class
 * @author sjwilliams
 */
public class SigninResolver implements GraphQLResolver<SigninPayload>{

    public User user(SigninPayload payload){
        return payload.getUser();
    }

}
