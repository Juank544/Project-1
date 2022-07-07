package service;

import model.Driver;
import model.Team;

import java.util.*;
import java.util.stream.Collectors;

public class F1Service {

    public static List<Driver> drivers = new ArrayList<>();
    public static Set<Team> teams = new HashSet<>();

    /*
        Team redB = new Team("Oracle Red Bull Racing",4,"Christian Horner","RB18","Red Bull Powertrains",null);
        Driver ver = new Driver("1","Max Verstappen","Netherlands",1,redB);
        Driver per = new Driver("11","Sergio Perez","Mexico",0,redB);
        redB.setDrivers(List.of(ver,per));
     */
    public static void create() {
        createTeams();
        createDrivers();
        contractDriver();
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
        Driver ver = new Driver("1", "Max Verstappen", "Netherlands", 1, teams.stream().filter(team -> team.getCar().equals("RB18")).findAny().get());
        Driver per = new Driver("11", "Sergio Perez", "Mexico", 0, teams.stream().filter(team -> team.getCar().equals("RB18")).findAny().get());

        Driver ham = new Driver("44", "Lewis Hamilton", "United Kingdom", 7, teams.stream().filter(team -> team.getCar().equals("W13")).findAny().get());
        Driver rus = new Driver("63", "George Russell", "United Kingdom", 0, teams.stream().filter(team -> team.getCar().equals("W13")).findAny().get());

        Driver lec = new Driver("16", "Charles Lecrec", "Monaco", 0, teams.stream().filter(team -> team.getCar().equals("F1-75")).findAny().get());
        Driver sai = new Driver("55", "Carlos Sainz", "Spain", 0, teams.stream().filter(team -> team.getCar().equals("F1-75")).findAny().get());

        Driver nor = new Driver("4", "Lando Norris", "United Kingdom", 0, teams.stream().filter(team -> team.getCar().equals("MCL36")).findAny().get());
        Driver ric = new Driver("3", "Daniel Ricciardo", "Australia", 0, teams.stream().filter(team -> team.getCar().equals("MCL36")).findAny().get());
        Driver alo = new Driver("14", "Fernando Alonso", "Spain", 2, teams.stream().filter(team -> team.getCar().equals("A522")).findAny().get());
        Driver oco = new Driver("31", "Esteban Ocon", "France", 0, teams.stream().filter(team -> team.getCar().equals("A522")).findAny().get());
        Driver bot = new Driver("77", "Valtteri Bottas", "Finland", 0, teams.stream().filter(team -> team.getCar().equals("C42")).findAny().get());
        Driver zho = new Driver("24", "Zhou Guanyu", "China", 0, teams.stream().filter(team -> team.getCar().equals("C42")).findAny().get());
        Driver gas = new Driver("10", "Pierre Gasly", "France", 0, teams.stream().filter(team -> team.getCar().equals("AT03")).findAny().get());
        Driver tsu = new Driver("22", "Yuki Tsunoda", "Japan", 0, teams.stream().filter(team -> team.getCar().equals("AT03")).findAny().get());
        Driver msc = new Driver("47", "Mick Schumacher", "Germany", 0, teams.stream().filter(team -> team.getCar().equals("VF-22")).findAny().get());
        Driver mag = new Driver("20", "Kevin Magnussen", "Denmark", 0, teams.stream().filter(team -> team.getCar().equals("VF-22")).findAny().get());
        Driver vet = new Driver("5", "Sebastian Vettel", "Germany", 4, teams.stream().filter(team -> team.getCar().equals("AMR22")).findAny().get());
        Driver str = new Driver("18", "Lance Stroll", "Canada", 0, teams.stream().filter(team -> team.getCar().equals("AMR22")).findAny().get());
        Driver alb = new Driver("23", "Alexander Albon", "Thailand", 0, teams.stream().filter(team -> team.getCar().equals("FW44")).findAny().get());
        Driver lat = new Driver("6", "Nicholas Latifi", "Canada", 0, teams.stream().filter(team -> team.getCar().equals("FW44")).findAny().get());
        drivers.addAll(Arrays.asList(ver, per, ham, rus, lec, sai, nor, ric, alo, oco, bot, zho, gas, tsu, msc, mag, vet, str, alb, lat));
    }

    public static void contractDriver() {
        teams.forEach(team ->
          team.setDrivers(drivers.stream()
                  .filter(driver -> driver.getTeam().getCar().equals(team.getCar())).collect(Collectors.toList())
          )
        );
    }
}
