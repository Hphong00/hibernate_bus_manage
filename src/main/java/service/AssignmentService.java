package service;

import entity.Assignment;
import entity.Driver;
import entity.Route;
import entity.detail.DetailRoute;
import main.Main;
import reponsitory.AssignmentDaoImpl;
import reponsitory.DriverDaoImpl;
import reponsitory.RouteDaoImpl;

import java.util.*;

public class AssignmentService {
    static AssignmentDaoImpl assignmentDao = new AssignmentDaoImpl();
    static DriverDaoImpl driverDao = new DriverDaoImpl();
    static RouteDaoImpl routeDao = new RouteDaoImpl();
    static Map<Driver, ArrayList<DetailRoute>> linkedHashMap;

    public void Assignment() {
        linkedHashMap = new LinkedHashMap<Driver, ArrayList<DetailRoute>>();
    }

    public static void addAssignmentToMap(Driver driver, ArrayList<DetailRoute> detailRouteArrayList) {
        linkedHashMap.put(driver, detailRouteArrayList);
    }
    public List<Assignment> sortAsignmentNameDriver() {
        return assignmentDao.sortAsignmentName();
    }
    public List<Assignment> sortAsignmentNumberRoute() {
        return assignmentDao.sortAsignmentNumber();
    }

    public static void addListAssignment() throws Exception {
        do {
            int numberAssignment = -1;
            try {
                System.out.println("Nhập số lượng phân công lái xe: ");
                numberAssignment = new Scanner(System.in).nextInt();
            } catch (Exception ex) {
                System.out.println("Mời nhập lại: ");
            }
            Driver driver = null;
            for (int i = 0; i < numberAssignment; i++) {
                try {
                    System.out.println("Nhập mã lái xe: ");
                    int idDriver = new Scanner(System.in).nextInt();
                    driver = DriverService.geEntityByIdDriver(idDriver);

                    System.out.println("Nhập số tuyến: ");
                    int numberRoute = new Scanner(System.in).nextInt();
                    ArrayList<DetailRoute> detailRouteArrayList = new ArrayList<DetailRoute>();

                    addDtRouteToArrayList(detailRouteArrayList, numberRoute);

                    addAssignmentToMap(driver, detailRouteArrayList);
                } catch (Exception ex) {
                    System.out.println("Mời nhập lại mã");
                }
            }
            if (driver != null) {
                break;
            }
        } while (true);
    }

    public static void addDtRouteToArrayList(ArrayList<DetailRoute> detailRouteArrayList, int numberRoute) {
        int totalNumberOfTurns = 0;
        double statistical = 0;
        for (int i = 0; i < numberRoute; i++) {
            System.out.println("Nhập mã tuyến");
            int idRoute = new Scanner(System.in).nextInt();
            Route route = RouteService.getEntityByIdRoute(idRoute);
            // chi tiết route
            DetailRoute detailRoute = new DetailRoute();
            detailRoute.inputInformation();
            // add chi tiết route vào arr
            detailRouteArrayList.add(detailRoute);
        }
    }
    public static void sort() {
        int number = 0;
        do {
            try {
                System.out.println("Mời bạn chọn sắp xếp: ");
                System.out.println("1. Theo Họ tên lai xe. ");
                System.out.println("2. Theo Tên số lượng tuyến . ");
                number = new Scanner(System.in).nextInt();
                if (number == 1 || number == 2) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Mời nhập lại: ");
            }
        } while (true);
        if (number == 1) {
            Main.assignmentService.sortAsignmentNameDriver();
        } else if (number == 2) {
            Main.assignmentService.sortAsignmentNumberRoute();
        }
    }
}
