import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl<T> implements StringDoubleEndedQueue<T>{

    protected Node<T> head;
    protected Node<T> tail;
    protected int counter = 0; //gia na bgei to size() xwris loop --> O(1)

    StringDoubleEndedQueueImpl() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(T item) {
        Node<T> n = new Node<>(item);
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

    public T removeFirst() throws NoSuchElementException {
        Node<T> n = head;
        if (isEmpty()){
            System.out.println("The queue is empty!");
            throw new NoSuchElementException();
        }else if ((head == tail) && (head != null)) {
            head = null;
            tail = null;
            counter--;
        } else if (head != tail) {
            head = head.next;
            head.prev = null;
            n.next = null;
            counter--;
        }
        return n.getData();
    }

    public void addLast(T item) {
        Node<T> n = new Node<>(item);
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

    public T removeLast() throws NoSuchElementException {
        Node<T> n = tail;
        if(isEmpty()){
            System.out.println("The queue is empty!");
            throw new NoSuchElementException();
        }else if ((tail == head) && (tail != null)) {
            head = null;
            tail = null;
            counter--;
        } else if (head != tail) {
            tail = tail.prev;
            tail.next = null;
            n.prev = null;
            counter--;
        }
        return n.getData();
    }

    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
        return tail.getData();
    }

    public void printQueue(PrintStream stream) {
        Node<T> n = head;
        while (n != null) {
            stream.println(n.getData());
            n = n.next;
        }
    }

    public int size() {
        return counter;
    }

}
