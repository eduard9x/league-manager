package myPackage;

class FotballClub extends SportsClub {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private String wins, defeats, draws, goalsReceived, goalsScored, points, matchesPlayed, colour;

    public String getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = Integer.toString(Integer.parseInt(this.wins) + wins);
    }

    public String getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = Integer.toString(Integer.parseInt(this.defeats) + defeats);
    }

    public String getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = Integer.toString(Integer.parseInt(this.matchesPlayed) + matchesPlayed);
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = Integer.toString(Integer.parseInt(this.points) + points);
    }

    public String getGoalsScored() {

        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = Integer.toString(Integer.parseInt(this.goalsScored) + goalsScored);
    }

    public String getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = Integer.toString(Integer.parseInt(this.goalsReceived) + goalsReceived);
    }

    public String getDraws() {

        return draws;
    }

    public void setDraws(int draws) {
        this.draws = Integer.toString(Integer.parseInt(this.draws) + draws);
    }

    FotballClub(String name) {

        super(name); // use the constructor in SportsClub

        if(name=="Name"){ // this is the head of the Premier League Table
            matchesPlayed = "Matches played";
            wins = "Wins";
            draws = "Draws";
            defeats = "Defeats";
            goalsReceived = "Goals received";
            goalsScored = "Goals scored";
            points = "Points";
            colour = ANSI_BLUE;
        }
        else {
            matchesPlayed = "0";
            wins = "0";
            draws = "0";
            defeats = "0";
            goalsReceived = "0";
            goalsScored = "0";
            points = "0";
            colour=ANSI_BLACK;
        }

    }

    public void statistics(int[] biggestField) {

        String[] secondLine = {getName(), matchesPlayed, wins, draws, defeats, goalsReceived, goalsScored, points};
        int i, bigger;

        for (i = 0; i < secondLine.length; i++) {
            if (biggestField[i] > secondLine[i].length()) bigger = biggestField[i];
            else bigger = secondLine[i].length();

            secondLine[i] = addLeft(bigger - secondLine[i].length()) + secondLine[i] + addRight(bigger - secondLine[i].length());
        }

        for (i = 0; i < secondLine.length; i++) {
            System.out.print(this.colour+ secondLine[i] + ANSI_RESET);
        }
        System.out.print(this.colour+ "|\n" + ANSI_RESET);
    }

    public String addLeft(int difference) { //I use the difference between strings to center the text
        String space = "| "; // I want to start with a border and a space
        if (difference % 2 == 0) // even number eg. 6
            for (int i = 0; i < difference / 2; i++)
                space = space + " "; // 3
        else //odd number eg. 7
            for (int i = 0; i < difference / 2; i++) //3
                space = space + " ";
        return space;
    }

    public String addRight(int difference) {//I use the difference between strings to center the text
        String space = " "; // I want to finish with space
        if (difference % 2 == 0) // even number eg. 6
            for (int i = 0; i < difference / 2; i++)
                space = space + " "; // 3
        else //odd number eg. 7
            for (int i = 0; i <= difference / 2; i++) //4
                space = space + " ";
        return space;
    }

}