package com.acme.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "PatientDisasterStatus")
public class PatientDisasterStatus implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -801170488594839477L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name = "disasterId", referencedColumnName = "id")
    private Disaster disaster;

    @Column(nullable = false)
    private LocalDateTime date;
    
    @OneToOne
    @JoinColumn(name = "statusId", referencedColumnName = "id")
    private PatientStatus patientStatus;

}