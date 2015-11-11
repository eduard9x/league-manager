package myPackage;

import java.util.ArrayList;
import java.util.Iterator;


class FotballClub extends SportsClub {

    //todo sould show statistics; wins, loss, draws, goals recive/scored,
    //todo number of points club has
    //todo number of matches played
    //locaions

    String name;
    int wins, defeats, draws, goalsReceived, goalsScored, points, matchesPlayed;
    private final int STATS;  // This is the number of attributes

    FotballClub(String name) {
        this.name = name;
        matchesPlayed = 0;
        wins = 0;
        draws = 0;
        defeats = 0;
        goalsReceived = 0;
        goalsScored = 0;
        points = 0;
        STATS = 8;
    }


    public void statistics2() {
        ArrayList stats = new ArrayList();

        stats.add("Name");
        stats.add("Matches played");
        stats.add("Wins");
        stats.add("Draws");
        stats.add("Defeats");
        stats.add("Goals received");
        stats.add("Goals scored");
        stats.add("Points");


        Iterator it = stats.iterator();
        while (it.hasNext())
            System.out.print(it.next());

        String x = (String) stats.get(0);
        System.out.println(x.length());

    }

    public void statistics3() {

        ArrayList listTest = new ArrayList();
        listTest.add("Name");
        listTest.add(0);

        Iterator it = listTest.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println(listTest.get(0));

    }


    public void statistics(String headVSstats, int biggestName) { // 17

        String[] firstLine = {"Name", "Matches played", "Wins", "Draws", "Defeats", "Goals received", "Goals scored", "Points"};
        String[] secondLine = new String[STATS];
        int i = 0, difference, bigger;


        // start Name
        if (biggestName > firstLine[i].length()) bigger = biggestName;
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - name.length()) + name + addRight(bigger - name.length());
        i++;
        // end Name

        // start Matches played
        String matchesPlayed = Integer.toString(this.matchesPlayed);

        if (matchesPlayed.length() > firstLine[i].length()) bigger = matchesPlayed.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - matchesPlayed.length()) + matchesPlayed + addRight(bigger - matchesPlayed.length());
        i++;
        // end Matches played


        // start Wins
        String wins = Integer.toString(this.wins);

        if (wins.length() > firstLine[i].length()) bigger = wins.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - wins.length()) + wins + addRight(bigger - wins.length());
        i++;
        // end Wins


        // start Draws
        String draws = Integer.toString(this.draws);

        if (draws.length() > firstLine[i].length()) bigger = draws.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - draws.length()) + draws + addRight(bigger - draws.length());
        i++;
        // end Draws


        // start Defeats
        String defeats = Integer.toString(this.draws);

        if (defeats.length() > firstLine[i].length()) bigger = defeats.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - defeats.length()) + defeats + addRight(bigger - defeats.length());
        i++;
        // end Defeats


        // start Goals Recieved
        String goalsReceived = Integer.toString(this.draws);

        if (goalsReceived.length() > firstLine[i].length()) bigger = goalsReceived.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - goalsReceived.length()) + goalsReceived + addRight(bigger - goalsReceived.length());
        i++;
        // end Goals Recieved


        // start Goals Scored
        String goalsScored = Integer.toString(this.draws);

        if (goalsScored.length() > firstLine[i].length()) bigger = goalsScored.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length());
        secondLine[i] = addLeft(bigger - goalsScored.length()) + goalsScored + addRight(bigger - goalsScored.length());
        i++;
        // end Goals Scored


        // start Points
        String points = Integer.toString(this.draws);

        if (points.length() > firstLine[i].length()) bigger = points.length();
        else bigger = firstLine[i].length();

        firstLine[i] = addLeft(bigger - firstLine[i].length()) + firstLine[i] + addRight(bigger - firstLine[i].length()) + "|";
        secondLine[i] = addLeft(bigger - points.length()) + points + addRight(bigger - points.length()) + "|";
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
        String space = "| "; // I want to start with a border
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

    public String getName() {
        return name;
    }


}