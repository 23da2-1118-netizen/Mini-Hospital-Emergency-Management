package hospital;

public class PatientVisitHistory {
    private VisitNode head;
    private int size;

    public void addVisit(VisitRecord visit) {
        VisitNode newNode = new VisitNode(visit);
        if (head == null) {
            head = newNode;
        } else {
            VisitNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean removeVisit(int visitId) {
        if (head == null) {
            return false;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            size--;
            return true;
        }

        VisitNode current = head;
        while (current.next != null && current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        size--;
        return true;
    }

    public VisitRecord searchVisit(int visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }

    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit records available.");
            return;
        }

        VisitNode current = head;
        System.out.println("Patient visit history:");
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private static class VisitNode {
        private final VisitRecord visit;
        private VisitNode next;

        public VisitNode(VisitRecord visit) {
            this.visit = visit;
        }
    }
}
