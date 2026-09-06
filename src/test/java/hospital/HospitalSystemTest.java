package hospital;

public class HospitalSystemTest {
    public static void main(String[] args) {
        Patient patient = new Patient(101, "Alice Johnson", 32, "0712345678", "Asthma");
        assert patient.getPatientId() == 101 : "Patient ID should match";

        PatientBST bst = new PatientBST();
        bst.insert(patient);
        bst.insert(new Patient(50, "Bob Smith", 41, "0723456789", "Fracture"));
        bst.insert(new Patient(150, "Carol Lee", 27, "0734567890", "Fever"));

        assert bst.search(101) != null : "Patient 101 should exist";
        assert bst.search(999) == null : "Patient 999 should not exist";

        EmergencyQueue queue = new EmergencyQueue();
        queue.enqueue(patient);
        queue.enqueue(new Patient(50, "Bob Smith", 41, "0723456789", "Fracture"));
        assert queue.size() == 2 : "Queue size should be 2";
        assert queue.dequeue().getPatientId() == 101 : "First patient should be dequeued first";

        TreatmentStack stack = new TreatmentStack();
        stack.push(new TreatmentRecord(1, "Alice Johnson", "Discharged", "Routine check"));
        stack.push(new TreatmentRecord(2, "Bob Smith", "Admitted", "Cast applied"));
        assert stack.size() == 2 : "Stack size should be 2";
        assert stack.pop().getTreatmentId() == 2 : "Most recent treatment should be popped first";

        PatientVisitHistory history = new PatientVisitHistory();
        history.addVisit(new VisitRecord(1, "2026-09-01", "Dr. Patel", "Checkup", "Prescribed inhaler"));
        history.addVisit(new VisitRecord(2, "2026-09-05", "Dr. Gomez", "Follow-up", "Reviewed recovery"));
        assert history.searchVisit(2) != null : "Visit ID 2 should be found";
        assert history.size() == 2 : "Visit history size should be 2";

        System.out.println("All hospital system tests passed.");
    }
}
