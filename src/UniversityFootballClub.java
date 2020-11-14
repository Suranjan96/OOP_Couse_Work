public class UniversityFootballClub extends FootBallClub {
    private String universityName;

    public UniversityFootballClub(String clubName, String location, String foundedYear, int wins, int draws, int defeats, int noOfGoals, int scored, int noOfPoints, int noOfMatches, int goalDifference, String date, String universityName) {
        super(clubName, location, foundedYear, wins, draws, defeats, noOfGoals, scored, noOfPoints, noOfMatches, goalDifference, date);
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
