class TrieNode {

    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word
    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    // Search a complete word
    public boolean search(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isEnd;
    }

    // Check if any word starts with prefix
    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return true;
    }
}