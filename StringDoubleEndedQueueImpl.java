import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl {

    private Node head;
    private Node tail;

    StringDoubleEndedQueueImpl() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(String item) {
        Node n = new Node(item);
        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head.setPrev(n);
            head = n;
        }
    }

    public String removeFirst() throws NoSuchElementException {
        try {
            Node n = head;
            if (head != tail) {
                head = head.next;
                head.prev = null;
                n.next = null;
                return n.getData();
            } else if ((head == tail) && (head != null)) {
                head = null;
                tail = null;
                return n.getData();
            }
        } catch (NoSuchElementException e) {
            System.out.println("nsee");

        }
        return null;
    }

    public void addLast(String item) {
        Node n = new Node(item);
        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setPrev(tail);
            tail.setNext(n);
            tail = n;
        }
    }

    public String removeLast() throws NoSuchElementException {
        try {
            Node n = tail;
            if (!isEmpty()) {
                tail = tail.prev;
                tail.next = null;
                n.prev = null;
                return tail.getData();
            } else if ((tail == head) && (tail != null)) {
                head = null;
                tail = null;
                return tail.getData();
            }
        } catch (NoSuchElementException e) {
            System.out.println("nsee");
        }
        return null;

    }

    public String getFirst() {
        return head.getData();
    }

    public String getLast() {
        return tail.getData();
    }
}
