package myPackage;

class FotballClub extends SportsClub {

    private int wins, defeats, draws, goalsReceived, goalsScored, points, matchesPlayed;

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getPoints() {

        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsScored() {

        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsReceived() {

        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getDraws() {

        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    FotballClub(String name) {
        super(name);
        matchesPlayed = 0;
        wins = 0;
        draws = 0;
        defeats = 0;
        goalsReceived = 0;
        goalsScored = 0;
        points = 0;
    }


    public void statistics(String headVSstats, int biggestName) { // 17

        final int STATS = 8;  // This is the number of attributes I want to show in the statistics()

        String[] firstLine = {"Name", "Matches played", "Wins", "Draws", "Defeats", "Goals received", "Goals scored", "Points"};
        String[] secondLine = new String[STATS];
        int i = 0, difference, bigger;

        // start Name -- getting it from the SportsClub
        if (biggestName > firstLine[i].length()) bigger = biggestName;
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - this.getName().length()) + this.getName() + addRight(bigger - this.getName().length());
        i++;
        // end Name

        // start Matches played
        String matchesPlayed = Integer.toString(this.getMatchesPlayed());

        if (matchesPlayed.length() > firstLine[i].length()) bigger = matchesPlayed.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - matchesPlayed.length()) + matchesPlayed + addRight(bigger - matchesPlayed.length());
        i++;
        // end Matches played


        // start Wins
        String wins = Integer.toString(this.getWins());

        if (wins.length() > firstLine[i].length()) bigger = wins.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - wins.length()) + wins + addRight(bigger - wins.length());
        i++;
        // end Wins


        // start Draws
        String draws = Integer.toString(this.getDraws());

        if (draws.length() > firstLine[i].length()) bigger = draws.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - draws.length()) + draws + addRight(bigger - draws.length());
        i++;
        // end Draws


        // start Defeats
        String defeats = Integer.toString(this.getDefeats());

        if (defeats.length() > firstLine[i].length()) bigger = defeats.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - defeats.length()) + defeats + addRight(bigger - defeats.length());
        i++;
        // end Defeats


        // start Goals Recieved
        String goalsReceived = Integer.toString(this.getGoalsReceived());

        if (goalsReceived.length() > firstLine[i].length()) bigger = goalsReceived.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - goalsReceived.length()) + goalsReceived + addRight(bigger - goalsReceived.length());
        i++;
        // end Goals Recieved


        // start Goals Scored
        String goalsScored = Integer.toString(this.getGoalsScored());

        if (goalsScored.length() > firstLine[i].length()) bigger = goalsScored.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - goalsScored.length()) + goalsScored + addRight(bigger - goalsScored.length());
        i++;
        // end Goals Scored


        // start Points
        String points = Integer.toString(this.getPoints());

        if (points.length() > firstLine[i].length()) bigger = points.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length()) + "|"; //all as usual + a border to close the table
        secondLine[i] = addLeft(bigger - points.length()) + points + addRight(bigger - points.length()) + "|"; //all as usual + a border to close the table
        i++;
        // end Points


        if (headVSstats == "head") { // sometimes I want to print the head of the table
            for (i = 0; i < STATS; i++) {
                System.out.print(firstLine[i]);
            }

            System.out.println("");
        }

        if (headVSstats == "stats") { // sometimes I want to print the statistics of the team
            for (i = 0; i < STATS; i++) {
                System.out.print(secondLine[i]);
            }
            System.out.println("");
        }
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