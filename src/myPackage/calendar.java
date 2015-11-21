package myPackage;

public class calendar {

    private String match;
    private String date;

    calendar(String match, String date) {
        this.match = match;
        this.date = date;
    }

    calendar(String date) {
        this.date = date;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDay() {
        return Integer.parseInt(date.substring(0, date.indexOf("-")));
    }

    public String getMonth() {
        String monthAndYear = date.substring(date.indexOf("-") + 1, date.length());
        String month = monthAndYear.substring(0, monthAndYear.indexOf("-"));
        return month;
    }

    public int getYear() {
        String monthAndYear = date.substring(date.indexOf("-") + 1, date.length());
        int year = Integer.parseInt(monthAndYear.substring(monthAndYear.indexOf("-") + 1, monthAndYear.length()));
        return year;
    }

}
