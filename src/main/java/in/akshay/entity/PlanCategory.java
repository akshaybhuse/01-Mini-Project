package in.akshay.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {

	@Id
	@GeneratedValue
	private Integer categoryID;

	private String categoryName;

	private String ActiveSw;

	private String createdBy;

	private String updatedBy;

	@Column(insertable = false)
	@CreationTimestamp
	private LocalDate createDate;

	@Column(updatable = false)
	@UpdateTimestamp
	private LocalDate updateDate;

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getActiveSw() {
		return ActiveSw;
	}

	public void setActiveSw(String activeSw) {
		ActiveSw = activeSw;
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

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "PlanCategory [categoryID=" + categoryID + ", categoryName=" + categoryName + ", ActiveSw=" + ActiveSw
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
