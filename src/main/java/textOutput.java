public class textOutput {

    //Welcome text
    public static void welcome() {
        System.out.println("Welcome to the ManagePersonal App\n" +
                "--------------------------------------------------------------------------------------");
    }
    //Menu Layout
    public static void menu() {
        System.out.println("\nPlease choose one action you would like to execute by typing in one of the numbers:\n" +
                "(0) Exit the ManagePersonal App\n" +
                "(1) Create a new Salesman\n" +
                "(2) Add a performance record to a salesman\n" +
                "(3) Read the general Information of a salesman\n" +
                "(4) Read the evaluation records of a salesman\n" +
                "(5) Delete a SalesMan\n" +
                "(6) Delete a Evaluation Record\n" +
                "(7) Update the data of a Salesman\n" +
                "(8) Update the data of a evaluation record\n");
    }
    //Thank you text
    public static void thankYou() {
        System.out.println("Thank you for choosing ManagePersonal App\nGood Bye");
    }
}
