class Trie {

    Trie[] children;
    boolean isEnd;
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        char[] array = word.toCharArray();
        Trie root = this;
        for (int i = 0; i < array.length; i++) {
            int index = array[i]-'a';
            if(root.children[index] == null){
                root.children[index]=new Trie();
                root.isEnd = false;
            }
            root = root.children[index];
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        Trie root = this;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i]-'a';
            if(root.children[index] == null) return false;
            root = root.children[index];
        }
        return root.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        char[] array = prefix.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i]-'a';
            if(root.children[index] == null) return false;
            root = root.children[index];
        }
        return true;
    }
}