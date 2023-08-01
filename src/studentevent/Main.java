package studentevent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class Main implements Participatable{
    public static void main(String[] args) {
        EventDAO eventDAO = new EventDAO();
        StudentDAO studentDAO = new StudentDAO();
        ParticipationDAO participationDAO = new ParticipationDAO();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Event");
            System.out.println("2. Add Student");
            System.out.println("3. Register Participant");
            System.out.println("4. View All Events");
            System.out.println("5. View All Students");
            System.out.println("0. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter event name:");
                    String eventName = scanner.nextLine();

                    Date eventDate = null;
                    while (eventDate == null) {
                        System.out.println("Enter event date (YYYY-MM-DD):");
                        String eventDateStr = scanner.nextLine();
                        try {
                            eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(eventDateStr);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }

                    System.out.println("Enter event location:");
                    String eventLocation = scanner.nextLine();

                    System.out.println("Enter event category:");
                    String eventCategory = scanner.nextLine();

                    Event event = new Event();
                    event.setEventName(eventName);
                    event.setEventDate(eventDate);
                    event.setEventLocation(eventLocation);
                    event.setEventCategory(eventCategory);

                    eventDAO.addEvent(event);
                    System.out.println("Event added successfully!");
                    break;

                case 2:
                    System.out.println("Enter student name:");
                    String studentName = scanner.nextLine();

                    System.out.println("Enter student email:");
                    String studentEmail = scanner.nextLine();

                    Student student = new Student();
                    student.setStudentName(studentName);
                    student.setStudentEmail(studentEmail);

                    studentDAO.addStudent(student);
                    System.out.println("Student added successfully!");
                    break;

                case 3:
                    System.out.println("Enter event ID:");
                    int eventId = scanner.nextInt();

                    System.out.println("Enter student ID:");
                    int studentId = scanner.nextInt();

                    // Polymorphism: Using the Participatable interface reference to call registerParticipant method
                    Participatable participant = eventDAO.getEventById(eventId); // Implement this method in EventDAO to get the event by ID
                    participant.registerParticipant(eventId, studentId);
                    break;
//                case 3:
//                	
//                    System.out.println("Enter event ID:");
//                    int eventId = scanner.nextInt();
//
//                    System.out.println("Enter student ID:");
//                    int studentId = scanner.nextInt();
//
//                    participationDAO.registerParticipant(eventId, studentId);
//                    System.out.println("Participant registered successfully!");
//                    break;

                case 4:
                    List<Event> events = eventDAO.getAllEvents();
                    for (Event ev : events) {
                        System.out.println(ev.getEventName() + " | " + ev.getEventDate() + " | " + ev.getEventLocation() + " | " + ev.getEventCategory());
                    }
                    break;

                case 5:
                    List<Student> students = studentDAO.getAllStudents();
                    for (Student st : students) {
                        System.out.println(st.getStudentName() + " | " + st.getStudentEmail());
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}