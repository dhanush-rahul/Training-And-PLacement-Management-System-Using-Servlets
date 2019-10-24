package bean;

public class PlacedStudentsBean {

	private String studentUsername,studentId,stream,companyName,role;
	private float gpa;

	public String getStudentUsername() {
		return studentUsername;
	}

	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "PlacedStudentsBean [studentUsername=" + studentUsername + ", studentId=" + studentId + ", stream="
				+ stream + ", gpa=" + gpa + ", companyName=" + companyName + ", role=" + role + "]";
	}
	
}
