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
                System.out.println(myOption + myName);
        } catch (NullPointerException a) {
            //adding a friendly username
            myName = "friendly user";
            System.out.println(myOption + myName);
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

                myOption = JOptionPane.showInputDialog("Please enter your option:");

                //making the program safe for the user to input options
                if (myOption == null || myOption.length() == 0) throw new NullPointerException();
                else if (myOption.equalsIgnoreCase("a")) {
                    clubName = JOptionPane.showInputDialog("Please enter the club name to create:");
                    MyLeague.CreateClub(clubName);
                } else if (myOption.equalsIgnoreCase("b")) {
                    clubName = JOptionPane.showInputDialog("Please enter the club name to delete:");
                    MyLeague.DeleteClub(clubName);
                } else if (myOption.equalsIgnoreCase("c")) {
                    clubName = JOptionPane.showInputDialog("Please enter the club name to display various statistics:");
                    MyLeague.stats(MyLeague.find(clubName));
                } else if (myOption.equalsIgnoreCase("d")) {
                    MyLeague.stats(ALL);
                } else if (myOption.equalsIgnoreCase("e")) {

                    //might be cool to display some team names before that.

                    String homeTeam = JOptionPane.showInputDialog("Please enter the home team:");
                    String awayTeam = JOptionPane.showInputDialog("Please enter the away team:");

                    int year = Integer.parseInt(JOptionPane.showInputDialog("Please enter the year of the match:"));
                    String month = JOptionPane.showInputDialog("Please enter the month using the following format 'November','March', etc :");
                    int day = Integer.parseInt(JOptionPane.showInputDialog("Please enter the day of the match:"));
                    String date = day + "-" + month + "-" + year;
                    MyLeague.addMatch(homeTeam, awayTeam, date);

                } else if (myOption.equalsIgnoreCase("f")) {
                    int year = Integer.parseInt(JOptionPane.showInputDialog("Please enter the year of the match:"));
                    String month = JOptionPane.showInputDialog("Please enter the month using the following format 'November','March', etc :");
                    int day = Integer.parseInt(JOptionPane.showInputDialog("Please enter the day of the match:"));
                    String date = day + "-" + month + "-" + year;

                    calendar mytest = new calendar(date);

                    MyLeague.calendar(mytest);
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

                    MyLeague.doMatches();

                } else throw new NullPointerException();


            }

        } catch (NullPointerException a) {
            System.out.println("\n Have a nice day, " + myName + ".");
        }
    }
}
