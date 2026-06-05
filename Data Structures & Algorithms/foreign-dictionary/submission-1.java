class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      int[] degree = new int[26];
      buildGraph(degree, words, graph);
      Queue<Character> queue = new LinkedList<>();
      StringBuilder sb = new StringBuilder();

      for(char key: graph.keySet()) {
        if (degree[key - 'a'] == 0) {
            queue.offer(key);
        }
      }

      while(!queue.isEmpty()) {
        char c = queue.poll();
        sb.append(c);
        if (graph.containsKey(c)){
            for (char candidate: graph.get(c)) {
                degree[candidate - 'a']--;
                if (degree[candidate - 'a'] == 0) {
                    queue.offer(candidate);
                }
            }
        }
      }
      return sb.length() == graph.size() ? sb.toString() : "";

    }

    private void buildGraph(int[] degree, String[] words, Map<Character, Set<Character>> graph) {

        for(String word: words) {
            for(char c: word.toCharArray()) {
                graph.computeIfAbsent(c, k-> new HashSet<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            int len = Math.min(words[i-1].length(), words[i].length());

            for (int j = 0; j < len; j++) {
                char upper = words[i-1].charAt(j);
                char down = words[i].charAt(j);

                if (upper != down ) {
                    if (!graph.get(upper).contains(down)) {
                        graph.get(upper).add(down);
                        degree[down -'a']++;
                    }
                    break;
                }
                if (j == len -1 && words[i-1].length() > words[i].length()){
                    graph.clear();
                    return;
                }
            }
        }
    }
}
