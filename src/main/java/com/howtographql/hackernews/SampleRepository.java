package com.howtographql.hackernews;


import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Sample Repositoryclass that will neatly isolate the concern of saving and loading links from the storage.
 * @author sjwilliams
 */
public class SampleRepository {

    private final MongoCollection<Document> samples;


    /**
     * Default Constructor
     * @param samples
     */
    public SampleRepository(MongoCollection<Document> samples) {
        this.samples = samples;
    }


    public Sample findById(String id){
        Document doc = samples.find(eq("_id", new ObjectId(id))).first();
        return  sample(doc);
    }



    public List<Sample> getAllSamples(){
        List<Sample> allSamples = new ArrayList<>();
        for (Document doc : samples.find()){
            allSamples.add(sample(doc));
        }
        return allSamples;
    }


public void saveSample(Sample sample){
        Document doc = new Document();
        doc.append("processorId", sample.getProcessorId());
        doc.append("markedLatitude", sample.getMarkedLatitude());
        doc.append("markedLongitude", sample.getMarkedLongitude());
        doc.append("killDate", sample.getKillDate());
        doc.append("species", sample.getSpecies());
        doc.append("killType", sample.getKillType());
        doc.append("sex", sample.getSex());
        doc.append("age", sample.getAge());
        doc.append("earNotch", sample.getEarNotch());
        doc.append("comments", sample.getComments());
        doc.append("cwdCode", sample.getCwdCode());
        doc.append("customerID", sample.getCustomerID());
        doc.append("gameCheckNumber", sample.getGameCheckNumber());
        doc.append("firstName", sample.getFirstName());
        doc.append("lastName", sample.getLastName());
        doc.append("address", sample.getAddress());
        doc.append("city", sample.getCity());
        doc.append("zipCode", sample.getZipCode());
        doc.append("phoneNumber", sample.getPhoneNumber());
        samples.insertOne(doc);
}





    private Sample sample(Document doc){
        return new Sample(
                doc.get("_id").toString(),
                doc.getString("processorId"),
                doc.getString("markedLatitude"),
                doc.getString("markedLongitude"),
                doc.getString("killDate"),
                doc.getString("species"),
                doc.getString("killType"),
                doc.getString("sex"),
                doc.getString("age"),
                doc.getBoolean("earNotch"),
                doc.getString("comments"),
                doc.getString("cwdCode"),
                doc.getString("customerID"),
                doc.getString("gameCheckNumber"),
                doc.getString("firstName"),
                doc.getString("lastName"),
                doc.getString("address"),
                doc.getString("city"),
                doc.getString("zipCode"),
                doc.getString("phoneNumber"));
    }

}
