public class Runner {
    public static void main(String[] args) {
        String[] words = new String[]{"cat", "dog", "cats", "catsdog", "catsdogcats", "catsdogcatsdog", "catsdogcatsdogcats"};
        SpellChecker newCheck = new SpellChecker(words);
        String word = "crtr";

        String[] results = newCheck.checkWords(word);

        if (results.length == 0) {
            System.out.println("No suggestions for " + word + ".");
        } else {
            System.out.println("Suggestions for " + word + ":");
            for (String result : results) {
                System.out.println(result);
            }
        }
    }
}