package in.akshay.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "PLAN_MASTER")
public class Plan {

	@Id
	@GeneratedValue
	private Integer planID;

	private String planName;

	private LocalDate planStartDate;

	private LocalDate planEndDate;

	private Integer planCategoryID;

	private String activeSW;

	private String createdBy;

	private String updatedBy;

	@Column(insertable = false)
	private LocalDate createDate;

	@Column(updatable = false)
	private LocalDate updatedate;

	public Integer getPlanID() {
		return planID;
	}

	public void setPlanID(Integer planID) {
		this.planID = planID;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public Integer getPlanCategoryID() {
		return planCategoryID;
	}

	public void setPlanCategoryID(Integer planCategoryID) {
		this.planCategoryID = planCategoryID;
	}

	public String getActiveSW() {
		return activeSW;
	}

	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(LocalDate updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "Plan [planID=" + planID + ", planName=" + planName + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", planCategoryID=" + planCategoryID + ", activeSW=" + activeSW
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createDate=" + createDate
				+ ", updatedate=" + updatedate + "]";
	}

}
