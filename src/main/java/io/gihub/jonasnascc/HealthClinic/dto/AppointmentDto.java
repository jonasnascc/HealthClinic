package io.gihub.jonasnascc.HealthClinic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.gihub.jonasnascc.HealthClinic.entity.Exam;

import java.time.LocalDateTime;
import java.util.List;

public record AppointmentDto(
   String patientCpf,
   String doctorCrm,
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm") LocalDateTime scheduledDate,
   List<Exam> exams
) {}