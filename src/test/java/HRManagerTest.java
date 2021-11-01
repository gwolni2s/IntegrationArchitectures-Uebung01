import Uebung01.*;
import org.bson.Document;
import org.junit.jupiter.api.*;

import static com.mongodb.client.model.Filters.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HRManagerTest {

    static SalesMan salesman1;
    static SalesMan salesman2;
    static SalesMan salesman3;
    static SalesMan salesman4;
    static SalesMan salesman5;
    static SalesMan salesman6;
    static SalesMan supdate1;
    static SalesMan supdate2;
    static EvaluationRecord record1;
    static EvaluationRecord record2;
    static EvaluationRecord record3;
    static EvaluationRecord record4;
    static EvaluationRecord record5;
    static EvaluationRecord record6;
    static EvaluationRecord rupdate1;
    static EvaluationRecord rupdate2;
    static HRManager manager;
    static MongoWrapper mongoDatabase;

    @AfterAll
    public static void cleanUp() {
        salesman1 = null;
        salesman2 = null;
        salesman3 = null;
        salesman4 = null;
        supdate1 = null;
        supdate2 = null;
        record1 = null;
        record2 = null;
        record3 = null;
        record4 = null;
        rupdate1 = null;
        rupdate2 = null;
        manager = null;
        mongoDatabase = null;
    }
    @AfterAll
    public static void closeDatabase() {
        manager.closeConnection();
    }

    @BeforeAll
    public static void createConnection() {
        mongoDatabase = new MongoWrapper();
        manager = new HRManager(mongoDatabase);
    }

    @BeforeAll
    public static void setUp() {
        //init()
        //Create salesman
        salesman5 = new SalesMan(000001, "John", "Smith");
        salesman6 = new SalesMan(000002, "Louisa", "Widdmann");

        //Create evaluation records
        record5 = new EvaluationRecord(000001, 2021, "HooverGo", "Telekom AG", "excellent", 20, 4, 3, 2, 3, 3, 3, 4, 100, 30, "What's wrong?");
        record6 = new EvaluationRecord(000002, 2021, "HooverClean", "Germania GmbH", "good", 15, 4, 4, 3, 4, 4, 3, 3, 150, 90, "Good Job");

        //Create salesman
        salesman1 = new SalesMan(000003, "Mario", "Italiano");
        salesman2 = new SalesMan(000004, "Luigi", "Italiano");
        //Create evaluation records
        record1 = new EvaluationRecord(000003, 2021, "tax course", "american bank", "good", 30, 4, 2, 3, 4, 5, 4, 5, 120, 50, "Can I help you?");
        record2 = new EvaluationRecord(000004, 2021, "Real estate course", "dhl", "bad", 20, 4, 3, 4, 3, 1, 2, 4, 100, 60, "You Good?");
        //Create Update Uebung01.SalesMan
        supdate1 = new SalesMan(000003, "Pablo", "Escobar");
        supdate2 = new SalesMan(000004, "Pablo", "Picasso");
        //Create update records
        rupdate1 = new EvaluationRecord(000003, 2001, "televisions", "president", "really good", 100, 4, 5, 2, 1, 3, 5, 5, 1000000, 250000, "Perfect");
        rupdate2 = new EvaluationRecord(000004, 2000, "pictures", "instagram", "wonderful", 1, 4, 4, 1, 2, 2, 3, 2, 10, 30, "Great Work");
    }
    @BeforeEach
    public void createData() throws InvalidInputException {
        mongoDatabase.salesmen.drop();
        mongoDatabase.evaluationRecords.drop();
        manager.createSalesMan(salesman1);
        manager.createSalesMan(salesman2);
        manager.addPerformanceRecord(record1, 000003);
        manager.addPerformanceRecord(record2, 000004);
        manager.createSalesMan(salesman5);
        manager.createSalesMan(salesman6);
        manager.addPerformanceRecord(record5, 1);
        manager.addPerformanceRecord(record6, 2);
    }
    @DisplayName("Test was successful if the Uebung01.SalesMan were created and inserted correctly into the database")
    @Test
    public void createSalesManTest() throws InvalidInputException {
        Document doc1 = mongoDatabase.salesmen.find(eq("sid", salesman1.getSid())).first();
        Document doc2 = mongoDatabase.salesmen.find(eq("sid", salesman2.getSid())).first();
        salesman3 = new SalesMan(doc1.getInteger("sid"),
                doc1.getString("firstname"),
                doc1.getString("lastname"));
        salesman4 = new SalesMan(doc2.getInteger("sid"),
                doc2.getString("firstname"),
                doc2.getString("lastname"));
        assertEquals(salesman1.toString(), salesman3.toString());
        assertEquals(salesman2.toString(), salesman4.toString());
    }

    @DisplayName("Test was successful if the evaluation records were created and inserted correctly into the database")
    @Test
    public void addPerformanceRecordTest() {
        Document doc1 = mongoDatabase.evaluationRecords.find(eq("sid", record1.getSid())).first();
        Document doc2 = mongoDatabase.evaluationRecords.find(eq("sid", record2.getSid())).first();
        record3 = new EvaluationRecord(doc1.getInteger("sid"),
                doc1.getInteger("year of performance"),
                doc1.getString("name of product"),
                doc1.getString("client"),
                doc1.getString("Client Ranking"),
                doc1.getInteger("Number of sold Items"),
                doc1.getInteger("Target Value"),
                doc1.getInteger("Leadership Competence"),
                doc1.getInteger("Openness to Employee"),
                doc1.getInteger("Social Behaviour to Employee"),
                doc1.getInteger("Attitude towards Client"),
                doc1.getInteger("Communication Skills"),
                doc1.getInteger("Integrity to Company"),
                doc1.getInteger("Bonus Part A"),
                doc1.getInteger("Bonus Part B"),
                doc1.getString("Remarks"));
        record4 = new EvaluationRecord(doc2.getInteger("sid"),
                doc2.getInteger("year of performance"),
                doc2.getString("name of product"),
                doc2.getString("client"),
                doc2.getString("Client Ranking"),
                doc2.getInteger("Number of sold Items"),
                doc2.getInteger("Target Value"),
                doc2.getInteger("Leadership Competence"),
                doc2.getInteger("Openness to Employee"),
                doc2.getInteger("Social Behaviour to Employee"),
                doc2.getInteger("Attitude towards Client"),
                doc2.getInteger("Communication Skills"),
                doc2.getInteger("Integrity to Company"),
                doc2.getInteger("Bonus Part A"),
                doc2.getInteger("Bonus Part B"),
                doc2.getString("Remarks"));
        assertEquals(record1.toString(), record3.toString());
        assertEquals(record2.toString(), record4.toString());
    }
    @DisplayName("Test was successful if the salesman data was read correctly out of the database")
    @Test
    public void readSalesManTest() throws InvalidInputException {
        salesman3 = manager.readSalesMan(salesman1.getSid());
        salesman4 = manager.readSalesMan(salesman2.getSid());
        assertEquals(salesman1.toString(), salesman3.toString());
        assertEquals(salesman2.toString(), salesman4.toString());
    }
    @DisplayName("Test was successful if the evaluation records data was read correctly out of the database")
    @Test
    public void readEvaluationRecordTest() throws InvalidInputException {
        record3 = manager.readEvaluationRecords(record1.getSid());
        record4 = manager.readEvaluationRecords(record2.getSid());
        assertEquals(record1.toString(), record3.toString());
        assertEquals(record2.toString(), record4.toString());
    }
    @DisplayName("Test was successful if the update of the salesman data was correctly executed")
    @Test
    public void updateSalesManTest() throws InvalidInputException {
        manager.updateSalesMan(supdate1);
        manager.updateSalesMan(supdate2);
        assertEquals(supdate1.toString(), manager.readSalesMan(supdate1.getSid()).toString());
        assertEquals(supdate2.toString(), manager.readSalesMan(supdate2.getSid()).toString());
    }
    @DisplayName("Test was successful if the update of the evaluation record data was correctly executed")
    @Test
    public void updateEvaluationRecordTest() throws InvalidInputException {
        manager.updateEvaluationRecord(rupdate1, rupdate1.getSid());
        manager.updateEvaluationRecord(rupdate2, rupdate2.getSid());
        assertEquals(rupdate1.toString(), manager.readEvaluationRecords(rupdate1.getSid()).toString());
        assertEquals(rupdate2.toString(), manager.readEvaluationRecords(rupdate2.getSid()).toString());
    }
    @DisplayName("Test was successful if salesmen data was deleted correctly out of the database")
    @Test
    public void deleteSalesManTest() throws InvalidInputException {
        int sid1 = salesman1.getSid();
        int sid2 = salesman2.getSid();
        manager.deleteSalesMan(salesman1.getSid());
        manager.deleteSalesMan(salesman2.getSid());
        Document doc1 = mongoDatabase.salesmen.find(eq("sid", sid1)).first();
        Document doc2 = mongoDatabase.salesmen.find(eq("sid", sid2)).first();
        assertEquals(null, doc1);
        assertEquals(null, doc2);
    }
    @DisplayName("Test was successful if evaluation record data was deleted correctly out of the database")
    @Test
    public void deleteEvaluationRecordTest() throws InvalidInputException {
        int sid1 = record1.getSid();
        int sid2 = record2.getSid();
        manager.deleteEvaluationRecord(record1.getSid());
        manager.deleteEvaluationRecord(record2.getSid());
        Document doc1 = mongoDatabase.evaluationRecords.find(eq("sid", sid1)).first();
        Document doc2 = mongoDatabase.evaluationRecords.find(eq("sid", sid2)).first();
        assertEquals(null, doc1);
        assertEquals(null, doc2);
    }
}





