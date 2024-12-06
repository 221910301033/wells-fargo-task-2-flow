package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.FinancialAdvisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialAdvisorRepository extends JpaRepository<FinancialAdvisor, Long> {
}

