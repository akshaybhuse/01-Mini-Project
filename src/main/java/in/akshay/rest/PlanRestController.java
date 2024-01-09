package in.akshay.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.akshay.entity.Plan;
import in.akshay.service.PlanService;

@RestController
public class PlanRestController {

	@Autowired
	private PlanService planService;

	@GetMapping("/plan-categories")
	public ResponseEntity<Map<Integer, String>> getPlanCategories() {
		Map<Integer, String> planCategories = planService.getPlanCategories();
		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}

	@PostMapping("/save-plane")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		boolean isPlanSaved = planService.savePlan(plan);

		String responseMsg = "";
		if (isPlanSaved)
			responseMsg = "Plan Saved Successfully...";
		else
			responseMsg = "Plan Not Saved.";
		return new ResponseEntity<>(responseMsg, HttpStatus.OK);
	}

	@GetMapping("/get-all-plans")
	public ResponseEntity<List<Plan>> getAllPlans() {
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
	}

	@GetMapping("/get-plan-by-id/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
		Plan planById = planService.getPlanById(planId);

		return new ResponseEntity<>(planById, HttpStatus.OK);
	}

	@PutMapping("/update-plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
		boolean isPlanUpdated = planService.updatePlan(plan);

		String msg = "";
		if (isPlanUpdated)
			msg = "Plan updated Successfully...";
		else
			msg = "Plan not updated.";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/delete-plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		boolean isDeleted = planService.deletePlanById(planId);

		String msg = " ";

		if (isDeleted)
			msg = "Plan deleted successfully...";
		else
			msg = "Plan not deleted.";

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer planId, @PathVariable String status) {
		boolean isStatusChanged = planService.chnagePlanStatus(planId, status);
		String msg = "";
		if (isStatusChanged)
			msg = "Status is changed...";
		else
			msg = "Status not changed.";

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
