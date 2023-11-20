import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl implements StringDoubleEndedQueue {

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
            if (head != tail) {
                return head.getData();
                Node n = head;
                head = head.next;
                head.prev = null;
                n.next = null;
            } else if ((head == tail) && (head != null)) {
                return head.getData();
                head = null;
                tail = null;
            }
        } catch (NoSuchElementException e) {
            System.out.println("nsee");
        }
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
            if (!isEmpty()) {
                return tail.getData();
                Node n = tail;
                tail = tail.prev;
                tail.next = null;
                n.prev = null;
            } else if ((tail == head) && (tail != null)) {
                return tail.getData();
                head = null;
                tail = null;
            }
        } catch (NoSuchElementException e) {
            System.out.println("nsee");
        }

    }

}
