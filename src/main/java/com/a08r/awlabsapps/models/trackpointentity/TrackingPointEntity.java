package com.a08r.awlabsapps.models.trackpointentity;


import jakarta.persistence.*;
import lombok.*;





@Entity
@Table(name = "Track_break_locations")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TrackingPointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "sector_name")
    private String sectorName;
    @Column(name = "lab_name")
    private String labName;
    @Column(name = "lab_code")
    private int labCode;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "break_id")
    private int breakId;
    @Column(name = "break_date")
    private String breakDate;
    @Column(name = "break_time")
    private String breakTime;
    @Column(name = "location_x")
    private double locationX;
    @Column(name = "location_y")
    private double locationY;

}

