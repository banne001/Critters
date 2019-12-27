import java.awt.*;

/** 
 * A Giant class that is a subclass of Critter
 * Prints either the name of fee, fie, foe, or fum in the color gray
 * Main moves are to go to the walls and circulate it in the 
 * Clockwise direction and infects anything that is in front of it
 * 
 * @author Blezyl Santos
 * @version 1.17 (Jan 17 2019)
 */
public class Giant extends Critter {
   private int steps;      // keeps track of the steps
   private String name;    // keeps track of the name it is since its changing 
   
   /**
    * A Giant Constructor that initializes the step at 0 and 
    * the name as fum
    */
   public Giant(){
      steps = 0;
      name = "fum";
      
   }
   /**
    * Returns the color of the Giant as grey   
    *
    * @return the grey to represent the Giant 
    */
   public Color getColor(){
      return Color.GRAY;
   }
   /**
    * For every 6 steps the Giant has taken the Giant will change  
    * from fee to fie; fie to foe; foe to fum; or fum to fie. And repeats
    * in this order
    *
    * @return name the name of the Giant as fee, fie, foe, or fum depending on the steps
    */

   public String toString(){
      if ( steps % 6 == 0 ){
         if (name == "fee" ){
            name = "fie";
         } else if (name == "fie"){
            name = "foe";
         } else if (name == "foe"){
            name = "fum";
         } else {
            name = "fee";
         } 
      } return name;
   }
   /**
    * Inserts all the information of the direction of the Giant
    * and its neighbor. If there is a critter in front it infects it, if not 
    * checks if its front is empty and moves forward (hops). Otherwise turn Right.
    *
    * @param info information of the Giant
    * @return the Action the bear will take either infect, hop, or turn Right
    */
   public Action getMove(CritterInfo info){
      steps++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) { 
         return Action.HOP;
      } else {
         return Action.RIGHT;
      }
   }
}

