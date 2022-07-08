package service;

import model.Driver;
import model.Team;

import java.util.*;
import java.util.stream.Collectors;

public class F1Service {

    public static List<Driver> drivers = new ArrayList<>();
    public static Set<Team> teams = new HashSet<>();
    public static Map<Integer,Driver> map = new HashMap<>();

    public static void create() {
        createTeams();
        createDrivers();
        addDriverstoList();
        setTeamtoDriver();
        setDriverstoTeam();
    }

    private static void createTeams() {
        teams.add(new Team("Oracle Red Bull Racing", 4, "Christian Horner", "RB18", "Red Bull Powertrains", null));
        teams.add(new Team("Mercedes-AMG Petronas F1 Team", 8, "Toto Wolf", "W13", "Mercedes", null));
        teams.add(new Team("Scuderia Ferrari", 16, "Mattia Binotto", "F1-75", "Ferrari", null));
        teams.add(new Team("Mclaren F1 Team", 8, "Andreas Seidl", "MCL36", "Mercedes", null));
        teams.add(new Team("BWT Alpine F1 Team", 2, "Otmar Szafnauer", "A522", "Renault", null));
        teams.add(new Team("Alfa Romeo F1 Team ORLEN", 0, "Frederic Vasseur", "C42", "Ferrari", null));
        teams.add(new Team("Scuderia AlphaTauri", 0, "Franz Tost", "AT03", "Red Bull Powertrains", null));
        teams.add(new Team("Hass F1 Team", 0, "Frederic Vasseur", "VF-22", "Ferrari", null));
        teams.add(new Team("Aston Martin Aramco Cognizant F1 Team", 0, "Mike Krack", "AMR22", "Mercedes", null));
        teams.add(new Team("Williams Racing", 9, "Jost Capito", "FW44", "Mercedes", null));
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
        teams.forEach(team ->
          team.setDrivers(drivers.stream()
                  .filter(driver -> driver.getTeam().getCar().equals(team.getCar())).collect(Collectors.toList())
          )
        );
    }

    public static void setTeamtoDriver(){
        for (Integer key : map.keySet()){
            switch (key){
                case 1, 11 ->
                        map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("RB18")).findAny().get());
                case 44, 63 ->
                        map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("W13")).findAny().get());
                case 16, 55 ->
                        map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("F1-75")).findAny().get());
                case 4, 3 ->
                        map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("MCL36")).findAny().get());
                case 14, 31 ->
                        map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("A522")).findAny().get());
                case 77, 24 ->
                        map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("C42")).findAny().get());
                case 10, 22 ->
                        map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("AT03")).findAny().get());
                case 47, 20 ->
                        map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("VF-22")).findAny().get());
                case 5, 18 ->
                        map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("AMR22")).findAny().get());
                default -> map.get(key).setTeam(teams.stream().filter(team -> team.getCar().equals("FW44")).findAny().get());
            }
        }
    }

    private static void addDriverstoList(){
        for (Integer key : map.keySet()) {
            drivers.add(map.get(key));
        }
    }
}
