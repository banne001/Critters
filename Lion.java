import java.awt.*;
import java.util.*;

/** 
 * A lion class that is a subclass of Critter
 * Prints either a red, green, or blue "L" 
 * General moves are to go to up and down or side to side of the walls
 * and infects anything that is in front of it
 * 
 * @author Blezyl Santos
 * @version 1.17 (Jan 17 2019)
 */
public class Lion extends Critter{
   private Random rand;    // initializes random 
   private int steps;      // keep the track of steps
   private Color color;   
   
   /**
    * A lion Constructor that declares the random
    * and initializes the step at 0
    */
   public Lion(){
      rand = new Random();
      steps = 0;
   }
   /**
    * For every 3 steps the lion has taken the lion will change  
    * randomly between red, blue, or green.
    *
    * @return the color of the lion as blue, red, or green
    */
   public Color getColor(){
      if (steps%3 == 0){      // if divisible by 3 means it has taken 3 steps
         int color = rand.nextInt(3);  // randomly picks a number between 0 and 2
         if (color == 0) {             // red if number was 0
            this.color = Color.RED;
         } else if (color == 1) {      // blue if number was 1 
            this.color = Color.BLUE;
         } else{ this.color = Color.GREEN; } // else it is green 
      } return this.color;
   }
   /**
    * Returns a String "L" to represent the lion
    * 
    * @return the String of lion as "L"
    */
   public String toString(){
      return "L";
   }
   /**
    * Inserts all the information of the direction of the lion
    * and its neighbor. If there is a critter in front it infects it; if not 
    * checks if its front or right is a wall and turns left; if not checks if
    * in front is also a lion and turns right. Otherwise it hops forward
    *
    * @param info information of the Lion
    * @return the Action the lion will take either infect, hop, or turn left or right
    */
   public Action getMove(CritterInfo info){
      steps ++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
         return Action.LEFT;
      } else if (info.getFront() == Neighbor.SAME){
         return Action.RIGHT;
      } else { return Action.HOP;}

   }
}