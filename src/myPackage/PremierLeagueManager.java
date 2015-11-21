package myPackage;

import java.util.*;

class PremierLeagueManager implements LeagueManager {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static final String DAYS[] = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
    public static final String MONTHS[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static final int[] MONTHS_LENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    ArrayList<FotballClub> stats = new ArrayList<FotballClub>();
    FotballClub MyClub;

    ArrayList<calendar> myCal = new ArrayList<calendar>();

    public void CreateClub(String name) {

        MyClub = new FotballClub(name);
        stats.add(MyClub);

        if (stats.size() > 1) //hide the first line -- table header
            validMessage(" >>> " + name + " -- football club created.");

    }

    public void DeleteClub(String name) {
        //making sure no one can delete the first line
        // making sure the club name is valid
        if (find(name) != 0 && find(name) != -1) {
            validMessage(" >>> " + name + " - was deleted ");
            stats.remove(find(name));
        } else invalidMessage(" >>> " + name + " - is not a valid name ");
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
            if (i == which || i == 0 || which == -1) //only for head of table and the searched team
                stats.get(i).statistics(biggestField);
    }

    public void calendar(calendar myDate) {

        try {
            //validate the date
            if (myDate.getYear() > 0 && Integer.toString(myDate.getYear()).length() < 5) ;
                // positive year but with maximum 4 digits
            else throw new NullPointerException();

            int monthPos = -1;
            for (int a = 0; a < MONTHS.length; a++)
                if (myDate.getMonth().equals(MONTHS[a])) monthPos = a;
            //the month exists in the MONTHS array

            if (monthPos == -1) throw new NullPointerException();
                //found no month as the one from the user
            else if (myDate.getDay() > 0 && myDate.getDay() <= MONTHS_LENGTH[monthPos]) ;
                //the day is between boundaries - positive but not bigger than the maximum number possible
            else if (monthPos == 1) { // might be february and a leap year
                if ((myDate.getYear() % 4 == 0) && (myDate.getYear() % 100 != 0) || (myDate.getYear() % 400 == 0))
                    if (myDate.getDay() > 0 && myDate.getDay() <= 29) ;
            } else throw new NullPointerException();

            int selectedYear = myDate.getYear();
            int selectedDay = myDate.getDay();
            int selectedMonth = -1; // months 0-11 --> Jan-Dec

            for (int a = 0; a < MONTHS.length; a++) {
                if (myDate.getMonth().equals(MONTHS[a]))
                    selectedMonth = a; //getting the month's position in our array on months
            }

            if (selectedMonth == -1) {
                System.out.println(ANSI_RED + " >>> Please enter a valid month format." + ANSI_RESET);
            } else {

                String colour = ANSI_PURPLE;
                int dayOfWeek, i;

                if ((selectedYear % 4 == 0) && (selectedYear % 100 != 0) || (selectedYear % 400 == 0))
                    MONTHS_LENGTH[1] = 29; //is it leap year?

                Calendar myCalendar = new GregorianCalendar(selectedYear, selectedMonth, 1); // create a calendar entry on the 1st of our monts & year

                dayOfWeek = myCalendar.get(Calendar.DAY_OF_WEEK); //find the name of that day -- will return 1 for Sunday

                //the use of colours
                System.out.println("\nUse of colours:\n  >> Past day - " + ANSI_BLUE + "blue" + ANSI_RESET + "\n  >> Future day - " + ANSI_PURPLE + "purple" + ANSI_RESET + " \n");

                //printing the selected month and year
                System.out.println("    " + MONTHS[selectedMonth] + "  " + selectedYear);

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

                //start printing days of the month
                for (i = 0; i < MONTHS_LENGTH[selectedMonth]; i++) { //I used that 9 - to addi an extra space for digits less than 10
                    if ((selectedYear < thisYear) || (selectedYear == thisYear && selectedMonth < thisMonth) || (selectedYear == thisYear && selectedMonth == thisMonth && i < thisDay))
                        colour = ANSI_BLUE; //past day
                    else colour = ANSI_PURPLE; //future day

                    if (i < 9)
                        System.out.print(colour + (i + 1) + "   " + ANSI_RESET); //will have blue colour for past and red for future
                    else System.out.print(colour + (i + 1) + "  " + ANSI_RESET);
                    if ((i + dayOfWeek) % 7 == 0) System.out.println();
                }

                System.out.println();
                boolean found = false;
                int testMonth = -1;

                if ((selectedYear < thisYear) || (selectedYear == thisYear && selectedMonth < thisMonth) || (selectedYear == thisYear && selectedMonth == thisMonth && i < thisDay))
                    colour = ANSI_BLUE; //past day
                else colour = ANSI_PURPLE; //future day

                for (calendar t : myCal) {

                    for (int a = 0; a < MONTHS.length; a++) {
                        if (t.getMonth().equals(MONTHS[a]))
                            testMonth = a; //getting the month's position in our array on months
                    }

                    if (t.getDay() == selectedDay && testMonth == selectedMonth && t.getYear() == selectedYear) {
                        System.out.println("\n" + colour + t.getDate() + " >>> " + t.getMatch() + ANSI_RESET);
                        found = true;
                    }
                }
                if (found == false) invalidMessage(" >>> No matches played today:" + myDate.getDate());
            }

        } catch (NullPointerException a) {
            invalidMessage(" >>> The date was not valid.");
        }


    }

    public int find(String name) {

        for (int i = 0; i < stats.size(); i++)
            if (stats.get(i).getName().equals(name)) return i;

        return -1;
    }

    public void addMatch(String homeClub, String awayClub, calendar date) {

        try {
            //validate the date
            if (date.getYear() > 0 && Integer.toString(date.getYear()).length() < 5) ;
                // positive year but with maximum 4 digits
            else throw new NullPointerException();

            int monthPos = -1;
            for (int a = 0; a < MONTHS.length; a++)
                if (date.getMonth().equals(MONTHS[a])) monthPos = a;
            //the month exists in the MONTHS array

            if (monthPos == -1) throw new NullPointerException();
                //found no month as the one from the user
            else if (date.getDay() > 0 && date.getDay() <= MONTHS_LENGTH[monthPos]) ;
                //the day is between boundaries - positive but not bigger than the maximum number possible
            else if (monthPos == 1) { // might be february and a leap year
                if ((date.getYear() % 4 == 0) && (date.getYear() % 100 != 0) || (date.getYear() % 400 == 0))
                    if (date.getDay() > 0 && date.getDay() <= 29) ;
            } else throw new NullPointerException();

            //get the present date
            Calendar myCalendar = new GregorianCalendar();
            int thisYear = myCalendar.getInstance().get(myCalendar.YEAR);
            int thisMonth = myCalendar.getInstance().get(myCalendar.MONTH);
            int thisDay = myCalendar.getInstance().get(myCalendar.DAY_OF_MONTH);
            myCalendar.clear();

            int home = find(homeClub);
            int away = find(awayClub);

            String dateOfMatch = date.getDay() + "-" + MONTHS[monthPos] + "-" + date.getYear();

            //if it's future
            if ((date.getYear() > thisYear) || (date.getYear() == thisYear && monthPos > thisMonth) || (date.getYear() == thisYear && monthPos == thisMonth && date.getDay() > thisDay)) {//add a future match to the calendar
                calendar newMatch = new calendar(homeClub + " - " + awayClub, dateOfMatch);
                validMessage(homeClub + " - " + awayClub);
                myCal.add(newMatch);
            } else {
                int randomHome = (int) Math.floor(4 * Math.random());
                int randomAway = (int) Math.floor(3 * Math.random());

                if (randomHome >= randomAway) {
                    addStats(home, away, randomHome, randomAway);
                } else {
                    addStats(away, home, randomAway, randomHome);
                }

                validMessage(homeClub + " " + randomHome + " - " + randomAway + " " + awayClub);

                calendar newMatch = new calendar(homeClub + " " + randomHome + " - " + randomAway + " " + awayClub, dateOfMatch);
                myCal.add(newMatch);
            }

            //sort the teams by points and goals scored
            doSort();

        } catch (NullPointerException a) {
            invalidMessage(" >>> The date was not valid.");
        }

    }

    public void addStats(int win, int lose, int scoreWin, int scoreLose) {

        //winning part
        stats.get(win).setMatchesPlayed(1);
        stats.get(win).setGoalsReceived(scoreLose);
        stats.get(win).setGoalsScored(scoreWin);
        //losing part
        stats.get(lose).setMatchesPlayed(1);
        stats.get(lose).setGoalsReceived(scoreWin);
        stats.get(lose).setGoalsScored(scoreLose);

        if (scoreWin > scoreLose) {
            stats.get(win).setPoints(3);
            stats.get(win).setWins(1);
            stats.get(lose).setDefeats(1);
        } else { //it's a draw
            stats.get(win).setPoints(1);
            stats.get(win).setDraws(1);
            stats.get(lose).setPoints(1);
            stats.get(lose).setDraws(1);
        }
    }

    public void doMatches() {

        int thisYear, thisMonth, thisDay, i, j;
        Calendar myCalendar;
        String dateOfMatch;
        calendar matchDate;

        //get the present date
        myCalendar = new GregorianCalendar();
        thisYear = myCalendar.getInstance().get(myCalendar.YEAR);
        thisMonth = myCalendar.getInstance().get(myCalendar.MONTH);
        thisDay = myCalendar.getInstance().get(myCalendar.DAY_OF_MONTH);
        myCalendar.clear();

        // every team plays with every team twice
        for (i = 1; i < stats.size(); i++)
            for (j = 1; j < stats.size(); j++) {
                if (i != j) {
                    dateOfMatch = thisDay + "-" + MONTHS[thisMonth] + "-" + thisYear;
                    matchDate = new calendar(dateOfMatch);
                    addMatch(stats.get(i).getName(), stats.get(j).getName(), matchDate);

                    System.out.println(matchDate.getDate());

                    if (thisDay > 1) thisDay--;
                    else if (thisMonth > 0) //because 0 means January
                    {
                        thisMonth--;
                        if ((thisMonth == 1) && ((thisYear % 4 == 0) && (thisYear % 100 != 0) || (thisYear % 400 == 0))) // february and leap year
                            thisDay = 29;
                        else
                            thisDay = MONTHS_LENGTH[thisMonth];
                    } else {
                        thisYear--;
                        thisMonth = MONTHS.length - 1; //11 - December
                        thisDay = MONTHS_LENGTH[thisMonth];
                    }
                }
            }

        //add matches in the future as well

        //get the present date
        myCalendar = new GregorianCalendar();
        thisYear = myCalendar.getInstance().get(myCalendar.YEAR);
        thisMonth = myCalendar.getInstance().get(myCalendar.MONTH);
        thisDay = myCalendar.getInstance().get(myCalendar.DAY_OF_MONTH);
        myCalendar.clear();

        // every team plays with every team twice
        for (i = 1; i < stats.size(); i++)
            for (j = 1; j < stats.size(); j++) {
                if (i != j) {
                    dateOfMatch = thisDay + "-" + MONTHS[thisMonth] + "-" + thisYear;
                    matchDate = new calendar(dateOfMatch);
                    addMatch(stats.get(i).getName(), stats.get(j).getName(), matchDate);

                    System.out.println(matchDate.getDate());

                    if (thisDay < MONTHS_LENGTH[thisMonth]) thisDay++;
                    else if ((thisMonth == 1) && ((thisYear % 4 == 0) && (thisYear % 100 != 0) || (thisYear % 400 == 0))&& (thisDay<29))
                        thisDay++; //will go to 29 on a leap year
                    else if (thisMonth < MONTHS.length - 1) //because 11 means December
                    {
                        thisMonth++;
                        thisDay = 1;
                    } else {
                        thisYear++;
                        thisMonth = 0; //0 - January
                        thisDay = 1;
                    }
                }
            }

    }

    public void doSort() {

        int statsSorting = 1, highestPosition, aux;

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

    public String getNames() {
        //I created this method to show the user a list of already created clubs
        String names = "\n   List of clubs: ";

        //the user might call this method before creating any clubs
        if (stats.size() == 1) names = names + "None created.";
        //size 1 -- because the first line will have the head of Premier League table

        for (int i = 1; i < stats.size(); i++) {
            names = names + stats.get(i).getName();
            if (i < stats.size() - 1) names = names + ", ";
            //add commas after each listed club name, except the last one
        }
        return names;
    }

    public void validMessage(String message) {
        System.out.println("\n" + ANSI_GREEN + message + ANSI_RESET);
    }

    public void invalidMessage(String message) {
        System.out.println("\n" + ANSI_RED + message + ANSI_RESET);
    }


}
