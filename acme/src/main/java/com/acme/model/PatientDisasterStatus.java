package com.acme.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "PatientDisasterStatus")
public class PatientDisasterStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    private Patient patient;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "disasterId", referencedColumnName = "id")
    private Disaster disaster;

    @Column(nullable = false)
    private Date date;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "statusId", referencedColumnName = "id")
    private PatientStatus patientStatus;

}