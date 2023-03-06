class Trie {
    node main;
    private class node{
        boolean endOfWord;
        node[] characters;
        public node(){
            endOfWord = false;
            characters = new node[26];
            for(int i=0; i<26; i++){
                characters[i] = null;
            }
        }
    }

    public Trie() {
        main = new node();
    }
    
    public void insert(String word){
        node curr = main;
        for(int i=0;i<word.length(); i++){
            int ind = word.charAt(i) - 'a';
            if(curr.characters[ind]!=null){
                curr = curr.characters[ind];
            } else {
                curr.characters[ind] = new node();
                curr = curr.characters[ind];
            }
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word){
        node curr = main;
        for(int i=0; i<word.length(); i++){
            int ind = word.charAt(i)-'a';
            if(curr.characters[ind] == null){
                return false;
            }
            curr = curr.characters[ind];
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        node curr = main;
        for(int i=0; i<prefix.length(); i++){
            int ind = prefix.charAt(i)-'a';
            if(curr.characters[ind] == null){
                return false;
            }
            curr = curr.characters[ind];
        }
        return true;
    }
}