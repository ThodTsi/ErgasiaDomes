import java.util.Scanner;

public class PrefixToInfix {

    public static void main(String Args[]) {

        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
        char[] prefix = c.toCharArray();
        boolean pref = true;
        for (int i = 0; i < prefix.length; i++) {
            if (!((prefix[i] >= '0' & prefix[i] <= '9') || (prefix[i] == '+') || (prefix[i] == '-')
                    || (prefix[i] == '*') || (prefix[i] == '/'))) {
                pref = false;
            }
        }
        if (pref) {
            StringDoubleEndedQueueImpl queue = new StringDoubleEndedQueueImpl();
            for (int i = 0; i < prefix.length; i++) {
                /*
                 * if (prefix[i] >= '0' & prefix[i] <= '9') {
                 * queue.addLast(Integer.parseInt(String.valueOf(prefix[i])));
                 * } else {
                 * queue.addLast(Character.toString(prefix[i]));
                 * }
                 */
                queue.addLast(Character.toString(prefix[i]));
            }
            queue.printQueue(System.out);
            Node n = queue.head;
            while (n != null) {

            }

        }

        in.close();

    }

}
