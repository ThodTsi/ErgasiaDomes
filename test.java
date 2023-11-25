public class test {
    
    public static void main(String args[]){
        StringDoubleEndedQueueImpl<String> q = new StringDoubleEndedQueueImpl<>();
        q.addFirst("Stella");
        q.addLast("Thodwrhs");
        q.addFirst("Nektaria");
        q.addLast("Giwrgos");
        q.addFirst("Maria");
        q.addLast("Giannis");
        q.printQueue(System.out);
        System.out.println(q.size());
        System.out.println(q.removeFirst());
        System.out.println(q.removeLast());
        System.out.println(q.getFirst());
        System.out.println(q.getLast());
        q.printQueue(System.out);
        System.out.println(q.size());
        System.out.println(q.removeLast());
        System.out.println(q.removeLast());
        System.out.println(q.removeLast());
        System.out.println(q.removeLast());
        q.removeLast();
        q.removeLast();
    }
}
