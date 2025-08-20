package com.subscriber.planservice.service;

import com.subscriber.planservice.entity.Plan;
import java.util.List;

public interface PlanService {

    Plan createPlan(Plan plan);

    Plan getPlanById(Long id);

    List<Plan> getAllPlans();

    Plan updatePlan(Long id, Plan planDetails);

    void deletePlan(Long id);
}
