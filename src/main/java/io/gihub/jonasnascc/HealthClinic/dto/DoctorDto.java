package io.gihub.jonasnascc.HealthClinic.dto;

public record DoctorDto(
   String crm,
   String cnpj,
   String name,
   String surname,
   String email,
   String phone,
   String address
) {}
