package com.howtographql.hackernews;

/**
 * Sample Class is a POJO that models the Sample type in the Graphql schema
 * @author Shawn.Williams
 */
public class Sample {

    private final String id;
//    private final String employeeId;
    private final String processorId;
    private final String  markedLatitude;
    private final String markedLongitude;
    private final String killDate;
    private final String species;
    private final String killType;
    private  Sex sex;
    private final String age;
    private final Boolean earNotch;
    private final String comments;
    private final String cwdCode;
    private final String customerID;
    private final String gameCheckNumber;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String zipCode;
    private final String phoneNumber;


    public  enum Sex {
        MALE, FEMALE
    }


    /**
     * Constructor with all paramater but ID
     */
//    public Sample( String processorId, String markedLatitude, String markedLongitude, String killDate, String species, String killType, String sex, String age, Boolean earNotch, String comments, String cwdCode, String customerID, String gameCheckNumber, String firstName, String lastName, String address, String city, String zipCode, String phoneNumber) {
//        this(null,  processorId, markedLatitude,markedLongitude,killDate,species,killType,sex,age,earNotch,comments,cwdCode,customerID,gameCheckNumber,firstName,lastName,address,city,zipCode,phoneNumber);
//    }


    public Sample(String id,  String processorId, String markedLatitude, String markedLongitude, String killDate, String species, String killType, Sex sex, String age, Boolean earNotch, String comments, String cwdCode, String customerID, String gameCheckNumber, String firstName, String lastName, String address, String city, String zipCode, String phoneNumber ){
        this.id = id;
//        this.employeeId = employeeId;
        this.processorId = processorId;
        this.markedLatitude = markedLatitude;
        this.markedLongitude = markedLongitude;
        this.killDate = killDate;
        this.species = species;
        this.killType = killType;
        this.sex = sex;
        this.age = age;
        this.earNotch = earNotch;
        this.comments = comments;
        this.cwdCode = cwdCode;
        this.customerID = customerID;
        this.gameCheckNumber = gameCheckNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter method
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter method
     * @return assisID
     */
//    public String getAssisID() {
//        return employeeId;
//    }

    /**
     * Getter method
     * @return processorID
     */
    public String getProcessorId() {
        return processorId;
    }

    public String getMarkedLatitude() {
        return markedLatitude;
    }

    public String getMarkedLongitude() {
        return markedLongitude;
    }

    public String getKillDate() {
        return killDate;
    }

    public String getSpecies() {
        return species;
    }

    public String getKillType() {
        return killType;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public Boolean getEarNotch() {
        return earNotch;
    }

    public String getComments() {
        return comments;
    }

    public String getCwdCode() {
        return cwdCode;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getGameCheckNumber() {
        return gameCheckNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
