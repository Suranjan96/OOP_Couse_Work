public  class FootBallClub extends SportClub implements Comparable<FootBallClub> {
    private int wins;
    private int draws;
    private int defeats;
    private int noOfGoals;
    private int scored;
    private int noOfPoints;
    private int noOfMatches;
    private int goalDifference;
    private String date;


    public FootBallClub(String clubName,String location, String foundedYear,int wins, int draws, int defeats, int noOfGoals, int scored, int noOfPoints, int noOfMatches,int goalDifferentsString,String date) {
        super(clubName,location,foundedYear);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.noOfGoals = noOfGoals;
        this.scored = scored;
        this.noOfPoints = noOfPoints;
        this.noOfMatches = noOfMatches;
        this.goalDifference = goalDifferentsString;
        this.date = date;
    }


    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getNoOfGoals() {
        return noOfGoals;
    }

    public void setNoOfGoals(int noOfGoals) {
        this.noOfGoals = noOfGoals;
    }

    public  int getScored() {
        return scored;
    }

    public void setScored(int scored) {
        this.scored = scored;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public int getNoOfMatches() {
        return noOfMatches;
    }

    public void setNoOfMatches(int noOfMatches) {
        this.noOfMatches = noOfMatches;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int compareTo(FootBallClub points){           //https://www.javatpoint.com/Comparable-interface-in-collection-framework
        if (noOfPoints>points.noOfPoints){
            return 1;
        }
        else if (getNoOfPoints()==points.getNoOfPoints()){
            if (getGoalDifference()>points.getGoalDifference()){
                return 1;
            }else if (getGoalDifference()>points.getGoalDifference()){
                return 0;
            }else {
                return -1;

            }
        }
        else {
            return -1;
        }
    }



}
