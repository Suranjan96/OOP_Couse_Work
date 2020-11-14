import java.io.Serializable;

public class SportClub implements Serializable {
    private String clubName;
    private String location;
    private String foundedYear;

    public SportClub(String clubName, String location, String foundedYear) {
        this.clubName = clubName;
        this.location = location;
        this.foundedYear = foundedYear;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(String foundedYear) {
        this.foundedYear = foundedYear;
    }

    public static boolean clubChecker(String clubName){      //duplicate club names checking
        if((clubName!=null) && clubName.matches("^[a-zA-Z]*$")){
            for (SportClub name : PremierLeagueManager.premierLeague){
                if (name.getClubName().equalsIgnoreCase(clubName)){
                    System.out.println("Duplicate club name!!");
                    return false;
                }
            }
            return true;
        }
        else {
            System.out.println("Invalid input..... please try again");
            return false;
        }
    }
}
