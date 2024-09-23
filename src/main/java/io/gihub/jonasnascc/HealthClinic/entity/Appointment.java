package io.gihub.jonasnascc.HealthClinic.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime scheduledDate;

    @ManyToOne
    @JsonIgnore
    private Patient patient;

    @ManyToOne
    @JsonIgnore
    private Doctor doctor;

    @ManyToMany
    private Set<Exam> exams;

    public Appointment(LocalDateTime scheduledDate, Patient patient, Doctor doctor, Set<Exam> exams) {
        this.scheduledDate = scheduledDate;
        this.patient = patient;
        this.doctor = doctor;
        this.exams = exams;
    }
}
