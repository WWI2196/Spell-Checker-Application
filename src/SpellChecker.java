public class SpellChecker {
    Node root;

    public SpellChecker(String[] words){
        root = new Node();
        for(String word : words){
            addWord(word);
        }
    }

    public void addWord(String word){
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            if(!current.hasChild(character)){
                current.addChild(character, new Node(character));
            }
            current = current.getChild(character);
        }
        current.setEnd(true);
    }
    public boolean checkWord(String word) {
        for(String lowerCaseWord : Runner.words){
            if(lowerCaseWord.equalsIgnoreCase(word)){
                return true;
            }
        }
        return false;
    }
    public String[] checkWords(String word){
        String[] result = new String[1];
        int index = 0;
        if (word.length() == 0) {
            return result;
        }
        if (searchWord(word)){
            result[index] = word;
            index++;
            return resize(result, index);
        }

        for(int i = 0; i < word.length(); i++){
            if (i < word.length() - 1) {
                String newWord = deleteLetterAt(word, i);
                if (searchWord(newWord) && contains(result, index, newWord)) {
                    result = resize(result, index + 1);
                    result[index] = newWord;
                    index++;

                }
            }
            for (char character = 'a'; character <= 'z'; character++) {
                String newWord = replaceLetterAt(word, i, character);
                if (searchWord(newWord) && contains(result, index, newWord)){
                    result = resize(result, index + 1);
                    result[index] = newWord;
                    index++;
                }
            }
            for (char character = 'a'; character <= 'z'; character++) {
                String newWord = insertLetterAt(word, i, character);
                if (searchWord(newWord) && contains(result, index, newWord)){
                    result = resize(result, index + 1);
                    result[index] = newWord;
                    index++;
                }
            }
            if (i < word.length() - 1) {
                String newWord = swapLetterAt(word, i);
                if (searchWord(newWord) && contains(result, index, newWord)){
                    result = resize(result, index + 1);
                    result[index] = newWord;
                    index++;
                }
            }
        }
        if (index == 0){
            return new String[0];
        }else {
            return resize(result, index);
        }
    }

    private boolean contains(String[] result, int index, String newWord) {
        for (int i = 0; i < index; i++) {
            if (result[i].equals(newWord)) {
                return false;
            }
        }
        return true;
    }

    public boolean searchWord(String word){
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            if(!current.hasChild(character)){
                return false;
            }
            current = current.getChild(character);
        }
        return current.isEnd();
    }
    private String[] resize(String[] array, int size) {
        String[] newArray = new String[size];
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, size));
        return newArray;
    }
    private String deleteLetterAt(String word, int index) {
        return word.substring(0, index) + word.substring(index + 1);
    }
    private String replaceLetterAt(String word, int index, char character) {
        return word.substring(0, index) + character + word.substring(index + 1);
    }
    private String insertLetterAt(String word, int index, char character) {
        return word.substring(0, index) + character + word.substring(index);
    }
    private String swapLetterAt(String word, int index) {
        if (index < word.length() - 1) {
            return word.substring(0, index) + word.charAt(index + 1) + word.charAt(index) + word.substring(index + 2);
        }else {
            return word;
        }
    }
}
