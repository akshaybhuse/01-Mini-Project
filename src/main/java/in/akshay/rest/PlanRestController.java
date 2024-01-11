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

import in.akshay.constants.AppConstants;
import in.akshay.entity.Plan;
import in.akshay.props.AppProperties;
import in.akshay.service.PlanService;

@RestController
public class PlanRestController {

	
	private PlanService planService;
	
	
	private Map<String, String> messages;
	
	

	public PlanRestController(PlanService planService, AppProperties appProperties) {
		super();
		this.planService = planService;
		this.messages = appProperties.getMessages();
		System.out.println(messages);
	}

	@GetMapping("/plan-categories")
	public ResponseEntity<Map<Integer, String>> getPlanCategories() {
		Map<Integer, String> planCategories = planService.getPlanCategories();
		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}

	@PostMapping("/save-plane")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		
		//Map<String, String> messages = appProperties.getMessagesMap();
		boolean isPlanSaved = planService.savePlan(plan);

		//String responseMsg = "";
		String responseMsg = AppConstants.EMPTY_STR;
		if (isPlanSaved)
			responseMsg = messages.get(AppConstants.PLAN_SAVE_SUCC);
		else
			responseMsg = messages.get(AppConstants.PLAN_SAVE_FAIL);
		
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

		String msg = AppConstants.EMPTY_STR;
		if (isPlanUpdated)
			msg = messages.get(AppConstants.PLAN_UPDATE_SUCC);
		else
			msg = messages.get(AppConstants.PLAN_UPDATE_FAIL);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/delete-plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		boolean isDeleted = planService.deletePlanById(planId);

		String msg = AppConstants.EMPTY_STR;

		if (isDeleted)
			msg = messages.get(AppConstants.PLAN_DELETE_SUCC);
		else
			msg = messages.get(AppConstants.PLAN_DELETE_FAIL);

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer planId, @PathVariable String status) {
		boolean isStatusChanged = planService.chnagePlanStatus(planId, status);
		String msg = AppConstants.EMPTY_STR;
		if (isStatusChanged)
			msg = messages.get(AppConstants.PLAN_STATUS_CHANGE_SUCC);
		else
			msg = messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
