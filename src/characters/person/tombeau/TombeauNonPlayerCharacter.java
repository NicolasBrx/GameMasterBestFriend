package characters.person.tombeau;

import characters.CharacterAttribute;
import characters.NonPlayerCharacter;
import exceptions.RPG_CharacterManagementException;

/**
 *
 * @author Nicolas Brax
 */
public class TombeauNonPlayerCharacter extends NonPlayerCharacter {
  
  private int maxLifePoints;
  private int currentLifePoints;
  
  public TombeauNonPlayerCharacter(){
    super();
    attributeList.put("bouger", new CharacterAttribute("bouger",1,1,6));
    attributeList.put("attaquer", new CharacterAttribute("attaquer",1,1,6));
    attributeList.put("encaisser", new CharacterAttribute("encaisser",1,1,6));
    attributeList.put("reagir", new CharacterAttribute("reagir",1,1,6));
    attributeList.put("remarquer", new CharacterAttribute("remarquer",1,1,6));
  }
  
  public int getMove(){
    return attributeList.get("bouger").getCurrentValue();
  }
  
  public void setMove(int move) throws RPG_CharacterManagementException {
    attributeList.get("bouger").setCurrentValue(move);
  }
  
  public int getAttack(){
    return attributeList.get("attaquer").getCurrentValue();
  }
  
  public void setAttack(int attack) throws RPG_CharacterManagementException {
    attributeList.get("attaquer").setCurrentValue(attack);
  }
  
  public int getTakeUp(){
    return attributeList.get("encaisser").getCurrentValue();
  }
  
  public void setTakeUp(int takeup) throws RPG_CharacterManagementException {
    attributeList.get("encaisser").setCurrentValue(takeup);
  }
  
  public int getReact(){
    return attributeList.get("reagir").getCurrentValue();
  }
  
  public void setReact(int react) throws RPG_CharacterManagementException {
    attributeList.get("reagir").setCurrentValue(react);
  }
  
  public int getSpot(){
    return attributeList.get("remarquer").getCurrentValue();
  }
  
  public void setSpot(int spot) throws RPG_CharacterManagementException {
    attributeList.get("remarquer").setCurrentValue(spot);
  }
  
  public int getCurrentLifePoints(){
    return currentLifePoints;
  }

  public void setCurrentLifePoints(int currentLifePoints){
    this.currentLifePoints = currentLifePoints;
  }

  public int getMaxLifePoints(){
    return maxLifePoints;
  }

  public void setMaxLifePoints(int maxLifePoints){
    this.maxLifePoints = maxLifePoints;
  }
  
  @Override
  public void saveCharacter(){
    // TODO  
  }
  
  @Override
  public void loadCharacter(String characterName){
    // TODO
  }
  
}
