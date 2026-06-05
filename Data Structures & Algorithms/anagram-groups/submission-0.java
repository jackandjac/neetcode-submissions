class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for(String str: strs) {
            char[] ckey = str.toCharArray();
            Arrays.sort(ckey);
            groups.computeIfAbsent(new String(ckey), k-> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
