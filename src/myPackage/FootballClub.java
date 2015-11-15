package myPackage;

class FotballClub extends SportsClub {

    private String wins, defeats, draws, goalsReceived, goalsScored, points, matchesPlayed;

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDefeats() {
        return defeats;
    }

    public void setDefeats(String defeats) {
        this.defeats = defeats;
    }

    public String getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(String matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getGoalsScored() {

        return goalsScored;
    }

    public void setGoalsScored(String goalsScored) {
        this.goalsScored = goalsScored;
    }

    public String getGoalsReceived() {

        return goalsReceived;
    }

    public void setGoalsReceived(String goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public String getDraws() {

        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
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
        }
        else {
            matchesPlayed = "1";
            wins = "2";
            draws = "3";
            defeats = "4";
            goalsReceived = "5";
            goalsScored = "6";
            points = "7";
        }

    }

//todo make biggest name an array that holds the longest words in each column
    public void statistics(int[] biggestField) { // 17

        String[] firstLine = {"Name", "Matches played", "Wins", "Draws", "Defeats", "Goals received", "Goals scored", "Points"};
        String[] secondLine = {getName(), matchesPlayed, wins, draws, defeats, goalsReceived, goalsScored, points};
        int i, bigger;

        for (i = 0; i < firstLine.length; i++) {
            //todo create a function that compares every cell on columns and returns the largest
            //todo use that function to make the table responsive

            if (biggestField[i] > firstLine[i].length()) bigger = biggestField[i];
            else if (secondLine[i].length() > firstLine[i].length()) bigger = secondLine[i].length();
            else bigger = firstLine[i].length();

            firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
            secondLine[i] = addLeft(bigger - secondLine[i].length()) + secondLine[i] + addRight(bigger - secondLine[i].length());
        }

        for (i = 0; i < firstLine.length; i++) {
            System.out.print(secondLine[i]);
        }
        System.out.print("|\n");
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