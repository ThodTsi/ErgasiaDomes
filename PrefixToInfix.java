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
            int count = 0;
            boolean flag = false;
            for (int i = prefix.length - 1; i > 0; i--) {
                /*
                 * if (prefix[i] >= '0' & prefix[i] <= '9') {
                 * queue.addLast(Integer.parseInt(String.valueOf(prefix[i])));
                 * } else {
                 * queue.addLast(Character.toString(prefix[i]));
                 * }
                 */
                if ((prefix[i] == '+') || (prefix[i] == '-') || (prefix[i] == '*') || (prefix[i] == '/')) {
                    int temp = 0;
                    while (temp <= 1 && count < prefix.length) {
                        if (flag == false) {
                            if ((prefix[count] <= '0' && prefix[count] >= '9')) {
                                flag = true;
                                queue.addLast(Character.toString(prefix[count]));
                                temp++;
                                count++;
                            } else {
                                count++;
                            }
                        } else {
                            if ((prefix[count] <= '0' && prefix[count] >= '9')) {
                                queue.addLast(Character.toString(prefix[i]));
                                queue.addLast(Character.toString(prefix[count]));
                                temp++;
                                count++;
                            } else {
                                count++;
                            }

                        }
                    }
                }
            }

            queue.printQueue(System.out);
        }

        in.close();

    }

}
