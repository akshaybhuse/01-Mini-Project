package in.akshay.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.akshay.entity.Plan;
import in.akshay.entity.PlanCategory;
import in.akshay.repo.PlanCategoryRepo;
import in.akshay.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> categories = planCategoryRepo.findAll();

		Map<Integer, String> categoryMap = new HashMap<>();

		categories.forEach(category -> {
			categoryMap.put(category.getCategoryID(), category.getCategoryName());
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan savePlan = planRepo.save(plan);

		/*if (savePlan.getPlanID() != null) {
			return true;
		} else
			return false;*/

		/*return savePlan.getPlanID() != null;*/

		return savePlan.getPlanID() != null ? true : false;
	}

	@Override
	public List<Plan> getAllPlans() {
		List<Plan> allPlans = planRepo.findAll();

		return allPlans;

	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;

	}

	@Override
	public boolean updatePlan(Plan plan) {
		planRepo.save(plan);
		return plan.getPlanID() != null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {

		boolean status = false;
		try {
			planRepo.deleteById(planId);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean chnagePlanStatus(Integer planId, String status) {
		Optional<Plan> findById = planRepo.findById(planId);

		if (findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSW(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
