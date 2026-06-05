class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int l = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#'){
                int len = Integer.parseInt(str.substring(l, i));
                String candidate = str.substring(i + 1, i + 1 + len);
                res.add(candidate);
                i = i + 1 + len;
                l = i;
            }
        }
        return res;
    }
}
