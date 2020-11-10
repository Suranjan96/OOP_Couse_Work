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
        System.out.println("\nNumber of club registered: "+Main.teams);
        System.out.println("Number of free slots : "+(20-Main.teams));
        /*for (SportClub footBallClub : premierLeague) {
            if (footBallClub instanceof FootBallClub) {
                System.out.println(((FootBallClub) footBallClub).getNoOfPoints());
                System.out.println(((FootBallClub) footBallClub).getNoOfMatches());

            }
        }*/
    }

    @Override
    public void displayStatistics(String clubName) {
        if (Main.teams >= 1) {
            boolean nameCheck = false;
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your club name :");
                clubName = input.next();
                for (SportClub footBallClub : premierLeague) {
                    if (footBallClub.getClubName().equals(clubName)) {
                        System.out.println("Founded Year      : " + ((FootBallClub) footBallClub).getFoundedYear());
                        System.out.println("Location          : " + ((FootBallClub) footBallClub).getLocation());
                        System.out.println("Wins              : " + ((FootBallClub) footBallClub).getWins());
                        System.out.println("Draws             : " + ((FootBallClub) footBallClub).getDraws());
                        System.out.println("Defeats           : " + ((FootBallClub) footBallClub).getDefeats());
                        System.out.println("Number of Goals   : " + ((FootBallClub) footBallClub).getNoOfGoals());
                        System.out.println("Scored            : " + ((FootBallClub) footBallClub).getScored());
                        System.out.println("Number of Points  : " + ((FootBallClub) footBallClub).getNoOfPoints());
                        System.out.println("Number of Matches : " + ((FootBallClub) footBallClub).getNoOfMatches());
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
            System.out.println("There are no football clubs to display some statistics!");
        }
    }

    @Override
    public void displayLeagueTable() {
        if (Main.teams>=1){
            Collections.sort(premierLeague,Collections.reverseOrder());
            System.out.println("Club Name\t\tWins\t\tDraws\t\tDefeats\t\tGoals\t\tScored\t\tPoints\t\tMatches\t\tDate");
            for (SportClub footBallClub : premierLeague) {
                System.out.println();
                System.out.print(((FootBallClub) footBallClub).getClubName());
                System.out.print("\t\t\t\t"+((FootBallClub) footBallClub).getWins()+"\t\t\t\t");
                System.out.print(((FootBallClub) footBallClub).getDraws()+"\t\t\t\t");
                System.out.print(((FootBallClub) footBallClub).getDefeats()+"\t\t\t\t");
                System.out.print(((FootBallClub) footBallClub).getNoOfGoals()+"\t\t\t\t");
                System.out.print(((FootBallClub) footBallClub).getScored()+"\t\t\t\t");
                System.out.print(((FootBallClub) footBallClub).getNoOfPoints()+"\t\t\t\t");
                System.out.print(((FootBallClub) footBallClub).getNoOfMatches()+"\t\t\t\t");
                System.out.print(((FootBallClub) footBallClub).getDate());
                System.out.println();
            }
        }
        else  {
            System.out.println("There are no football clubs to display Premier League Table!");
        }
    }

    @Override
    public void addPlayedMatch(SportClub football)  {
        premierLeague.add(football);

    }

    @Override
    public void saveInformations(String name,String location, String foundedYear,String wins) {
        //SportClub footballClub = new SportClub(name,location,foundedYear);
    }

}
