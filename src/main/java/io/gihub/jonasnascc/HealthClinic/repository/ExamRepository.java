package io.gihub.jonasnascc.HealthClinic.repository;

import io.gihub.jonasnascc.HealthClinic.entity.Exam;
import io.gihub.jonasnascc.HealthClinic.entity.ExamType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
