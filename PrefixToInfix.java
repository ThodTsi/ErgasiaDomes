import java.util.Scanner;

public class PrefixToInfix {

    public static void main(String Args[]) {

        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
        char[] prefix = c.toCharArray();
        StringDoubleEndedQueueImpl queue = new StringDoubleEndedQueueImpl();
        boolean pref = true;
        int telestes = 0;
        int nums = 0;
        for (int i = 0; i < prefix.length; i++) {
            if (!((prefix[i] >= '0' & prefix[i] <= '9') || (prefix[i] == '+') ||
                    (prefix[i] == '-')
                    || (prefix[i] == '*') || (prefix[i] == '/'))) {
                pref = false;
            } else if ((prefix[i] == '-') || (prefix[i] == '+') || (prefix[i] == '*') || (prefix[i] == '/')) {
                telestes += 1;
            } else if (prefix[i] >= 0 & prefix[i] <= '9') {
                nums += 1;
            }
        }
        if (telestes > nums) {
            pref = false;
        }
        int pos = 1;

        if (pref) {

            int count = 0;
            boolean flag = false;
            for (int i = 0; i < prefix.length; i++) {
                if ((prefix[i] == '+') || (prefix[i] == '-') || (prefix[i] == '*') ||
                        (prefix[i] == '/')) {
                    if (count < prefix.length) {
                        if (prefix[count] >= '0' & prefix[count] <= '9') {
                            queue.addLast(Character.toString(prefix[count]));
                            flag = false;
                            while (flag == false) {
                                if (prefix[count] >= '0' & prefix[count] <= '9') {
                                    queue.addLast(Character.toString(prefix[i]));
                                    queue.addLast(Character.toString(prefix[count]));
                                    flag = true;
                                }
                                count++;
                            }
                        }
                    }
                    /*
                     * else {
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
                     */
                }

                queue.printQueue(System.out);

                in.close();

            }
        }
    }
}