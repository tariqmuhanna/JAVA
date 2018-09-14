package assignment2;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class game {
    public static void main(String[] args) throws FileNotFoundException {
        String code = SecretCodeGenerator.getInstance().getNewSecretCode();
        System.out.println(code);

        Scanner kb = new Scanner(System.in);
        System.out.println("You have " + GameConfiguration.guessNumber + ", please enter your guess: ");
        String readString = kb.nextLine();

        String[] feedback = new String[12];
        String[] answerList = new String[12];
        for(int i=0; i < GameConfiguration.guessNumber; i++) {
            answerList[i] = readString;
            feedback[i] = wordComparison(code, readString);
            printFeedback(i, answerList, feedback);

        }
        //System.out.println(wordComparison(code, readString));

    }

    public static String wordComparison(String ans, String word){
        Boolean completedFlag = false;
        int white = 0;
        int black = 0;

        for (int i=0; i < 4; i++){
            if(ans.charAt(i) == word.charAt(i))
                black++;
        }
//        System.out.print("b: ");
//        System.out.print(black);


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
//        System.out.print(" w: ");
//        System.out.print(white);
        String s = black + "b_" + "w" + white;
        return s;
    }
    public static void printFeedback(int iterations, String[] fd, String[] ans){
        for (int i=0; i < iterations; i++){

        }

    }
}


