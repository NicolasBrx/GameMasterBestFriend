package characters.person.tombeau;

import characters.CharacterAttribute;
import characters.PlayerCharacter;
import exceptions.RPG_CharacterManagementException;

/**
 *
 * @author Nicolas Brax
 */
public class TombeauPlayerCharacter extends PlayerCharacter {
  
  private int adrenaline;
  private int currentLifePoints;  
  private int maxLifePoints;
  
  public TombeauPlayerCharacter(){
    super();
    attributeList.put("courir", new CharacterAttribute("courir",1,1,6));
    attributeList.put("encaisser", new CharacterAttribute("encaisser",1,1,6));
    attributeList.put("escalader", new CharacterAttribute("escalader",1,1,6));
    attributeList.put("forcer", new CharacterAttribute("forcer",1,1,6));
    attributeList.put("reagir", new CharacterAttribute("reagir",1,1,6));
    attributeList.put("remarquer", new CharacterAttribute("remarquer",1,1,6));
    attributeList.put("s'imposer", new CharacterAttribute("s'imposer",1,1,6));
    attributeList.put("sauter", new CharacterAttribute("sauter",1,1,6));
    attributeList.put("savoir-faire", 
                                  new CharacterAttribute("savoir-faire",1,1,6));
    attributeList.put("combattre", new CharacterAttribute("combattre",1,1,6));
    attributeList.put("se calmer", new CharacterAttribute("se calmer",1,1,6));
    attributeList.put("viser", new CharacterAttribute("viser",1,1,6));
    this.adrenaline = 4;
    this.currentLifePoints = 1;
    this.maxLifePoints = 6;
  }
  
  public int getRun(){
    return attributeList.get("courir").getCurrentValue();
  }
  
  public void setRun(int run) throws RPG_CharacterManagementException {
    attributeList.get("courir").setCurrentValue(run);
  }
   
  public int getTakeUp(){
    return attributeList.get("encaisser").getCurrentValue();
  }
  
  public void setTakeUp(int takeup) throws RPG_CharacterManagementException {
    attributeList.get("encaisser").setCurrentValue(takeup);
  }
   
  public int getClimb(){
    return attributeList.get("escalader").getCurrentValue();
  }
  
  public void setClimb(int climb) throws RPG_CharacterManagementException {
    attributeList.get("escalader").setCurrentValue(climb);
  }
   
  public int getForce(){
    return attributeList.get("forcer").getCurrentValue();
  }
  
  public void setForce(int force) throws RPG_CharacterManagementException {
    attributeList.get("forcer").setCurrentValue(force);
  }
   
  public int getReact(){
    return attributeList.get("reagir").getCurrentValue();
  }
  
  public void setReact(int react) throws RPG_CharacterManagementException {
    attributeList.get("reagir").setCurrentValue(react);
  }
   
  public int getSpot(){
    return attributeList.get("reamarquer").getCurrentValue();
  }
  
  public void setSpot(int spot) throws RPG_CharacterManagementException {
    attributeList.get("remarquer").setCurrentValue(spot);
  }
   
  public int getImpose(){
    return attributeList.get("s'imposer").getCurrentValue();
  }
  
  public void setImpose(int impose) throws RPG_CharacterManagementException {
    attributeList.get("s'imposer").setCurrentValue(impose);
  }
   
  public int getJump(){
    return attributeList.get("sauter").getCurrentValue();
  }
  
  public void setJump(int jump) throws RPG_CharacterManagementException {
    attributeList.get("sauter").setCurrentValue(jump);
  }
   
  public int getHandy(){
    return attributeList.get("savoir-faire").getCurrentValue();
  }
  
  public void setHandy(int handy) throws RPG_CharacterManagementException {
    attributeList.get("savoir-faire").setCurrentValue(handy);
  }
   
  public int getFight(){
    return attributeList.get("combattre").getCurrentValue();
  }
  
  public void setFight(int fight) throws RPG_CharacterManagementException {
    attributeList.get("combattre").setCurrentValue(fight);
  }
   
  public int getCalm(){
    return attributeList.get("se calmer").getCurrentValue();
  }
  
  public void setCalm(int calm) throws RPG_CharacterManagementException {
    attributeList.get("se calmer").setCurrentValue(calm);
  }
   
  public int getAim(){
    return attributeList.get("viser").getCurrentValue();
  }
  
  public void setAim(int aim) throws RPG_CharacterManagementException {
    attributeList.get("viser").setCurrentValue(aim);
  }
   

  public int getAdrenaline(){
    return adrenaline;
  }

  public void setAdrenaline(int adrenaline){
    this.adrenaline = adrenaline;
  }

  public int getCurrentLifePoints(){
    return currentLifePoints;
  }

  public void setCurrentLifePoints(int lifePoints){
    this.currentLifePoints = lifePoints;
  }

  public int getMaxLifePoints(){
    return maxLifePoints;
  }

  public void setMaxLifePoints(int maxLifePoints){
    this.maxLifePoints = maxLifePoints;
  }
  
  @Override
  public void loadCharacter(String playerName){
    // TODO
  }
  
  @Override
  public void saveCharacter(){
    // TODO
  }
  
}
