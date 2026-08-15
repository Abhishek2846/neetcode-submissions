class Solution {
    public boolean isAnagram(String s, String t) {
        List<Character> li_s = new ArrayList<>();
        List<Character> li_t = new ArrayList<>();

        for(char ch : s.toCharArray()) li_s.add(ch);
        for(char ch : t.toCharArray()) li_t.add(ch);

        Collections.sort(li_s);
        Collections.sort(li_t);

        return li_s.equals(li_t);
    }
}
