package hospital;

import java.util.Scanner;

public class HospitalManagementSystem {
    private final PatientBST patientBST;
    private final EmergencyQueue emergencyQueue;
    private final TreatmentStack treatmentStack;
    private final Scanner scanner;

    public HospitalManagementSystem() {
        this.patientBST = new PatientBST();
        this.emergencyQueue = new EmergencyQueue();
        this.treatmentStack = new TreatmentStack();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        HospitalManagementSystem system = new HospitalManagementSystem();
        system.run();
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Mini Hospital Emergency Management System ===");
            System.out.println("1. Insert Patient");
            System.out.println("2. Search Patient by ID");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display Patients (In-order BST)");
            System.out.println("5. Enqueue Emergency Patient");
            System.out.println("6. Dequeue Emergency Patient");
            System.out.println("7. Display Emergency Queue");
            System.out.println("8. Add Completed Treatment Record");
            System.out.println("9. Pop Latest Treatment Record");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Visit to Patient History");
            System.out.println("12. Remove Visit from Patient History");
            System.out.println("13. Search Visit in Patient History");
            System.out.println("14. Display Patient Visit History");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1 -> insertPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> displayPatients();
                case 5 -> enqueueEmergencyPatient();
                case 6 -> dequeueEmergencyPatient();
                case 7 -> emergencyQueue.displayQueue();
                case 8 -> addTreatmentRecord();
                case 9 -> popTreatmentRecord();
                case 10 -> treatmentStack.display();
                case 11 -> addVisit();
                case 12 -> removeVisit();
                case 13 -> searchVisit();
                case 14 -> displayVisitHistory();
                case 0 -> {
                    System.out.println("Exiting system.");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void insertPatient() {
        System.out.print("Enter patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter contact number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter medical condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(id, name, age, contact, condition);
        patientBST.insert(patient);
        System.out.println("Patient inserted successfully.");
    }

    private void searchPatient() {
        System.out.print("Enter patient ID to search: ");
        int id = Integer.parseInt(scanner.nextLine());
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            System.out.println(patient);
        }
    }

    private void deletePatient() {
        System.out.print("Enter patient ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (patientBST.search(id) == null) {
            System.out.println("Patient not found.");
            return;
        }
        patientBST.delete(id);
        System.out.println("Patient deleted successfully.");
    }

    private void displayPatients() {
        if (patientBST.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        System.out.println("Patients in ascending order by ID:");
        patientBST.inOrderTraversal();
    }

    private void enqueueEmergencyPatient() {
        System.out.print("Enter patient ID for emergency queue: ");
        int id = Integer.parseInt(scanner.nextLine());
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient does not exist in records. Register the patient first.");
            return;
        }
        emergencyQueue.enqueue(patient);
        System.out.println("Patient added to emergency queue.");
    }

    private void dequeueEmergencyPatient() {
        Patient patient = emergencyQueue.dequeue();
        if (patient != null) {
            System.out.println("Dequeued patient: " + patient);
        }
    }

    private void addTreatmentRecord() {
        System.out.print("Enter treatment ID: ");
        int treatmentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter treatment status: ");
        String status = scanner.nextLine();
        System.out.print("Enter treatment summary: ");
        String summary = scanner.nextLine();

        treatmentStack.push(new TreatmentRecord(treatmentId, patientName, status, summary));
        System.out.println("Treatment record added.");
    }

    private void popTreatmentRecord() {
        TreatmentRecord record = treatmentStack.pop();
        if (record != null) {
            System.out.println("Popped treatment: " + record);
        }
    }

    private void addVisit() {
        System.out.print("Enter patient ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter visit ID: ");
        int visitId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter visit date: ");
        String date = scanner.nextLine();
        System.out.print("Enter doctor name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter treatment: ");
        String treatment = scanner.nextLine();

        patient.getVisitHistory().addVisit(new VisitRecord(visitId, date, doctor, diagnosis, treatment));
        System.out.println("Visit added to patient history.");
    }

    private void removeVisit() {
        System.out.print("Enter patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter visit ID to remove: ");
        int visitId = Integer.parseInt(scanner.nextLine());
        boolean removed = patient.getVisitHistory().removeVisit(visitId);
        System.out.println(removed ? "Visit removed." : "Visit not found.");
    }

    private void searchVisit() {
        System.out.print("Enter patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter visit ID to search: ");
        int visitId = Integer.parseInt(scanner.nextLine());
        VisitRecord visit = patient.getVisitHistory().searchVisit(visitId);
        System.out.println(visit == null ? "Visit not found." : visit);
    }

    private void displayVisitHistory() {
        System.out.print("Enter patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine());
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        patient.getVisitHistory().displayHistory();
    }
}
