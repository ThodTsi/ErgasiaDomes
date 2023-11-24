public class test {

    public static void main(String Args[]) {
        StringDoubleEndedQueueImpl list = new StringDoubleEndedQueueImpl();

        list.addFirst("Stella");
        list.addLast("Thodoras");
        // list.addFirst("Nektaria");
        // list.addLast("Parthikleon");
        /*
         * list.printQueue(System.out);
         * System.out.println(list.size());
         * System.out.println(list.getFirst());
         * System.out.println(list.getLast());
         * System.out.println(list.removeLast());
         * System.out.println(list.removeFirst());
         * char str = '0';
         * System.out.println(str < '1');
         */
        Node n = new Node("eii");
        list.head.setNext(n);
        list.tail.setPrev(n);
        n.next = list.tail;
        n.prev = list.head;
        list.printQueue(System.out);
    }

    /*
     * if(pref)
     * 
     * {
     * int count = 0;
     * boolean flag = false;
     * for (int i = prefix.length - 1; i >= 0; i--) {
     * if ((prefix[i] == '+') || (prefix[i] == '-') || (prefix[i] == '*') ||
     * (prefix[i] == '/')) {
     * if (flag == false) {
     * if (prefix[count] >= '0' & prefix[count] <= '9') {
     * queue.addLast(Character.toString(prefix[count]));
     * count++;
     * while (flag == false & count < prefix.length) {
     * if (prefix[count] >= '0' & prefix[count] <= '9') {
     * queue.addLast(Character.toString(prefix[i]));
     * queue.addLast(Character.toString(prefix[count]));
     * flag = true;
     * }
     * count++;
     * }
     * 
     * }
     * } else {
     * boolean stop = false;
     * while (stop == false & count < prefix.length) {
     * if (prefix[count] >= '0' & prefix[count] <= '9') {
     * queue.addLast(Character.toString(prefix[i]));
     * queue.addLast(Character.toString(prefix[count]));
     * stop = true;
     * }
     * count++;
     * }
     * }
     * }
     * }
     */

}
