package io.gihub.jonasnascc.HealthClinic.service;

import io.gihub.jonasnascc.HealthClinic.dto.ExamDto;
import io.gihub.jonasnascc.HealthClinic.entity.Appointment;
import io.gihub.jonasnascc.HealthClinic.entity.EnumTypes.ExamStatus;
import io.gihub.jonasnascc.HealthClinic.entity.Exam;
import io.gihub.jonasnascc.HealthClinic.entity.ExamType;
import io.gihub.jonasnascc.HealthClinic.repository.ExamRepository;
import io.gihub.jonasnascc.HealthClinic.repository.ExamTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    private final AppointmentService appointmentService;

    private final ExamTypeRepository examTypeRepository;

    public Long create(ExamDto dto){
        return examRepository.save(convertExamDto(dto)).getId();
    }
    public Exam find(Long id){
        return findExam(id);
    }
    public List<Exam> list(){
        return examRepository.findAll();
    }
    public Long update(Long id, ExamDto dto){
        Exam saved = findExam(id);

        Exam exam = convertExamDto(dto);
        exam.setId(saved.getId());

        return examRepository.save(exam).getId();
    }
    public Exam delete(Long id){
        Exam exam = findExam(id);
        examRepository.delete(exam);
        return exam;
    }

    private Exam findExam(Long id){
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found."));
    }

    private Exam convertExamDto(ExamDto dto) {
        Appointment appointment = appointmentService.find(dto.appointmentCode());

        ExamType examType = examTypeRepository.findById(dto.examType())
                .orElseThrow(() -> new RuntimeException("ExamType not found."));

        return new Exam(
                dto.description(),
                dto.date(),
                dto.results(),
                ExamStatus.SCHEDULED,
                examType,
                appointment
        );
    }
}
