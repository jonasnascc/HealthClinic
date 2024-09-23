package io.gihub.jonasnascc.HealthClinic.repository;

import io.gihub.jonasnascc.HealthClinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    Optional<Patient> findByCpf(String cpf);
}
