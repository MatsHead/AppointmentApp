package pl.matshead.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp appointmentTime;
    private Boolean started;
    private Boolean ended;
    private String reason;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
}
