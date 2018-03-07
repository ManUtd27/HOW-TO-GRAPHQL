package com.howtographql.hackernews;


import com.coxautodev.graphql.tools.GraphQLResolver;

/** Because Vote data class contains a complex (non-scalar) object Vote, it needs a companion resolver class
 * @author sjwilliams
 */
public class VoteResolver implements GraphQLResolver<Vote> {

    private final LinkRepository linkRepository;
    private final UserRepository userRepository;

    /**
     * Default Constructor
     * @param linkRepository
     * @param userRepository
     */
    public VoteResolver(LinkRepository linkRepository, UserRepository userRepository) {
        this.linkRepository = linkRepository;
        this.userRepository = userRepository;
    }


    /**
     * Return user who Votes for link
     * @param vote
     * @return
     */
    public User user(Vote vote){
        return userRepository.findById(vote.getUserId());
    }

    /**
     * Return link that got voted on
     * @param vote
     * @return
     */
    public Link link(Vote vote){
        return linkRepository.findById(vote.getLinkId());
    }

}
