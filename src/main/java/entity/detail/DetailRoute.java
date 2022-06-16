package entity.detail;

import entity.inputInfo.InputInformation;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Scanner;

@Data
@Entity
public class DetailRoute implements Serializable, InputInformation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
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
    @Column(name = "NUMBEROFTURNS")
    private int numberofturns;

    @Override
    public void inputInformation() {
        try {
            System.out.println("Nhập số lượt: ");
            numberofturns = new Scanner(System.in).nextInt();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
