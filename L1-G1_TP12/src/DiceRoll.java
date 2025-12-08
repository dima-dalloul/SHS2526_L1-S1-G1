import java.io.*;
import java.util.Scanner;

public class DiceRoll {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to TP12 - Dice Roll");

        // We will open the previous score file and we prepare a file writer
        BufferedReader fileReader = new BufferedReader(new FileReader("score.txt"));
        String lineRead = fileReader.readLine();
        String previousUser = "";
        int previousScore = -1;
        for(int i = 0; i < 2 && lineRead != null; i++){
            if(i == 0)  // We are on the first line
                previousUser = lineRead;
            else        // We are on the second line
                previousScore = Integer.parseInt(lineRead);

            // We continue to the next line
            lineRead = fileReader.readLine();
        }

        System.out.println("Previous user is " + previousUser + " and scored : " + previousScore);
        System.out.println("Let's play");

        // We will listen to the user
        Scanner s = new Scanner(System.in);
        char answerUser = ' ';
        int dice1, dice2, score, globalScore = 0;
        // We enter the loop
        do{
            // Let's roll the dice
            dice1 = (int) (Math.random() * (6 + 1) );
            dice2 = (int) (Math.random() * (6 + 1) );
            score = dice1 + dice2;

            // We show the user the result
            System.out.print("Roll of the dice : " + dice1 + " & " + dice2 + ". Score : ");

            // We test if score equals 7
            if(score == 7){
                System.out.println(score + ".");
                System.out.println("You lost !");
                break;
            }  else {
                globalScore += score;
                System.out.println(globalScore + ".");
                // We ask the user if he/she wants to stop
                System.out.println("Shall we continue? (y/n)");
                answerUser = s.nextLine().charAt(0);
            }
        } while (answerUser == 'y');

        System.out.println("Your final score is : " + globalScore);

        // We compare the current global score with the previous one
        if(globalScore > previousScore){
            // if the user beat the previous score, we're going to save it
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("score.txt"));
            System.out.println("Congrats ! You beat the previous score. We're going to save this achievement");
            System.out.println("What's your name?");
            String name = s.nextLine();
            fileWriter.write(name);
            fileWriter.newLine();
            fileWriter.write(""+ globalScore);
            fileWriter.newLine();
            System.out.println("Done writing to score.txt");
            fileWriter.close();
        }

        System.out.println("Thank you and goodbye !");
        fileReader.close();
    }
}
