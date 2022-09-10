import java.util.*;

class PhonePermutation {
    static List<String> permutationList = new ArrayList();
    static HashMap<Character, char[]> phoneNumChars = new HashMap() {
        {
            put('2', new char[] { 'A', 'B', 'C' });
            put('3', new char[] { 'D', 'E', 'F' });
            put('4', new char[] { 'G', 'H', 'I' });
            put('5', new char[] { 'J', 'K', 'L' });
            put('6', new char[] { 'M', 'N', 'O' });
            put('7', new char[] { 'P', 'Q', 'R', 'S' });
            put('8', new char[] { 'T', 'U', 'V' });
            put('9', new char[] { 'W', 'X', 'Y', 'Z' });
        }
    };

    public static void main(String... args) {

        String pressedNums = "234";

        stringPermutation(pressedNums, 0, pressedNums.length() - 1);

        permutationList.forEach(System.out::println);

    }

    static void phonePermutation(String s, int start, int end, String dash) {
        char[] schars = s.toCharArray();

        // System.out.println(dash + "1-" + String.valueOf(schars) + " " + schars[start]
        // + " " + start + "," + end);
        char[] replaceChars = phoneNumChars.get(schars[start]);

        for (char c : replaceChars) {
            schars[start] = c;
            if (start == end) {
                // System.out.println(dash + "-(" + String.valueOf(schars) + ")");
                permutationList.add(String.valueOf(schars));

            } else {
                // System.out.println(dash + "2-" + String.valueOf(schars) + " " + schars[start]
                // + " " + start + "," + end);
                phonePermutation(String.valueOf(schars), start + 1, end, dash + "-");
            }
        }
    }

    static void stringPermutation(String s, int start, int end) {
        /*
         * 2(345) start = 0
         * 2(3(45)) start = 1
         * 2(3(54) start = end = 2
         * 2(4(35))
         * 2(4(53))
         * 2(5(43))
         * 2(5(34))
         * 3(245)
         * 5(342)
         */

        if (start == end) {
            System.out.println(s);
            phonePermutation(s, 0, end, "");
        } else {
            for (int i = start; i <= end; i++) {
                s = swap(s, start, i);
                stringPermutation(s, start + 1, end);
            }
        }
    }

    static String swap(String s, int i, int j) {
        char[] schars = s.toCharArray();

        char temp = schars[i];
        schars[i] = schars[j];
        schars[j] = temp;

        return String.valueOf(schars);
    }

}