class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for(String str: strs){
            char[] cstr= str.toCharArray();
            Arrays.sort(cstr);
            groups.computeIfAbsent(new String(cstr), k-> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
