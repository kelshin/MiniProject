package MiniProject.MiniProject1;

import java.util.Scanner;

public class Question {
    public static int Number_Of_Tries = 10;

    public static void guessAndMatch(String city, String theBlank){
        String wrongs = "";
        int tries = Number_Of_Tries;
        while (true){
            System.out.print("Guess a letter: ");
            Scanner in = new Scanner(System.in);
            char guessInput = in.next().charAt(0);
            System.out.printf("You are guessing: %c \n", guessInput);
            String[] checkReturn = checkMatch(guessInput, city, theBlank);
            theBlank = checkReturn[0];
            System.out.println(theBlank);
            if(Integer.parseInt(checkReturn[1]) == 0){
                wrongs += Character.toString(guessInput) + " ";
                tries--;
            }
            if(ifGuessed(theBlank)){
                System.out.println("You win!");
                System.out.printf("You have guessed '%s' correctly.", city);
                break;
            } else if (tries == 0){
                System.out.println("You lose!");
                System.out.printf("The word was '%s' correctly.", city);
                break;
            } else {
                System.out.printf("You have guessed (%d) wrong letters: %s\n", Number_Of_Tries - tries, wrongs);
            }

        }
    }

    public static String[] checkMatch(char guess, String city, String theBlank){
        int index = 0;
        int matched = 0;
        char[] breakBlank = theBlank.toCharArray();
        for (char ch : city.toCharArray()){
            if(Character.toUpperCase(guess) == ch || Character.toLowerCase(guess) == ch){
                breakBlank[index] = ch;
                matched++;
            }
            index++;
        }
        return new String[] {String.valueOf(breakBlank), Integer.toString(matched)};
    }

    public static boolean ifGuessed(String word){
        return !word.contains("_");
    }
}
