package Uebung01;

import Uebung01.EvaluationRecord;
import Uebung01.InvalidInputException;
import Uebung01.MongoWrapper;
import Uebung01.SalesMan;

import java.util.List;

public class HRManager implements ManagePersonal {

    private MongoWrapper mongo;

    public HRManager(MongoWrapper mongo) {
        this.mongo = mongo;
    }

    @Override
    public void createSalesMan(SalesMan record) throws InvalidInputException {
        mongo.insertSalesMan(record);
    }

    @Override
    public void addPerformanceRecord(EvaluationRecord record, int sid) {
        record.setSid(sid);
        mongo.insertPerformanceRecord(record);
    }

    @Override
    public SalesMan readSalesMan(int sid) throws InvalidInputException {
        return mongo.findSalesMan(sid);
    }

    //Do not understand what the method actually should do
    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        return null;
    }

    @Override
    public EvaluationRecord readEvaluationRecords(int sid) throws InvalidInputException{
        return mongo.findEvaluationRecord(sid);
    }

    @Override
    public void updateSalesMan(SalesMan record) throws InvalidInputException {
        mongo.updateSalesMan(record);
    }

    @Override
    public void updateEvaluationRecord(EvaluationRecord record, int sid) throws InvalidInputException {
        record.setSid(sid);
        mongo.updateEvaluationRecord(record);
    }

    @Override
    public void deleteSalesMan(int sid) throws InvalidInputException {
        mongo.deleteSalesMan(sid);
    }

    @Override
    public void deleteEvaluationRecord(int sid) throws InvalidInputException {
        mongo.deleteEvaluationRecord(sid);
    }
    public void closeConnection() {
        mongo.closeDatabase();
    }
}
