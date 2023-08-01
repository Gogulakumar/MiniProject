package studentevent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    public void addEvent(Event event) {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO events (event_name, event_date, event_location, event_category) VALUES (?, ?, ?, ?)"
             )) {
            preparedStatement.setString(1, event.getEventName());
            preparedStatement.setDate(2, new java.sql.Date(event.getEventDate().getTime()));
            preparedStatement.setString(3, event.getEventLocation());
            preparedStatement.setString(4, event.getEventCategory());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM events");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Event event = new Event();
                event.setEventId(resultSet.getInt("event_id"));
                event.setEventName(resultSet.getString("event_name"));
                event.setEventDate(resultSet.getDate("event_date"));
                event.setEventLocation(resultSet.getString("event_location"));
                event.setEventCategory(resultSet.getString("event_category"));

                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

	public Participatable getEventById(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}
}
