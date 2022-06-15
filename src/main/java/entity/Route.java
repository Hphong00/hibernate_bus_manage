package entity;

import entity.inputInfo.InputInformation;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Scanner;
@Data
@Entity(name = "Route")
@Table(name ="Route")
public class Route implements Serializable, InputInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Basic
    @Column(name = "DISTANCE",nullable = false)
    private int distance;
    @Basic
    @Column(name = "NUMBEROFSTOPS")
    private int numberofstops;

    @Override
    public void inputInformation() {
    }
}
