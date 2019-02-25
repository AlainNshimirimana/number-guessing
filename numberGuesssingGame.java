import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    private static Scanner in = new Scanner(System.in);
    private static Random randGen = new Random();
    public static final int RANGE = 100;

    public static void main(String[] args) {
        gameDescription(); //describe the game to the player
        int numOfGames = game(); //let the player play the game and display how many games played at the end
    }
    
    //This method will describe and introduce the game to the user
    public static void gameDescription(){
        System.out.println("This program will allow you to play a guessing game.\nI "
                + "will think of a number between 1-100 and will allow you to "
                + "guess until you get it.");
        System.out.println("For each guess, I will tell you whether the "
                + "right answer is higher or lower than your guess.");
        System.out.println();
    }
    
    //This method will play the game and also return the amount of guesses it took to get the right answer
    public static void guessingGame(){
        int number = randGen.nextInt(RANGE) + 1; //computer will generate a random number between 1-100
        System.out.println("I am thinking of a number between 1-100.");
        //System.out.println(number); //this line shows the random generated number
        System.out.print("Type in your guess and hit ENTER: ");
        
        int guess = in.nextInt(); //get the user's guess
        int amountOfGuesses = 1; //we will use this to calcute how many tries it took to get the right answer
        
         while(guess != number){ 
             //Let the player know if their guess is higher or lower than the number the computer is thinking of
             if(guess > number){
                 System.out.println("It's lower.");
             }
             
             else if(guess < number){
                 System.out.println("It's higher.");
             }
             System.out.print("Guess again: "); //Ask them to guess again if they got it wrong
             guess = in.nextInt();
             amountOfGuesses++; //increase the amount of guesses by 1 each time they guess wrong until they get it right
         }
         
         //After they got it right, let them know that they got it right and how many tries it took.
         System.out.println("you got it right in " +amountOfGuesses+ " guesses!!");
         System.out.println();
        
    }
    /*this method will ask the player whether they want to start the game or not
    and return the number of games played
    */
    public static int game(){
        System.out.print("Would you like to play?: ");
        String play = "yes"; //set the default answer to yes
        play = in.next(); //This line will get the user's input (yes/no)
        int numOfGames = 0; //we will use this to count how many games were played
        
        
        while(!play.equalsIgnoreCase("no")){
            numOfGames++; //Increase the number of games played by 1
            guessingGame(); //play the game
            System.out.print("Would you like to play again?: "); //This will ask if the user wants to play again
            play = in.next(); //This line will get the user's input (yes/no)
        }
        if (numOfGames != 0){
            System.out.println("Thank you for playing! Goodbye.");
        }
        else{
            System.out.println("ok Goodbye :(");
        }
        System.out.println();
        System.out.println("You played a total of " +numOfGames+ " games.");
        return numOfGames;
    }
   
    
}
