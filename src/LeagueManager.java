import java.io.IOException;

public interface LeagueManager {
    void createNewClub(SportClub footBallClub) throws IOException;
    void deleteClub();
    void displayStatistics(String clubName);
    void displayLeagueTable();
    void addPlayedMatch();
    void saveInformations();
}
