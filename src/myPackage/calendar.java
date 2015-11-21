package myPackage;


public class calendar {

    private String match;
    private String[] date;

    calendar(String match, String[] date){
        this.match=match;
        this.date=date;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String[] getDate() {
        return date;
    }

    public void setDate(String[] date) {
        this.date = date;
    }
}
