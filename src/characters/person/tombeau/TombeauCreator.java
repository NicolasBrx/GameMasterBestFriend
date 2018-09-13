package characters.person.tombeau;

import characters.CharacterCreator;
import characters.PlayerCharacter;

/**
 *
 * @author Nicolas Brax
 */
public class TombeauCreator implements CharacterCreator {
  
  private TombeauPlayerCharacter character;
  
  @Override
  public String ValidateCharacter(){
    return null;
  }
  
  @Override
  public void createCharacter(){
    character = new TombeauPlayerCharacter();
  }
  
  @Override
  public PlayerCharacter getCharacter(){
    return this.character;
  }
  
  // plus all methods to modify the character according to both the creation 
  // rules and the game
  
}
