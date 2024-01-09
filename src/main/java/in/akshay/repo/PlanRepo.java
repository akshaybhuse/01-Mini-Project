package in.akshay.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import in.akshay.entity.Plan;

public interface PlanRepo extends JpaRepositoryImplementation<Plan, Integer> {

}
