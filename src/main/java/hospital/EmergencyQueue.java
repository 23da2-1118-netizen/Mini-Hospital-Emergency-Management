package hospital;

public class EmergencyQueue {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    public void enqueue(Patient patient) {
        QueueNode newNode = new QueueNode(patient);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return patient;
    }

    public Patient peek() {
        if (isEmpty()) {
            return null;
        }
        return front.patient;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        QueueNode current = front;
        System.out.println("Emergency patients waiting:");
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    private static class QueueNode {
        private final Patient patient;
        private QueueNode next;

        public QueueNode(Patient patient) {
            this.patient = patient;
        }
    }
}
