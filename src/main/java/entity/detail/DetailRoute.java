package entity.detail;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
@Data
@Entity
public class DetailRoute implements Serializable {
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
}
