// Rupert @ Min Khant Thaw
// Game A - Rock, paper, scissors

import java.util.Scanner;

public class qMain {
    static int Botcounter = 0, Usercounter = 0;
    // I had to use documentation and reddit for this part 'static int'
    // couldn't declare the variable in 'playingPart()' since it would always assign back to 0 when the user wants to play again.

    static Scanner scanner = new Scanner(System.in);
    // every time, I called the inputOutput() procedure in main program, the Scanner import always repeat again and again so,
    // I did like the above one.

    public static String inputOutput() {//a user interface in a separate procedure
        System.out.println("      ROCK               PAPER                SCISSORS");

        //CREDIT TO 'wynand1004' for uploading this ASCII art in GITHUB (I LOVE GITHUB)
        System.out.println(("""
    _______            _______                _______
---'   ____)      ---'    ____)____       ---'   ____)____
      (_____)                 ______)               ______)
      (_____)               _______)             __________)
      (____)               _______)             (____)
---.__(___)       ---.__________)         ---.__(___)
"""));
        System.out.println("     Enter 'r' for rock                ");
        System.out.println("     Enter 'p' for paper               ");
        System.out.println("     Enter 's' for scissors            ");
        System.out.println();

        System.out.print("Please Enter your option: ");
        return scanner.nextLine().toLowerCase();
    }

    public static void displayScore() { //scoreboard
        System.out.println("Bot: " + Botcounter + " | You: " + Usercounter);
    }

    public static boolean inputCheck(String input) { //procedure for validating the user input. Comparing with 'r', 's', 'p'
        if (input .equals("r") || input .equals("p") || input .equals("s")) {
            return false;
        } else  {
            System.out.println();
            System.out.print("INVALID INPUT. You must pick either 'r', 'p' or 's'.");
            System.out.println();
            System.out.println();
            return true;

        }
    }

    public static void playingPart(String userChoice) { // procedure for actual playing part


        switch ((int) (Math.random() * 3) + 1) {
            case 1: //bot picked r (rock)
                if (userChoice.equals("r")) {
                    System.out.println("We picked the same thing! Lucky you, I was about to pick a different one!");
                    displayScore();

                } else if (userChoice.equals("p")) {
                    System.out.println("I picked rock");
                    System.out.println("You covered the rock. You win.");
                    Usercounter++;
                    displayScore();

                } else if (userChoice.equals("s")) {
                    System.out.println("I picked rock");
                    System.out.println("I WIN! THE ROCK THE BEST!!");
                    Botcounter++;
                    displayScore();

                }
                break;

            case 2: //bot picked p (paper)
                if (userChoice.equals("p")) {
                    System.out.println("We picked the same thing! Lucky you, I was about to pick a different one!");
                    displayScore();

                } else if (userChoice.equals("s")) {
                    System.out.println("I picked paper");
                    System.out.println("You cut my paper in half, you win...");
                    Usercounter++;
                    displayScore();

                } else if (userChoice.equals("r")) {

                    System.out.println("I picked paper");
                    System.out.println("I win... The nature of paper is always light and calm");
                    Botcounter++;
                    displayScore();

                }
                break;

            case 3: //bot picked s (scissors)
                if (userChoice.equals("s")) {
                    System.out.println("We picked the same thing! Lucky you, I was about to pick a different one!");
                    displayScore();

                } else if (userChoice.equals("r")) {
                    System.out.println("I picked scissors");
                    System.out.println("Darn, you broke my scissors. You win!");
                    Usercounter++;
                    displayScore();

                } else if (userChoice.equals("p")) {
                    System.out.println("I picked scissors");
                    System.out.println("Win win. Scissors can cut in half");
                    Botcounter++;
                    displayScore();

                }
                break;

        }
    }

    public static void main(String[] args) { //procedure where all the subsets come together
        int round = 0;
        String playAgain = null;

        System.out.println("          --WELCOME TO THE RUPERT'S CREATION--        ");

        // the most tricky part
        do{
            boolean check = true;
            String userinput = null;

            while (check) {
                userinput = inputOutput();
                check = inputCheck(userinput);
            }
            playingPart(userinput);
            round++; //I added this to let the user know how many rounds she/he has played
            System.out.println();

            do {
                System.out.print("Would you like to play again. Please Enter either 'y' or 'n': ");
                playAgain = scanner.nextLine().toLowerCase();
                System.out.println();
                if (!playAgain.equals("n") && !playAgain.equals("y")) {
                    //false && false so, asked the bot to re-input again

                    System.out.print("INVALID INPUT. Pick either 'y' or 'n': ");
                    System.out.println();
                } else if (playAgain.equals("n")) {
                    System.out.println("Final scores ---> Bot: " + Botcounter + " | You: " + Usercounter);
                    System.out.println("Total rounds you have played: " + round);
                    break;
                }
            } while (!playAgain.equals("y")); //without "!playAgain.equals(("y"))" the validation loop of playing again never ends when 'y' is inputted

        } while (playAgain.equals("y"));
    }

}
