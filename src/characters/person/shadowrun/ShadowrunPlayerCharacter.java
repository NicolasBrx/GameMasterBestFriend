package characters.person.shadowrun;

import characters.PlayerCharacter;
import characters.equipment.shadowrun.Gear;
import characters.equipment.shadowrun.GearAugmentation;
import characters.social.shadowrun.Contact;
import characters.social.shadowrun.Identity;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Nicolas Brax
 */
public class ShadowrunPlayerCharacter extends PlayerCharacter {
    
  private Races race;
  
  private HashMap<String,Integer> reputation; //street credit, public awareness, notoriety
  
  private RunnerTypes runnertype;
  private SpecialSkills specialskill;
  
  private HashMap<String,Integer> computedAttribute;
  // initiatives, matrixInit, astralInit, physicalLimit,mentalLimit, socialLimit
  // physical dmg track, stun damage track, overflow, composure, judgeIntention,
  // memory, lift, movement, life cost adjustment
  
  private int startingNuyens;
  private double essance;
  
  private LifeStyles lifestyle;
  
  // other information and data
  private ArrayList<String> raceAdvantages;
  private ArrayList<Identity> identityList;
  private ArrayList<Contact> contactList;
  private ArrayList<GearAugmentation> augmentationList;
  private ArrayList<Gear> gearList;
  
  
  
  
  @Override
  public void saveCharacter(){
    //TODO
  }
  
  @Override
  public void loadCharacter(String playerName){
    //TODO
  }
}
