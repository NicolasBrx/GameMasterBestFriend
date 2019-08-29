/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters.person.cthulhu;

import characters.CharacterCreator;
import characters.PlayerCharacter;

/**
 *
 * @author nibrax
 */
public class CthulhuCreator implements CharacterCreator {
  
  private CthulhuPlayerCharacter character;
  
  public CthulhuCreator(){
    this.character = null;
  }
  
  @Override
  public String ValidateCharacter(){
    return null;
  }
  
  @Override
  public void createCharacter(){
    character = new CthulhuPlayerCharacter();
  }
  
  @Override
  public PlayerCharacter getCharacter(){
    return this.character;
  }
    
}
