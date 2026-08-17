public class Solution {

//IN encoding ,the strategy is to record the length of each string first, followed by a special separator, and then append all the strings together.
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs) {
            sizes.add(str.length());
        }
        for (int size : sizes) {
            res.append(size).append(',');
        }
        res.append('#');
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

//During decoding, we can read the recorded lengths to know exactly how many characters to extract for each original string.
    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;
        for (int sz : sizes) {
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;
    }
}