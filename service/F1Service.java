package service;

import model.Driver;
import model.Team;

import java.util.*;
import java.util.stream.Collectors;

public class F1Service {

    public static List<Driver> drivers = new ArrayList<>();
    public static Map<String, Team> teams = new HashMap<>();
    public static Map<Integer,Driver> map = new HashMap<>();
    public static Set<String> countries = new HashSet<>();

    public static void create() {
        createTeams();
        createDrivers();
        addDriverstoList();
        setTeamtoDriver();
        setDriverstoTeam();
        setCountries();
    }

    private static void createTeams() {
        teams.put("RB18", new Team("Oracle Red Bull Racing", 4, "Christian Horner", "Red Bull Powertrains", null));
        teams.put("W13", new Team("Mercedes-AMG Petronas F1 Team", 8, "Toto Wolf", "Mercedes", null));
        teams.put("F1-75", new Team("Scuderia Ferrari", 16, "Mattia Binotto", "Ferrari", null));
        teams.put("MCL36", new Team("Mclaren F1 Team", 8, "Andreas Seidl", "Mercedes", null));
        teams.put("A522", new Team("BWT Alpine F1 Team", 2, "Otmar Szafnauer", "Renault", null));
        teams.put("C42", new Team("Alfa Romeo F1 Team ORLEN", 0, "Frederic Vasseur", "Ferrari", null));
        teams.put("AT03", new Team("Scuderia AlphaTauri", 0, "Franz Tost", "Red Bull Powertrains", null));
        teams.put("VF-22", new Team("Hass F1 Team", 0, "Frederic Vasseur", "Ferrari", null));
        teams.put("AMR22", new Team("Aston Martin Aramco Cognizant F1 Team", 0, "Mike Krack", "Mercedes", null));
        teams.put("FW44", new Team("Williams Racing", 9, "Jost Capito", "Mercedes", null));
    }

    private static void createDrivers() {
        map.put(1,new Driver("Max Verstappen", "Netherlands", 1, null));
        map.put(11,new Driver( "Sergio Perez", "Mexico", 0, null));
        map.put(44,new Driver( "Lewis Hamilton", "United Kingdom", 7, null));
        map.put(63,new Driver( "George Russell", "United Kingdom", 0, null));
        map.put(16,new Driver( "Charles Lecrec", "Monaco", 0, null));
        map.put(55,new Driver( "Carlos Sainz", "Spain", 0, null));
        map.put(4,new Driver( "Lando Norris", "United Kingdom", 0, null));
        map.put(3,new Driver( "Daniel Ricciardo", "Australia", 0, null));
        map.put(14,new Driver( "Fernando Alonso", "Spain", 2, null));
        map.put(31,new Driver( "Esteban Ocon", "France", 0, null));
        map.put(77,new Driver( "Valtteri Bottas", "Finland", 0, null));
        map.put(24,new Driver( "Zhou Guanyu", "China", 0, null));
        map.put(10,new Driver( "Pierre Gasly", "France", 0, null));
        map.put(22,new Driver( "Yuki Tsunoda", "Japan", 0, null));
        map.put(47,new Driver( "Mick Schumacher", "Germany", 0, null));
        map.put(20,new Driver( "Kevin Magnussen", "Denmark", 0, null));
        map.put(5,new Driver( "Sebastian Vettel", "Germany", 4, null));
        map.put(18,new Driver( "Lance Stroll", "Canada", 0, null));
        map.put(23,new Driver( "Alexander Albon", "Thailand", 0, null));
        map.put(6,new Driver( "Nicholas Latifi", "Canada", 0, null));
    }

    private static void setDriverstoTeam() {
        teams.forEach((car, team) ->
                team.setDrivers(drivers.stream()
                        .filter(driver -> driver.getTeam().equals(teams.get(car))).collect(Collectors.toList())
                )
        );
    }

    public static void setTeamtoDriver(){
        for (Integer key : map.keySet()){
            switch (key){
                case 1, 11 ->
                        map.get(key).setTeam(teams.get("RB18"));
                case 44, 63 ->
                        map.get(key).setTeam(teams.get("W13"));
                case 16, 55 ->
                        map.get(key).setTeam(teams.get("F1-75"));
                case 4, 3 ->
                        map.get(key).setTeam(teams.get("MCL36"));
                case 14, 31 ->
                        map.get(key).setTeam(teams.get("A522"));
                case 77, 24 ->
                        map.get(key).setTeam(teams.get("C42"));
                case 10, 22 ->
                        map.get(key).setTeam(teams.get("AT03"));
                case 47, 20 ->
                        map.get(key).setTeam(teams.get("VF-22"));
                case 5, 18 ->
                        map.get(key).setTeam(teams.get("AMR22"));
                default -> map.get(key).setTeam(teams.get("FW44"));
            }
        }
    }

    private static void addDriverstoList(){
        for (Integer key : map.keySet()) {
            drivers.add(map.get(key));
        }
    }

    private static void setCountries(){
        drivers.forEach(driver -> countries.add(driver.getCountry()));
    }
}
