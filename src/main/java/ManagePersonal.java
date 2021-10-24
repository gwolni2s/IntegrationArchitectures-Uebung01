import java.util.List;

public interface ManagePersonal {

    public void createSalesMan( SalesMan record ) throws InvalidInputException;

    public void addPerformanceRecord( EvaluationRecord record , int sid );

    public SalesMan readSalesMan( int sid ) throws InvalidInputException;

    public List<SalesMan> querySalesMan(String attribute , String key );

    public EvaluationRecord readEvaluationRecords( int sid ) throws InvalidInputException;

}
