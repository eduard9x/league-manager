package myPackage;

abstract class SportsClub {

    public abstract void statistics(int[] biggestField);

    private String name, location;

    public SportsClub(String name) {
        this.name = name;
        location = "not known";
    }

    public void variousStatistics() {
        System.out.println(" >>> Club Name:" + this.getName());
        System.out.println("Location:" + this.getLocation());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
