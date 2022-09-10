import java.util.*;
import java.util.stream.*;

public class GroupAnagrams {

    public static void main(String... args) {
        GroupAnagrams run = new GroupAnagrams();

        // String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        String[] strs = { "a" };
        List<List<String>> groups = run.groupAnagrams(strs);
        groups.stream().forEach(System.out::println);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> anagramList = new HashMap();
        anagramList.put(0, new ArrayList<String>(Arrays.asList(strs[0])));

        boolean isAnagram;
        for (int i = 1; i < strs.length; i++) {

            isAnagram = false;
            for (int j : anagramList.keySet()) {

                if (isAnagram(strs[i], strs[j])) {
                    anagramList.get(j).add(strs[i]);
                    isAnagram = true;
                    break;
                }
            }

            if (!isAnagram) {
                anagramList.put(i, new ArrayList<String>(Arrays.asList(strs[i])));
            }
        }

        return anagramList.values().stream().collect(Collectors.toList());

    }

    public boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;

        int[] counters = new int[28];

        for (int i = 0; i < s1.length(); i++) {
            counters[s1.charAt(i) - 'a']++;
            counters[s2.charAt(i) - 'a']--;
        }

        for (int i : counters) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

}
