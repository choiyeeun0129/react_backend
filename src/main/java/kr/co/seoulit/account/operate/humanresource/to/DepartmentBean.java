package kr.co.seoulit.account.operate.humanresource.to;

import kr.co.seoulit.account.sys.base.to.BaseBean;

public class DepartmentBean extends BaseBean{
	
	private String workplaceCode;
	private String workplaceName;
	private String deptCode;
	private String deptName;
	private String companyCode;
	private String deptStartDate;
	private String deptEndDate;
	
	public String getWorkplaceCode() {
		return workplaceCode;
	}
	public void setWorkplaceCode(String workplaceCode) {
		this.workplaceCode = workplaceCode;
	}
	public String getWorkplaceName() {
		return workplaceName;
	}
	public void setWorkplaceName(String workplaceName) {
		this.workplaceName = workplaceName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getDeptStartDate() {
		return deptStartDate;
	}
	public void setDeptStartDate(String deptStartDate) {
		this.deptStartDate = deptStartDate;
	}
	public String getDeptEndDate() {
		return deptEndDate;
	}
	public void setDeptEndDate(String deptEndDate) {
		this.deptEndDate = deptEndDate;
	}
	
	

}
