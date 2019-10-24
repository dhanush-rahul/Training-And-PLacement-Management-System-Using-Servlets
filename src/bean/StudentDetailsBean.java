package bean;

public class StudentDetailsBean {

	private String studentUsername,studentId,stream,currentStatus,password;
	private float avgGpa;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public float getAvgGpa() {
		return avgGpa;
	}

	public void setAvgGpa(float f) {
		this.avgGpa = f;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Override
	public String toString() {
		return "StudentDetailsBean [studentUsername=" + studentUsername + ", studentId=" + studentId + ", stream="
				+ stream + ", avgGpa=" + avgGpa + ", currentStatus=" + currentStatus + ", password=" + password + "]";
	}
	
}
