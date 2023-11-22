import java.util.Scanner;

public class PrefixToInfix {

    public static void main(String Args[]) {

        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
        char[] prefix = c.toCharArray();
        StringDoubleEndedQueueImpl queue = new StringDoubleEndedQueueImpl();
        for (int i = 0; i < prefix.length; i++) {
            queue.addLast(Character.toString(prefix[i]));
        }
        boolean pref = true;
        // for (int i = 0; i < prefix.length; i++) {
        // if (!((prefix[i] >= '0' & prefix[i] <= '9') || (prefix[i] == '+') ||
        // (prefix[i] == '-')
        // || (prefix[i] == '*') || (prefix[i] == '/'))) {
        // pref = false;
        // }
        // }
        Node node = queue.head;
        while (n != null) {
            String d = node.getData();
            if (!((d.charAt(0) >= '0' & d.charAt(0) <= '9') || (d.equals("+")) || (d.equals("-")) || (d.equals("*"))
                    || (d.equals("/")))) {
                pref = false;
            }
            node = node.next;
        }
        if (pref) {
            int count = 0;
            boolean flag = false;
            Node t = queue.tail;
            Node h = queue.head;
            while (t != null) {
                if ((t.getData().equals("+")) || (t.getData().equals("-")) || (t.getData().equals("*"))
                        || (t.getData().equals("/"))) {
                    if (flag == false) {
                        if (t.charAt(0) >= '0' & t.charAt(0) <= '9') {
                            String temp = queue.removeFirst();
                            queue.addLast(temp);
                            h = h.next;
                            while (flag == false & count < prefix.length) {
                                if (prefix[count] >= '0' & prefix[count] <= '9') {
                                    queue.addLast(Character.toString(prefix[i]));
                                    queue.addLast(Character.toString(prefix[count]));
                                    flag = true;
                                }
                                count++;
                            }

                        }
                    } else {
                        boolean stop = false;
                        while (stop == false & count < prefix.length) {
                            if (prefix[count] >= '0' & prefix[count] <= '9') {
                                queue.addLast(Character.toString(prefix[i]));
                                queue.addLast(Character.toString(prefix[count]));
                                stop = true;
                            }
                            count++;
                        }
                    }
                }

            }
            queue.printQueue(System.out);
        }

        in.close();

    }

}
