import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {
    public static List<SportClub> premierLeague = new ArrayList<>() ;

    @Override
    public void createNewClub(SportClub footBallClub) throws IOException {
        premierLeague.add(footBallClub);
        System.out.println("\nNumber of club registered: "+Main.teams);
        System.out.println("Number of free slots : "+(20-Main.teams));

    }

    @Override
    public void deleteClub() {
        Collections.sort(premierLeague,Collections.reverseOrder());    //https://stackoverflow.com/questions/61224776/reason-no-instances-of-type-variables-t-exist-so-that-int-conforms-to-t
        premierLeague.remove(premierLeague.size()-1);

        System.out.println("Last has been successfully deleted!!!");
        Main.teams=-1;
        System.out.println("\nNumber of club registered: "+Main.teams);
        System.out.println("Number of free slots : "+(20-Main.teams));
    }

    @Override
    public void displayStatistics(String clubName) throws IOException {
        if (Main.teams >= 1&& (Main.playedMatches1>0 || Main.playedMatches2>0)) {
            boolean nameCheck = false;
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your club name :");
                clubName = input.next();
                for (SportClub footBallClub : premierLeague) {
                    if (footBallClub.getClubName().equals(clubName)) {
                        System.out.println("> Founded Year      : " + footBallClub.getFoundedYear());
                        System.out.println("> Location          : " + footBallClub.getLocation());
                        System.out.println("> Wins              : " + ((FootBallClub) footBallClub).getWins());
                        System.out.println("> Draws             : " + ((FootBallClub) footBallClub).getDraws());
                        System.out.println("> Defeats           : " + ((FootBallClub) footBallClub).getDefeats());
                        System.out.println("> Number of Goals   : " + ((FootBallClub) footBallClub).getNoOfGoals());
                        System.out.println("> Scored            : " + ((FootBallClub) footBallClub).getScored());
                        System.out.println("> Number of Points  : " + ((FootBallClub) footBallClub).getNoOfPoints());
                        System.out.println("> Number of Matches : " + ((FootBallClub) footBallClub).getNoOfMatches());
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
            System.out.println("There are no statistics to display!");
        }
    }

    @Override
    public void displayLeagueTable() {
        if (Main.teams>=1){
            Collections.sort(premierLeague,Collections.reverseOrder());
            String leftAlignFormat = "| %-15s | %-6d |%-4d |%-6d |%-5d |%-5d |%-5d |%-7d |%-15s |%n";
            System.out.format("+-----------------+--------+-----+-------+------+------+------+--------+----------------+%n");
            System.out.format("| Club name       | Played | Won | Drawn | Lost |  GF  |  GA  | Points | Date           | %n");
            System.out.format("+-----------------+--------+-----+-------+------+------+------+--------+----------------+%n");
            for (SportClub footBallClub : premierLeague) {
                System.out.format(leftAlignFormat,footBallClub.getClubName(), ((FootBallClub) footBallClub).getNoOfMatches(),((FootBallClub) footBallClub).getWins(),
                        ((FootBallClub) footBallClub).getDraws(),((FootBallClub) footBallClub).getDefeats(),((FootBallClub) footBallClub).getScored(),
                            ((FootBallClub) footBallClub).getNoOfGoals(),((FootBallClub) footBallClub).getNoOfPoints(),((FootBallClub) footBallClub).getDate());
                }
            System.out.format("+-----------------+--------+-----+-------+------+------+------+--------+----------------+%n");
        }
        else  {
            System.out.println("There are no football clubs to display Premier League Table!");
        }
    }

    @Override
    public void addPlayedMatch(SportClub football) throws IOException  {}

    @Override
    public void saveInformation() {

    }

}
