package entity;

import entity.inputInfo.InputInformation;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

@Data
@Entity
@Table(name = "driver")
public class Driver implements Serializable, InputInformation {
    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    private static final String D = "D";
    private static final String E = "E";
    private static final String F = "F";
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID",nullable = false)
    private int id;
    @Basic
    @Column(name = "FULLNAME",nullable = false)
    private String fullname;
    @Basic
    @Column(name = "ADDRESS")
    private String address;
    @Basic
    @Column(name = "PHONE")
    private String phone;
    @Basic
    @Column(name = "LEVELE")
    private String levele;

    @Override
    public void inputInformation() {
        System.out.println("Nhập họ tên");
        fullname = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ");
        address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại");
        phone = new Scanner(System.in).nextLine();
        System.out.println("Nhâp loại trình độ: ");
        levelChoose();
    }

    public void levelChoose() {
        int s = 0;
        do {
            System.out.println("1-6. A-F");
            try {
                Scanner scanner = new Scanner(System.in);
                s = scanner.nextInt();
                if (s <= 6 && s >= 1) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Mời Nhập lại:");
            }
        } while (true);
        switch (s) {
            case 1:
                this.levele = Driver.A;
                break;
            case 2:
                this.levele = Driver.B;
                break;
            case 3:
                this.levele = Driver.C;
                break;
            case 4:
                this.levele = Driver.D;
                break;
            case 5:
                this.levele = Driver.E;
                break;
            case 6:
                this.levele = Driver.F;
                break;
        }
    }
}
