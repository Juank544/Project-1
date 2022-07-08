package model;

public class Driver {
    private String number;
    private String name;
    private String country;
    private Integer championships;
    private Team team;

    public Driver(String number,String name, String country, Integer championships, Team team) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.championships = championships;
        this.team = team;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Integer getChampionships() {
        return championships;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        //return super.toString();
        return name;
    }
}
