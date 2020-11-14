import java.io.*;
import java.util.*;


public class PremierLeagueManager implements LeagueManager {
    public static List<SportClub> premierLeague = new ArrayList<>() ;
    public static List<SportClub> matches1 = new ArrayList<>();
    public static List<SportClub> matches2 = new ArrayList<>();

    @Override
    public void createNewClub(SportClub footBallClub) throws IOException {
        premierLeague.add(footBallClub);
        System.out.println("\nNumber of club registered: "+premierLeague.size());
        System.out.println("Number of free slots : "+(20-premierLeague.size()));

    }

    @Override
    public void deleteClub() {
        if(PremierLeagueManager.premierLeague.size()>=2) {
            premierLeague.sort(Collections.reverseOrder());    //https://stackoverflow.com/questions/61224776/reason-no-instances-of-type-variables-t-exist-so-that-int-conforms-to-t
            premierLeague.remove(premierLeague.size() - 1);    //delete the last object from arraylist

            System.out.println("Last has been successfully deleted!!!");
            System.out.println("\nNumber of club registered: "+premierLeague.size());
            System.out.println("Number of free slots : "+(20-premierLeague.size()));
        }
        else {
            System.out.println("There are no football clubs to delete!");
        }
    }

    @Override
    public void displayStatistics(String clubName) throws IOException {
        if (premierLeague.size() >= 1) {
            boolean nameCheck = false;
            do {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your club name :");      //display the various statistics to the relevant club name
                clubName = input.next();
                for (SportClub footBallClub : premierLeague) {
                    if (footBallClub.getClubName().equalsIgnoreCase(clubName)) {
                        System.out.println("> Founded Year      : " + footBallClub.getFoundedYear());
                        System.out.println("> Location          : " + footBallClub.getLocation());
                        System.out.println("> Number of Matches : " + ((FootBallClub) footBallClub).getNoOfMatches());
                        System.out.println("> Wins              : " + ((FootBallClub) footBallClub).getWins());
                        System.out.println("> Draws             : " + ((FootBallClub) footBallClub).getDraws());
                        System.out.println("> Lost              : " + ((FootBallClub) footBallClub).getDefeats());
                        System.out.println("> Number of Goals   : " + ((FootBallClub) footBallClub).getNoOfGoals());
                        System.out.println("> Scored            : " + ((FootBallClub) footBallClub).getScored());
                        System.out.println("> Goal Difference   : " + ((FootBallClub) footBallClub).getGoalDifference());
                        System.out.println("> Number of Points  : " + ((FootBallClub) footBallClub).getNoOfPoints());
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
        if (premierLeague.size()>=1){
            premierLeague.sort(Collections.reverseOrder());

            String leftAlignFormat = "| %-15s | %-6d |%-4d |%-6d |%-5d |%-5d |%-5d |%-5d |%-6d |%-15s |%n";         //https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
            System.out.format("+-----------------+--------+-----+-------+------+------+------+------+-------+----------------+%n");
            System.out.format("| Club name       | Played | Won | Drawn | Lost |  GF  |  GA  |  GD  |Points | Date           | %n");
            System.out.format("+-----------------+--------+-----+-------+------+------+------+------+-------+----------------+%n");
            for (SportClub footBallClub : premierLeague) {
                System.out.format(leftAlignFormat,footBallClub.getClubName(), ((FootBallClub) footBallClub).getNoOfMatches(),((FootBallClub) footBallClub).getWins(),
                        ((FootBallClub) footBallClub).getDraws(),((FootBallClub) footBallClub).getDefeats(),((FootBallClub) footBallClub).getScored(),
                            ((FootBallClub) footBallClub).getNoOfGoals(),((FootBallClub) footBallClub).getGoalDifference(),((FootBallClub) footBallClub).getNoOfPoints(),((FootBallClub) footBallClub).getDate());
                }
            System.out.format("+-----------------+--------+-----+-------+------+------+------+------+-------+----------------+%n");

            /*for (SportClub footBallClub1 : matches1) {
                System.out.println(((FootBallClub) footBallClub1).getDate());
                System.out.print("\t"+footBallClub1.getClubName()+" - ");
                System.out.print(((FootBallClub) footBallClub1).getScored()+" | ");
                for (SportClub footBallClub2 : matches2){
                    System.out.print(((FootBallClub) footBallClub2).getScored()+" - ");
                    System.out.print(footBallClub2.getClubName());
                    break;
                }
            }*/

        }
        else  {
            System.out.println("There are no football clubs to display Premier League Table!");
        }
    }

    @Override
    public void addPlayedMatch(SportClub football) throws IOException  {

    }

    @Override
    public void saveInformation() {
        try {
            FileOutputStream fileOut = new FileOutputStream("ClubData");                    //https://howtodoinjava.com/java/collections/arraylist/serialize-deserialize-arraylist/#:~:text=In%20Java%2C%20ArrayList%20class%20is,to%20deserialize%20an%20arraylist%20object.
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(premierLeague);                                 //Serialize arraylist of objects
            //out.writeObject(matches1);
            //out.writeObject(matches2);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data has been successfully saved!!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @Override
    public void loadInformation(){
        try {
            FileInputStream fileIn = new FileInputStream("ClubData");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            premierLeague = (ArrayList) in.readObject();                //Deserialize list of objects
            //matches1 = (ArrayList) in.readObject();
            //matches2 = (ArrayList) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data has been successfully loaded!\n");
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Data not found");
            c.printStackTrace();
            return;
        }
    }


}
