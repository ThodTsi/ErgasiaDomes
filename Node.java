public class Node {
    private String data;
    protected Node next;
    protected Node prev;

    Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public String getData() {
        return this.data;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public Node getNext() {
        return this.next;
    }

    public void setPrev(Node p) {
        this.prev = p;
    }

    public Node getPrev() {
        return this.prev;
    }

}
