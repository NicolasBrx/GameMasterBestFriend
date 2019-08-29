package tools;

import exceptions.RPG_XMLException;

/**
 *
 * @author Nicolas Brax
 */
public interface XMLLoader {
  
  /**
   * 
   * @param name
   * @return 
   * @throws exceptions.RPG_XMLException 
   */
  public Character loadCharacter(String name) throws RPG_XMLException ;
   
  /**
   * 
   * @param toSave 
   * @throws exceptions.RPG_XMLException 
   */
  public void saveCharacter(Character toSave) throws RPG_XMLException ;
  
}
