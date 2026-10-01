class PrefixTree {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;


        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for(char c: word.toCharArray()){
            int index = c-'a';

            if(current.children[index]==null){
                current.children[index]= new TrieNode();
            }

            current = current.children[index];


        }

        current.isEnd=true;

    }

    public boolean search(String word) {
        TrieNode current = root;


        for(char ch : word.toCharArray()){

            int index = ch - 'a';

            if(current.children[index]==null) return false;
            current = current.children[index];
        }

        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(current.children[index]==null) return false;
            current=current.children[index];
        }

        return true;
    }
}
