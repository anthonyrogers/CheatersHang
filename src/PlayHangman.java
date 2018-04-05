import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class PlayHangman {


    public static void main(String [] args){
        int numOfLetter=0;
        int numOfGuess=0;
        char userGuess;




        ArrayList<String> dictionary = new ArrayList<>();



        String fileName = "dictionary.txt";

        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                if(line.length() == numOfLetter){
                    dictionary.add(line);
                }
            }
            scanner.close();

        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

       /* Scanner scan = new Scanner(System.in);

        System.out.println("How many numbers would you like to have for hangman?: ");
        numOfLetter = scan.nextInt();
        System.out.println("How many chances do you want of guessing?: ");
        numOfGuess = scan.nextInt();*/

        Hangman hang = new Hangman(numOfLetter,numOfGuess, dictionary);


       /* System.out.println("Please input first Character: ");
        userGuess = scan.next().charAt(0);
        System.out.println(userGuess);
        hang.play(userGuess);

        while(hang.play(userGuess)==true){
            System.out.println("next Character: ");
            userGuess = scan.next().charAt(0);
            System.out.println(userGuess);
            hang.play(userGuess);
        }*/

       hang.play('c');
        hang.play('a');
        hang.play('e');
        hang.play('i');
        hang.play('o');
        hang.play('t');


    }
}
