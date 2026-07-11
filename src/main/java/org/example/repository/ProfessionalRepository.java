package org.example.repository;

import org.example.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    boolean existsByEmail(String email);
    Professional findByEmail(String email);
}
