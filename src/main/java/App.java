import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InvalidInputException {
        //Create Scanner to take input from the command line
        Scanner scan = new Scanner(System.in);

        //Welcome and create database connection with HRManager object
        HRManager manager = new HRManager(new MongoWrapper());
        textOutput.welcome();

        boolean active = true;
        while(active) {
            //Choose option from menu to execute
            textOutput.menu();
            switch (scan.nextInt()) {
                case 0:
                    System.out.println("Thank you for choosing ManagePersonal App\nGood Bye");
                    active = false;
                    break;
                case 1:
                    System.out.println("Please enter the sid of the new salesman");
                    int sid = scan.nextInt();
                    System.out.println("Please enter the firstname of the new salesman");
                    scan.nextLine();
                    String firstname = scan.nextLine();
                    System.out.println("Please enter the lastname of the new salesman");
                    String lastname = scan.nextLine();
                    manager.createSalesMan(new SalesMan(sid, firstname, lastname));
                    break;
                case 2:
                    System.out.println("Please enter <sid> of the new evaluation record");
                    sid = scan.nextInt();
                    System.out.println("Please enter <year> of the new evaluation record");
                    int year = scan.nextInt();
                    System.out.println("Please enter <name of product> of the new evaluation record");
                    scan.nextLine();
                    String nameProduct = scan.nextLine();
                    System.out.println("Please enter <client> of the new evaluation record");
                    String client = scan.nextLine();
                    System.out.println("Please enter <Client Ranking> of the new evaluation record");
                    String clientRanking = scan.nextLine();
                    System.out.println("Please enter <Number of sold Items> of the new evaluation record");
                    int soldItems = scan.nextInt();
                    System.out.println("Please enter <Target Value> of the new evaluation record");
                    int targetValue = scan.nextInt();
                    System.out.println("Please enter <Leadership Competence> of the new evaluation record");
                    int leadershipCompetence = scan.nextInt();
                    System.out.println("Please enter <Openness to Employee> of the new evaluation record");
                    int opennessToEmployee = scan.nextInt();
                    System.out.println("Please enter <Social Behaviour to Employee> of the new evaluation record");
                    int socialBehaviour = scan.nextInt();
                    System.out.println("Please enter <Attitude towards Client> of the new evaluation record");
                    int attitudeTowardsClient = scan.nextInt();
                    System.out.println("Please enter <Communication Skills> of the new evaluation record");
                    int communicationSkills = scan.nextInt();
                    System.out.println("Please enter <Integrity> to Company of the new evaluation record");
                    int integrityToCompany = scan.nextInt();
                    System.out.println("Please enter <Bonus> Part A of the new evaluation record");
                    int bonusA = scan.nextInt();
                    System.out.println("Please enter <Bonus> Part B of the new evaluation record");
                    int bonusB = scan.nextInt();
                    System.out.println("Please enter <Remark> of the new evaluation record");
                    scan.nextLine();
                    String remark = scan.nextLine();
                    manager.addPerformanceRecord(new EvaluationRecord(sid, year, nameProduct, client, clientRanking, soldItems, targetValue, leadershipCompetence, opennessToEmployee, socialBehaviour, attitudeTowardsClient, communicationSkills, integrityToCompany, bonusA, bonusB, remark), sid);
                    break;
                case 3:
                    System.out.println("Please enter the sid of the salesman.");
                    SalesMan salesman = manager.readSalesMan(scan.nextInt());
                    System.out.println(salesman.toString());
                    break;
                case 4:
                    System.out.println("Please enter the sid of the evaluation record");
                    EvaluationRecord record = manager.readEvaluationRecords(scan.nextInt());
                    System.out.println(record.toString());
                    break;
                default:
                    System.out.println("Input was not correct.\nGood Bye");
                    active = false;
                    break;
            }
        }
        scan.close();
    }
}

