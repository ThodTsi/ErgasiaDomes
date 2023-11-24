public class Node<T> {
    private T data;
    protected Node<T> next;
    protected Node<T> prev;

    Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return this.data;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

}
