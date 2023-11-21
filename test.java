public class test {

    public static void main(String Args[]) {
        StringDoubleEndedQueueImpl list = new StringDoubleEndedQueueImpl();
        list.addFirst("Stella");
        list.addLast("Thodoras");
        list.addFirst("Nektaria");
        list.addLast("Parthikleon");
        list.printQueue(System.out);
        System.out.println(list.size());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.removeLast());
        System.out.println(list.removeFirst());

    }

}
