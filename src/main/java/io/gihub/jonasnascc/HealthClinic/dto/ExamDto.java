package io.gihub.jonasnascc.HealthClinic.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ExamDto(
        String description,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm") LocalDateTime date,
        String results,

        String examType,

        Long appointmentCode
) {}
