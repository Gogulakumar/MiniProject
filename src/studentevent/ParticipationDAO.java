package studentevent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipationDAO {
    public void registerParticipant(int eventId, int studentId) {
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO event_participation (event_id, student_id) VALUES (?, ?)"
             )) {
            preparedStatement.setInt(1, eventId);
            preparedStatement.setInt(2, studentId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

