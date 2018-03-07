package com.howtographql.hackernews;

import com.coxautodev.graphql.tools.SchemaParser;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.SimpleGraphQLServlet;

import java.util.Optional;


/**
 * This class is the servlet exposing the API
 * @author shawn.williams
 */
@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint  extends SimpleGraphQLServlet {

    private static final LinkRepository linkRepository;
    private static final SampleRepository sampleRepository;
    private static final UserRepository   userRepository;

    static {
        //Change to `new MongoClient("mongodb://<host>:<port>/hackernews")`
        //if you don't have Mongo running locally on port 27017
        MongoDatabase mongo = new MongoClient().getDatabase("hackernews");
        linkRepository = new LinkRepository(mongo.getCollection("links"));
        sampleRepository = new SampleRepository(mongo.getCollection("samples"));
        userRepository = new UserRepository(mongo.getCollection("users"));
    }

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(
                        new Query(linkRepository, sampleRepository),
                        new Mutation(linkRepository, sampleRepository, userRepository),
                        new SigninResolver(),
                        new LinkResolver(userRepository))
                .build()
                .makeExecutableSchema();
    }

    /**
     * Overriing method provided by SimpleGraphQLServlet
     * @param request
     * @param response
     * @return
     */
    @Override
    protected GraphQLContext createContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
        User user = request
                .map(req -> req.getHeader("Authorization"))
                .filter(id -> !id.isEmpty())
                .map(id -> id.replace("Bearer ", ""))
                .map(userRepository::findById)
                .orElse(null);
        return new AuthContext(user, request, response);
    }
}