package myPackage;

import java.util.ArrayList;

class PremierLeagueManager implements LeagueManager {

    PremierLeagueManager() {

    }

    ArrayList<FotballClub> stats = new ArrayList();
    FotballClub MyClub;



    public void CreateClub(String name) {

        MyClub = new FotballClub(name);
        stats.add(MyClub);
//        stats.get(0).variousStatistics();
//        stats.get(0).setDraws(12356789);
    }


    public void DeleteClub(String name) {
    }

//todo research if it's useful to add the table in the attributes
//todo make a method that adds the first row of the table in the actual attributes
// todo after that, this method might work
//todo you can do a method with 8 arguments or with a string[8] or even more for location and various statistics in the constructor


    public void stats() {

        int i;
        int[] biggestField = {stats.get(0).getName().length(), stats.get(0).getMatchesPlayed().length(), stats.get(0).getWins().length(), stats.get(0).getDraws().length(), stats.get(0).getDefeats().length(), stats.get(0).getGoalsReceived().length(), stats.get(0).getGoalsScored().length(), stats.get(0).getPoints().length()};

        for( i=1;i< stats.size();i++)
        for(int j=0;j< biggestField.length;j++) {
            int[] test2 = {stats.get(i).getName().length(), stats.get(i).getMatchesPlayed().length(), stats.get(i).getWins().length(), stats.get(i).getDraws().length(), stats.get(i).getDefeats().length(), stats.get(i).getGoalsReceived().length(), stats.get(i).getGoalsScored().length(), stats.get(i).getPoints().length()};
            if(biggestField[j] < test2[j]) biggestField[j] = test2[j];
        }

        //this will create my Premier League table

        for (i = 0; i < stats.size(); i++)
            stats.get(i).statistics(biggestField);
    }

}
