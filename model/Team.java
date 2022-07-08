package model;

import java.util.List;

public class Team {
    private String name;
    private Integer championships;
    private String chief;
    private String car;

    private String powerUnit;

    private List<Driver> drivers;

    public Team(String name, Integer championships, String chief, String car, String powerUnit, List<Driver> drivers) {
        this.name = name;
        this.championships = championships;
        this.chief = chief;
        this.car = car;
        this.powerUnit = powerUnit;
        this.drivers = drivers;
    }

    public String getName() {
        return name;
    }

    public Integer getChampionships() {
        return championships;
    }

    public String getChief() {
        return chief;
    }

    public String getCar() {
        return car;
    }

    public String getPowerUnit() {
        return powerUnit;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "El nombre del equipo es: "+name+"\n"
                +"y sus pilotos son:"+drivers.toString()+"\n";
    }
}
