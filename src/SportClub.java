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


}
