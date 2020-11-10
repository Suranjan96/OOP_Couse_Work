import java.io.IOException;

public interface LeagueManager {
    void createNewClub(SportClub footBallClub) throws IOException;
    void deleteClub();
    void displayStatistics(String clubName);
    void displayLeagueTable();
    void addPlayedMatch(SportClub football);
    void saveInformations(String name,String location, String foundedYear,String wins);
}
