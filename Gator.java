import java.awt.*;
import java.util.*;
/** 
 * A Gator class that is a subclass of Critter
 * Prints "G" in the color pink
 * General moves are to go to the walls and circulate it in the 
 * Clockwise direction. If not by the walls it finds a fellow gator 
 * and goes to the wall together. If it does nothing for 50 steps it goes in the 
 * counterclockwise direction unless faced by fellow Gator. Infects anything that is in front of it.
 * 
 * @author Blezyl Santos
 * @version 1.17 (Jan 17 2019)
 */

public class Gator extends Critter{
   private int nothing;
   private Action move;
   private Random rand;
   
   /**
    * A Gator Constructor that declares the random
    * and initializes nothing at 0
    */
   public Gator(){
      rand = new Random();
      nothing = 0;   
   }
    /**
    * Returns the color of the Gator as Pink   
    *
    * @return the color pink to represent the Gator 
    */

   public Color getColor(){
      return Color.PINK;
   }
   /**
    * Returns a String "G" to represent the Gator
    * 
    * @return the String of Gator as "G"
    */
   public String toString(){
      return "G";
   }
   /**
    * Inserts all the information of the direction of the lion
    * and its neighbor. If there is a critter in front it infects it. finds
    * a wall and decide either it turns left or right. Moves next to wall unless
    * encountered by fellow Gator. 
    * Adds 1 to nothing if Gator has not infected a Critter, otherwise it resets at 0
    * Goes the Counter - Clockwise direction if it has done nothing for more than 50 moves
    * unless encuntered by fellow gator.
    *
    * @param info information of the Gator
    * @return the Action the Gator will take either infect, hop, 
    * or turn left or right depending on situation
    */
   public Action getMove(CritterInfo info){
      //infects critter 
      if (info.getFront() == Neighbor.OTHER) {
         nothing = 0;
         move =  Action.INFECT;
            
      } else if (info.getFront() == Neighbor.SAME) {
         move = checkFront(info);
            
      } else if (nothing >= 50){
         nothing++;
         if (info.getRight() == Neighbor.WALL) {
            if (info.getFront() == Neighbor.EMPTY){
              move = Action.HOP; 
            } else { move = Action.LEFT; }
         } else if (info.getFront()== Neighbor.EMPTY) {
            move = Action.HOP;
         } else if (info.getFront() == Neighbor.WALL) {
           nothing++;
            int direc = rand.nextInt(2);
            if(direc == 0){
               move = Action.LEFT;
            } else { move = Action.RIGHT;}
         } else {
            move = Action.RIGHT;
         }
      } else if (info.getFront() == Neighbor.WALL) {
         nothing++;
         int direc = rand.nextInt(2);
         if(direc == 0){
            move = Action.LEFT;
         } else { move = Action.RIGHT;}
      } else if (info.getLeft() == Neighbor.WALL) {
         nothing++;
         if (info.getFront()== Neighbor.EMPTY) {
            move = Action.HOP;   
         }  else { move = Action.RIGHT;}
      } else {
         move = Action.HOP;
      } return move;
   } 
   /**
    * Inserts all the information of the direction of the Gator
    * and its neighbor. Check the direction of the Gator infront of it
    * and goes the direction so they are both facing the same direction.
    *
    * @param info information of the Gator
    * @return move the Action the lion will take either infect, hop, 
    * or turn left or right depending on situation
    */
   public Action checkFront(CritterInfo info){
      nothing++;
       if (info.getFront() ==Neighbor.WALL){
         move = Action.RIGHT;
       } else if (info.getFrontDirection() == Direction.EAST){
          move =  Action.RIGHT;
       } else if (info.getFrontDirection() == Direction.SOUTH){
          move = Action.RIGHT;
       } else if (info.getFrontDirection() == Direction.NORTH){
          move = Action.LEFT;
       } else if (info.getFrontDirection() == Direction.WEST){
          move = Action.LEFT;
       }return move;
   }
}