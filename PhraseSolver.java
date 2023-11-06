
import java.util.Scanner;
  /** PhraseSolver, solves phrases, gets solutions from players to do so
  * @author Peyton Leonard, PLTW
  * @version 1.1
  * @date 10/30/23
  */
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board display;
  private boolean solved;
  /* your code here - constructor(s) */ 
  /** Default constructor of PhraseSolver class
  *  Precondition:
  *    none
  *  Postcondition:
  *    newly populated object
  */
  public PhraseSolver(){
    player1 = new Player();
    player2 = new Player();
    display = new Board();
    solved = false;
  }
  
  /**  
  * play(): The main process of the game, where players take turns inputting guesses
  * @see Board.java
  * 
  * Precondition:
  *  None
  * Postcondition:
  *  None
  */
  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      
      /* your code here - game logic */
      System.out.println("Make a guess Player " + currentPlayer + " (one letter or try and solve the entire puzzle):");
      //ask user for guess and keep asking them until the guess is considered valid. 
      String guess = input.nextLine();
      boolean validGuess = false;
      while (!validGuess){
        if (!guess.contains("[^a-zA-Z]")){
          validGuess = true;
        } else {
          System.out.println("Invalid guess, go again");
          guess = input.nextLine();
        }
      }
      
      boolean huh = display.guessLetter(guess);
      
      /* your code here - determine how game ends */
      //Gives player whose turn it is 100 points for solved.
      if (display.isSolved(guess)){
        if (currentPlayer == 1){
          player1.setScore(player1.getScore() + 1000);
        } else {
          player2.setScore(player2.getScore() + 1000);
        }
        //otherwise, swap the turn
      } else {
        //and add points to the appropriate player if the guess added new letters
        if (huh){
          if(currentPlayer == 1){
            player1.setScore(player1.getScore() + display.getLetterVal());
          } else {
            player2.setScore(player2.getScore() + display.getLetterVal());
          }
        }
        if(currentPlayer == 1){ 
          currentPlayer = 2;
        } else {
          currentPlayer = 1;
        }
      }
      System.out.println(player1.getName() + " score: " + player1.getScore());
      System.out.println(player2.getName() + " score: " + player2.getScore());
      System.out.println("Progress: " + display.getSolvedPhrase());
      solved = display.isSolved(guess);
      
    } 
    System.out.println("Congratulations player " + currentPlayer + "! \nYou have won the game. \nThe correct phrase was: " +display.getPhrase() + "\n");
    System.out.println(player1.getName()+ " scored " + player1.getScore() + " points.");
    System.out.println(player2.getName()+ " scored " + player2.getScore() + " points.");
  }
  
}