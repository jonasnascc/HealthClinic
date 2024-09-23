package io.gihub.jonasnascc.HealthClinic.service;

import io.gihub.jonasnascc.HealthClinic.dto.DoctorDto;
import io.gihub.jonasnascc.HealthClinic.entity.Doctor;
import io.gihub.jonasnascc.HealthClinic.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public String create(DoctorDto dto){
        Optional<Doctor> optDoctor = doctorRepository
                .findByCrm(dto.crm());

        if(optDoctor.isPresent()) throw new RuntimeException("Doctor already exists");

        return doctorRepository.save(convertDoctorDto(dto)).getId();
    }
    public Doctor find(String crm){
        return findDoctor(crm);
    }
    public List<Doctor> list(){
        return doctorRepository.findAll();
    }
    public String update(String crm, DoctorDto dto){
        Doctor savedDoctor = findDoctor(crm);

        Doctor doctor = convertDoctorDto(dto);
        doctor.setId(savedDoctor.getId());

        return doctorRepository.save(doctor).getCrm();
    }
    public Doctor delete(String crm){
        Doctor doctor = findDoctor(crm);

        doctorRepository.delete(doctor);

        return doctor;
    }

    private Doctor convertDoctorDto(DoctorDto dto){
        return new Doctor(
                dto.crm(),
                dto.cnpj(),
                dto.name(),
                dto.surname(),
                dto.email(),
                dto.phone(),
                dto.address()
        );
    }

    private Doctor findDoctor(String crm){
        return doctorRepository.findByCrm(crm)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
}
