public class UniversityFootballClub extends FootBallClub {
    private String universityName;

    public UniversityFootballClub(String clubName, String location, String foundedYear, int wins, int draws, int defeats, int noOfGoals, int scored, int noOfPoints, int noOfMatches,String universityName,String date) {
        super(clubName, location, foundedYear, wins, draws, defeats, noOfGoals, scored, noOfPoints, noOfMatches,date);
        this.universityName = universityName;
    }
}
