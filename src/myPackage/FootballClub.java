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
        while(it.hasNext())
            System.out.print(it.next());

        String x = (String) stats.get(0);
        System.out.println(x.length());

    }

    public void statistics3() {

        ArrayList listTest = new ArrayList();
        listTest.add("Name");
        listTest.add(0);

        Iterator it = listTest.iterator();
        while(it.hasNext())
            System.out.println(it.next());

        System.out.println(listTest.get(0));

    }


    public void statistics() {

        String[] firstLine = {"Name", "Matches played", "Wins", "Draws", "Defeats", "Goals received", "Goals scored", "Points"};
        String[] secondLine = new String[STATS];
        int i = 0;

        // Name
        int difference = name.length() - firstLine[i].length(); //I use the difference between strings to center the text
        if (name.length() > firstLine[i].length()) {
            firstLine[i] = addLeft(difference) + firstLine[i] + addRight(difference);
            secondLine[i] = "| " + name + " ";
        } else {
            firstLine[i] = "| " + firstLine[i] + " ";
            secondLine[i] = addLeft(difference) + name + addRight(difference);
        }
        i++;


        // Matches played
        String matchesPlayed = Integer.toString(this.matchesPlayed);
        difference = matchesPlayed.length() - firstLine[i].length(); //I use the difference between strings to center the text
        if (matchesPlayed.length() > firstLine[i].length()) {
            firstLine[i] = addLeft(difference) + firstLine[i] + addRight(difference);
            secondLine[i] = "| " + matchesPlayed + " ";
        } else {
            firstLine[i] = "| " + firstLine[i] + " ";
            secondLine[i] = addLeft(-difference) + matchesPlayed + addRight(-difference);
        }
        i++;

        // Wins
        String wins = Integer.toString(this.wins);
        difference = wins.length() - firstLine[i].length(); //I use the difference between strings to center the text
        if (wins.length() > firstLine[i].length()) {
            firstLine[i] = addLeft(difference) + firstLine[i] + addRight(difference);
            secondLine[i] = "| " + wins + " ";
        } else {
            firstLine[i] = "| " + firstLine[i] + " ";
            secondLine[i] = addLeft(-difference) + wins + addRight(-difference);
        }
        i++;

        // Draws
        String draws = Integer.toString(this.draws);
        difference = draws.length() - firstLine[i].length(); //I use the difference between strings to center the text
        if (draws.length() > firstLine[i].length()) {
            firstLine[i] = addLeft(difference) + firstLine[i] + addRight(difference);
            secondLine[i] = "| " + draws + " ";
        } else {
            firstLine[i] = "| " + firstLine[i] + " ";
            secondLine[i] = addLeft(-difference) + draws + addRight(-difference);
        }
        i++;

        // Defeats
        String defeats = Integer.toString(this.defeats);
        difference = defeats.length() - firstLine[i].length(); //I use the difference between strings to center the text
        if (defeats.length() > firstLine[i].length()) {
            firstLine[i] = addLeft(difference) + firstLine[i] + addRight(difference);
            secondLine[i] = "| " + defeats + " ";
        } else {
            firstLine[i] = "| " + firstLine[i] + " ";
            secondLine[i] = addLeft(-difference) + defeats + addRight(-difference);
        }
        i++;

        // Goals Recieved
        String goalsReceived = Integer.toString(this.goalsReceived);
        difference = goalsReceived.length() - firstLine[i].length(); //I use the difference between strings to center the text
        if (goalsReceived.length() > firstLine[i].length()) {
            firstLine[i] = addLeft(difference) + firstLine[i] + addRight(difference);
            secondLine[i] = "| " + goalsReceived + " ";
        } else {
            firstLine[i] = "| " + firstLine[i] + " ";
            secondLine[i] = addLeft(-difference) + goalsReceived + addRight(-difference);
        }
        i++;

        // Goals Scored
        String goalsScored = Integer.toString(this.goalsScored);
        difference = goalsScored.length() - firstLine[i].length(); //I use the difference between strings to center the text
        if (goalsScored.length() > firstLine[i].length()) {
            firstLine[i] = addLeft(difference) + firstLine[i] + addRight(difference);
            secondLine[i] = "| " + goalsScored + " ";
        } else {
            firstLine[i] = "| " + firstLine[i] + " ";
            secondLine[i] = addLeft(-difference) + goalsScored + addRight(-difference);
        }
        i++;

        // Points
        String points = Integer.toString(this.points);
        difference = points.length() - firstLine[i].length(); //I use the difference between strings to center the text
        if (points.length() > firstLine[i].length()) {
            firstLine[i] = addLeft(difference) + firstLine[i] + addRight(difference) + "|";
            secondLine[i] = "| " + points + " |";
        } else {
            firstLine[i] = "| " + firstLine[i] + " |";
            secondLine[i] = addLeft(-difference) + points + addRight(-difference) + "|";
        }



            for (i = 0; i < STATS; i++) {
                System.out.print(firstLine[i]);
            }

            System.out.println("");


        for (i = 0; i < STATS; i++) {
            System.out.print(secondLine[i]);
        }
        System.out.println("");

    }


    public String addLeft(int difference) { //I use the difference between strings to center the text
        String space = "| "; // I want to start with a border
        if (difference % 2 == 0) // even number eg. 6
            for (int i = 0; i < difference / 2; i++)
                space = space + " "; // 3
        else //odd number eg. 7
            for (int i = 0; i < difference / 2; i++)
                space = space + " "; //3

        return space;
    }

    public String addRight(int difference) {//I use the difference between strings to center the text
        String space = " "; // I want to finish with space
        if (difference % 2 == 0) // even number eg. 6
            for (int i = 0; i < difference / 2; i++)
                space = space + " "; // 3
        else //odd number eg. 7
            for (int i = 0; i <= difference / 2; i++)
                space = space + " "; //4

        return space;
    }


}