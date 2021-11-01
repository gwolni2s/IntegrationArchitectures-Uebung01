package Uebung01;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class MongoWrapper {

    public MongoClient client;
    public MongoDatabase mongo;
    public MongoCollection<Document> salesmen;
    public MongoCollection<Document> evaluationRecords;

    public MongoWrapper() {

        //Create mongodb connection
        client = new MongoClient("localhost", 27017);
        mongo = client.getDatabase("mongo");

        //Get salesmen and evaluationRecords Collection
        salesmen = mongo.getCollection("salesmen");
        evaluationRecords = mongo.getCollection("evaluationRecords");

        // Initialize database with example datasheets
        init();
    }

    public void init() {
        //print Ausgabe der Verbindung
        System.out.println("Connection to the database was succesfully created.\n-----------------------------------------------------------------------------------");
    }

    //method from lecture 19.10.2021
    public void insertSalesMan(SalesMan salesMan) throws InvalidInputException {
        //check if sid already exists
        Document check = salesmen.find(eq("sid", salesMan.getSid())).first();
        if(check != null) throw new InvalidInputException("Uebung01.SalesMan with the given SID already exists.");

        //insert document
        salesmen.insertOne(salesMan.toDocument());
    }

    //method from lecture 19.10.2021
    public SalesMan findSalesMan(int sid) throws InvalidInputException {
        Document salesManDoc = salesmen.find(eq("sid", sid)).first();
        if(salesManDoc == null) throw new InvalidInputException("Uebung01.SalesMan with the given SID does not exist.");
        return new SalesMan(salesManDoc.getInteger("sid"),
                    salesManDoc.getString("firstname"),
                    salesManDoc.getString("lastname"));
    }
    //method similar to findSalesMan
    public void deleteSalesMan(int sid) throws InvalidInputException {
        Document salesManDoc = salesmen.find(eq("sid", sid)).first();
        if(salesManDoc == null) throw new InvalidInputException("Uebung01.SalesMan with the given SID does not exist");
        //Delete salesman
        salesmen.deleteOne(eq("sid", sid));
        System.out.println("The Salesman with the given sid: " + sid + " was deleted successfully");
    }
    public void updateSalesMan(SalesMan salesMan) throws InvalidInputException {
        Document check = salesmen.find(eq("sid", salesMan.getSid())).first();
        if(check == null) throw new InvalidInputException("Uebung01.SalesMan with the given SID does not exist");
        //Update Uebung01.SalesMan
        salesmen.updateOne(eq("sid", salesMan.getSid()), eq("$set", salesMan.toDocument()));
    }
    //insert performance record
    public void insertPerformanceRecord(EvaluationRecord record) {
        evaluationRecords.insertOne(record.toDocument());
    }

    //method analog to findSalesMan for find Evaluation Records
    public EvaluationRecord findEvaluationRecord(int sid) throws InvalidInputException {
        Document evaluationRecordDoc = evaluationRecords.find(eq("sid", sid)).first();
        if(evaluationRecordDoc == null) throw new InvalidInputException("Evaluation record with the given SID does not exist.");
        return new EvaluationRecord(evaluationRecordDoc.getInteger("sid"),
                evaluationRecordDoc.getInteger("year of performance"),
                evaluationRecordDoc.getString("name of product"),
                evaluationRecordDoc.getString("client"),
                evaluationRecordDoc.getString("Client Ranking"),
                evaluationRecordDoc.getInteger("Number of sold Items"),
                evaluationRecordDoc.getInteger("Target Value"),
                evaluationRecordDoc.getInteger("Leadership Competence"),
                evaluationRecordDoc.getInteger("Openness to Employee"),
                evaluationRecordDoc.getInteger("Social Behaviour to Employee"),
                evaluationRecordDoc.getInteger("Attitude towards Client"),
                evaluationRecordDoc.getInteger("Communication Skills"),
                evaluationRecordDoc.getInteger("Integrity to Company"),
                evaluationRecordDoc.getInteger("Bonus Part A"),
                evaluationRecordDoc.getInteger("Bonus Part B"),
                evaluationRecordDoc.getString("Remarks"));

    }
    //similar method to deleteSalesMan
    public void deleteEvaluationRecord(int sid) throws InvalidInputException {
        Document evaluationRecordDoc = evaluationRecords.find(eq("sid", sid)).first();
        if(evaluationRecordDoc == null) throw new InvalidInputException("Evaluation Record with the given SID does not exist");
        //Delete Evaluation Record
        evaluationRecords.deleteOne(eq("sid", sid));
        System.out.println("The evaluation record with the sid: " + sid + " was deleted successfully");
    }
    public void updateEvaluationRecord(EvaluationRecord record) throws InvalidInputException {
        Document check = evaluationRecords.find(eq("sid", record.getSid())).first();
        if(check == null) throw new InvalidInputException("The evaluation record with the given sid does not exist");
        //Update evaluation record
        evaluationRecords.updateOne(eq("sid", record.getSid()), eq("$set", record.toDocument()));
    }
    public void closeDatabase() {
        client.close();
    }
}



