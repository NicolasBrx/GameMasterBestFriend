package dices_mechanisms;

import exceptions.RPG_DiceException;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class handles die mechanism for the RPG called Notre Tombeau. In this 
 * game several six face dices are launched for each test. To succeed, a given 
 * amount of dice must exceed a threshold, usually 4.
 * @author Nicolas Brax
 */
public class TombeauMechanism implements GameMechanism {
  
  /**
   * The scores hit by the dices after a launch.
   */
  private ArrayList<Integer> scores = new ArrayList<>();
  
  /**
   * This method is an indicator to the fact that the mechanism is static or 
   * not, meaning that each test is resolved using the same launch or that each
   * launch can use different dice according to contexts. In Notre Tombeau, 
   * it is not always the same as different numbers of 6-faced dice might
   * be launched at any test. Then it is compared to a given threshold 
   * determined by the Game Master according to the launch context.
   * @return False since for Shadowrun launches might be different one from 
   *         another.
   */
  @Override
  public boolean staticMechanism(){
    return true;
  }
  
  /**
   * Analyse the expression to resolve the dice launch. For Patient 13, the 
   * three dices are launched and then the scores are analysed to give the 
   * result. This result is computed as follows: 
   *  - Two or more dices over the threshold 4 give a success;
   *  - otherwise it is a failure.
   *  - Critical success or glitches are also indicated.
   * @param exp the expression to analyse, IT MUST BE "3D6 --threshold2".
   * @return a String containing the dice scores and the results.
   * @throws RPG_DiceException This expression is thrown if the expression is 
   *                           not understandable by this engine.
   */
  @Override
  public String launchDices(String exp) throws RPG_DiceException{
    scores.clear();
    String toReturn = "";
    Random rand = new Random();
    try{
      int numberOfLaunch = Integer.parseInt(exp.split("D|d")[0]);
      int threshold = Integer.parseInt(exp.split("--threshold")[1].trim());
      int hits = 0, relaunch = 0;
      for(int i = 0 ; i < numberOfLaunch ; ++i){
        scores.add(rand.nextInt(6) + 1);
        if(scores.get(i) == 6){
          numberOfLaunch++;
          relaunch++;
        }
        if(scores.get(i) >= 4){hits++;}
        toReturn += scores 
                 + " --result "
                 + ((hits == threshold) ? "success"                             // if equals to the threshold this is a success
                                        : ((hits > threshold) ? "good success"  // else if it is above the threshold, it is a good success
                                          : ((hits == 0) ? "bad failure"        // else if there is no single hit, this is a bad failure
                                            : "failure")));                     // else it is a failure
        toReturn += " --hits(" + hits + ")"
                 + " --relaunch(" + relaunch 
                 + ") --threshold(" + threshold +")";
      }
    }//try
    catch(Exception e){
      throw new RPG_DiceException("Can't analyse the dice expression "
                                                        + "for Notre Tombeau.");
    }
    return toReturn;
  }
  
  /**
   * The expression that MUST be used for the game Notre Tombeau. Capital 
   * letters other than D might be replaced by digits.
   * @return the expression to use.
   */
  @Override
  public String helpExpression(){
    return "XD6 --thresholdT (static)";
  }
    
  /**
   * This method gives a quick description of how the die mechanism for the 
   * game Notre Tombeau works.
   * @return a description of the die mechanism.
   */
  @Override
  public String mechanismQuickDescription(){
    return "In Notre Tombeau, several 6-faced dice are launched when a test is "
            + "required. The number of dice to launch is determined by the "
            + "related skill to the test. Then all scores above or equal to "
            + "4 are hits. Each 6 scored is launched again. Then the number "
            + "of hits is compared to a given threshold determined by the "
            + "Game Master:\r\n"
            + " - equals the threshold, it is a success;\r\n"
            + " - over the threshold, it is a good success;\r\n"
            + " - below the threshold, it is a failure;\r\n"
            + " - no hit at all, it is a bad failure.\r\n";
  }  
}
