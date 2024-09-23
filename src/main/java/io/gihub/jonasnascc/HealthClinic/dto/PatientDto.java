package io.gihub.jonasnascc.HealthClinic.dto;

public record PatientDto(
   String cpf,
   String firstName,
   String lastName,
   String email,
   String phone,
   String address
) {}
