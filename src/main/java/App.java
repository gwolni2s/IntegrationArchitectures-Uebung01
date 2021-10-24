import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InvalidInputException {
        //declaration of variables
        boolean active = true;
        int sid;
        String firstname;
        String lastname;
        int year;
        String nameProduct;
        String client;
        String clientRanking;
        int soldItems;
        int targetValue;
        int leadershipCompetence;
        int opennessToEmployee;
        int socialBehaviour;
        int attitudeTowardsClient;
        int communicationSkills;
        int integrityToCompany;
        int bonusA;
        int bonusB;
        String remark;
        SalesMan salesman;
        EvaluationRecord record;


        //Create Scanner to take input from the command line
        Scanner scan = new Scanner(System.in);

        //Welcome and create database connection with HRManager object
        HRManager manager = new HRManager(new MongoWrapper());
        textOutput.welcome();

        while(active) {
            //Choose option from menu to execute
            textOutput.menu();
            switch (scan.nextInt()) {
                case 0:
                    textOutput.thankYou();
                    active = false;
                    break;
                case 1:
                    System.out.println("Please enter the sid of the new salesman");
                    sid = scan.nextInt();
                    System.out.println("Please enter the firstname of the new salesman");
                    scan.nextLine();
                    firstname = scan.nextLine();
                    System.out.println("Please enter the lastname of the new salesman");
                    lastname = scan.nextLine();
                    manager.createSalesMan(new SalesMan(sid, firstname, lastname));
                    break;
                case 2:
                    System.out.println("Please enter <sid> of the new evaluation record");
                    sid = scan.nextInt();
                    System.out.println("Please enter <year> of the new evaluation record");
                    year = scan.nextInt();
                    System.out.println("Please enter <name of product> of the new evaluation record");
                    scan.nextLine();
                    nameProduct = scan.nextLine();
                    System.out.println("Please enter <client> of the new evaluation record");
                    client = scan.nextLine();
                    System.out.println("Please enter <Client Ranking> of the new evaluation record");
                    clientRanking = scan.nextLine();
                    System.out.println("Please enter <Number of sold Items> of the new evaluation record");
                    soldItems = scan.nextInt();
                    System.out.println("Please enter <Target Value> of the new evaluation record");
                    targetValue = scan.nextInt();
                    System.out.println("Please enter <Leadership Competence> of the new evaluation record");
                    leadershipCompetence = scan.nextInt();
                    System.out.println("Please enter <Openness to Employee> of the new evaluation record");
                    opennessToEmployee = scan.nextInt();
                    System.out.println("Please enter <Social Behaviour to Employee> of the new evaluation record");
                    socialBehaviour = scan.nextInt();
                    System.out.println("Please enter <Attitude towards Client> of the new evaluation record");
                    attitudeTowardsClient = scan.nextInt();
                    System.out.println("Please enter <Communication Skills> of the new evaluation record");
                    communicationSkills = scan.nextInt();
                    System.out.println("Please enter <Integrity> to Company of the new evaluation record");
                    integrityToCompany = scan.nextInt();
                    System.out.println("Please enter <Bonus> Part A of the new evaluation record");
                    bonusA = scan.nextInt();
                    System.out.println("Please enter <Bonus> Part B of the new evaluation record");
                    bonusB = scan.nextInt();
                    System.out.println("Please enter <Remark> of the new evaluation record");
                    scan.nextLine();
                    remark = scan.nextLine();
                    manager.addPerformanceRecord(new EvaluationRecord(sid, year, nameProduct, client, clientRanking, soldItems, targetValue, leadershipCompetence, opennessToEmployee, socialBehaviour, attitudeTowardsClient, communicationSkills, integrityToCompany, bonusA, bonusB, remark), sid);
                    break;
                case 3:
                    System.out.println("Please enter the sid of the salesman.");
                    salesman = manager.readSalesMan(scan.nextInt());
                    System.out.println(salesman.toString());
                    break;
                case 4:
                    System.out.println("Please enter the sid of the evaluation record");
                    record = manager.readEvaluationRecords(scan.nextInt());
                    System.out.println(record.toString());
                    break;
                case 5:
                    System.out.println("Please enter the sid of the salesman you would like to delete");
                    manager.deleteSalesMan(scan.nextInt());
                    break;
                case 6:
                    System.out.println("PLease enter the sid of the evaluation record you would like to delete");
                    manager.deleteEvaluationRecord(scan.nextInt());
                    break;
                case 7:
                    System.out.println("Please enter the sid of the new salesman");
                    sid = scan.nextInt();
                    System.out.println("Please enter the firstname of the new salesman");
                    scan.nextLine();
                    firstname = scan.nextLine();
                    System.out.println("Please enter the lastname of the new salesman");
                    lastname = scan.nextLine();
                    manager.updateSalesMan(new SalesMan(sid, firstname, lastname));
                    break;
                case 8:
                    System.out.println("Please enter <sid> of the new evaluation record");
                    sid = scan.nextInt();
                    System.out.println("Please enter <year> of the new evaluation record");
                    year = scan.nextInt();
                    System.out.println("Please enter <name of product> of the new evaluation record");
                    scan.nextLine();
                    nameProduct = scan.nextLine();
                    System.out.println("Please enter <client> of the new evaluation record");
                    client = scan.nextLine();
                    System.out.println("Please enter <Client Ranking> of the new evaluation record");
                    clientRanking = scan.nextLine();
                    System.out.println("Please enter <Number of sold Items> of the new evaluation record");
                    soldItems = scan.nextInt();
                    System.out.println("Please enter <Target Value> of the new evaluation record");
                    targetValue = scan.nextInt();
                    System.out.println("Please enter <Leadership Competence> of the new evaluation record");
                    leadershipCompetence = scan.nextInt();
                    System.out.println("Please enter <Openness to Employee> of the new evaluation record");
                    opennessToEmployee = scan.nextInt();
                    System.out.println("Please enter <Social Behaviour to Employee> of the new evaluation record");
                    socialBehaviour = scan.nextInt();
                    System.out.println("Please enter <Attitude towards Client> of the new evaluation record");
                    attitudeTowardsClient = scan.nextInt();
                    System.out.println("Please enter <Communication Skills> of the new evaluation record");
                    communicationSkills = scan.nextInt();
                    System.out.println("Please enter <Integrity> to Company of the new evaluation record");
                    integrityToCompany = scan.nextInt();
                    System.out.println("Please enter <Bonus> Part A of the new evaluation record");
                    bonusA = scan.nextInt();
                    System.out.println("Please enter <Bonus> Part B of the new evaluation record");
                    bonusB = scan.nextInt();
                    System.out.println("Please enter <Remark> of the new evaluation record");
                    scan.nextLine();
                    remark = scan.nextLine();
                    manager.updateEvaluationRecord(new EvaluationRecord(sid, year, nameProduct, client, clientRanking, soldItems, targetValue, leadershipCompetence, opennessToEmployee, socialBehaviour, attitudeTowardsClient, communicationSkills, integrityToCompany, bonusA, bonusB, remark), sid);
                    break;
                default:
                    System.out.println("Input was not correct.\nPlease try again");
                    break;
            }
        }
        scan.close();
    }
}

