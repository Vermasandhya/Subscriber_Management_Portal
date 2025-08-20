package com.subscriber.planservice.service.impl;

import com.subscriber.planservice.entity.Plan;
import com.subscriber.planservice.repository.PlanRepository;
import com.subscriber.planservice.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan getPlanById(Long id) {
        return planRepository.findById(id).orElse(null);
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public Plan updatePlan(Long id, Plan planDetails) {
        Plan plan = getPlanById(id);
        if (plan != null) {
            plan.setPlanName(planDetails.getPlanName());
            plan.setPlanType(planDetails.getPlanType());
            plan.setPrice(planDetails.getPrice());
            plan.setDataLimitGb(planDetails.getDataLimitGb());
            plan.setValidityDays(planDetails.getValidityDays());
            return planRepository.save(plan);
        }
        return null;
    }

    @Override
    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}
