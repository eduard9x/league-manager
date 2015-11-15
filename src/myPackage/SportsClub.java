package myPackage;

abstract class SportsClub {

    public abstract void statistics( int[] biggestField);

    private String name, location, awards, capital, worldWidePosition;

    public SportsClub(String name) {
        this.name = name;
        location = "unknown";
        awards = "unknown";
        capital = "unknown";
        worldWidePosition = "unknown";
    }

    public void variousStatistics() {
        System.out.println(" >>> Club Name:" + this.getName());
        System.out.println("Location:" + this.getLocation());
        System.out.println("Awards: " + this.getLocation());
        System.out.println("Capital: " + this.getCapital());
        System.out.println("World Wide Position: " + this.getWorldWidePosition());
        System.out.println();
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

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getWorldWidePosition() {
        return worldWidePosition;
    }

    public void setWorldWidePosition(String worldWidePosition) {
        this.worldWidePosition = worldWidePosition;
    }

}
