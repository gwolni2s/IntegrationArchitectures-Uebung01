package Uebung01;

import Uebung01.EvaluationRecord;
import Uebung01.InvalidInputException;
import Uebung01.SalesMan;

import java.util.List;

public interface ManagePersonal {

    public void createSalesMan( SalesMan record ) throws InvalidInputException;

    public void addPerformanceRecord(EvaluationRecord record , int sid );

    public SalesMan readSalesMan( int sid ) throws InvalidInputException;

    //Do not understand what the method actually should do
    public List<SalesMan> querySalesMan(String attribute , String key );

    public EvaluationRecord readEvaluationRecords( int sid ) throws InvalidInputException;

    public void updateSalesMan(SalesMan record) throws InvalidInputException;

    public void updateEvaluationRecord(EvaluationRecord record, int sid) throws InvalidInputException;

    public void deleteSalesMan(int sid) throws InvalidInputException;

    public void deleteEvaluationRecord(int sid) throws InvalidInputException;

}
