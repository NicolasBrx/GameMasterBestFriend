package characters.person.patient13;

import characters.NonPlayerCharacter;
import java.util.ArrayList;

/**
 *
 * @author Nicolas Brax
 */
public class PatientNonPlayerCharacter extends NonPlayerCharacter {
 
  private boolean isSupervisor;
  private String room;
  private String supervisor;
  private String secret;
  private ArrayList<String> allies;
  private ArrayList<String> enemies;
  
  public PatientNonPlayerCharacter(){
    super(false);
    allies = new ArrayList<>();
    enemies = new ArrayList<>();
  }

  public boolean isIsSupervisor(){
    return isSupervisor;
  }

  public void setIsSupervisor(boolean isSupervisor){
    this.isSupervisor = isSupervisor;
    if(this.isSupervisor){
      this.supervisor = "none";
    }
  }
  
  public String getRoom(){
    return room;
  }

  public void setRoom(String room){
    this.room = room;
  }

  public String getSupervisor(){
    return supervisor;
  }

  public void setSupervisor(String supervisor){
    this.supervisor = supervisor;
  }

  public ArrayList<String> getAllies(){
    return allies;
  }

  public void setAllies(ArrayList<String> allies){
    this.allies = allies;
  }

  public ArrayList<String> getEnemies(){
    return enemies;
  }

  public void setEnemies(ArrayList<String> enemies){
    this.enemies = enemies;
  }

  public String getSecret(){
    return secret;
  }

  public void setSecret(String secret){
    this.secret = secret;
  }

  @Override
  public void loadCharacter(String characterName){
    // TODO
  }
  
  @Override
  public void saveCharacter(){
    // TODO
  }
}
