package studentevent;
import java.util.Date;


public class Event extends Entity implements Participatable{
	@Override
    public void registerParticipant(int eventId, int studentId) {
        ParticipationDAO participationDAO = new ParticipationDAO();
        participationDAO.registerParticipant(eventId, studentId);
        System.out.println("Participant registered successfully for the event " + getEventName());
    }
    private int eventId;
    private String eventName;
    private Date eventDate;
    private String eventLocation;
    private String eventCategory;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }
    public String getEventCategory() {
        return eventCategory;
    }
    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }
    
}
