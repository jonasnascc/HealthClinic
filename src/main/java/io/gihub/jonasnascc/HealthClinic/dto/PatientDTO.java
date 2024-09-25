package io.gihub.jonasnascc.HealthClinic.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public record PatientDTO(
    @CPF(message = "CPF format is invalid.")
    @NotBlank(message = "CPF must not be empty.")
    @NotNull(message = "CPF must not be null.")
    String cpf,
    @Length(min = 3, max = 50, message = "First name must have 3 to 50 characters.")
    @NotBlank(message = "First name must not be empty.")
    @NotNull(message = "First name must not be null.")
    String firstName,
    @Length(min = 3, max = 50, message = "Last name must have 3 to 50 characters.")
    @NotBlank(message = "Last name must not be empty.")
    @NotNull(message = "Last name must not be null.")
    String lastName,
    @Email(message = "Email address format is invalid.")
    @NotBlank(message = "Email address must not be empty.")
    @NotNull(message = "Email must not be null.")
    String email,

    @Length(min = 11, max = 11, message = "Phone number must have 11 numbers.")
    @NotBlank(message = "Phone number must not be empty.")
    @NotNull(message = "Phone number must not be null.")
    String phone,
    @NotBlank(message = "Address must not be empty.")
    @NotNull(message = "Address must not be null.")
    String address
) {}
