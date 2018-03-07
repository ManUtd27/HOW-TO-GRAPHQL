package com.howtographql.hackernews;


import com.mongodb.client.MongoCollection;
import graphql.Scalars;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * VoteRepository class that will neatly isolate the concern of saving and loading links from the storage.
 * @author sjwilliams
 */
public class VoteRepository {

    private final MongoCollection<Document> votes;

    /**
     * Default constructor for Vote Repository
     * @param votes
     */
    public VoteRepository(MongoCollection<Document> votes) {
        this.votes = votes;
    }

    /**
     * Returns a list of Votes user voted for
     * @param userId
     * @return list
     */
    public List<Vote> findByUserId(String userId){
        List<Vote> list = new ArrayList<>();
        for (Document doc: votes.find(eq("userId", userId))) {
            list.add(vote(doc));
        }
        return list;
    }

    /**
     * Returns a list of Votes user voted for
     * @param linkId
     * @return list
     */
    public List<Vote> findByLinkId(String linkId){
        List<Vote> list = new ArrayList<>();
        for (Document doc: votes.find(eq("linkId", linkId))) {
            list.add(vote(doc));
        }
        return list;
    }

    /**
     * Return Vote once it is saved
     * @param vote
     * @return
     */
    public Vote saveVote(Vote vote){
        Document doc = new Document();
        doc.append("userId", vote.getUserId());
        doc.append("linkId", vote.getLinkId());
        doc.append("createdAt", com.howtographql.hackernews.Scalars.dateTime.getCoercing().serialize(vote.getCreatedAt()));
        votes.insertOne(doc);
        return new Vote (
                doc.get("_id").toString(),
                vote.getCreatedAt(),
                vote.getUserId(),
                vote.getLinkId());

    }

    private Vote vote(Document doc){
        return new Vote(
                doc.get("_id").toString(),
                ZonedDateTime.parse(doc.getString("createdAt")),
                doc.getString("userId"),
                doc.getString("linkId"));
    }

}
