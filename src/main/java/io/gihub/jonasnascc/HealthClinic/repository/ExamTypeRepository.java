package io.gihub.jonasnascc.HealthClinic.repository;

import io.gihub.jonasnascc.HealthClinic.entity.ExamType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTypeRepository extends JpaRepository<ExamType, String> {
}
