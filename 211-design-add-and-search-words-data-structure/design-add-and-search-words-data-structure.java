class WordDictionary {

    NodeBucket root;

    public WordDictionary() {
        root = new NodeBucket();
    }

    public void addWord(String word) {
        NodeBucket temp = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            temp = temp.cache.computeIfAbsent(current, ifNotPresent -> new NodeBucket());
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, NodeBucket node) {
        if (index == word.length()) {
            return node.isEndOfWord != null && node.isEndOfWord;
        }

        char current = word.charAt(index);
        if (current == '.') {
            for (NodeBucket child : node.cache.values()) {
                if (searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            NodeBucket nextNode = node.cache.get(current);
            if (nextNode == null) {
                return false;
            }
            return searchInNode(word, index + 1, nextNode);
        }
    }
}

class NodeBucket {
    Map<Character, NodeBucket> cache = new HashMap<>();
    Boolean isEndOfWord;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */