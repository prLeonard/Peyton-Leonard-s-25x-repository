/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int score;
  private int wins;
  /* your code here - constructor(s) */ 
  public Player(){
    System.out.println("Enter player name: ");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();
    System.out.println("Hello and welcome to the game, " + name);
    score = 0;
  }
  public Player(String inputName){
    name = inputName;
    score = 0;
    System.out.println("Hello and welcome to the game, " + name);
  }
  /* your code here - accessor(s) */ 

  /* your code here - mutator(s) */ 
}