package hospital;

public class TreatmentStack {
    private StackNode top;
    private int size;

    public void push(TreatmentRecord record) {
        StackNode newNode = new StackNode(record);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment history stack is empty.");
            return null;
        }

        TreatmentRecord record = top.record;
        top = top.next;
        size--;
        return record;
    }

    public TreatmentRecord peek() {
        if (isEmpty()) {
            return null;
        }
        return top.record;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }

        StackNode current = top;
        System.out.println("Treatment history stack (most recent first):");
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    private static class StackNode {
        private final TreatmentRecord record;
        private StackNode next;

        public StackNode(TreatmentRecord record) {
            this.record = record;
        }
    }
}
