package io.gihub.jonasnascc.HealthClinic.service;

import io.gihub.jonasnascc.HealthClinic.dto.AppointmentDto;
import io.gihub.jonasnascc.HealthClinic.entity.Appointment;
import io.gihub.jonasnascc.HealthClinic.entity.Doctor;
import io.gihub.jonasnascc.HealthClinic.entity.Patient;
import io.gihub.jonasnascc.HealthClinic.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    private final DoctorService doctorService;

    private final PatientService patientService;

    public Long create(AppointmentDto dto){
        return appointmentRepository.save(convertAppointmentDto(dto)).getId();
    }
    public Appointment find(Long id){
        return findAppointment(id);
    }
    public List<Appointment> list(){
        return appointmentRepository.findAll();
    }
    public Long update(Long id, AppointmentDto dto){
        Appointment savedAppointment = findAppointment(id);

        Appointment appointment = convertAppointmentDto(dto);
        appointment.setId(savedAppointment.getId());

        return appointmentRepository.save(appointment).getId();
    }

    @Transactional
    public Appointment delete(Long id){
        Appointment appointment = findAppointment(id);
        appointmentRepository.delete(appointment);

        return appointment;
    }

    private Appointment findAppointment(Long id){
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found."));
    }

    private Appointment convertAppointmentDto(AppointmentDto dto){
        Doctor doctor = doctorService.find(dto.doctorCrm());
        Patient patient = patientService.find(dto.patientCpf());

        return new Appointment(
                dto.scheduledDate(),
                patient,
                doctor,
                dto.exams() != null ? new HashSet<>(dto.exams()) : null
        );
    }
}
