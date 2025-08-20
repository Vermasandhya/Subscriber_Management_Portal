package com.subscriber.planservice.repository;

import com.subscriber.planservice.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
