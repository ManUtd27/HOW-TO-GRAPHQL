package com.howtographql.hackernews;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

/**
 * Sample Repository class that will neatly isolate the concern of saving and loading links from the storage.
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



    public List<Sample> getAllSamples(SampleFilter filter,  int skip, int first){
        Optional<Bson> mongoFilter = Optional.ofNullable(filter).map(this::buildFilter);

        List<Sample> allSamples = new ArrayList<>();
        FindIterable<Document> documents = mongoFilter.map(samples::find).orElseGet(samples::find);
        for (Document doc : documents.skip(skip).limit(first)){
            allSamples.add(sample(doc));
        }
        return allSamples;
    }


    /**
     * Method helper for filter data
     * @param filter
     * @return
     */
    private Bson buildFilter(SampleFilter filter){

        String speciesPattern = filter.getSpeciesContains();
        String killTypePattern = filter.getKillTypeContains();
        Bson speciesCondition = null;
        Bson killTypeCondition = null;

        if (speciesPattern != null && !speciesPattern.isEmpty()){
            speciesCondition = regex("species", ".*" + speciesPattern + ".*", "i");
        }
        if (killTypePattern != null && !killTypePattern.isEmpty()) {
            killTypeCondition = regex("killType", ".*" + killTypePattern + ".*", "i");
        }
        if (speciesCondition != null && killTypeCondition != null){
            return and(speciesCondition, killTypeCondition);
        }
        return speciesCondition != null ? speciesCondition:killTypeCondition;
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
