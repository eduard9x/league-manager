package myPackage;

public class Main {

    public static void main(String[] args) {


        //todo create a list of clubs
        //todo get the longest club name
        //todo make a method return the firstLine string
        //todo print that string
        //todo make the statistics print on the same structure as the firstLine string
        //todo as you create clubs, measure their structure(name) and keep the largest one
        //todo make sure it shows properly when you have a smaller club name than 4 letters

        PremierLeagueManager MyLeague = new PremierLeagueManager();
        MyLeague.CreateClub("Name");
        MyLeague.CreateClub("Liverpool");
        MyLeague.CreateClub("Chelsea");
        MyLeague.CreateClub("Arsenal");
        MyLeague.CreateClub("Everton");
        MyLeague.CreateClub("Manchester City");

        MyLeague.stats();


        // todo create menu
        //todo create find function
    }
}
