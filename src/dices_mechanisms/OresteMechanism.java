package dices_mechanisms;

import exceptions.RPG_DiceException;
import java.util.Random;

/**
 
 * @author Nicolas Brax
 */
public class OresteMechanism implements GameMechanism {

  
  /**
   * @return True since for Patient 13, 3D6 are always launched.
   */
  @Override
  public boolean staticMechanism(){
    return true;
  }
  
  /**
   * @throws RPG_DiceException This expression is thrown if the expression is 
   *                           not understandable by this engine.
   */
  @Override
  public String launchDices(String exp) throws RPG_DiceException{
    String toReturn = "";
 
    return toReturn;
  }
  
  /**
   * The expression that MUST be used for the game Patient 13.
   * 
   * @return the expression to use.
   */
  @Override
  public String helpExpression(){
    return " ";
  }
    
  /**
   * This method gives a quick description of how the die mechanism for the 
   * game Patient 13 works.
   * @return a description of the die mechanism.
   */
  @Override
  public String mechanismQuickDescription(){
    return "In Oreste...";
  }
}
