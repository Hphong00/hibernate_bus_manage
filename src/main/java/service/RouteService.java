package service;

import entity.Driver;
import entity.Route;
import main.Main;
import reponsitory.DriverDaoImpl;
import reponsitory.RouteDaoImpl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RouteService implements Serializable {
    static RouteDaoImpl routeDao = new RouteDaoImpl();
    private static ArrayList<Route> routeArrayList = new ArrayList<Route>();
    public static void addRoute() throws IOException {
        System.out.println("Nhập số tuyến: ");
        do {
            int numberRoute = -1;
            Route route = null;
            try {
                numberRoute = new Scanner(System.in).nextInt();
            } catch (Exception ex) {
                System.out.println("Mời nhập lại ");
            }
            for (int i = 0; i < numberRoute; i++) {
                route = new Route();
                route.inputInformation();
                routeArrayList.add(route);
                addRoute(route);
            }
            if (route != null) {
                break;
            }
        } while (true);
        System.out.println("---------");
        getAllRoute();
        System.out.println("---------");
    }
    public static List<Route> getAllRoute() {return routeDao.getAll();}
    public Route geEntityByIdRoute(int id) {return  routeDao.geEntityById(id);}
    public static boolean addRoute(Route route) { return routeDao.add(route);}
    public boolean updateRoute(Route route) {return routeDao.update(route);}
    public boolean deleteRoute(int id) {return routeDao.delete(id);}

}
