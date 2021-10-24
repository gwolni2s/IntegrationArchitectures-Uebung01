import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class MongoWrapper {

    MongoClient client;
    MongoDatabase mongo;
    MongoCollection<Document> salesmen;
    MongoCollection<Document> evaluationRecords;

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
        /**
         * Question: By dropping all collections at the beginning,
         *              everything except the example data is deleted,
         *              how can the data created external using the app still be saved ?
         */
        //Clean database (Onl two collections yet)
        salesmen.drop();
        evaluationRecords.drop();

        //Create salesman
        SalesMan salesman = new SalesMan(000001, "John", "Smith");
        SalesMan saleswoman = new SalesMan(000002, "Louisa", "Widdmann");

        //Create evaluation records
        EvaluationRecord recordOne = new EvaluationRecord(000001, 2021, "HooverGo", "Telekom AG", "excellent", 20, 4, 3, 2, 3, 3, 3, 4, 100, 30, "What's wrong?");
        EvaluationRecord recordTwo = new EvaluationRecord(000002, 2021, "HooverClean", "Germania GmbH", "good", 15, 4, 4, 3, 4, 4, 3, 3, 150, 90, "Good Job");

        //Insert Salesmen into database
        salesmen.insertOne(salesman.toDocument());
        salesmen.insertOne(saleswoman.toDocument());

        //Insert evaluation records into database
        evaluationRecords.insertOne(recordOne.toDocument());
        evaluationRecords.insertOne(recordTwo.toDocument());

        //print Ausgabe der Verbindung
        System.out.println("Connection to the database was succesfully created.\n-----------------------------------------------------------------------------------");
    }

    //method from lecture 19.10.2021
    public void insertSalesMan(SalesMan salesMan) throws InvalidInputException {
        //check if sid already exists
        Document check = salesmen.find(eq("sid", salesMan.getSid())).first();
        if(check != null) throw new InvalidInputException();

        //insert document
        salesmen.insertOne(salesMan.toDocument());
    }

    //method from lecture 19.10.2021
    public SalesMan findSalesMan(int sid) throws InvalidInputException {
        Document salesManDoc = salesmen.find(eq("sid", sid)).first();
        if(salesManDoc == null) throw new InvalidInputException();
        return new SalesMan(salesManDoc.getInteger("sid"),
                    salesManDoc.getString("firstname"),
                    salesManDoc.getString("lastname"));
    }

    //insert performance record
    public void insertPerformanceRecord(EvaluationRecord record) {
        evaluationRecords.insertOne(record.toDocument());
    }

    //method analog to findSalesMan for find Evaluation Records
    public EvaluationRecord findEvaluationRecord(int sid) throws InvalidInputException {
        Document evaluationRecordDoc = evaluationRecords.find(eq("sid", sid)).first();
        if(evaluationRecordDoc == null) throw new InvalidInputException();
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
}

