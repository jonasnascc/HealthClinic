package io.gihub.jonasnascc.HealthClinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gihub.jonasnascc.HealthClinic.entity.EnumTypes.ExamStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exam {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private LocalDateTime date;

    private String results;

    @Enumerated(value = EnumType.STRING)
    private ExamStatus status;

    @OneToOne
    private ExamType examType;

    @ManyToOne
    private Appointment appointment;

    public Exam(String description,
                LocalDateTime date,
                String results,
                ExamStatus status,
                ExamType examType,
                Appointment appointment) {
        this.description = description;
        this.date = date;
        this.results = results;
        this.status = status;
        this.examType = examType;
        this.appointment = appointment;
    }
}
