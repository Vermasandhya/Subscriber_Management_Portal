package com.example.plan.controller;

import com.example.plan.model.Plan;
import com.example.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public Plan getPlan(@PathVariable Long id) {
        return planService.getPlanById(id);
    }

    @PostMapping
    public Plan createPlan(@RequestBody Plan plan) {
        return planService.createPlan(plan);
    }

    @PutMapping("/{id}")
    public Plan updatePlan(@PathVariable Long id, @RequestBody Plan plan) {
        return planService.updatePlan(id, plan);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
    }
}
