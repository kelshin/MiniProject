package MiniProject.MiniProject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static MiniProject.MiniProject1.Question.*;

public class Hangman {
    private String guessCity;
    public StringBuilder theBlank = new StringBuilder();

    public Hangman() throws FileNotFoundException {
        try {
            File f = new File("src/MiniProject/MiniProject1/cities.txt");
            Scanner city = new Scanner(f);
            int rand = (int)(Math.random() * 100) + 1;
            while (city.hasNextLine()){
                if(rand == 1){
                    String line = city.nextLine();
                    this.guessCity = line;
                }
                city.nextLine();
                rand--;
            }
        } catch (FileNotFoundException e){
            System.out.println("empty");
        }
    }

    public void gameStart(){
        //System.out.println(this.guessCity);
        System.out.println("Here's the question.");
        for (int c = 0; c != this.guessCity.length(); c++){
            char checkChar = this.guessCity.charAt(c);
            if(Character.toString(checkChar).equals(" ")){
                System.out.print(" ");
                this.theBlank.append(" ");
            } else {
                System.out.print("_");
                this.theBlank.append("_");
            }
        }
        System.out.println();
        guessAndMatch(this.guessCity, theBlank.toString());
    }

}
