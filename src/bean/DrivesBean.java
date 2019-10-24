package bean;

public class DrivesBean {

	private String companyName,eligibility,stream,role,typeOfJob,scheduleDate,State,CurrentStatus;
	public String getCurrentStatus() {
		return CurrentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		CurrentStatus = currentStatus;
	}

	int contract,pay;

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getContract() {
		return contract;
	}

	public void setContract(int contract) {
		this.contract = contract;
	}

	public String getTypeOfJob() {
		return typeOfJob;
	}

	public void setTypeOfJob(String typeOfJob) {
		this.typeOfJob = typeOfJob;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	@Override
	public String toString() {
		return "DrivesBean [companyName=" + companyName + ", eligibility=" + eligibility + ", stream=" + stream
				+ ", role=" + role + ", typeOfJob=" + typeOfJob + ", scheduleDate=" + scheduleDate + ", State=" + State
				+ ", CurrentStatus=" + CurrentStatus + ", contract=" + contract + ", pay=" + pay + "]";
	}
	
}
