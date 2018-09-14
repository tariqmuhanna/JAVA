package assignment2;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class game {
    public static void main(String[] args) throws FileNotFoundException {
        String code = SecretCodeGenerator.getInstance().getNewSecretCode();
        System.out.println(code);

        String[] feedback = new String[12];
        String[] answerList = new String[12];
        int turnsLeft = GameConfiguration.guessNumber;

        Scanner kb = new Scanner(System.in);
        String readString;

        System.out.println("Welcome to Mastermind.");
        System.out.println("Do you want to play a new game? (Y/N):");
        readString = kb.nextLine();
        System.out.println();
        while (readString.equals("Y")){

            for (int i = 0; i < GameConfiguration.guessNumber; i++) {
                System.out.println("You have " + (turnsLeft-i) + " guess(es) left.");
                System.out.println("Enter guess:");
                readString = kb.nextLine();

                if (readString.equals("HISTORY"))
                    printFeedback(i--, answerList, feedback);

                else if (!checkUserGuess(readString))
                    i--;

                else {
                    answerList[i] = readString;
                    feedback[i] = wordComparison(code, readString);
                    if (readString.equals(code)){
                        System.out.println(answerList[i] + " -> " + feedback[i]);
                        System.out.println("You win!");
                        System.out.println();
                        break;
                    }
                    System.out.println(answerList[i] + " -> " + feedback[i]);
                    System.out.println();
                }
            }
            if (!readString.equals(code))
                System.out.println("You lose! The pattern was " + code);
            System.out.println();
            System.out.println("Do you want to play a new game? (Y/N)");
            readString = kb.nextLine();
        }

        kb.close();
    }

    public static Boolean checkUserGuess(String guess){
        for (int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) <= 65 | guess.charAt(i) >= 91){
                System.out.println("INVALID_GUESS\n");
                return false;
            }
        }

        if (guess.length() != 4) {
            System.out.println("INVALID_GUESS\n");
            return false;
        }
        return true;
    }

    public static String wordComparison(String ans, String word){
        Boolean completedFlag = false;
        int white = 0;
        int black = 0;

        for (int i=0; i < 4; i++){
            if(ans.charAt(i) == word.charAt(i))
                black++;
        }

        for (int i=0; i < 4; i++){  // Goes through answer string

            for (int k=0; k < i; k++){              // Checks to see we don't double count a letter
                if(ans.charAt(i) == ans.charAt(k))
                    completedFlag = true;           // Sets flag if letter was already accounted for
            }
            if(!completedFlag) {                    // If new char, proceed to compare strings

                for (int j = 0; j < 4; j++) {       // Checks for white peg feedback
                    if (ans.charAt(i) == word.charAt(j) &
                            i != j &
                            ans.charAt(j) != word.charAt(j) &
                            ans.charAt(i) != word.charAt(i)) {
                        white++;
                        break;
                    }
                }
            }
            completedFlag = false;  // Resets flag
        }

        String s = black + "b_" + white + "w";
        return s;
    }

    public static void printFeedback(int iterations, String[] ans, String[] fd){
        for (int i=0; i < iterations; i++){
            System.out.println(ans[i] + " -> " + fd[i]);
        }
        System.out.println();

    }
}


