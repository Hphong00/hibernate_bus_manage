package entity;

import entity.inputInfo.InputInformation;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "driver")
public class Driver implements Serializable, InputInformation {
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
    }
}
