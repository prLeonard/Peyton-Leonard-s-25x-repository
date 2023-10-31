
import java.util.Scanner;
/** Player class, represents one player of the hangman game, provides an interface with said player's points and name
 * @author Peyton Leonard, PLTW
 * @version 1.1
 * @date 10/30/23
 */
public class Player
{
  /* your code here - attributes */
  private String name;
  private int score;
  private int wins;
  /* your code here - constructor(s) */ 
  /* Default constructor of Player class
  */
  public Player(){
    System.out.println("Enter player name: ");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();
    System.out.println("Hello and welcome to the game, " + name);
    score = 0;
  }
  /* One parameter constructor of Player class
  * @param inputName    User provided name for the player class
  * @see above constructor
  */
  public Player(String inputName){
    name = inputName;
    score = 0;
    System.out.println("Hello and welcome to the game, " + name);
  }
  
  public int getPoints(){/*not yet implemented*/ return "";}
  public String getName(){/*not yet implemented*/ return 0;}
  public void setPoints(int i){/*not yet implemented*/}
  public void setName(String s){/*not yet implemented*/}
  /* your code here - accessor(s) */ 

  /* your code here - mutator(s) */ 
}