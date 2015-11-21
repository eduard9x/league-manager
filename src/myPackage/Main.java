package myPackage;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        PremierLeagueManager MyLeague = new PremierLeagueManager();
        // this will create the head of Premier League table
        MyLeague.CreateClub("Name");

        //todo test everything with no clubs added

//        MyLeague.stats(-1);
//        MyLeague.calendar();
//        MyLeague.DeleteClub("Real Madrid");

//        MyLeague.doMatches();
//        System.out.println();

//        MyLeague.doSort();
//        MyLeague.stats(-1); //-1 for showing all the premier league

//        MyLeague.calendar();

//        MyLeague.stats(MyLeague.find("Liverpool"));

//        MyLeague.addMatch("Liverpool","Chelsea", "13-November-2015");
//        MyLeague.addMatch("Real Madrid","Arsenal", "14-November-2015");

//        MyLeague.doSort();
//        MyLeague.stats(-1);
        //todo create menu
//        MyLeague.doEnd();
//        MyLeague.calendar();

        final int ALL = -1; //-1 is for showing all the premier league table
        String clubName, myName;
        String myOption = "Hello, ";

        try {
            myName = JOptionPane.showInputDialog("Please enter your name:");

            //making the program safe when the user doesn't want to input name
            if (myName == null || myName.length() == 0) throw new NullPointerException();
            else
                MyLeague.validMessage(myOption + myName);
        } catch (NullPointerException a) {
            //adding a friendly username
            myName = "friendly user";
            MyLeague.validMessage(myOption + myName);
        }


        try {
            while (!myOption.equalsIgnoreCase("q")) {
                System.out.println("\n   Please choose one of the following options:");
                System.out.println("Press A to -> Create football club. ");
                System.out.println("Press B to -> Delete football club. ");
                System.out.println("Press C to -> Display various statistics for a club. ");
                System.out.println("Press D to -> Display the Premier League Table. ");
                System.out.println("Press E to -> Add a match between two clubs. ");
                System.out.println("Press F to -> Display calendar. ");
                System.out.println("Press G to -> Load the test clubs. ");
                System.out.println("Press H to -> Load the test matches. ");
                System.out.println("Press Q to -> Quit. ");

                myOption = JOptionPane.showInputDialog("Please enter your option:");

                //making the program safe for the user to input options
                if (myOption == null || myOption.length() == 0) throw new NullPointerException();
                else if (myOption.equalsIgnoreCase("a")) {
                    //Create football club.
                    clubName = JOptionPane.showInputDialog("Please enter the club name to create:");
                    if (clubName == null || clubName.length() == 0)
                        MyLeague.invalidMessage(" >>> Please follow instructions carefully.");
                    else {
                        //add location details
                        String clubLocation = JOptionPane.showInputDialog("Please enter location for " + clubName + ":");

                        MyLeague.CreateClub(clubName);
                        if (clubLocation == null || clubLocation.length() == 0) ; //leave the location as unknown
                        else {
                            //set the location
                            MyLeague.stats.get(MyLeague.find(clubName)).setLocation(clubLocation);
                        }
                    }
                } else if (myOption.equalsIgnoreCase("b")) {
                    //Delete football club.
                    if (MyLeague.stats.size() > 1) {
                        //display team names in order to know a club name.
                        System.out.println(MyLeague.getNames());

                        clubName = JOptionPane.showInputDialog("Please enter the club name to delete:");
                        MyLeague.DeleteClub(clubName);
                    } else MyLeague.invalidMessage(" >>> There are no clubs to delete.");

                } else if (myOption.equalsIgnoreCase("c")) {
                    //Display various statistics for a club.
                    if (MyLeague.stats.size() > 1) {
                        //display team names in order to know a club name.
                        System.out.println(MyLeague.getNames());

                        clubName = JOptionPane.showInputDialog("Please enter the club name to display various statistics:");

                        //if the name is not valid
                        if (MyLeague.find(clubName) == -1)
                            MyLeague.invalidMessage(" >>> " + clubName + " - is not a valid club name.");
                        else {
                            MyLeague.stats(MyLeague.find(clubName));
                            System.out.println();
                            MyLeague.stats.get(MyLeague.find(clubName)).variousStatistics();
                        }
                    } else MyLeague.invalidMessage(" >>> Cannot show statistics. Please create a club first.");

                } else if (myOption.equalsIgnoreCase("d")) {
                    //Display the Premier League Table.
                    System.out.println();
                    MyLeague.stats(ALL);
                } else if (myOption.equalsIgnoreCase("e")) {
                    //Add a match between two clubs.

                    //display team names first - to be able to pick one
                    System.out.println(MyLeague.getNames());

                    String homeTeam = JOptionPane.showInputDialog("Please enter the home team:");
                    //if the name is not valid
                    if (MyLeague.find(homeTeam) == -1)
                        MyLeague.invalidMessage(" >>> " + homeTeam + " - is not a valid club name.");
                    else {
                        String awayTeam = JOptionPane.showInputDialog("Please enter the away team:");
                        if (MyLeague.find(awayTeam) == -1)
                            MyLeague.invalidMessage(" >>> " + awayTeam + " - is not a valid club name.");
                        else {
                            int year = Integer.parseInt(JOptionPane.showInputDialog("Please enter the year of the match:"));
                            String month = JOptionPane.showInputDialog("Please enter the month as March, June, November, etc :");
                            int day = Integer.parseInt(JOptionPane.showInputDialog("Please enter the day of the match:"));

                            String date = day + "-" + month + "-" + year;

                            calendar myDate = new calendar(date);
                            //parsing this as a date in my calendar class

                            //the date will be validated in the add match method
                            MyLeague.addMatch(homeTeam, awayTeam, myDate);
                        }
                    }
                } else if (myOption.equalsIgnoreCase("f")) {
                    int year = Integer.parseInt(JOptionPane.showInputDialog("Please enter the year of the match:"));
                    String month = JOptionPane.showInputDialog("Please enter the month using the following format 'November','March', etc :");
                    int day = Integer.parseInt(JOptionPane.showInputDialog("Please enter the day of the match:"));
                    String date = day + "-" + month + "-" + year;

                    calendar myDate = new calendar(date);
                    //parsing this as a date in my calendar class

                    MyLeague.calendar(myDate);
                } else if (myOption.equalsIgnoreCase("g")) {
                    MyLeague.CreateClub("Liverpool");
                    MyLeague.CreateClub("Chelsea");
                    MyLeague.CreateClub("Arsenal");
                    MyLeague.CreateClub("Everton");
                    MyLeague.CreateClub("Manchester City");
                    MyLeague.CreateClub("West Ham");
                    MyLeague.CreateClub("Juventus");
                    MyLeague.CreateClub("Real Madrid");
                    MyLeague.CreateClub("Barcelona");
                    MyLeague.CreateClub("Sevilla");
                } else if (myOption.equalsIgnoreCase("h")) {
                    MyLeague.doMatches();
                } else throw new NullPointerException();


            }

        } catch (NullPointerException a) {
            MyLeague.validMessage(" Have a nice day, " + myName + ".");
        }
    }
}
