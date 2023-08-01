package studentevent;
public class Student extends Entity implements Participatable {
	@Override
    public void registerParticipant(int eventId, int studentId) {
        
        ParticipationDAO participationDAO = new ParticipationDAO();
        participationDAO.registerParticipant(eventId, studentId);
        System.out.println("Successfully registered for the event as a participant");
    }
	private int studentId;
    private String studentName;
    private String studentEmail;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}