package characters.person.patient13;

import characters.CharacterCreator;
import characters.PlayerCharacter;

/**
 *
 * @author Nicolas Brax
 */
public class PatientCreator implements CharacterCreator {
  
  private PatientPlayerCharacter character;
  
  public PatientCreator(){
    this.character = null;
  }
  
  @Override
  public String ValidateCharacter(){
    return null;
  }
  
  @Override
  public void createCharacter(){
    character = new PatientPlayerCharacter();
  }
  
  @Override
  public PlayerCharacter getCharacter(){
    return this.character;
  }
  
  // plus all methods to modify the character according to both the creation 
  // rules and the game
    
}
