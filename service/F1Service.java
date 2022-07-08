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
        map.put(1,new Driver("1", "Max Verstappen", "Netherlands", 1, null));
        map.put(11,new Driver("11", "Sergio Perez", "Mexico", 0, null));
        map.put(44,new Driver("44", "Lewis Hamilton", "United Kingdom", 7, null));
        map.put(63,new Driver("63", "George Russell", "United Kingdom", 0, null));
        map.put(16,new Driver("16", "Charles Lecrec", "Monaco", 0, null));
        map.put(55,new Driver("55", "Carlos Sainz", "Spain", 0, null));
        map.put(4,new Driver("4", "Lando Norris", "United Kingdom", 0, null));
        map.put(3,new Driver("3", "Daniel Ricciardo", "Australia", 0, null));
        map.put(14,new Driver("14", "Fernando Alonso", "Spain", 2, null));
        map.put(31,new Driver("31", "Esteban Ocon", "France", 0, null));
        map.put(77,new Driver("77", "Valtteri Bottas", "Finland", 0, null));
        map.put(24,new Driver("24", "Zhou Guanyu", "China", 0, null));
        map.put(10,new Driver("10", "Pierre Gasly", "France", 0, null));
        map.put(22,new Driver("22", "Yuki Tsunoda", "Japan", 0, null));
        map.put(47,new Driver("47", "Mick Schumacher", "Germany", 0, null));
        map.put(20,new Driver("20", "Kevin Magnussen", "Denmark", 0, null));
        map.put(5,new Driver("5", "Sebastian Vettel", "Germany", 4, null));
        map.put(18,new Driver("18", "Lance Stroll", "Canada", 0, null));
        map.put(23,new Driver("23", "Alexander Albon", "Thailand", 0, null));
        map.put(6,new Driver("6", "Nicholas Latifi", "Canada", 0, null));
    }

    private static void setDriverstoTeam() {
        teams.forEach(team ->
          team.setDrivers(drivers.stream()
                  .filter(driver -> driver.getTeam().getCar().equals(team.getCar())).collect(Collectors.toList())
          )
        );
    }

    public static void setTeamtoDriver(){
        for (Driver driver :drivers) {
            switch (driver.getNumber()) {
                case "1", "11" ->
                        driver.setTeam(teams.stream().filter(team -> team.getCar().equals("RB18")).findAny().get());
                case "44", "63" ->
                        driver.setTeam(teams.stream().filter(team -> team.getCar().equals("W13")).findAny().get());
                case "16", "55" ->
                        driver.setTeam(teams.stream().filter(team -> team.getCar().equals("F1-75")).findAny().get());
                case "4", "3" ->
                        driver.setTeam(teams.stream().filter(team -> team.getCar().equals("MCL36")).findAny().get());
                case "14", "31" ->
                        driver.setTeam(teams.stream().filter(team -> team.getCar().equals("A522")).findAny().get());
                case "77", "24" ->
                        driver.setTeam(teams.stream().filter(team -> team.getCar().equals("C42")).findAny().get());
                case "10", "22" ->
                        driver.setTeam(teams.stream().filter(team -> team.getCar().equals("AT03")).findAny().get());
                case "47", "20" ->
                        driver.setTeam(teams.stream().filter(team -> team.getCar().equals("VF-22")).findAny().get());
                case "5", "18" ->
                        driver.setTeam(teams.stream().filter(team -> team.getCar().equals("AMR22")).findAny().get());
                default -> driver.setTeam(teams.stream().filter(team -> team.getCar().equals("FW44")).findAny().get());
            }
        }
    }
    private static void addDriverstoList(){
        for (Integer key : map.keySet()) {
            drivers.add(map.get(key));
        }
    }
}
