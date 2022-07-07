import model.Driver;
import model.Team;
import service.F1Service;

import java.util.Iterator;
import java.util.List;

public class App {
    public static void main(String[] args) {

        F1Service.create();
//        for (Team team : F1Service.teams) {
//            System.out.println(team.getName());
//        }
//
//        System.out.println("===========================================");
//
//        for (Driver driver:F1Service.drivers) {
//            System.out.println(driver.getName()+"---"+driver.getTeam().getName());
//        }

        for (Team team: F1Service.teams){
            System.out.println(team.getName()); //TODO Implementarlo con un toString() y que imprima lo mismo en consola
            //TODO porque es importante el hashcode
            //TODO implementar algo en este proyecto con hashmap y set

            List<Driver> teamDrivers = team.getDrivers();
            Iterator<Driver> iterator = teamDrivers.iterator();

            while (iterator.hasNext()){
                System.out.println(iterator.next().getName());
            }

            System.out.println("=======================");
        }

    }
}