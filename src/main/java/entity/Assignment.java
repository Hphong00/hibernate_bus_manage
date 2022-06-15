package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;
@Data
@Entity
public class Assignment implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID",nullable = false)
    private int id;
    @Basic
    @Column(name = "DRIVER_ID",nullable = false)
    private int driverId;
    @Basic
    @Column(name = "DRIVER_FULLNAME")
    private String driverFullname;
    @Basic
    @Column(name = "DRIVER_ADDRESS")
    private String driverAddress;
    @Basic
    @Column(name = "DRIVER_PHONE")
    private String driverPhone;
    @Basic
    @Column(name = "DRIVER_LEVELE")
    private String driverLevele;
    @Basic
    @Column(name = "DETAIL_ROUTE",nullable = false)
    private int detailRoute;
    @Basic
    @Column(name = "ROUTE_ID")
    private int routeId;
    @Basic
    @Column(name = "ROUTE_DISTANCE")
    private int routeDistance;
    @Basic
    @Column(name = "ROUTE_NUMBEROFSTOPS")
    private int routeNumberofstops;
    @Basic
    @Column(name = "NUMBEROFTURNS",nullable = false)
    private int numberofturns;
}
