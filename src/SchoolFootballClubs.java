public class SchoolFootballClubs extends FootBallClub {
    private String schoolName;

    public SchoolFootballClubs(String clubName, String location, String foundedYear, int wins, int draws, int defeats, int noOfGoals, int scored, int noOfPoints, int noOfMatches, int goalDifferentsString, String date, String schoolName) {
        super(clubName, location, foundedYear, wins, draws, defeats, noOfGoals, scored, noOfPoints, noOfMatches, goalDifferentsString, date);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
