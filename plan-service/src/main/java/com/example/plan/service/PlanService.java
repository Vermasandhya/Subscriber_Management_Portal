package com.example.plan.service;

import com.example.plan.model.Plan;
import com.example.plan.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Plan getPlanById(Long id) {
        return planRepository.findById(id).orElse(null);
    }

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan updatePlan(Long id, Plan plan) {
        Optional<Plan> existing = planRepository.findById(id);
        if(existing.isPresent()) {
            Plan p = existing.get();
            p.setName(plan.getName());
            p.setPrice(plan.getPrice());
            p.setDescription(plan.getDescription());
            return planRepository.save(p);
        }
        return null;
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}
