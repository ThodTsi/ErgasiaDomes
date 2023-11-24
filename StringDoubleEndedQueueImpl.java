import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl implements StringDoubleEndedQueue {

    protected Node head;
    protected Node tail;
    protected int counter = 0;

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
        counter++;
    }

    public String removeFirst() throws NoSuchElementException {
        try {
            Node n = head;
            if ((head == tail) && (head != null)) {
                head = null;
                tail = null;
                counter--;
                return n.getData();
            } else if (head != tail) {
                head = head.next;
                head.prev = null;
                n.next = null;
                counter--;
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
        counter++ ;
    }

    public String removeLast() throws NoSuchElementException {
        try {
            Node n = tail;
            if ((tail == head) && (tail != null)) {
                head = null;
                tail = null;
                counter--;
                return n.getData();
            } else if (head != tail) {
                tail = tail.prev;
                tail.next = null;
                n.prev = null;
                counter--;
                return n.getData();
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

    public void printQueue(PrintStream stream) {
        Node n = head;
        while (n != null) {
            stream.println(n.getData());
            n = n.next;
        }
    }

    public int size() {
        return counter;
    }

}
