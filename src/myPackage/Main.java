package myPackage;

public class Main {

    public static void main(String[] args) {


        //todo create a list of clubs
        //todo get the longest club name
        //todo make a method return the firstLine string
        //todo print that string
        //todo make the statistics print on the same structure as the firstLine string



//        String[] firstLine = {"Name", "Matches played", "Wins", "Draws", "Defeats", "Goals received", "Goals scored", "Points"};
//        String[] firstLineStructure = {4,14,4,5,7,14,12,6};

        //todo as you create clubs, measure their structure(name) and keep the largest one
        //todo make sure it shows properly when you have a smaller club name than 4 letters

        PremierLeagueManager MyLeague = new PremierLeagueManager("eddie");
        MyLeague.CreateClub("Liverpool");
        MyLeague.CreateClub("Chelsea");
        MyLeague.CreateClub("Arsenal");
        MyLeague.CreateClub("Everton");
        MyLeague.CreateClub("Manchester United");


//        FotballClub EdwardPool = new FotballClub("EdwardPool");
//        EdwardPool.statistics();

        MyLeague.stats();


    }
}
