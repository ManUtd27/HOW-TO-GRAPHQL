package com.howtographql.hackernews;


import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

/**
 * Query class models behavior of the Query type in our schema. It contains resolvers for all links query
 */
public class Query implements GraphQLRootResolver {

    private final LinkRepository linkRepository;
    private final SampleRepository sampleRepository;

    /**
     * Overloaded constructor
     * @param - linkRepository
     */
    public Query(LinkRepository linkRepository, SampleRepository sampleRepository) {
        this.linkRepository = linkRepository;
        this.sampleRepository = sampleRepository;
    }

    public List<Link> allLinks(LinkFilter filter, Number skip, Number first) {
        return linkRepository.getAllLinks(filter, skip.intValue(), first.intValue());
    }

    public List<Sample> allSamples(){
        return sampleRepository.getAllSamples();
    }


}
