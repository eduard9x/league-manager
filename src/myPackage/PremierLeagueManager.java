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

    PremierLeagueManager() {

    }

    ArrayList<FotballClub> stats = new ArrayList();
    FotballClub MyClub;

    public void CreateClub(String name) {
        MyClub = new FotballClub(name);
        stats.add(MyClub);

        if(stats.size()>1) //hide the first line -- table header
        System.out.println(ANSI_BLUE + name + " -- football club created." + ANSI_RESET);
    }

    public void DeleteClub(String name) {
        //making sure no one can delete the first line
        // making sure the club name is valid
        if(find(name)!=0 && find(name)!=-1)  {
            System.out.println("\n" + ANSI_GREEN + name + " - was deleted " + ANSI_RESET + "\n");
            stats.remove(find(name));
        }
        else System.out.println("\n" + ANSI_RED + name + " - is not a valid name " + ANSI_RESET + "\n");
    }

    public void stats() {
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
            stats.get(i).statistics(biggestField);
    }

    public void calendar() {

        int year = 2011;
        int month = 9; // months 0-11 --> Jan-Dec
        //todo add validation to this and to whatever else you input from keyboard

        int dayOfWeek, i;

        String days[] = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] monthsLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) monthsLength[1] = 29; //is it leap year?

        Calendar myCalendar = new GregorianCalendar(year, month, 1); // create a calendar entry on the 1st of our monts & year

        dayOfWeek = myCalendar.get(Calendar.DAY_OF_WEEK); //find the name of that day -- will return 1 for Sunday

        System.out.println("    " + months[month] + "  " + year);

        //printing head of calendar
        for (i = 0; i < days.length; i++)
            System.out.print(days[i] + "  ");
        System.out.println();

        //getting before the day our month is starting
        for (i = 1; i < dayOfWeek; i++)
            System.out.print("    ");

        //start printing with the actual day the month starts
        for (i = 0; i < monthsLength[month]; i++) {
            if (i < 9) System.out.print((i + 1) + "   ");
            else System.out.print((i + 1) + "  ");
            if ((i + dayOfWeek) % 7 == 0) System.out.println();
        }


    }

    public int find(String name){

        for(int i=0;i<stats.size();i++)
            if(stats.get(i).getName().equals(name)) return i;

        return -1;
    }

}
