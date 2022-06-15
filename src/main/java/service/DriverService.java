package service;

import entity.Driver;
import entity.Route;
import reponsitory.DriverDaoImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverService {
    public static DriverDaoImpl driverDao = new DriverDaoImpl();
    private static ArrayList<Driver> driverArrayList;

    public void DriverService() {
        driverArrayList = new ArrayList<Driver>();
    }
    public static void addDriver() throws IOException {
        System.out.println("Nhập số người lái: ");
        do {
            int numberDriver = -1;
            Driver driver = null;
            try {
                numberDriver = new Scanner(System.in).nextInt();
            } catch (Exception ex) {
                System.out.println("Mời nhập lại ");
            }
            for (int i = 0; i < numberDriver; i++) {
                driver = new Driver();
                driver.inputInformation();
                driverArrayList.add(driver);
                addDriver(driver);
            }
            if (driver != null) {
                break;
            }
        } while (true);
        System.out.println("---------");
        getListDriver();
        System.out.println("---------");
    }
    public static List<Driver> getListDriver() {
        return driverDao.getAll();
    }
    public static Driver geEntityByIdDriver(int id) {return  driverDao.geEntityById(id);}
    public static boolean addDriver(Driver driver) { return driverDao.add(driver);}
    public boolean updateDriver(Driver driver) {return driverDao.update(driver);}
    public boolean deleteDriver(int id) {return driverDao.delete(id);}

}
