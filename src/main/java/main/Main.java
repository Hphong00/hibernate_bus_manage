package main;

import entity.Assignment;
import entity.detail.DetailRoute;
import reponsitory.AssignmentDaoImpl;
//import reponsitory.DetailRouteDaoImpl;
import reponsitory.RouteDaoImpl;
import service.AssignmentService;
import service.DriverService;
import service.RouteService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static DriverService driverService = new DriverService();
    public static RouteService routeService = new RouteService();
    public static DetailRoute detailRoute = new DetailRoute();
    public static AssignmentService assignmentService = new AssignmentService();

    public static void main(String[] args) throws Exception {
//        DetailRouteDaoImpl detailRouteDao = new DetailRouteDaoImpl();
//        detailRouteDao.getAll();
//        detailRouteDao.geEntityById(101);
//        detailRouteDao.delete(101);

        sMenu();
        select();
    }

    private static void select() throws Exception {
        boolean cont = true;
        do {
            System.out.print("Mời bạn chọn: ");
            int number = 0;
            try {
                number = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Moi nhap lai: ");
            }
            switch (number) {
                case 1:
                    DriverService.addDriver();
                    sMenu();
                    break;
                case 2:
                    DriverService.getListDriver();
                    sMenu();
                    break;
                case 3:
                    RouteService.addRoute();
                    sMenu();
                    break;
                case 4:
                    RouteService.getAllRoute();
                    sMenu();
                    break;
                case 5:
                    AssignmentService.addListAssignment();
                    sMenu();
                    break;
                case 6:
                    AssignmentService.sort();
                    sMenu();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (cont);
    }

    private static void sMenu() {
        System.out.println("---Quản lý lái xe--");
        System.out.println("1. Nhập danh sách lái xe. ");
        System.out.println("2. Xem list lái xe. ");
        System.out.println("3. Nhập danh sách tuyến. ");
        System.out.println("4. Xem list tuyến. ");
        System.out.println("5. Nhập danh sách phân công. ");
        System.out.println("6. Sắp xếp. ");
        System.out.println("7. Thoát. ");
    }
}
