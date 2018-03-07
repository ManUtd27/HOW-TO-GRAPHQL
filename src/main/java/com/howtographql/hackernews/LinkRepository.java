package com.howtographql.hackernews;


import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * LinkRepository class that will neatly isolate the concern of saving and loading links from the storage.
 * @author sjwilliams
 */
public class LinkRepository {

    private final MongoCollection<Document> links;

    /**
     * Default constructor
     */
    public LinkRepository(MongoCollection<Document> links) {
       this.links = links;

    }


    public Link findById(String id) {
        Document doc = links.find(eq("_id", new ObjectId(id))).first();
        return link(doc);
    }

    /**
     * Getter for List of links
     * @return links
     */
    public List<Link> getAllLinks() {
        List<Link> allLinks = new ArrayList<>();
        for (Document doc : links.find()) {
            Link link = new Link(
                    doc.get("_id").toString(),
                    doc.getString("url"),
                    doc.getString("description"),
                    doc.getString("postedBy")
            );
            allLinks.add(link);
        }
        return allLinks;
    }

    /**
     * Method to add links to the List of Links
     * @param - link
     */
    public void saveLink(Link link){
        Document doc = new Document();
        doc.append("url", link.getUrl());
        doc.append("description", link.getDescription());
        doc.append("postedBy", link.getUserId());
        links.insertOne(doc);
    }

    private Link link(Document doc) {
        return new Link(
                doc.get("_id").toString(),
                doc.getString("url"),
                doc.getString("description"));
    }
}
