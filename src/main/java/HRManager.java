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

    //Do not understand what the method should return
    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        return null;
    }

    @Override
    public EvaluationRecord readEvaluationRecords(int sid) throws InvalidInputException{
        return mongo.findEvaluationRecord(sid);
    }
}
