import model.Driver;
import model.Team;
import service.F1Service;

//TODO porque es importante el hashcode
//TODO implementar algo en este proyecto con hashmap y set
//TODO Implementarlo con un toString() y que imprima lo mismo en consola
public class App {
    public static void main(String[] args) {

        F1Service.create();
//        for (Driver driver:F1Service.drivers) {
//            System.out.println(driver.getName()+"---"+driver.getTeam().getName());
//        }

        for (String key:F1Service.teams.keySet()) {
            System.out.println(F1Service.teams.get(key));
        }

        System.out.println("tamaño lista drivers: "+F1Service.drivers.size());
        System.out.println("tamaño map teams: "+F1Service.teams.size());
        System.out.println("tamaño map: "+F1Service.map.size());
    }
}
