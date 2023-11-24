import java.util.Scanner;

public class PrefixToInfix {

    public static boolean isPrefix(char[] c) {
        int telestes = 0;
        int nums = 0;
        boolean wrongChar = false;
        for (int i = 0; i < c.length; i++) {
            if (!((c[i] >= '0' & c[i] <= '9') || (c[i] == '+') ||
                    (c[i] == '-')
                    || (c[i] == '*') || (c[i] == '/'))) {
                wrongChar = true;
            } else if ((c[i] == '-') || (c[i] == '+') || (c[i] == '*') || (c[i] == '/')) {
                telestes += 1;
            } else if (c[i] >= 0 & c[i] <= '9') {
                nums += 1;
            }
        }
        if (telestes >= nums || !(c[0] == '+' || c[0] == '-' || c[0] == '*' || c[0] == '/') || wrongChar == true) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String Args[]) {

        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
        char[] prefix = c.toCharArray();
        StringDoubleEndedQueueImpl queue = new StringDoubleEndedQueueImpl();
        boolean pref = isPrefix(prefix);
        int count = prefix.length - 1;
        int first = 0;
        boolean found = false;
        if (pref) {
            for (int i = prefix.length - 1; i >= 0; i--) {
                if (first <= 1) {
                    if ((prefix[i] == '+') || (prefix[i] == '-') || (prefix[i] == '*') || (prefix[i] == '/')) {
                        while (first <= 1 & count >= 0) {
                            if (prefix[count] >= '0' & prefix[count] <= '9') {
                                if (first == 0) {
                                    queue.addLast(Character.toString(prefix[count]));
                                    first++;
                                } else if (first == 1) {
                                    queue.addLast(Character.toString(prefix[count]));
                                    Node n = new Node("(" + queue.tail.getData() + Character.toString(prefix[i])
                                            + queue.tail.prev.getData() + ")");
                                    queue.removeLast();
                                    queue.removeLast();
                                    queue.addLast(n.getData());
                                    first++;
                                }
                            }
                            count--;
                        }
                    } else {
                        queue.addLast(Character.toString(prefix[i]));
                        first++;
                    }
                } else {
                    if ((prefix[i] == '+') || (prefix[i] == '-') || (prefix[i] == '*') || (prefix[i] == '/')) {
                        if (queue.size() == 1) {
                            while (found == false & count >= 0) {
                                if (prefix[count] >= '0' & prefix[count] <= '9') {
                                    queue.addLast(Character.toString(prefix[count]));
                                    Node n = new Node("(" + queue.tail.getData() + Character.toString(prefix[i])
                                            + queue.tail.prev.getData() + ")");
                                    queue.removeLast();
                                    queue.removeLast();
                                    queue.addLast(n.getData());
                                    found = true;
                                }
                                count--;
                            }
                        } else {
                            Node n = new Node("(" + queue.tail.getData() + Character.toString(prefix[i])
                                    + queue.tail.prev.getData() + ")");
                            queue.removeLast();
                            queue.removeLast();
                            queue.addLast(n.getData());
                        }
                    } else {
                        queue.addLast(Character.toString(prefix[i]));
                    }
                }

                // }
            }

            queue.printQueue(System.out);

        } else {
            System.out.println("This equation is not in prefix form");
        }

        in.close();
    }
}