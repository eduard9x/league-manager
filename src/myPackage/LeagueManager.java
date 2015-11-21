package myPackage;

interface LeagueManager {
    void CreateClub(String ClubName);
    void DeleteClub(String ClubName);
    int find(String name);
    void addMatch(String homeClub, String awayClub, calendar date);
    void calendar(calendar myDate);
}
