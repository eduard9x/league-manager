package myPackage;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        PremierLeagueManager MyLeague = new PremierLeagueManager();
        MyLeague.CreateClub("Name");
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

        //todo test everything with no clubs added


//        MyLeague.stats(-1);
//        MyLeague.calendar();
//        MyLeague.DeleteClub("Real Madrid");

        MyLeague.doMatches();
//        System.out.println();

//        MyLeague.doSort();
//        MyLeague.stats(-1); //-1 for showing all the premier league

//        MyLeague.calendar();

//        MyLeague.stats(MyLeague.find("Liverpool"));

//        MyLeague.addMatch("Liverpool","Chelsea");
//        MyLeague.addMatch("Real Madrid","Arsenal");


//        MyLeague.doSort();

//        MyLeague.stats(-1);
        //todo create menu

        MyLeague.doEnd();


    }





}
