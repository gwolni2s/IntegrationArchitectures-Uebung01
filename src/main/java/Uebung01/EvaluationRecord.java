package Uebung01;

import org.bson.Document;


public class EvaluationRecord {
    private int sid; //Identification per sid
    private int year; //Year of performance

    //Orders Evaluation
    private String nameProduct;
    private String client;
    private String clientRanking;
    private int soldItems;

    private int targetValue; //target value for competences

    //social performance evaluation
    private int leadershipCompetence;
    private int opennessToEmployee;
    private int socialBehaviour;
    private int attitudeTowardsClient;

    private int communicationSkills;
    private int integrityToCompany;

    //Bonuses
    private int bonusA;
    private int bonusB;

    //private String comment
    private String remark;

    /**
     * constructor
     */
    public EvaluationRecord(int sid, int year, String nameProduct, String client, String clientRanking, int soldItems, int targetValue, int leadershipCompetence, int opennessToEmployee, int socialBehaviour, int attitudeTowardsClient, int communicationSkills, int integrityToCompany, int bonusA, int bonusB, String remark) {
        this.sid = sid;
        this.year = year;
        this.nameProduct = nameProduct;
        this.client = client;
        this.clientRanking = clientRanking;
        this.soldItems = soldItems;
        this.targetValue = targetValue;
        this.leadershipCompetence = leadershipCompetence;
        this.opennessToEmployee = opennessToEmployee;
        this.socialBehaviour = socialBehaviour;
        this.attitudeTowardsClient = attitudeTowardsClient;
        this.communicationSkills = communicationSkills;
        this.integrityToCompany = integrityToCompany;
        this.bonusA = bonusA;
        this.bonusB = bonusB;
        this.remark = remark;
    }

    /**
     * getter and setter methods
     */
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientRanking() {
        return clientRanking;
    }

    public void setClientRanking(String clientRanking) {
        this.clientRanking = clientRanking;
    }

    public int getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(int soldItems) {
        this.soldItems = soldItems;
    }

    public int getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(int Value) {
        targetValue = Value;
    }

    public int getLeadershipCompetence() {
        return leadershipCompetence;
    }

    public void setLeadershipCompetence(int leadershipCompetence) {
        this.leadershipCompetence = leadershipCompetence;
    }

    public int getOpennessToEmployee() {
        return opennessToEmployee;
    }

    public void setOpennessToEmployee(int opennessToEmployee) {
        this.opennessToEmployee = opennessToEmployee;
    }

    public int getSocialBehaviour() {
        return socialBehaviour;
    }

    public void setSocialBehaviour(int socialBehaviour) {
        this.socialBehaviour = socialBehaviour;
    }

    public int getAttitudeTowardsClient() {
        return attitudeTowardsClient;
    }

    public void setAttitudeTowardsClient(int attitudeTowardsClient) {
        this.attitudeTowardsClient = attitudeTowardsClient;
    }

    public int getCommunicationSkills() {
        return communicationSkills;
    }

    public void setCommunicationSkills(int communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    public int getIntegrityToCompany() {
        return integrityToCompany;
    }

    public void setIntegrityToCompany(int integrityToCompany) {
        this.integrityToCompany = integrityToCompany;
    }

    public int getBonusA() {
        return bonusA;
    }

    public void setBonusA(int bonusA) {
        this.bonusA = bonusA;
    }

    public int getBonusB() {
        return bonusB;
    }

    public void setBonusB(int bonusB) {
        this.bonusB = bonusB;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * Implementation of the Object-to-Document Mapping by Prof. Dr. Alda from lectures
     */
    public Document toDocument() {
        return new Document()
                .append("sid", this.sid)
                .append("year of performance", this.year)
                .append("name of product", this.nameProduct)
                .append("client", this.client)
                .append("Client Ranking", this.clientRanking)
                .append("Number of sold Items", this.soldItems)
                .append("Target Value", targetValue)
                .append("Leadership Competence", this.leadershipCompetence)
                .append("Openness to Employee", this.opennessToEmployee)
                .append("Social Behaviour to Employee", this.socialBehaviour)
                .append("Attitude towards Client", this.attitudeTowardsClient)
                .append("Communication Skills", this.communicationSkills)
                .append("Integrity to Company", this.integrityToCompany)
                .append("Bonus Part A", this.bonusA)
                .append("Bonus Part B", this.bonusB)
                .append("Remarks", this.remark);
    }
    public String toString() {
        return "sid: " + this.sid + "\nyear of performance: " + this.year + "\nname of product: " + this.nameProduct +
                "\nclient: " + this.client + "\nClient Ranking: " + this.clientRanking + "\nNumber of sold Items: " +
                this.soldItems + "\nTarget Value: " + this.targetValue + "\nLeadership Competence: " + this.leadershipCompetence +
                "\nOpenness to Employee: " + this.opennessToEmployee + "\nSocial Behaviour to Employee: " + this.socialBehaviour +
                "\nAttitude towards Client: " + this.attitudeTowardsClient + "\nCommunication Skills: " + this.communicationSkills +
                "\nIntegrity to Company: " + this.integrityToCompany + "\nBonus Part A: " + this.bonusA + "\nBonus Part B: " + this.bonusB +
                "\nRemarks: " + this.remark;
    }
}
