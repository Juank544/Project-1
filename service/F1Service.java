package service;

import model.Driver;
import model.Team;

import java.util.*;
import java.util.stream.Collectors;

public class F1Service {

    public static List<Driver> drivers = new ArrayList<>();
    public static Set<Team> teams = new HashSet<>();

    public static void create() {
        createTeams();
        createDrivers();
        setTeamtoDriver();
        setDriverstoTeam();
    }

    private static void createTeams() {
        var redB = new Team("Oracle Red Bull Racing", 4, "Christian Horner", "RB18", "Red Bull Powertrains", null);
        Team mercedes = new Team("Mercedes-AMG Petronas F1 Team", 8, "Toto Wolf", "W13", "Mercedes", null);
        Team ferrari = new Team("Scuderia Ferrari", 16, "Mattia Binotto", "F1-75", "Ferrari", null);
        Team mclaren = new Team("Mclaren F1 Team", 8, "Andreas Seidl", "MCL36", "Mercedes", null);
        Team alpine = new Team("BWT Alpine F1 Team", 2, "Otmar Szafnauer", "A522", "Renault", null);
        Team alfaR = new Team("Alfa Romeo F1 Team ORLEN", 0, "Frederic Vasseur", "C42", "Ferrari", null);
        Team alphaT = new Team("Scuderia AlphaTauri", 0, "Franz Tost", "AT03", "Red Bull Powertrains", null);
        Team hass = new Team("Hass F1 Team", 0, "Frederic Vasseur", "VF-22", "Ferrari", null);
        Team astonM = new Team("Aston Martin Aramco Cognizant F1 Team", 0, "Mike Krack", "AMR22", "Mercedes", null);
        teams.add(new Team("Williams Racing", 9, "Jost Capito", "FW44", "Mercedes", null));
        teams.addAll(Arrays.asList(redB, mercedes, ferrari, mclaren, alpine, alfaR, alphaT, hass, astonM));
    }

    private static void createDrivers() {
        Driver ver = new Driver("1", "Max Verstappen", "Netherlands", 1, null);
        Driver per = new Driver("11", "Sergio Perez", "Mexico", 0, null);
        Driver ham = new Driver("44", "Lewis Hamilton", "United Kingdom", 7, null);
        Driver rus = new Driver("63", "George Russell", "United Kingdom", 0, null);
        Driver lec = new Driver("16", "Charles Lecrec", "Monaco", 0, null);
        Driver sai = new Driver("55", "Carlos Sainz", "Spain", 0, null);
        Driver nor = new Driver("4", "Lando Norris", "United Kingdom", 0, null);
        Driver ric = new Driver("3", "Daniel Ricciardo", "Australia", 0, null);
        Driver alo = new Driver("14", "Fernando Alonso", "Spain", 2, null);
        Driver oco = new Driver("31", "Esteban Ocon", "France", 0, null);
        Driver bot = new Driver("77", "Valtteri Bottas", "Finland", 0, null);
        Driver zho = new Driver("24", "Zhou Guanyu", "China", 0, null);
        Driver gas = new Driver("10", "Pierre Gasly", "France", 0, null);
        Driver tsu = new Driver("22", "Yuki Tsunoda", "Japan", 0, null);
        Driver msc = new Driver("47", "Mick Schumacher", "Germany", 0, null);
        Driver mag = new Driver("20", "Kevin Magnussen", "Denmark", 0, null);
        Driver vet = new Driver("5", "Sebastian Vettel", "Germany", 4, null);
        Driver str = new Driver("18", "Lance Stroll", "Canada", 0, null);
        Driver alb = new Driver("23", "Alexander Albon", "Thailand", 0, null);
        Driver lat = new Driver("6", "Nicholas Latifi", "Canada", 0, null);
        drivers.addAll(Arrays.asList(ver, per, ham, rus, lec, sai, nor, ric, alo, oco, bot, zho, gas, tsu, msc, mag, vet, str, alb, lat));
    }

    public static void setDriverstoTeam() {
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
}
