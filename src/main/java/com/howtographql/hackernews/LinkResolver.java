package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLResolver;

/** Because Link data class contains a complex (non-scalar) object User, it needs a companion resolver class
 * @author sjwilliams
 */
public class LinkResolver implements GraphQLResolver<Link> {

    private final UserRepository userRepository;

    /**
     * Default constructor for Link Resolver
     * @param userRepository
     */
    public LinkResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * This method returns the User who posted the link
     * It finds the user by ID
     * @param link
     * @return
     */
    public User postedBy(Link link){
        if (link.getUserId() == null){
            return null;
        }
        return userRepository.findById(link.getUserId());

    }

}
