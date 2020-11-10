import java.io.IOException;
import java.util.Scanner;

public class Main {
    private final static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    public static int teams=0;
    private static String clubName;
    private static String location;
    private static String foundedYear;
    private static int wins;
    private static int draws;
    private static int defeats;
    private static int noOfGoals;
    private static int scored;
    private static int noOfPoints;
    private static int playedMatches;
    private static String date;


    public static void main(String[] args) throws IOException {
        System.out.println("**************************** Premier League Manager ****************************");
        menu:
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println();      //Main menu
            System.out.println("");
            System.out.println("|----------------------------MENU BAR-------------------------|");
            System.out.println("|'1'- Create new football club                                |");
            System.out.println("|'2'- Delete an existing club                                 |");
            System.out.println("|'3'- Display the various statistics for a selected club      |");
            System.out.println("|'4'- Display the Premier League Table                        |");
            System.out.println("|'5'- Add a played match with its score and its date          |");
            System.out.println("|'6'- Saving in a file of all the information                 |");
            System.out.println("|'Q'- Quit                                                    |");
            System.out.println("|-------------------------------------------------------------|");
            System.out.print("Enter letter: ");
            String option = input.next();
            System.out.println();
            switch (option) {
                case "1":
                    createNewFootBallClub();
                    break;
                case "2":
                    deleteFootballClub();
                    break;
                case "3":
                    premierLeagueManager.displayStatistics(clubName);
                    break;
                case "4":
                    premierLeagueManager.displayLeagueTable();
                    break;
                case "5":
                    addPlayedMatch();
                    break;
                case "6":
                    //premierLeagueManager.saveInformations();
                    break;
                case "Q":
                case "q":
                    break menu;
                default:
                    System.out.println("I'm not sure what you said, please try again");
            }
        }
    }

    private static void createNewFootBallClub() throws IOException{
        if (teams<=19){
            boolean winsBoolean,drawsBoolean,defeatsBoolean,goalsBoolean,scoredBoolean,pointsBoolean,matchesBoolean,nameCheck=false;
            Scanner input = new Scanner(System.in);

            do {
                System.out.print("1. Name of your club : ");
                clubName = input.next();
                if ((clubName != null) && (clubName.matches("^[a-zA-Z]*$"))) {
                    break;
                }
                System.out.println("Invalid input..... please try again");
            } while (!nameCheck);


            do {
                System.out.print("2. Enter your location : ");
                location = input.next();
                if ((location != null) && (location.matches("^[a-zA-Z]*$"))) {
                    break;
                }
                System.out.println("Invalid input..... please try again");
            } while (!nameCheck);

            do {
                System.out.print("3. Enter your founded year : ");
                foundedYear = input.next();
                if ((foundedYear != null) && (foundedYear.matches("^[0-2]|[8-9]|[0-9]|[0-9]*$"))) {
                    break;
                }
                System.out.println("Invalid input..... please try again");
            } while (!nameCheck);

            do {
                try{
                    Scanner input1 = new Scanner(System.in);
                    System.out.print("4. Number of wins you achieved : ");
                    wins = input1.nextInt();
                    winsBoolean = true;
                }catch (RuntimeException e){
                    System.out.println("\t\tPlease enter integer input!\n");
                    winsBoolean = false;
                }
            }while (!winsBoolean);

            do {
                try{
                    Scanner input2 = new Scanner(System.in);
                    System.out.print("5. Number of draws you achieved : ");
                    draws = input2.nextInt();
                    drawsBoolean = true;
                }catch (RuntimeException e){
                    System.out.println("\t\tPlease enter integer input!\n");
                    drawsBoolean = false;
                }
            }while (!drawsBoolean);

            do {
                try{
                    Scanner input3 = new Scanner(System.in);
                    System.out.print("6. Number of defeats you achieved : ");
                    defeats = input3.nextInt();
                    defeatsBoolean = true;
                }catch (RuntimeException e){
                    System.out.println("\t\tPlease enter integer input!\n");
                    defeatsBoolean = false;
                }
            }while (!defeatsBoolean);

            do {
                try{
                    Scanner input4 = new Scanner(System.in);
                    System.out.print("7. Number of goals you received : ");
                    noOfGoals = input4.nextInt();
                    goalsBoolean = true;
                }catch (RuntimeException e){
                    System.out.println("\t\tPlease enter integer input!\n");
                    goalsBoolean = false;
                }
            }while (!goalsBoolean);

            do {
                try{
                    Scanner input5 = new Scanner(System.in);
                    System.out.print("8. Number of scored : ");
                    scored = input5.nextInt();
                    scoredBoolean = true;
                }catch (RuntimeException e){
                    System.out.println("\t\tPlease enter integer input!\n");
                    scoredBoolean = false;
                }
            }while (!scoredBoolean);

            do {
                try{
                    Scanner input6 = new Scanner(System.in);
                    System.out.print("9. Number of points your club currently has : ");
                    noOfPoints = input6.nextInt();
                    pointsBoolean = true;
                }catch (RuntimeException e){
                    System.out.println("\t\tPlease enter integer input!\n");
                    pointsBoolean = false;
                }
            }while (!pointsBoolean);

           do {
                try{
                    Scanner input7 = new Scanner(System.in);
                    System.out.print("10. Number of matches played : ");
                    playedMatches = input7.nextInt();
                    matchesBoolean = true;
                }catch (RuntimeException e){
                    System.out.println("\t\tPlease enter integer input!\n");
                    matchesBoolean = false;
                }
            }while (!matchesBoolean);

            SportClub footballClub = null;
            footballClub = new FootBallClub(clubName,location,foundedYear,wins,draws,defeats,noOfGoals,scored,noOfPoints,playedMatches);
            teams+=1;
            premierLeagueManager.createNewClub(footballClub);

        }else if(teams==20) {
            System.out.println("No free slots are available to register!");
        }
    }

    private static void deleteFootballClub() throws IOException{
        if(teams>=1){
            premierLeagueManager.deleteClub();
            teams-=1;
        }
        else {
            System.out.println("There are no football clubs to delete!");
        }

    }

    private static void addPlayedMatch() throws IOException{
        if (Main.teams >= 1) {
            boolean nameCheck = false,scoredBoolean,dateCheck=false;

            do {
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter the date : ");
                date = input1.next();
                if ((date != null) &&(!date.equals(""))) {
                    break;
                }
                System.out.println("Invalid input..... please try again");
            } while (!dateCheck);

            do {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your club name :");
                clubName = input.next();
                for (SportClub footBallClub : PremierLeagueManager.premierLeague) {
                    if (footBallClub.getClubName().equals(clubName)) {

                        do {
                            try{
                                Scanner input5 = new Scanner(System.in);
                                System.out.print("1. Number of scored : ");
                                scored = input5.nextInt();
                                scoredBoolean = true;
                            }catch (RuntimeException e){
                                System.out.println("\t\tPlease enter integer input!\n");
                                scoredBoolean = false;
                            }
                        }while (!scoredBoolean);

                        nameCheck = true;
                        break;
                    } else {
                        nameCheck = false;
                    }
                }
                if (!nameCheck) {
                    System.out.println("Not found!");
                    nameCheck = false;
                }

            } while (!nameCheck);
        } else {
            System.out.println("There are no football clubs to add scored and date!");
        }
        SportClub footballClub ;

        footballClub = new FootBallClub(clubName,location,foundedYear,wins,draws,defeats,noOfGoals,scored,noOfPoints,playedMatches,date);
        premierLeagueManager.createNewClub(footballClub);

    }

}
