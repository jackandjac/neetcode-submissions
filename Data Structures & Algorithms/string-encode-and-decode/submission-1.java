class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int s = 0;
        while(str.indexOf("#") != -1) {
            int e = str.indexOf("#");
            int len = Integer.valueOf(str.substring(s, e));
            String candidate = str.substring(e + 1, e + 1 + len);
            list.add(candidate);
            str = str.substring(e + 1 + len);
        }
        return list;
    }
}
