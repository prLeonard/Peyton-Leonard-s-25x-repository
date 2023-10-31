
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
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */
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
      
      
      /* your code here - determine how game ends */
      solved = true; 
    } 
   
  }
  public static void main(String[] args){
    System.out.println("Temporary Main method");
    PhraseSolver solver = new PhraseSolver();
  }
}