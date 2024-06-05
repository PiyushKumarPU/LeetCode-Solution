class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (!temp.cache.containsKey(current)) {
                temp.cache.put(current, new Node());
            }
            temp = temp.cache.get(current);
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            temp = temp.cache.get(current);
            if (temp == null) return false;
        }
        return temp.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char current = prefix.charAt(i);
            temp = temp.cache.get(current);
            if (temp == null) return false;
        }
        return true;
    }
}

class Node {
    Map<Character, Node> cache = new HashMap<>();
    boolean isEndOfWord;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */