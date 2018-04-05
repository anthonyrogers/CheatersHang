import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class PlayHangman {


    public static void main(String [] args){
        ArrayList<Integer> longestWordInDictionary = new ArrayList<>();
        int numOfLetter=0;
        int numOfGuess=0;
        char userGuess;




        ArrayList<String> dictionary = new ArrayList<>();
        String fileName = "dictionary.txt";
        Scanner scan = new Scanner(System.in);


        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(!longestWordInDictionary.contains(line.length())){
                    longestWordInDictionary.add(line.length());
                }
                if(line.length() == numOfLetter){
                    dictionary.add(line);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        System.out.println("How many letter spaces would you like to have for hangman?: ");
        int spaces = scan.nextInt();
        if(!longestWordInDictionary.contains(spaces)){
            while(!longestWordInDictionary.contains(spaces)){
                System.out.println("Sorry, Please choose a different length for a word!");
                spaces = scan.nextInt();
            }
        }else{
            numOfLetter = spaces;
        }
        System.out.println("How many chances do you want of guessing?: ");
        numOfGuess = scan.nextInt();


        Hangman hang = new Hangman(numOfLetter,numOfGuess, dictionary);

        System.out.println(longestWordInDictionary);


         System.out.println("Please input first Character: ");
        userGuess = scan.next().charAt(0);

        while(hang.play(userGuess)==true){
            System.out.println("next Character: ");
            userGuess = scan.next().charAt(0);

        }

    /*   hang.play('y');
        hang.play('t');
        hang.play('e');
        hang.play('i');
        hang.play('o');
        hang.play('t');*/


    }
}
