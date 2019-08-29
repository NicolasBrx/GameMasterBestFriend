/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters.person.shadowrun;

import characters.CharacterCreator;
import characters.PlayerCharacter;

/**
 *
 * @author nibrax
 */
public class ShadowrunCreator implements CharacterCreator {
    
  
  private ShadowrunPlayerCharacter character;
  
  public ShadowrunCreator(){
    this.character = null;
  }
  
  @Override
  public String ValidateCharacter(){
    return null;
  }
  
  @Override
  public void createCharacter(){
    character = new ShadowrunPlayerCharacter();
  }
  
  @Override
  public PlayerCharacter getCharacter(){
    return this.character;
  }
}
