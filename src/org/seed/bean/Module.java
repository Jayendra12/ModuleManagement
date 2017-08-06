package org.seed.bean;

public class Module {
	int srNo;
	String moduleName;
	String moduleCode;
	String status;
	int noOfHours;
	String moduleDate;
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNoOfHours() {
		return noOfHours;
	}
	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}
	public String getModuleDate() {
		return moduleDate;
	}
	@Override
	public String toString() {
		return "Module [srNo=" + srNo + ", moduleName=" + moduleName + ", moduleCode=" + moduleCode + ", status="
				+ status + ", noOfHours=" + noOfHours + ", moduleDate=" + moduleDate + "]";
	}
	public void setModuleDate(String moduleDate) {
		this.moduleDate = moduleDate;
	}
	
	
	

}
