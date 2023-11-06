 
import java.util.Scanner;
import java.io.File;
/** Board, represents a game board handling a hangman type game, uses various methods to allow a user to guess attempt to solve a provided phrase
 * 
 * @author Peyton Leonard, PLTW
 * @version 1.1
 * @date 10/30/23
 * 
 */
public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 
  
  /* your code here - constructor(s) */ 
  /* Constructor of Board class
  **/
  public Board(){
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
    //System.out.println("Phrase: " + phrase); //temp test code
  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  /* Sets currentLetterValue to a randomly generated integer
  *
  * @see getLetterVal
  * Precondition:
  *  None
  * Postcondition
  *  None
  */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }
  /** Checks if the guess completes the phrase
  *
  *  @param guess    User inputted guess string
  *  @return boolean condition
  *  @see guessLetter()
  *  
  *  Precondition:
  *    guess is nonzero in length
  *  Postcondition:
  *    Always a boolean value
  *    No modifications
  */
  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }
  /** Fetches a random phrase from the phrases.txt file
    *
    *  @return String tempPhrase assigned to class attribute
    *  @see guessLetter()
    *  @throws File parse console output
    *  
    *  Precondition:
    *    file.txt has text
    *  Postcondition:
    *    Always a String
    *    Assigned to class attribute
    *    Contains spaces
    *    Always lowercase
    *    Assigns solvedPhrase to be a string of entirely underscores and spaces based on the length of the randomly selected phrase. It should also be noted that each underscore is separated by a space, and thus every word is separated by 3 spaces.
    */
  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  
  /** Updates the solvedPhrase string based on the guess input
  * @param guess Single letter user inputted guess of a certain letter in phrase
  * @return      Updated solvedPhrase with appropriate underscores replaced by guess
  * @see         Board
  * Precondition: 
  *  guess is one letter
  * Postcondition:
  *  Boolean
  *  solvedPhrase contains underscores and spaces for each letter
  */
  public boolean guessLetter(String guess)
  {
    //Initialize certain values
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    //Iterates over all characters in phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      //compares each letter to the guess argument
      if (phrase.substring(i, i + 1).equals(guess))
      {
        //Adds guess to newSolvedPhrase with a space, then updates
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      else
      {
        // copies underscore over with an extra space
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
        //end of condition
      }
    //end of loop  
    }
    //updates the solved phrase attribute and returns foundLetter
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  } 
  public String getSolvedPhrase(){return solvedPhrase;}
  /** Returns the value of phrase of the object its called on
    * @return String phrase: value of phrase
    * @see Player
    * 
    * Precondition:
    *  phrase is occupied by a nonnull value
    * Postcondition 
    *  string is always returned
    *  object always exists
    */
  public String getPhrase(){return phrase;}
  /** Returns the value of currentLetterValue of the object its called on
    * @return int currentLetterValue: value of currentLetterValue
    * @see Player
    * 
    * Precondition:
    *  currentLetterValue is occupied by a nonnull value
    * Postcondition 
    *  integer is always returned
    *  object always exists
    */
  public int getLetterVal(){return currentLetterValue;}
} 