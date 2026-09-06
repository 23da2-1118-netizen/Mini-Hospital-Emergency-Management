package hospital;

public class PatientBST {
    private PatientNode root;

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private PatientNode insertRec(PatientNode current, Patient patient) {
        if (current == null) {
            return new PatientNode(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRec(current.left, patient);
        } else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRec(current.right, patient);
        } else {
            current.patient = patient;
        }

        return current;
    }

    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(PatientNode current, int patientId) {
        if (current == null) {
            return null;
        }

        if (patientId == current.patient.getPatientId()) {
            return current.patient;
        }

        if (patientId < current.patient.getPatientId()) {
            return searchRec(current.left, patientId);
        }
        return searchRec(current.right, patientId);
    }

    public boolean delete(int patientId) {
        root = deleteRec(root, patientId);
        return true;
    }

    private PatientNode deleteRec(PatientNode current, int patientId) {
        if (current == null) {
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteRec(current.left, patientId);
            return current;
        }

        if (patientId > current.patient.getPatientId()) {
            current.right = deleteRec(current.right, patientId);
            return current;
        }

        if (current.left == null && current.right == null) {
            return null;
        }

        if (current.left == null) {
            return current.right;
        }

        if (current.right == null) {
            return current.left;
        }

        PatientNode successor = findMin(current.right);
        current.patient = successor.patient;
        current.right = deleteRec(current.right, successor.patient.getPatientId());
        return current;
    }

    private PatientNode findMin(PatientNode current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(PatientNode current) {
        if (current == null) {
            return;
        }

        inOrderRec(current.left);
        System.out.println(current.patient);
        inOrderRec(current.right);
    }

    public boolean isEmpty() {
        return root == null;
    }

    private static class PatientNode {
        private Patient patient;
        private PatientNode left;
        private PatientNode right;

        public PatientNode(Patient patient) {
            this.patient = patient;
        }
    }
}
