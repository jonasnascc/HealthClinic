package io.gihub.jonasnascc.HealthClinic.dto;

import io.gihub.jonasnascc.HealthClinic.entity.EnumTypes.ExamStatus;

public record ExamStatusDto(
   ExamStatus status
) {}
