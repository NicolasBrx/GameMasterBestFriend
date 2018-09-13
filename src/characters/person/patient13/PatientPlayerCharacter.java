package characters.person.patient13;

import characters.CharacterAttribute;
import characters.CharacterQuality;
import characters.PlayerCharacter;
import exceptions.RPG_CharacterManagementException;
import java.util.ArrayList;

/**
 *
 * @author Nicolas Brax
 */
public class PatientPlayerCharacter extends PlayerCharacter {
  
  private boolean sane;
  private String room;
  private String supervisor;
  private ArrayList<String> allies;
  private ArrayList<String> enemies;
  
  public PatientPlayerCharacter(){
    super();
    attributeList.put("lucidity",new CharacterAttribute("lucidity",5,1,13));
    attributeList.put("vitality",new CharacterAttribute("vitality",5,1,13));
    attributeList.put("cold blood",new CharacterAttribute("cold blood",5,1,13));
    attributeList.put("seniority",new CharacterAttribute("seniority",1));
    allies = new ArrayList<>();
    enemies = new ArrayList<>();
  }
  
  public int getLucidity(){
    return attributeList.get("lucidity").getCurrentValue();
  }
  
  public void setLucidity(int lucidity) throws RPG_CharacterManagementException
  {
    attributeList.get("lucidity").setCurrentValue(lucidity);
  }
  
  public int getColdBlood(){
    return attributeList.get("cold blood").getCurrentValue();
  }
  
  public void setColdblood(int coldblood) 
                                       throws RPG_CharacterManagementException {
    attributeList.get("cold blood").setCurrentValue(coldblood);
  }
  
  public int getVitality(){
    return attributeList.get("vitality").getCurrentValue();
  }
  
  public void setVitality(int vitality) throws RPG_CharacterManagementException
  {
    attributeList.get("vitality").setCurrentValue(vitality);
  }

  public boolean isSane(){
    return this.sane;
  }

  public void setSane(boolean sane){
    this.sane = sane;
  }

  public String getRoom(){
    return this.room;
  }

  public void setRoom(String room){
    this.room = room;
  }

  public String getSupervisor(){
    return this.supervisor;
  }

  public void setSupervisor(String supervisor){
    this.supervisor = supervisor;
  }
  
  public void addLineament(String lineament, String relatedSkill, int score){
    this.qualityList.put(lineament,new CharacterQuality(lineament,
                                                          relatedSkill, score));
  }
  
  public int getLineamentScore(String lineament){
    return this.skillList.get(lineament).getSkillRating();
  }

  public ArrayList<String> getAllies(){
    return this.allies;
  }

  public ArrayList<String> getEnemies(){
    return this.enemies;
  }
  
  public void addAllies(String ally){
    this.allies.add(ally);
  }
  
  public void addEnemies(String enemy){
    this.enemies.add(enemy);
  }
  
  // TODO: remove an ally or an enemy
  
  @Override
  public void saveCharacter(){
    // TODO
  }
  
  @Override
  public void loadCharacter(String playerName){
    // TODO
  }
}
