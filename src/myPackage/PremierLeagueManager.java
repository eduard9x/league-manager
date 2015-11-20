package myPackage;

import java.util.*;

class PremierLeagueManager implements LeagueManager {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String DAYS[] = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
    public static final String MONTHS[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static final int[] MONTHS_LENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    ArrayList<FotballClub> stats = new ArrayList();
    ArrayList<calendarOfMatches> matchCalendar = new ArrayList();
    FotballClub MyClub;

    public void CreateClub(String name) {
        MyClub = new FotballClub(name);
        stats.add(MyClub);

//        if(stats.size()>1) //hide the first line -- table header
//        System.out.println(ANSI_PURPLE + name + " -- football club created." + ANSI_RESET);
    }

    public void DeleteClub(String name) {
        //making sure no one can delete the first line
        // making sure the club name is valid
        if (find(name) != 0 && find(name) != -1) {
            System.out.println("\n" + ANSI_GREEN + name + " - was deleted " + ANSI_RESET + "\n");
            stats.remove(find(name));
        } else System.out.println("\n" + ANSI_RED + name + " - is not a valid name " + ANSI_RESET + "\n");
    }

    public void stats(int which) {
//The full display of Premier League table is good, however when you display 1 line, it might have too much space in the Name field

//        stats.get(1).variousStatistics();

        int i;
        int[] biggestField = {stats.get(0).getName().length(), stats.get(0).getMatchesPlayed().length(), stats.get(0).getWins().length(), stats.get(0).getDraws().length(), stats.get(0).getDefeats().length(), stats.get(0).getGoalsReceived().length(), stats.get(0).getGoalsScored().length(), stats.get(0).getPoints().length()};

        for (i = 1; i < stats.size(); i++)
            for (int j = 0; j < biggestField.length; j++) {
                int[] biggestField2 = {stats.get(i).getName().length(), stats.get(i).getMatchesPlayed().length(), stats.get(i).getWins().length(), stats.get(i).getDraws().length(), stats.get(i).getDefeats().length(), stats.get(i).getGoalsReceived().length(), stats.get(i).getGoalsScored().length(), stats.get(i).getPoints().length()};
                if (biggestField[j] < biggestField2[j]) biggestField[j] = biggestField2[j];
            }

        //this will create my Premier League table
        for (i = 0; i < stats.size(); i++)
            if(i==which || i==0 || which == -1) //only for head of table and the searched team
            stats.get(i).statistics(biggestField);
    }

    public void calendar() {

        int year = 2015;
        int month = 10; // months 0-11 --> Jan-Dec
        int selectedDay = 13;
        String colour;
        //todo add validation to this and to whatever else you input from keyboard

        int dayOfWeek, i;

        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) MONTHS_LENGTH[1] = 29; //is it leap year?

        Calendar myCalendar = new GregorianCalendar(year, month, 1); // create a calendar entry on the 1st of our monts & year

        dayOfWeek = myCalendar.get(Calendar.DAY_OF_WEEK); //find the name of that day -- will return 1 for Sunday

        //the use of colours
        System.out.println("Use of colours:\n  >> Past day - " + ANSI_BLUE + "blue" + ANSI_RESET + "\n  >> Future day - " + ANSI_PURPLE + "purple" + ANSI_RESET + " \n");

        //printing the selected month and year
        System.out.println("    " + MONTHS[month] + "  " + year);

        //printing head of calendar
        for (i = 0; i < DAYS.length; i++)
            System.out.print(DAYS[i] + "  ");
        System.out.println();

        //getting before the day our month is starting
        for (i = 1; i < dayOfWeek; i++)
            System.out.print("    ");

        //get the present date
        myCalendar.clear();
        int thisYear = myCalendar.getInstance().get(myCalendar.YEAR);
        int thisMonth = myCalendar.getInstance().get(myCalendar.MONTH);
        int thisDay = myCalendar.getInstance().get(myCalendar.DAY_OF_MONTH);
//        System.out.println( "\n" + thisDay + "-" + months[thisMonth] + "-" + thisYear);

        //start printing days of the month
        for (i = 0; i < MONTHS_LENGTH[month]; i++) { //I used that 9 - to addi an extra space for digits less than 10
            if ((year < thisYear) || (year == thisYear && month < thisMonth) || (year == thisYear && month == thisMonth && i < thisDay)) colour = ANSI_BLUE; //past day
            else colour = ANSI_PURPLE; //future day

            if (i < 9)
                System.out.print(colour + (i + 1) + "   " + ANSI_RESET); //will have blue colour for past and red for future
            else System.out.print(colour + (i + 1) + "  " + ANSI_RESET);
            if ((i + dayOfWeek) % 7 == 0) System.out.println();
        }

        for(i=0;i<matchCalendar.size();i++)
        if(matchCalendar.get(i).getDate().equals(Integer.toString(selectedDay)+" "+MONTHS[month]+" "+Integer.toString(year)))
            System.out.println("\n" + matchCalendar.get(i).getDate() + ": " + matchCalendar.get(i).getStats());
        //todo change this to a general structure
        //todo see if it should be good to colour every date that has matches instead of a random table like that.
        //todo or maybe green the matches somehow.
    }

    public int find(String name) {

        for (int i = 0; i < stats.size(); i++)
            if (stats.get(i).getName().equals(name)) return i;

        return -1;
    }

    public void addMatch(String homeClub, String awayClub, String[] date) {

        int home = find(homeClub);
        int away = find(awayClub);

        int randomHome = (int) Math.floor(4 * Math.random());
        int randomAway = (int) Math.floor(3 * Math.random());

        if (randomHome >= randomAway) {
            addStats(home, away, randomHome, randomAway);
        } else {
            addStats(away, home, randomAway, randomHome);
        }

//        System.out.println(homeClub + " " + randomHome + " - " + randomAway + " " + awayClub);


        //todo add to match calendar
        calendarOfMatches myListOfMatches = new calendarOfMatches(homeClub + " " + randomHome + " - " + randomAway + " " + awayClub);
        myListOfMatches.setDate(date);
        matchCalendar.add(myListOfMatches);
    }

    public void addStats(int win, int lose, int scoreWin, int scoreLose) {

        //winning part
        stats.get(win).setMatchesPlayed(1);
        stats.get(win).setWins(1);
        stats.get(win).setGoalsReceived(scoreLose);
        stats.get(win).setGoalsScored(scoreWin);
        if (scoreWin > scoreLose) stats.get(win).setPoints(3);

        //losing part
        stats.get(lose).setMatchesPlayed(1);
        stats.get(lose).setDefeats(1);
        stats.get(lose).setGoalsReceived(scoreWin);
        stats.get(lose).setGoalsScored(scoreLose);

        //add one point to each for draw
        if (scoreWin == scoreLose) {
            stats.get(win).setPoints(1);
            stats.get(win).setDraws(1);
            stats.get(lose).setPoints(1);
            stats.get(lose).setDraws(1);
        }
    }

    public void doMatches() {
        String date = " November 2015";

        Calendar myCalendar = new GregorianCalendar();
        int thisYear = myCalendar.getInstance().get(myCalendar.YEAR);
        int thisMonth = myCalendar.getInstance().get(myCalendar.MONTH);
        int thisDay = myCalendar.getInstance().get(myCalendar.DAY_OF_MONTH);

        int day=thisDay;

        String[] matchDate = {Integer.toString(thisDay),MONTHS[thisMonth],Integer.toString(thisYear)};

        //todo get today
        //todo day-j will get negative to bigger numbers.
        //todo this might need the number of days of each month
        //todo although this is just for testing


//        if(day>0 && day< MONTHS_LENGTH[])



        // every team plays with every team twice
        for (int i = 1; i < stats.size(); i++)
            for (int j = 1; j < stats.size(); j++) {


                if (i != j) addMatch(stats.get(i).getName(), stats.get(j).getName(), matchDate);

            }
    }

    public void doSort() {

        int statsSorting = 1, highestPosition, aux;

//        this is for testing purposes ONLY
//        for(int j=1;j<stats.size();j++) {
//            stats.get(j).setPoints(10);
//            stats.get(j).setGoalsScored(j);
//        }

        if (Integer.parseInt(stats.get(highestPoints(statsSorting)).getPoints()) != 0) {

            while (statsSorting < stats.size()) {
                highestPosition = highestPoints(statsSorting);

                //I'm finding the team with the highest points and add exchange their position with the team on the first row
                //after that I'm doing the same thing for the next team and place it on the next row

                stats.add(stats.get(statsSorting));
                aux = stats.size();//get the position of the last element
                stats.set(statsSorting, stats.get(highestPosition));
                stats.set(highestPosition, stats.get(aux - 1));
                stats.remove(aux - 1);

                statsSorting++;
            } //sorting finished

            //start looking for teams with the same number of points and interchange them after their scored goals
            for (int j = 1; j < stats.size(); j++)
                for (int i = 1; i < stats.size() - 1; i++)
                    if (Integer.parseInt(stats.get(i).getPoints()) == Integer.parseInt(stats.get(i + 1).getPoints()))
                        if (Integer.parseInt(stats.get(i).getGoalsScored()) < Integer.parseInt(stats.get(i + 1).getGoalsScored())) {

                            stats.add(stats.get(i));
                            aux = stats.size();//get the position of the last element
                            stats.set(i, stats.get((i + 1)));
                            stats.set((i + 1), stats.get(aux - 1));
                            stats.remove(aux - 1);

                        }
        }
    }

    public int highestPoints(int aux) {
        int maxPoints = -1, maxPosition = 1;
        // the max position will be the first team by default
        // and the max points will be an impossible value

        for (int i = aux; i < stats.size(); i++) {
            for (int j = i; j < stats.size(); j++) {
                if (stats.size() > j) {//todo this seems pointless - please check
                    if (Integer.parseInt(stats.get(j).getPoints()) > maxPoints) {
                        maxPosition = j;
                        maxPoints = Integer.parseInt(stats.get(j).getPoints());
                    }
                }
            }
        }
        return maxPosition;
    }

public void printMatchCalendar(){
    //let's sort it first

    for (int j = 0; j < matchCalendar.size(); j++)
    for(int i=0;i<matchCalendar.size();i++){
   //todo try and order them by date first

        System.out.println("\n" + matchCalendar.get(i).getDate() + ": " + matchCalendar.get(i).getStats());
    }
//todo neeeeeeed loooots of thinking about this !!!!!
}

}
