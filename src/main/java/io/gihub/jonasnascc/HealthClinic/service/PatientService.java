package io.gihub.jonasnascc.HealthClinic.service;

import io.gihub.jonasnascc.HealthClinic.dto.PatientDTO;
import io.gihub.jonasnascc.HealthClinic.entity.Patient;
import io.gihub.jonasnascc.HealthClinic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public String create(PatientDTO dto){
        Optional<Patient> optPatient = patientRepository
                .findByCpf(dto.cpf());
        if(optPatient.isPresent()) throw new RuntimeException("Patient already exists in database.");

        Patient patient = convertPatientDto(dto);

        return patientRepository.save(patient).getId();
    }
    public Patient find(String cpf){
        return findPatient(cpf);
    }

    public List<Patient> list(){
        return patientRepository.findAll();
    }
    public Patient update(String cpf, PatientDTO dto){
        Patient savedPatient = findPatient(cpf);

        Patient patient = convertPatientDto(dto);
        patient.setId(savedPatient.getId());

        return patientRepository.save(patient);
    }

    public Patient delete(String cpf){
        Patient patient = findPatient(cpf);
        patientRepository.delete(patient);
        return patient;
    }

    public static Patient convertPatientDto(PatientDTO dto) {
        return new Patient(
                dto.cpf(),
                dto.firstName(),
                dto.lastName(),
                dto.email(),
                dto.phone(),
                dto.address()
        );
    }

    private Patient findPatient(String cpf) {
        return patientRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}
