package com.howtographql.hackernews;


import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


/**
 * User repository class repository class to handle saving and loading users,
 * @author sjwilliams
 */
public class UserRepository {

    private final MongoCollection<Document> users;

    /**
     * Default constructor with params
     * @param users
     */
    public UserRepository(MongoCollection<Document> users) {
        this.users = users;
    }


    /**
     * Find user by email and return user
     * @param email
     * @return
     */
    public User findByEmail(String email){
        Document doc = users.find(eq("email", email)).first();
        return user(doc);
    }

    /**
     * Find user by Id and return user
     * @param id
     * @return
     */
    public User findById(String id ){
        Document doc = users.find(eq("_id", new ObjectId(id))).first();
        return user(doc);
    }

    /**
     * Save User
     * @param user
     * @return
     */
    public User saveUser(User user){
        Document doc = new Document();
        doc.append("name", user.getName());
        doc.append("email", user.getEmail());
        doc.append("password", user.getPassword());
        users.insertOne(doc);
        return new User(
                doc.get("_id").toString(),
                user.getName(),
                user.getEmail(),
                user.getPassword());
    }


    private User user(Document doc){
        if (doc == null ){
            return null;
        }
        return new User(
                doc.get("_id").toString(),
                doc.getString("name"),
                doc.getString("email"),
                doc.getString("password")
        );
    }

}
