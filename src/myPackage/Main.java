package myPackage;

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


//        MyLeague.stats();
//        MyLeague.calendar();
//        MyLeague.DeleteClub("Space");

//        MyLeague.doMatches();
//        System.out.println();

//        MyLeague.doSort();

        MyLeague.stats();
        //todo create menu
    }





}
