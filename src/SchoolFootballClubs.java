public class SchoolFootballClubs extends FootBallClub {
    private String schoolName;

    public SchoolFootballClubs(String clubName, String location, String foundedYear, int wins, int draws, int defeats, int noOfGoals, int scored, int noOfPoints, int noOfMatches,String schoolName,String date) {
        super(clubName, location, foundedYear, wins, draws, defeats, noOfGoals, scored, noOfPoints, noOfMatches,date);
        this.schoolName = schoolName;
    }
}
