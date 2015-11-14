package myPackage;

import java.util.ArrayList;

class PremierLeagueManager implements LeagueManager {

    PremierLeagueManager(String n) {

    }

    ArrayList<FotballClub> stats = new ArrayList();
    FotballClub MyClub;

    public void CreateClub(String name) {


        MyClub = new FotballClub(name);
        stats.add(MyClub);

//        stats.get(0).variousStatistics();

    }

    public void DeleteClub(String name) {

    }

    public void stats() {

        boolean first = false;
        String compare1 = "", compare2 = "";
        FotballClub MySadClub;
        int i;

        //this will find the longest club name
        for (i = 0; i < stats.size(); i++) {
            MySadClub = stats.get(i);

            if (first == false) { // add the first name in this variable
                compare1 = MySadClub.getName();
                first = true;
            } else { // we already added the first one and i>0
                compare2 = MySadClub.getName();
                if (compare1.length() < compare2.length()) compare1 = compare2;
            }
        }

        //this will create my Premier League table
        first = false;
        for (i = 0; i < stats.size(); i++) {
            MySadClub =  stats.get(i);
            if (first == false) {
                first = true;
                MySadClub.statistics("head", compare1.length());
            }
            MySadClub.statistics("stats", compare1.length());
        }
    }






}
