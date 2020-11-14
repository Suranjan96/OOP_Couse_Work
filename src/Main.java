import java.io.IOException;
import java.util.Scanner;

public class Main {
    private final static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    public static int teams=0;
    private static String clubName1;
    private static String clubName2;
    private static String location;
    private static String foundedYear;
    private static int wins1=0;
    private static int wins2=0;
    private static int draws1=0;
    private static int draws2=0;
    private static int defeats1=0;
    private static int defeats2=0;
    private static int noOfGoals1=0;
    private static int noOfGoals2=0;
    private static int scored1=0;
    private static int scored2=0;
    private static int noOfPoints1=0;
    private static int noOfPoints2=0;
    public static int playedMatches1=0;
    public static int playedMatches2=0;
    private static int team1Scored=0;
    private static int team2Scored=0;
    private static int playedMatches=-1;
    private static int goalDifference1 =0;
    private static int goalDifference2 =0;
    private static String date="-";



    public static void main(String[] args) throws IOException {
        premierLeagueManager.loadInformation();
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
                    premierLeagueManager.displayStatistics(clubName1);
                    break;
                case "4":
                    premierLeagueManager.displayLeagueTable();
                    break;
                case "5":
                    addPlayedMatch();
                    break;
                case "6":
                    premierLeagueManager.saveInformation();
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
            boolean nameCheck=false;
            Scanner input = new Scanner(System.in);

            do {
                System.out.print("1. Name of your club : ");
                clubName1 = input.next();
                if ((clubName1 != null) && (clubName1.matches("^[a-zA-Z]*$"))) {
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


            SportClub footballClub = new FootBallClub(clubName1,location,foundedYear,0,0,0,0,0,0,0,0,"-");
            //footballClub = new FootBallClub(clubName,location,foundedYear,wins,draws,defeats,noOfGoals,scored,noOfPoints,playedMatches,date);
            teams+=1;
            premierLeagueManager.createNewClub(footballClub);

        }else if(teams==20) {
            System.out.println("No free slots are available to register!");
        }
    }

    private static void deleteFootballClub() throws IOException{
        if(PremierLeagueManager.premierLeague.size()>=2){
            premierLeagueManager.deleteClub();
            teams-=1;
        }
        else {
            System.out.println("There are no football clubs to delete!");
        }

    }

    private static void addPlayedMatch() throws IOException{
        if (PremierLeagueManager.premierLeague.size() >= 2) {
            boolean nameCheck = false,scoredBoolean,dateCheck=false;
            playedMatches++;
            do {
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter the date : ");
                date = input1.next();
                if ((date != null) &&(!date.equals(""))) {
                    break;
                }
                System.out.println("Invalid input..... please try again");
            } while (!dateCheck);

            int a,b;
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("1. Enter your club name :");
                clubName1 = input.next();
                 a = 0;
                for (SportClub footBallClub : PremierLeagueManager.premierLeague) {
                    if (footBallClub.getClubName().equals(clubName1)) {
                        do {
                            try {
                                Scanner input5 = new Scanner(System.in);
                                System.out.print(">> Number of scored : ");
                                team1Scored = input5.nextInt();
                                System.out.println();
                                scoredBoolean = true;
                            } catch (RuntimeException e) {
                                System.out.println("\t\tPlease enter integer input!\n");
                                scoredBoolean = false;
                            }
                        } while (!scoredBoolean);
                        nameCheck = true;
                        break;
                    } else {
                        nameCheck = false;
                    }
                    a++;
                }
                if (!nameCheck) {
                    System.out.println("Not found!");
                    nameCheck = false;
                }
            } while (!nameCheck);

            do {
                Scanner input = new Scanner(System.in);
                System.out.print("2. Enter your club name :");
                clubName2 = input.next();
                b=0;
                for (SportClub footBallClub : PremierLeagueManager.premierLeague) {
                    if (footBallClub.getClubName().equals(clubName2)) {
                        do {
                            try {
                                Scanner input5 = new Scanner(System.in);
                                System.out.print(">> Number of scored : ");
                                team2Scored = input5.nextInt();
                                System.out.println();
                                scoredBoolean = true;
                            } catch (RuntimeException e) {
                                System.out.println("\t\tPlease enter integer input!\n");
                                scoredBoolean = false;
                            }
                        } while (!scoredBoolean);
                        nameCheck = true;
                        break;
                    } else {
                        nameCheck = false;
                    }
                    b++;
                }
                if (!nameCheck) {
                    System.out.println("Not found!");
                    nameCheck = false;
                }
            } while (!nameCheck);

            for (SportClub footBallClub : PremierLeagueManager.premierLeague) {
                if ((footBallClub.getClubName().equals(clubName1))) {
                    if (team1Scored > team2Scored) {
                        wins1 = ((FootBallClub) footBallClub).getWins()+1;
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints()+3;
                    }
                    else if (team2Scored > team1Scored) {
                        defeats1 = ((FootBallClub) footBallClub).getDefeats()+1;
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints();
                    }
                    else if (team1Scored == team2Scored) {
                        draws1 = ((FootBallClub) footBallClub).getDraws()+1;
                        noOfPoints1 = ((FootBallClub) footBallClub).getNoOfPoints()+1;
                    }
                    noOfGoals1 = ((FootBallClub) footBallClub).getNoOfGoals()+team2Scored;
                    scored1 = ((FootBallClub) footBallClub).getScored()+team1Scored;
                    playedMatches1=((FootBallClub) footBallClub).getNoOfMatches()+1;
                    goalDifference1 =scored1-noOfGoals1;

                }else if ((footBallClub.getClubName().equals(clubName2))){
                    if (team2Scored > team1Scored) {
                        wins2 = ((FootBallClub) footBallClub).getWins()+1;
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints()+3;
                    }
                    else if (team1Scored > team2Scored) {
                        defeats2 = ((FootBallClub) footBallClub).getDefeats()+1;
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints();
                    }
                    else if (team1Scored == team2Scored) {
                        draws2 = ((FootBallClub) footBallClub).getDraws()+1;
                        noOfPoints2 = ((FootBallClub) footBallClub).getNoOfPoints()+1;
                    }
                    noOfGoals2 = ((FootBallClub) footBallClub).getNoOfGoals()+team1Scored;
                    scored2 = ((FootBallClub) footBallClub).getScored()+team2Scored;
                    playedMatches2=((FootBallClub) footBallClub).getNoOfMatches()+1;
                    goalDifference2 =scored2-noOfGoals2;
                }
            }
            SportClub footballClub1 = new FootBallClub(clubName1,location,foundedYear,wins1,draws1,defeats1,noOfGoals1,scored1,noOfPoints1,playedMatches1, goalDifference1,date);
            SportClub footballClub2 = new FootBallClub(clubName2,location,foundedYear,wins2,draws2,defeats2,noOfGoals2,scored2,noOfPoints2,playedMatches2, goalDifference2,date);
            PremierLeagueManager.premierLeague.set(a,footballClub1);
            PremierLeagueManager.premierLeague.set(b,footballClub2);

            SportClub playedMatch1 = new FootBallClub(clubName1,"","",0,0,0,0,scored1,0,0,0,date);
            SportClub playedMatch2 = new FootBallClub(clubName2,"","",0,0,0,0,scored2,0,0,0,date);
            PremierLeagueManager.matches1.add(playedMatches,playedMatch1);
            PremierLeagueManager.matches2.add(playedMatches,playedMatch2);

        } else {
            System.out.println("There are no two football clubs to add scored and date!");
        }
    }
}