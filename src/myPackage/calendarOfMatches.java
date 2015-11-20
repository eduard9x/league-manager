package myPackage;

public class calendarOfMatches {

    private String stats;
    private String[] date;

    public calendarOfMatches(String stats) {
        this.stats = stats;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getDate() {
        return (date[0] +" "+ date[1] +" "+ date[2]);
    }

    public void setDate(int day, String month, int year) {
        date[0] = Integer.toString(day);
        date[1] = month;
        date[1] = Integer.toString(year);
    }

    public void setDate(String[] date) {
       this.date = date;
    }

}
