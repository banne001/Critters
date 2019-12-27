import java.util.*;
import java.awt.*;

/** 
 * A bear class that is a subclass of Critter
 * Prints either a white or black polar bear as a "/" or "\"
 * General moves are to go to the walls and circulate it in the 
 * Counter-Clockwise direction 
 * and infects anything that is in front of it
 * 
 * @author Blezyl Santos
 * @version 1.17 (Jan 17 2019)
 */

public class Bear extends Critter {
   private boolean color;
   private String S;
   
   /**
    * A bear Constructor which takes in a boolean to decide if its
    * true or false. This boolean will effect the color of the bear. 
    * Starts with a "/" when printed
    *
    * @param polar a boolean to accept true or false for the bear
    */
   
   public Bear(boolean polar){
      if( polar == true ){ this.color = true; }
      else { this.color = false; }
      S = "/";
   } 
   /**
    * Returns the color of the bear depending if the color was
    * true or false. if true it will return white, if not it will  
    * return black
    *
    * @return the color of the bear white if true, else black 
    */
   public Color getColor(){
      if (color == true ){ return Color.WHITE; } 
      else {return Color.BLACK; }
   }
   
   /**
    * Returns a String of "/" or "\".
    * it will alternate between "/" and "\"
    * if it was a blackslash before it will become a slash
    * and vice versa.
    *
    * @return the String of bear as "/" or "\" depending on the previous string
    */
   
   public String toString(){
      if (S == "/"){ 
         S = "\\";
         return S;
      }
      else { 
         S = "/";
         return S;
      }
   }
   
   /**
    * Inserts all the information of the direction of the bear
    * and its neighbor. If there is a critter in front it infects it, if not 
    * checks if its front is empty and moves forward (hops). Otherwise turn left.
    *
    * @param info information of the Bear
    * @return the Action the bear will take either infect, hop, or turn left
    */
   public Action getMove(CritterInfo info){
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) { 
         return Action.HOP;
      } else {
         return Action.LEFT;
      }
   }
}     
   