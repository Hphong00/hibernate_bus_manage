package service;

import entity.Assignment;
import entity.Driver;
import entity.Route;
import entity.detail.DetailRoute;
import main.Main;
import org.hibernate.query.Query;
import reponsitory.AssignmentDaoImpl;
import reponsitory.DetailRouteDaoImpl;
import reponsitory.DriverDaoImpl;
import reponsitory.RouteDaoImpl;
import util.HibernateUtil;

import java.sql.PreparedStatement;
import java.util.*;

public class AssignmentService {
    static AssignmentDaoImpl assignmentDao = new AssignmentDaoImpl();
    static DetailRouteDaoImpl detailRouteDao = new DetailRouteDaoImpl();
    static DriverDaoImpl driverDao = new DriverDaoImpl();
    static RouteDaoImpl routeDao = new RouteDaoImpl();

    static  Assignment assignment = new Assignment();
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
                    // set thuộc tính vì 2 thuộc tính khác nhau
                    assignment.setDriverId(driver.getId());
                    assignment.setDriverFullname(driver.getFullname());
                    assignment.setDriverAddress(driver.getAddress());
                    assignment.setDriverPhone(driver.getPhone());
                    assignment.setDriverLevele(driver.getLevele());

                    System.out.println("Nhập số tuyến: ");
                    int numberRoute = new Scanner(System.in).nextInt();
                    ArrayList<DetailRoute> detailRouteArrayList = new ArrayList<DetailRoute>();
                    addDtRouteToArrayList(detailRouteArrayList, numberRoute);
                    // add vô data
                    System.out.println("aaaaa");
                    assignmentDao.add(assignment);
                    assignmentDao.getAll();
                } catch (Exception ex) {
                    System.out.println("Mời nhập lại mã");
                }
            }
            if (driver != null) {
                break;
            }
        } while (true);
    }

    public static void addDtRouteToArrayList(ArrayList<DetailRoute> detailRouteArrayList,int numberRoute) {
        for (int i = 0; i < numberRoute; i++) {
            System.out.println("Nhập mã tuyến");
            int idRoute = new Scanner(System.in).nextInt();
            Route route = RouteService.getEntityByIdRoute(idRoute);
            // chi tiết route
            DetailRoute detailRoute = new DetailRoute();
            detailRoute.inputInformation();
            // add chi tiết route vào arr
            detailRouteArrayList.add(detailRoute);
            // set gia trị vì tên thuộc tính 2 bảng khác nhau
            detailRoute.setRouteId(route.getId());
            detailRoute.setRouteDistance(route.getDistance());
            detailRoute.setRouteNumberofstops(route.getNumberofstops());

            detailRouteDao.add(detailRoute);
            detailRouteDao.getAll();

            // set giá trị cho assignment
            assignment.setDetailRoute(detailRoute.getId());
            assignment.setRouteId(route.getId());
            assignment.setRouteDistance(route.getDistance());
            assignment.setRouteNumberofstops(route.getNumberofstops());
            assignment.setNumberofturns(detailRoute.getNumberofturns());
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
