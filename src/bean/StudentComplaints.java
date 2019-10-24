package bean;

public class StudentComplaints {

	private String studentId;
	private String complaint;
	private String stream;
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	@Override
	public String toString() {
		return "StudentComplaints [studentId=" + studentId + ", complaint=" + complaint + ", stream=" + stream + "]";
	}
	
}
