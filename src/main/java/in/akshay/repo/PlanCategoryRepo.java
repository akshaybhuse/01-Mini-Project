package in.akshay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.akshay.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
