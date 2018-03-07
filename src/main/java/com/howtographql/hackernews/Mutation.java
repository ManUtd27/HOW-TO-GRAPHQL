package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import graphql.GraphQLException;
import graphql.schema.DataFetchingEnvironment;

/**
 * This class is the root mutation resolver
 * @author sjwilliams
 */
public class Mutation implements GraphQLRootResolver {

    private final LinkRepository linkRepository;
    private final SampleRepository sampleRepository;
    private final UserRepository userRepository;

    /**
     * Overloaded constructor for creating a Mutation object
     * @param linkRepository
     */
    public Mutation(LinkRepository linkRepository, SampleRepository sampleRepository, UserRepository userRepository){
        this.linkRepository = linkRepository;
        this.sampleRepository = sampleRepository;
        this.userRepository = userRepository;
    }


    /**
     * This method creates a new Link objects based on Paramaters and add Link to list of link repository
     * @param url
     * @param description
     * @return
     */
    public Link createLink(String url, String description, DataFetchingEnvironment env){
        AuthContext context = env.getContext();
        Link newLink = new Link(url, description, context.getUser().getId());
        linkRepository.saveLink(newLink);
        return  newLink;
    }


    /**
     * This method creates a new Sample object on Paramateers and add Sample to list of Sample Repository
     * @return
     */
    public Sample createSample(String id, String processorId, String markedLatitude, String markedLongitude, String killDate, String species, String killType, String sex, String age, Boolean earNotch, String comments, String cwdCode, String customerID, String gameCheckNumber, String firstName, String lastName, String address, String city, String zipCode, String phoneNumber){
        Sample newSample = new Sample(id, processorId, markedLatitude,markedLongitude,killDate,species,killType,sex,age,earNotch,comments,cwdCode,customerID,gameCheckNumber,firstName,lastName,address,city,zipCode,phoneNumber);
        sampleRepository.saveSample(newSample);
        return  newSample;
    }


    /**
     * This method creates a new user object and also returns a referecence to the user
     * @param name
     * @param auth
     * @return
     */
    public User createUser(String name, AuthData auth){
        User newUser = new User(name, auth.getEmail(), auth.getPassword());
        return  userRepository.saveUser(newUser);
    }

    public SigninPayload signinUser(AuthData auth) throws IllegalAccessException {
        User user = userRepository.findByEmail(auth.getEmail());
        if (user.getPassword().equals(auth.getEmail())) {

            return  new SigninPayload(user.getId(), user);
        }
        throw  new GraphQLException("Invalid Credential");
    }

}
