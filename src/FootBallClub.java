public  class FootBallClub extends SportClub implements Comparable<FootBallClub>{
    private int wins;
    private int draws;
    private int defeats;
    private int noOfGoals;
    private int scored;
    private int noOfPoints;
    private int noOfMatches;


    public FootBallClub(String clubName,String location, String foundedYear,int wins, int draws, int defeats, int noOfGoals, int scored, int noOfPoints, int noOfMatches) {
        super(clubName,location,foundedYear);
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
        this.noOfGoals = noOfGoals;
        this.scored = scored;
        this.noOfPoints = noOfPoints;
        this.noOfMatches = noOfMatches;
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

    public int getScored() {
        return scored;
    }

    public void setScored(int scored) {
        this.scored = scored;
    }//

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

    public int compareTo(FootBallClub points){           //https://www.javatpoint.com/Comparable-interface-in-collection-framework
      //return (this.noOfPoints-points.noOfPoints);
        if (noOfPoints==points.noOfPoints){
            return 0;
        }else if (noOfPoints>points.noOfPoints){
            return 1;
        }else {
            return -1;
        }
    }
}
