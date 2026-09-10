class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      int[] degree = new int[26];
      StringBuilder sb = new StringBuilder();
      Queue<Character> queue = new LinkedList<>();

      this.buildGraph(words, degree, graph);

      for(Character key: graph.keySet()) {
        if (degree[key - 'a'] == 0) {
            queue.offer(key);
        }
      }

      while(!queue.isEmpty()) {
        char c = queue.poll();
        sb.append(c);
        if (graph.containsKey(c)) {
            for (char nc: graph.get(c)) {
                degree[nc - 'a']--;
                if (degree[nc - 'a'] == 0) {
                    queue.offer(nc);
                }
            }
        }
      }

      return sb.length() == graph.size() ? sb.toString() : "";

    }

    private void buildGraph(String words[], int[] degree, Map<Character, Set<Character>> graph) {
        for (String word: words) {
            for(char c: word.toCharArray()) {
                graph.computeIfAbsent(c, k-> new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String up = words[i -1];
            String dw = words[i];

            if (up.length() > dw.length() && up.startsWith(dw)) {
                graph.clear();
                return;
            }

            int len = Math.min(up.length(), dw.length());
            for (int j = 0; j < len; j++) {
                char u = up.charAt(j);
                char d = dw.charAt(j);

                if ( u != d) {
                    if (!graph.get(u).contains(d)) {
                        graph.get(u).add(d);
                        degree[d - 'a']++;
                    }
                    break;
                }
            }
        }
    }
}
