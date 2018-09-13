package characters.person.patient13;

import characters.CharacterAttribute;
import characters.CharacterQuality;
import characters.PlayerCharacter;
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
  
  @Override
  public void saveCharacter(){
    // TODO
  }
  
  @Override
  public void loadCharacter(){
    // TODO
  }
}
