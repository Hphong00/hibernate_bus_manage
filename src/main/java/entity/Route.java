package entity;

import entity.inputInfo.InputInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Route(int distance, int numberofstops) {
        this.distance = distance;
        this.numberofstops = numberofstops;
    }

    public Route() {

    }

    @Override
    public void inputInformation() {
        try {
            System.out.println("Nhâp khoảng cách: ");
            distance = new Scanner(System.in).nextInt();
            System.out.println("Nhập điểm dừng: ");
            numberofstops = new  Scanner(System.in).nextInt();
        }catch (Exception ex){
            System.out.println("Mời nhập lại: ");
        }
    }
}
