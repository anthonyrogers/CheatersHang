import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Hangman {

    private int numOfLetter;
    private int numOfGuess;
    private ArrayList<String> wordList;
    private String output;
    private String finalAnswer;
    private ArrayList<Character> guessed = new ArrayList<>();


    public Hangman(int numOfLetter, int numOfGuess, ArrayList<String> dictionary) {
        this.numOfLetter = numOfLetter;
        this.numOfGuess = numOfGuess;
        wordList = new ArrayList<>(dictionary);


        char[] outputArray = new char[numOfLetter];
        for (int i = 0; i < numOfLetter; i++) {
            outputArray[i] = '_';
        }

        output = new String(outputArray);

    }



    public ArrayList<String> getWordList() {
        return wordList;
    }


    public boolean play(char guess) {
        String HighestNumKey = output;
        boolean guessRight = false;
        HashMap<String, ArrayList<String>> wordChoices = new HashMap<>();



//checks to see which characters were used already.
        if(guessed.contains(guess)){
            System.out.println("You already used this character. Please choose another: ");
        }else {
            guessed.add(guess);




// Parse all words in word list to create keys for the hash map
            for (String word : wordList) {
                char[] key = new char[numOfLetter];

                for (int index = 0; index < numOfLetter; index++) {
                    if (word.charAt(index) == guess) {
                        key[index] = guess;
                    } else {
                        key[index] = output.charAt(index);
                    }
                }

                String keyString = new String(key);
                addWordChoice(keyString, word, wordChoices);



 //checks to see if there is a Key and if there is it compares which key contains the biggest array of words
                if (!wordChoices.keySet().contains(HighestNumKey)) {
                    HighestNumKey = keyString;
                }
                if (wordChoices.get(keyString).size() > wordChoices.get(HighestNumKey).size()) {
                    HighestNumKey = keyString;
                }
            }
            wordList = wordChoices.get(HighestNumKey);// makes new wordlist using largest with characters removed.
            output = HighestNumKey;
            System.out.println(wordList);

            // System.out.println(wordList);
            System.out.println(output);
            //System.out.println(wordChoices.get(HighestNumKey));
            //  System.out.println(wordChoices.get(HighestNumKey).size());

        }return true;
    }


    //creates a new array list if hashmap contains null. if it contains key then it inserts string into arraylist under that key.
    private void addWordChoice(String key, String word, HashMap<String, ArrayList<String>> wordChoiceMap) {
        if (wordChoiceMap.get(key) == null) {
            wordChoiceMap.put(key, new ArrayList<String>());
        }
        wordChoiceMap.get(key).add(word);
    }

}
